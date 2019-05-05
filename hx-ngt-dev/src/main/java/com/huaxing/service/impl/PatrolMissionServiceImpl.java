package com.huaxing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.huaxing.bean.PatrolMission;
import com.huaxing.bean.PatrolMissionContent;
import com.huaxing.bean.PatrolScheme;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.repository.PatrolMissionContentRepository;
import com.huaxing.repository.PatrolMissionRepository;
import com.huaxing.repository.UserRepository;
import com.huaxing.service.PatrolMissionService;
import com.huaxing.service.PatrolSchemeService;
import com.huaxing.util.NgtConvertUtil;
import com.huaxing.util.NgtDefine.MissionStatus;
import com.huaxing.util.NgtDefine.SchemeStatus;
import com.huaxing.util.NgtStatus;
import com.huaxing.util.SysStatus;
import com.huaxing.vo.PatrolMissionContentVO;
import com.huaxing.vo.PatrolMissionVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatrolMissionServiceImpl extends BaseServiceImpl<PatrolMission> implements PatrolMissionService {
	@Autowired
	private PatrolMissionRepository patrolMissionRepository;

	@Autowired
	private PatrolMissionContentRepository patrolMissionContentRepository;

	@Autowired
	private PatrolSchemeService patrolSchemeService;

	@Autowired
	private UserRepository userRepository;

	@Override
	public PagingList<PatrolMissionVO> queryList(PatrolMission patrolMission, PagingAttribute pageAttr) {
		Page page = pageAttr.toPage();
		List<PatrolMission> list = patrolMissionRepository.queryList(patrolMission);
		List<PatrolMissionVO> distList = this.toListVO(list, PatrolMissionVO.class);
		Paging paging = new Paging(page.getTotal(), pageAttr);
		return new PagingList<PatrolMissionVO>(distList, paging);
	}

	@Override
	public PatrolMissionVO getPatrolMissionVo(String id) {
		PatrolMission mission = this.getById(id);
		if (mission == null)
			return null;
		PatrolMissionVO vo = new PatrolMissionVO();
		this.toVO(mission, vo);
		List<PatrolMissionContentVO> contentList = toListVO(mission.getContentList(), PatrolMissionContentVO.class);
		contentList.stream().forEach(content -> {
			NgtConvertUtil.convertEquipment(content, content.getEquipmentId(), "equipmentName");
			NgtConvertUtil.convertEquipmentCode(content, content.getEquipmentId(), "equipmentCode");
		});
		vo.setContentList(contentList);
		return vo;
	}

	@Override
	@Transactional
	public RestResult<String> setMissionStatus(String missionId, MissionStatus missionStatus) {
		PatrolMission mission = new PatrolMission();
		mission.setId(missionId);
		mission.setState(missionStatus.getCode());
		int rows = patrolMissionRepository.update(mission);
		return result(rows);
	}

	@Override
	@Transactional
	public RestResult<String> order(PatrolMission mission) {
		PatrolMission source = getById(mission.getId());// 获取巡检任务信息
		if (source == null)
			return RestResultUtil.getResult(SysStatus.ID_IS_ERROR, "ID不存在");// 如果乜有获取到数据，则恢复ID不存在
		if (!MissionStatus.UNACCEPT.getCode().equals(source.getState())) {// 校验任务单的状态，如果不是可接单状态，恢复当前任务不可接单
			return RestResultUtil.getResult(NgtStatus.MISSION_STATUS_ERROR, "当前任务不是可接单状态");//
		}
		// 获取原始的受理人和传入的受理人，如果原受理人已存在，并且不是新的受理人，则提示已存在受理人
		String beforeHandlerId = source.getHandlerId();
		String nowHandlerId = mission.getHandlerId();
		if (beforeHandlerId != null && !beforeHandlerId.equals(nowHandlerId)) {
			return RestResultUtil.failed("当前任务单已经存在受理人");
		}
		mission.setState(MissionStatus.REPAIRING.getCode());// 设置任务单状态为修复中
		int rows = patrolMissionRepository.update(mission);
		return result(rows);
	}

	@Override
	@Transactional
	public RestResult<String> pass(PatrolMission mission) {
		PatrolMission source = getById(mission.getId());// 获取巡检任务信息
		if (source == null)
			return RestResultUtil.getResult(SysStatus.ID_IS_ERROR, "ID不存在");// 如果乜有获取到数据，则恢复ID不存在
		PatrolMission updateForm = new PatrolMission();
		updateForm.setId(mission.getId());
		updateForm.setState(MissionStatus.CHECKED_PASS.getCode());// 设置任务单状态为修复中
		updateForm.setUpdate(mission.getUpdateBy());
		int rows = patrolMissionRepository.update(updateForm);
		return result(rows);
	}

	@Override
	@Transactional
	public RestResult<String> saveRecord(PatrolMission mission) {
		List<PatrolMissionContent> contentList = mission.getContentList();
		if (contentList == null || contentList.size() == 0) {
			return RestResultUtil.ok();
		}
		for (PatrolMissionContent patrolMissionContent : contentList) {
			patrolMissionContentRepository.update(patrolMissionContent);
		}
		return RestResultUtil.ok();
	}

	@Override
	public RestResult<String> check(PatrolMission mission, String state) {
		PatrolMission source = getById(mission.getId());// 获取巡检任务信息
		if (source == null)
			return RestResultUtil.getResult(SysStatus.ID_IS_ERROR, "ID不存在");// 如果乜有获取到数据，则恢复ID不存在
		/*
		 * 验收巡检任务单步骤： 1.变更巡检任务单的状态为审批通过或不通过 2，变更对应计划的状态为已等待下一次派发任务单 注意：任务单审批不论通过或不通过，本次任务单都会完结
		 */
		PatrolMission updateParam = new PatrolMission();
		updateParam.setId(mission.getId());
		updateParam.setUpdate(mission.getUpdateBy());
		updateParam.setRemarks(mission.getRemarks());
		if (state.equals("1")) {
			updateParam.setState(MissionStatus.CHECKED_PASS.getCode());
		} else {
			updateParam.setState(MissionStatus.CHECKED_UNPASS.getCode());
		}
		int missionCount = patrolMissionRepository.update(updateParam);
		PatrolScheme scheme = new PatrolScheme();
		scheme.setId(source.getPatrolSchemeId());
		patrolSchemeService.setSchemeStatus(scheme, SchemeStatus.DONE_WAIT_NEXT);
		return RestResultUtil.ok();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = patrolMissionRepository;
	}

}
