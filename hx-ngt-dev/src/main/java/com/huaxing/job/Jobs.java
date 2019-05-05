package com.huaxing.job;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huaxing.bean.MaintenanceMission;
import com.huaxing.bean.MaintenanceMissionContent;
import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.bean.MaintenanceSchemeContent;
import com.huaxing.bean.PatrolMission;
import com.huaxing.bean.PatrolMissionContent;
import com.huaxing.bean.PatrolScheme;
import com.huaxing.bean.PatrolSchemeContent;
import com.huaxing.common.utils.JsonUtil;
import com.huaxing.service.MaintenanceMissionContentService;
import com.huaxing.service.MaintenanceMissionService;
import com.huaxing.service.MaintenanceSchemeService;
import com.huaxing.service.NgtCodeService;
import com.huaxing.service.PatrolMissionContentService;
import com.huaxing.service.PatrolMissionService;
import com.huaxing.service.PatrolSchemeService;
import com.huaxing.service.ScheduleJobService;
import com.huaxing.util.NgtDefine;
import com.huaxing.util.NgtDefine.MissionStatus;
import com.huaxing.util.NgtDefine.SchemeStatus;
import com.huaxing.util.NgtDefine.TableEnum;
import com.huaxing.util.NgtDefine.TerminationCondition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("jobs")
public class Jobs {
	
	@Autowired
	private ScheduleJobService scheduleJobService;
	@Autowired
	private NgtCodeService codeService;
	
	@Autowired
	private PatrolSchemeService patrolSchemeService;
	@Autowired
	private PatrolMissionService patrolMissionService;
	@Autowired
	private PatrolMissionContentService patrolMissionContentService;
	
	@Autowired
	private MaintenanceSchemeService maintenanceSchemeService;
	@Autowired
	private MaintenanceMissionService maintenanceMissionService;
	@Autowired
	private MaintenanceMissionContentService maintenanceMissionContentService;
	
	public void genPatrolMission(String paramsJson) {
		Map<String, String> params = JsonUtil.json2HashMap(paramsJson, String.class);
		String schemeId = params.get("schemeId");
		log.info("巡检计划创建巡检任务，job被执行");
		PatrolScheme scheme = patrolSchemeService.getById(schemeId);
		String terminationCondition=scheme.getTerminationCondition();		//获取计划运行方式  0始终运行;1按一定次数后终止;2指定日期后终止
		String terminationParameter=scheme.getTerminationParameter();		//获取参数
		int count = scheme.getExecutionCount();
		long taskId = scheme.getTaskId();
		//根据任务结束条件,判断,如果负荷条件,就终止任务
		if(!verifyPlanEffectiveness(NgtDefine.getTerminationConditionMap().get(terminationCondition), terminationParameter,count, taskId)) {
			return;
		};
		//验证通过，正常执行任务生成
		//创建要保存的任务对象，并填充属性
		PatrolMission template = new PatrolMission();
		template.setUUID();
		template.setPatrolSchemeId(schemeId);
		String code = codeService.genCode(TableEnum.PATROL_MISSION, scheme.getCompanyId());
		template.setCode(code);
		template.setType(scheme.getType());
		template.setHandlerId(scheme.getHandlerId());
		template.setState(MissionStatus.UNACCEPT.getCode());
		template.setCompanyId(scheme.getCompanyId());
		template.setCreate(scheme.getCreateBy());
		patrolMissionService.save(template);
		//从计划模板中获取详细内容，并填充到任务中
		List<PatrolSchemeContent> schemeContentList = scheme.getContentList();
		List<PatrolMissionContent> missionContentList = new ArrayList<>();
		template.setContentList(missionContentList);
		for (PatrolSchemeContent patrolSchemeContent : schemeContentList) {
			PatrolMissionContent contentTemp = new PatrolMissionContent();
			BeanUtils.copyProperties(patrolSchemeContent, contentTemp);
			contentTemp.setUUID();
			missionContentList.add(contentTemp);
		}
		patrolMissionContentService.save(template);
		patrolSchemeService.setSchemeStatus(scheme,SchemeStatus.DISPATCHED);//设置计划的状态为已经发布任务
		patrolSchemeService.plusExecutationCount(scheme, count);
		log.info("巡检计划创建巡检任务，job执行完毕");
	}
	
	public void genMaintenanceMission(String paramsJson) {
		Map<String, String> params = JsonUtil.json2HashMap(paramsJson, String.class);
		String schemeId = params.get("schemeId");
		log.info("定保计划创建定保任务，job被执行");
		MaintenanceScheme scheme = maintenanceSchemeService.getById(schemeId);
		int count = scheme.getExecutionCount();
		long taskId = scheme.getTaskId();
		//根据任务结束条件,判断,如果负荷条件,就终止任务
		//验证通过，正常执行任务生成
		MaintenanceMission template = new MaintenanceMission();
		template.setUUID();
		template.setTemplateId(schemeId);
		String code = codeService.genCode(TableEnum.MAINTENANCE_MISSION, scheme.getCompanyId());
		template.setCode(code);
		template.setHandlerId(scheme.getHandlerId());
		template.setState(MissionStatus.UNACCEPT.getCode());
		template.setCompanyId(scheme.getCompanyId());
		template.setCreate(scheme.getCreateBy());
		template.setHopeTime(scheme.getHopeTime());
		maintenanceMissionService.save(template);
		//从计划模板中获取详细内容，并填充到任务中
		List<MaintenanceSchemeContent> schemeContentList = scheme.getContentList();
		List<MaintenanceMissionContent> missionContentList = new ArrayList<>();
		template.setContentList(missionContentList);
		for (MaintenanceSchemeContent patrolSchemeContent : schemeContentList) {
			MaintenanceMissionContent contentTemp = new MaintenanceMissionContent();
			BeanUtils.copyProperties(patrolSchemeContent, contentTemp);
			contentTemp.setUUID();
			missionContentList.add(contentTemp);
		}
		maintenanceMissionContentService.save(template);
		maintenanceSchemeService.setSchemeStatus(scheme,SchemeStatus.DISPATCHED);//设置计划的状态为已经发布任务
		maintenanceSchemeService.plusExecutationCount(scheme, count);
		log.info("定保计划创建定保任务，job执行完毕");
	}
	/**
	 * 验证计划是否有效，如果计划已经超过预定的设定，则计划失败
	 * Lian weimao CreateTime:2018年7月13日 上午11:31:49
	 * @param terminationCondition
	 * @param terminationParameter
	 * @param count
	 * @param taskId
	 */
	private boolean verifyPlanEffectiveness(TerminationCondition terminationCondition,String terminationParameter, int count, long taskId) {
		if(terminationCondition.equals(TerminationCondition.LIMITED_NUMBER)){
			int terminationCount=0;
			try {
				terminationCount=Integer.parseInt(terminationParameter);
			} catch (Exception e) {
				terminationCount=0;
			}
			if(count>=terminationCount){
				scheduleJobService.deleteBatch(new Long[] {taskId});
				return false;
			}
		}else if(terminationCondition.equals(TerminationCondition.LIMITED_DATE)){
			Calendar now = Calendar.getInstance();
			Calendar terminationDateC = Calendar.getInstance();
			Date terminationDate=null;
			try {
				terminationDate=new SimpleDateFormat("yyyy-MM-dd").parse(terminationParameter);
			} catch (Exception e) {
				terminationDateC = Calendar.getInstance();
			}
			terminationDateC.setTime(terminationDate);
			terminationDateC.add(Calendar.DAY_OF_MONTH, 1);
			if(now.after(terminationDateC)){
				scheduleJobService.deleteBatch(new Long[] {taskId});
				return false;
			}
		}
		return true;
	}
}
