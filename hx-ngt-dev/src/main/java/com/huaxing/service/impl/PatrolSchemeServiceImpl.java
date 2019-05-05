package com.huaxing.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.huaxing.bean.PatrolScheme;
import com.huaxing.bean.PatrolSchemeContent;
import com.huaxing.bean.ScheduleJobEntity;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.Iterables;
import com.huaxing.common.utils.JsonUtil;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.repository.PatrolSchemeContentRepository;
import com.huaxing.repository.PatrolSchemeRepository;
import com.huaxing.service.NgtCodeService;
import com.huaxing.service.PatrolSchemeService;
import com.huaxing.service.ScheduleJobService;
import com.huaxing.util.NgtConvertUtil;
import com.huaxing.util.NgtDefine.SchemeStatus;
import com.huaxing.util.NgtDefine.TableEnum;
import com.huaxing.util.NgtStatus;
import com.huaxing.vo.PatrolSchemeContentVO;
import com.huaxing.vo.PatrolSchemeVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatrolSchemeServiceImpl extends BaseServiceImpl<PatrolScheme> implements PatrolSchemeService {
	@Autowired
	private PatrolSchemeRepository patrolSchemeRepository;

	@Autowired
	private PatrolSchemeContentRepository contentRepository;

	@Autowired
	private NgtCodeService codeService;

	@Autowired
	private ScheduleJobService scheduleJobService;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = patrolSchemeRepository;
	}

	@Override
	public PagingList<PatrolSchemeVO> queryList(PatrolScheme patrolScheme, PagingAttribute pageAttr) {
		// 使用分页插件
		Page page = pageAttr.toPage();

		// 查询MODEL
		List<PatrolScheme> list = patrolSchemeRepository.queryList(patrolScheme);

		// 将MODEL转换为VO

		List<PatrolSchemeVO> distList = this.toListVO(list, PatrolSchemeVO.class);

		// 将数据字典中的值替换
		// ConvertUtil.convertListDictitem(distList, new String[] { "type" }, new String[] { "dictName" });

		// 构建分页对象
		Paging paging = new Paging(page.getTotal(), pageAttr);

		return new PagingList<PatrolSchemeVO>(distList, paging);
	}

	@Override
	@Transactional
	public RestResult<String> createPatrol(PatrolScheme patrol) {
		patrol.setUUID();
		String code = codeService.genCode(TableEnum.PATROL_SCHEME, patrol.getCompanyId());
		patrol.setCode(code);
		patrol.setState(SchemeStatus.EDITABLE.getCode());
		patrol.setEnableFlag("1");
		int count = patrolSchemeRepository.save(patrol);
		if (count > 0) {
			saveContent(patrol);
			// 计划创建完毕后，需要创建定时任务
			// createPatrolSchemeScheduleJob(patrol);
			return RestResultUtil.ok(patrol.getId());
		} else {
			return RestResultUtil.failed();
		}

	}

	private void createPatrolSchemeScheduleJob(PatrolScheme scheme) {
		ScheduleJobEntity job = new ScheduleJobEntity();
		job.setBeanName("jobs");
		job.setMethodName("genPatrolMission");
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("schemeId", scheme.getId());
		try {
			job.setParams(JsonUtil.bean2Json(paramMap));
		} catch (IOException e) {
			log.error("巡检计划生成巡检任务,参数转换json错误：" + paramMap.toString());
			e.printStackTrace();
		}
		String cronExpression = new SimpleDateFormat("s m H d").format(scheme.getStartDate()) + "/" + scheme.getPeriod() + " * ?";
		// Calendar now = Calendar.getInstance();
		// now.add(Calendar.MINUTE, 1);
		// String cronExpression=new SimpleDateFormat("ss mm HH").format(now.getTime())+" */1 * ?";
		log.debug("巡检计划生成巡检任务,规则表达式：" + cronExpression);
		System.out.println("cronExpresion:" + cronExpression);
		job.setCronExpression(cronExpression);
		job.setRemark("巡检计划生成巡检任务");
		scheduleJobService.save(job);
		scheme.setTaskId(job.getJobId());
		patrolSchemeRepository.update(scheme);
	}

	private void saveContent(PatrolScheme patrol) {
		List<PatrolSchemeContent> contentList = patrol.getContentList();
		if (null != contentList && contentList.size() > 0) {

			Iterables.forEach(contentList, (index, item) -> {
				item.setUUID();
				item.setSort(++index + "");
			});
			contentRepository.saveContent(patrol);
		}
	}

	@Override
	@Transactional
	public RestResult<String> modifyPatrol(PatrolScheme patrol) {
		PatrolScheme source = patrolSchemeRepository.get(patrol.getId());
		if (!SchemeStatus.EDITABLE.getCode().equals(source.getState())) {
			return RestResultUtil.getResult(NgtStatus.SCHEME_STATUS_ERROR, "当前计划不可修改");
		}
		int count = patrolSchemeRepository.update(patrol);
		if (count > 0) {
			contentRepository.deleteByPatrolId(patrol.getId());
			saveContent(patrol);
		}
		return this.result(count);
	}

	@Override
	@Transactional
	public RestResult<String> removePatrol(String schemeId) {
		PatrolScheme scheme = patrolSchemeRepository.get(schemeId);
		patrolSchemeRepository.delete(schemeId);
		contentRepository.deleteByPatrolId(schemeId);
		scheduleJobService.deleteBatch(new Long[] { scheme.getTaskId() });
		setSchemeStatus(scheme, SchemeStatus.TERMINATED);
		return RestResultUtil.ok();
	}

	@Override
	public PatrolSchemeVO getPatrolSchemeVo(String id) {
		PatrolScheme scheme = patrolSchemeRepository.getDetailById(id);
		if (scheme == null) {
			return null;
		}
		PatrolSchemeVO schemeVO = new PatrolSchemeVO();
		this.toVO(scheme, schemeVO);
		List<PatrolSchemeContentVO> list = this.toListVO(scheme.getContentList(), PatrolSchemeContentVO.class);
		list.stream().forEach(content -> {
			NgtConvertUtil.convertEquipment(content, content.getEquipmentId(), "equipmentName");
			NgtConvertUtil.convertEquipmentCode(content, content.getEquipmentId(), "equipmentCode");
		});
		schemeVO.setContentList(list);
		return schemeVO;
	}

	@Override
	public PatrolScheme getById(Object id) {
		PatrolScheme scheme = patrolSchemeRepository.getDetailById((String) id);
		if (scheme == null) {
			return null;
		}
		List<PatrolSchemeContent> list = scheme.getContentList();
		list.stream().forEach(content -> {
			NgtConvertUtil.convertEquipment(content, content.getEquipmentId(), "equipmentName");
		});
		return scheme;
	}

	@Override
	public RestResult<String> removeBatchPatrol(String[] ids) {
		if (null != ids) {
			for (String id : ids) {
				this.removePatrol(id);
			}
		}
		return RestResultUtil.ok();
	}

	@Override
	@Transactional
	public RestResult<String> setSchemeStatus(PatrolScheme scheme, SchemeStatus schemeStatus) {
		PatrolScheme updateParam = new PatrolScheme();
		updateParam.setId(scheme.getId());
		updateParam.setState(schemeStatus.getCode());
		int count = patrolSchemeRepository.update(updateParam);
		return result(count);
	}

	@Override
	public RestResult<String> pausePatrol(String schemeId) {
		PatrolScheme scheme = patrolSchemeRepository.get(schemeId);
		scheduleJobService.pause(scheme.getTaskId());
		setSchemeStatus(scheme, SchemeStatus.TERMINATED);
		return RestResultUtil.ok();
	}

	@Override
	public RestResult<String> resumePatrol(String schemeId) {
		PatrolScheme scheme = patrolSchemeRepository.get(schemeId);
		scheduleJobService.resume(scheme.getTaskId());
		setSchemeStatus(scheme, SchemeStatus.NORMAL);
		return RestResultUtil.ok();
	}

	@Override
	public RestResult<String> plusExecutationCount(PatrolScheme scheme, int beforeCount) {
		PatrolScheme updateParam = new PatrolScheme();
		updateParam.setId(scheme.getId());
		updateParam.setExecutionCount(++beforeCount);
		int rows = patrolSchemeRepository.update(updateParam);
		return result(rows);
	}

}
