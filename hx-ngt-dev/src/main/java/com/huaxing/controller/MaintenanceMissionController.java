package com.huaxing.controller;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.MaintenanceMission;
import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.common.exception.ResponseStatus;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.MaintenanceMissionDTO;
import com.huaxing.dto.MaintenanceMissionQueryDTO;
import com.huaxing.service.MaintenanceMissionService;
import com.huaxing.util.NgtDefine.MissionStatus;
import com.huaxing.vo.MaintenanceMissionVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
@Api(tags = { "能管在线：定保任务接口" })
@RestController
@RequestMapping("/api/maintenance/mission/")
@Validated
public class MaintenanceMissionController extends BaseController<MaintenanceScheme, Serializable> {
	@Autowired
	private MaintenanceMissionService maintenanceMissionService;

	@ApiOperation(value = "查询任务列表", notes = "")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<PagingList<MaintenanceMissionVO>> queryList(@Validated MaintenanceMissionQueryDTO queryMission, PagingAttribute pagAttr) {
		MaintenanceMission missionQuery = queryMission.toObject(MaintenanceMission.class);
		missionQuery.setCompanyId(this.getCompanyId());
		PagingList<MaintenanceMissionVO> missionList = maintenanceMissionService.queryList(missionQuery, pagAttr);
		return RestResultUtil.ok(missionList);
	}

	@ApiOperation(value = "按照ID查询任务任务详情", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "任务ID", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<MaintenanceMissionVO> info(@PathVariable("id") String id) {
		MaintenanceMissionVO MaintenanceMissionVO = maintenanceMissionService.getMaintenanceMissionVO(id);
		return RestResultUtil.ok(MaintenanceMissionVO);
	}

	@ApiOperation(value = "接单", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "任务ID", required = true) })
	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public RestResult<String> order(@PathVariable("id") String id) {
		MaintenanceMission mission = new MaintenanceMission();
		mission.setId(id);
		mission.setHandlerId(getUserId());
		mission.setUpdate(getUserId());
		RestResult<String> orderResult = maintenanceMissionService.order(mission);
		return orderResult;
	}

	@ApiOperation(value = "终止任务", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "任务ID", required = true) })
	@RequestMapping(value = "/pass/{id}", method = RequestMethod.POST)
	public RestResult<String> pass(@PathVariable("id") String id) {
		MaintenanceMission mission = new MaintenanceMission();
		mission.setId(id);
		mission.setUpdate(getUserId());
		RestResult<String> passResult = maintenanceMissionService.pass(mission);
		return passResult;
	}

	@ApiOperation(value = "保存任务记录", notes = "")
	@RequestMapping(value = "/record/save", method = RequestMethod.POST)
	public RestResult<String> saveRecord(@Validated @RequestBody MaintenanceMissionDTO MaintenanceMissionDTO) {
		MaintenanceMission mission = MaintenanceMissionDTO.toObject(MaintenanceMission.class);
		mission.setUpdate(getUserId());
		RestResult<String> updateResult = maintenanceMissionService.saveRecord(mission);
		return updateResult;
	}

	@ApiOperation(value = "保存并提交任务记录", notes = "")
	@RequestMapping(value = "/record/save_submit", method = RequestMethod.POST)
	public RestResult<String> saveAndSubmitRecord(@Validated @RequestBody MaintenanceMissionDTO MaintenanceMissionDTO) {
		MaintenanceMission mission = MaintenanceMissionDTO.toObject(MaintenanceMission.class);
		mission.setUpdate(getUserId());
		RestResult<String> updateResult = maintenanceMissionService.saveRecord(mission);
		if (updateResult.getCode() != ResponseStatus.OK.getCode())
			return updateResult;
		RestResult<String> setStatusResult = maintenanceMissionService.setMissionStatus(mission.getId(), MissionStatus.WAIT_CHECK);
		return setStatusResult;
	}

	@ApiOperation(value = "提交任务记录", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "任务ID", required = true) })
	@RequestMapping(value = "/submit/{id}", method = RequestMethod.GET)
	public RestResult<String> submit(@PathVariable("id") String id) {
		RestResult<String> setStatusResult = maintenanceMissionService.setMissionStatus(id, MissionStatus.WAIT_CHECK);
		return setStatusResult;
	}

	@ApiOperation(value = "验收", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "id", value = "修复单ID ", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "string", name = "state", value = "通过(1)/不通过(0) ", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "string", name = "remark", value = "修复单ID ", required = true) })
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public RestResult<String> check(@NotBlank(message = "任务ID不能为空") String id,
			@Pattern(regexp = "^[0,1]{1}$", message = "验收结果仅可传入【0不通过,1通过】") String state, String remark) {
		MaintenanceMission mission = new MaintenanceMission();
		mission.setId(id);
		mission.setCommand(remark);
		mission.setUpdate(getUserId());
		RestResult<String> updateResult = maintenanceMissionService.check(mission, state);
		return updateResult;
	}

}
