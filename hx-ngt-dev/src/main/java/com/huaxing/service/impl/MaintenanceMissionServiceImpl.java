package com.huaxing.service.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.huaxing.bean.MaintenanceMission;
import com.huaxing.bean.MaintenanceMissionContent;
import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.utils.StringUtils;
import com.huaxing.repository.MaintenanceMissionContentRepository;
import com.huaxing.repository.MaintenanceMissionRepository;
import com.huaxing.service.MaintenanceMissionService;
import com.huaxing.service.MaintenanceSchemeService;
import com.huaxing.util.NgtConvertUtil;
import com.huaxing.util.NgtDefine.MissionStatus;
import com.huaxing.util.NgtDefine.SchemeStatus;
import com.huaxing.util.NgtStatus;
import com.huaxing.util.SysStatus;
import com.huaxing.vo.MaintenanceMissionContentVO;
import com.huaxing.vo.MaintenanceMissionVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceMissionServiceImpl extends BaseServiceImpl<MaintenanceMission> implements MaintenanceMissionService {
	@Autowired
	private MaintenanceMissionRepository maintenanceMissionRepository;
	@Autowired
	private MaintenanceMissionContentRepository maintenanceMissionContentRepository;
	@Autowired
	private MaintenanceSchemeService maintenanceSchemeService;

	NgtConvertUtil ngtConvertUtil = new NgtConvertUtil();

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = maintenanceMissionRepository;
	}

	@Override
	public PagingList<MaintenanceMissionVO> queryList(MaintenanceMission maintenanceMission, PagingAttribute pageAttr) {
		Page page = pageAttr.toPage();
		List<MaintenanceMission> list = maintenanceMissionRepository.queryList(maintenanceMission);
		List<MaintenanceMissionVO> distList = this.toListVO(list, MaintenanceMissionVO.class);
		Paging paging = new Paging(page.getTotal(), pageAttr);
		return new PagingList<MaintenanceMissionVO>(distList, paging);
	}

	@Override
	@Transactional
	public RestResult<String> setMissionStatus(String id, MissionStatus missionStatus) {
		Validate.notNull(missionStatus, "任务状态不能为空");
		MaintenanceMission mission = new MaintenanceMission();
		mission.setId(id);
		mission.setState(missionStatus.getCode());
		return result(maintenanceMissionRepository.update(mission));
	}

	@Override
	public MaintenanceMissionVO getMaintenanceMissionVO(String id) {
		MaintenanceMission mission = this.getById(id);
		if (mission == null)
			return null;
		MaintenanceMissionVO distVO = new MaintenanceMissionVO();
		this.toVO(mission, distVO);
		List<MaintenanceMissionContentVO> contentList = toListVO(mission.getContentList(), MaintenanceMissionContentVO.class);
		distVO.setContentList(contentList);
		return distVO;
	}

	@Override
	@Transactional
	public RestResult<String> order(MaintenanceMission mission) {
		MaintenanceMission source = getById(mission.getId());// 获取巡检任务信息
		if (source == null)
			return RestResultUtil.getResult(SysStatus.ID_IS_ERROR, "ID不存在");// 如果乜有获取到数据，则恢复ID不存在
		if (!MissionStatus.UNACCEPT.getCode().equals(source.getState())) {// 校验任务单的状态，如果不是可接单状态，恢复当前任务不可接单
			return RestResultUtil.getResult(NgtStatus.MISSION_STATUS_ERROR, "当前任务不是可接单状态");//
		}
		// 获取原始的受理人和传入的受理人，如果原受理人已存在，并且不是新的受理人，则提示已存在受理人
		String beforeHandlerId = source.getHandlerId();
		String nowHandlerId = mission.getHandlerId();
		if (StringUtils.isNotBlank(beforeHandlerId) && !beforeHandlerId.equals(nowHandlerId)) {
			return RestResultUtil.failed("当前任务单已经存在受理人");
		}
		mission.setState(MissionStatus.REPAIRING.getCode());// 设置任务单状态为修复中
		int rows = maintenanceMissionRepository.update(mission);
		return result(rows);
	}

	@Override
	@Transactional
	public RestResult<String> pass(MaintenanceMission mission) {
		MaintenanceMission source = getById(mission.getId());// 获取巡检任务信息
		if (source == null)
			return RestResultUtil.getResult(SysStatus.ID_IS_ERROR, "ID不存在");// 如果乜有获取到数据，则恢复ID不存在
		MaintenanceMission updateForm = new MaintenanceMission();
		updateForm.setId(mission.getId());
		updateForm.setState(MissionStatus.CHECKED_PASS.getCode());
		updateForm.setUpdate(mission.getUpdateBy());
		int rows = maintenanceMissionRepository.update(updateForm);
		return result(rows);
	}

	@Override
	@Transactional
	public RestResult<String> saveRecord(MaintenanceMission mission) {
		List<MaintenanceMissionContent> contentList = mission.getContentList();
		if (contentList == null || contentList.size() == 0) {
			return RestResultUtil.ok();
		}
		for (MaintenanceMissionContent patrolMissionContent : contentList) {
			maintenanceMissionContentRepository.update(patrolMissionContent);
		}
		return RestResultUtil.ok();
	}

	@Override
	@Transactional
	public RestResult<String> check(MaintenanceMission mission, String state) {
		MaintenanceMission source = getById(mission.getId());// 获取巡检任务信息
		if (source == null)
			return RestResultUtil.getResult(SysStatus.ID_IS_ERROR, "ID不存在");// 如果乜有获取到数据，则恢复ID不存在
		/*
		 * 验收巡检任务单步骤： 1.变更巡检任务单的状态为审批通过或不通过 2，变更对应计划的状态为已等待下一次派发任务单 注意：任务单审批不论通过或不通过，本次任务单都会完结
		 */
		MaintenanceMission updateParam = new MaintenanceMission();
		updateParam.setId(mission.getId());
		updateParam.setUpdate(mission.getUpdateBy());
		updateParam.setCommand(mission.getCommand());
		if (state.equals("1")) {
			updateParam.setState(MissionStatus.CHECKED_PASS.getCode());
		} else {
			updateParam.setState(MissionStatus.CHECKED_UNPASS.getCode());
		}
		int missionCount = maintenanceMissionRepository.update(updateParam);
		MaintenanceScheme scheme = new MaintenanceScheme();
		scheme.setId(source.getTemplateId());
		maintenanceSchemeService.setSchemeStatus(scheme, SchemeStatus.DONE_WAIT_NEXT);
		return RestResultUtil.ok();
	}
}
