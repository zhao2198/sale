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
import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.bean.MaintenanceSchemeContent;
import com.huaxing.bean.ScheduleJobEntity;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.Iterables;
import com.huaxing.common.utils.JsonUtil;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.repository.MaintenanceSchemeContentRepository;
import com.huaxing.repository.MaintenanceSchemeRepository;
import com.huaxing.service.MaintenanceSchemeService;
import com.huaxing.service.NgtCodeService;
import com.huaxing.service.ScheduleJobService;
import com.huaxing.util.NgtDefine.SchemeStatus;
import com.huaxing.util.NgtDefine.TableEnum;
import com.huaxing.util.NgtStatus;
import com.huaxing.vo.MaintenanceSchemeContentVO;
import com.huaxing.vo.MaintenanceSchemeVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceSchemeServiceImpl extends BaseServiceImpl<MaintenanceScheme> implements MaintenanceSchemeService {
	@Autowired
	private MaintenanceSchemeRepository maintenanceSchemeRepository;

	@Autowired
	private MaintenanceSchemeContentRepository schemeContentRepository;

	@Autowired
	private ScheduleJobService scheduleJobService;

	@Autowired
	private NgtCodeService codeService;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = maintenanceSchemeRepository;
	}

	@Override
	public PagingList<MaintenanceSchemeVO> queryList(MaintenanceScheme maintenanceScheme, PagingAttribute pageAttr) {
		// 使用分页插件
		Page page = pageAttr.toPage();

		// 查询MODEL
		List<MaintenanceScheme> list = maintenanceSchemeRepository.queryList(maintenanceScheme);

		// 将MODEL转换为VO

		List<MaintenanceSchemeVO> distList = this.toListVO(list, MaintenanceSchemeVO.class);

		// 将数据字典中的值替换
		// ConvertUtil.convertListDictitem(distList, new String[] { "type" }, new String[] { "dictName" });

		// 构建分页对象
		Paging paging = new Paging(page.getTotal(), pageAttr);

		return new PagingList<MaintenanceSchemeVO>(distList, paging);
	}

	@Override
	@Transactional
	public RestResult<String> createPeriodic(MaintenanceScheme maintenance) {
		maintenance.setUUID();
		// TODO 纺一生成CODE
		String code = codeService.genCode(TableEnum.MAINTENANCE_SCHEME, maintenance.getCompanyId());
		maintenance.setCode(code);
		maintenance.setState(SchemeStatus.EDITABLE.getCode());
		maintenance.setEnableFlag("1");
		/*
		 * if (codeService.isExistsCode(TableEnum.PERIODIC_MAINTENANCE_SCHEME, code, maintenance.getCompanyId())) { return
		 * RestResultUtil.getResult(NgtStatus.NGT_ONLINE_BUSINESS_CODE); }
		 */
		int count = maintenanceSchemeRepository.save(maintenance);
		if (count > 0) {
			saveContent(maintenance);
			createSchemeScheduleJob(maintenance);
			return RestResultUtil.ok();
		} else {
			return RestResultUtil.failed();
		}
	}

	private void createSchemeScheduleJob(MaintenanceScheme scheme) {
		ScheduleJobEntity job = new ScheduleJobEntity();
		job.setBeanName("jobs");
		job.setMethodName("genMaintenanceMission");
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("schemeId", scheme.getId());
		try {
			job.setParams(JsonUtil.bean2Json(paramMap));
		} catch (IOException e) {
			log.error("定保计划创建定保任务,参数转换json错误：" + paramMap.toString());
			e.printStackTrace();
		}
		String cronExpression = new SimpleDateFormat("s m H d").format(scheme.getStartDate()) + "/" + scheme.getPeriod() + " * ?";
		// Calendar now = Calendar.getInstance();
		// now.add(Calendar.MINUTE, 1);
		// String cronExpression=new SimpleDateFormat("ss mm HH").format(now.getTime())+" */1 * ?";
		log.debug("定保计划创建定保任务,规则表达式：" + cronExpression);
		System.out.println("cronExpresion:" + cronExpression);
		job.setCronExpression(cronExpression);
		job.setRemark("定保计划创建定保任务");
		scheduleJobService.save(job);
		scheme.setTaskId(job.getJobId());
		maintenanceSchemeRepository.update(scheme);
	}

	@Override
	@Transactional
	public RestResult<String> modifyPeriodic(MaintenanceScheme maintenance) {
		MaintenanceScheme source = maintenanceSchemeRepository.get(maintenance.getId());
		if (!SchemeStatus.EDITABLE.getCode().equals(source.getState())) {
			return RestResultUtil.getResult(NgtStatus.SCHEME_STATUS_ERROR, "当前计划不可修改");
		}
		int count = maintenanceSchemeRepository.update(maintenance);
		if (count > 0) {
			schemeContentRepository.deleteByMainId(maintenance.getId());
			saveContent(maintenance);
			return RestResultUtil.ok();
		} else {
			return RestResultUtil.failed();
		}

	}

	private void saveContent(MaintenanceScheme maintenance) {
		List<MaintenanceSchemeContent> contentList = maintenance.getContentList();
		if (null != contentList && contentList.size() > 0) {
			Iterables.forEach(contentList, (index, item) -> {
				item.setUUID();
				item.setSort(++index + "");
			});
			schemeContentRepository.saveContent(maintenance);
		}
	}

	@Override
	public MaintenanceSchemeVO getSchemeVo(String id) {
		MaintenanceScheme periodic = maintenanceSchemeRepository.getDetailById(id);
		MaintenanceSchemeVO maintenanceVO = new MaintenanceSchemeVO();
		this.toVO(periodic, maintenanceVO);
		List<MaintenanceSchemeContent> contentList = periodic.getContentList();
		if (null != contentList && contentList.size() > 0) {
			List<MaintenanceSchemeContentVO> contents = this.toListVO(contentList, MaintenanceSchemeContentVO.class);
			maintenanceVO.setContentList(contents);
		}
		return maintenanceVO;
	}

	@Override
	@Transactional
	public RestResult<String> removeScheme(String id) {
		MaintenanceScheme scheme = maintenanceSchemeRepository.get(id);
		maintenanceSchemeRepository.delete(id);
		schemeContentRepository.deleteByMainId(id);
		scheduleJobService.deleteBatch(new Long[] { scheme.getTaskId() });
		scheduleJobService.pause(scheme.getTaskId());
		return RestResultUtil.ok();
	}

	@Override
	@Transactional
	public RestResult<String> pauseScheme(String id) {
		MaintenanceScheme scheme = maintenanceSchemeRepository.get(id);
		scheduleJobService.pause(scheme.getTaskId());
		setSchemeStatus(scheme, SchemeStatus.TERMINATED);
		return RestResultUtil.ok();
	}

	@Override
	@Transactional
	public RestResult<String> resumeScheme(String id) {
		MaintenanceScheme scheme = maintenanceSchemeRepository.get(id);
		scheduleJobService.resume(scheme.getTaskId());
		setSchemeStatus(scheme, SchemeStatus.NORMAL);
		return RestResultUtil.ok();
	}

	@Override
	@Transactional
	public RestResult<String> setSchemeStatus(MaintenanceScheme scheme, SchemeStatus status) {
		MaintenanceScheme updateParam = new MaintenanceScheme();
		updateParam.setId(scheme.getId());
		updateParam.setState(status.getCode());
		int count = maintenanceSchemeRepository.update(updateParam);
		return result(count);
	}

	@Override
	public RestResult<String> plusExecutationCount(MaintenanceScheme scheme, int beforeCount) {
		MaintenanceScheme updateParam = new MaintenanceScheme();
		updateParam.setId(scheme.getId());
		updateParam.setExecutionCount(++beforeCount);
		int rows = maintenanceSchemeRepository.update(updateParam);
		return result(rows);
	}

}
