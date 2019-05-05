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

import com.huaxing.bean.PatrolMission;
import com.huaxing.bean.PatrolScheme;
import com.huaxing.common.exception.ResponseStatus;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.PatrolMissionDTO;
import com.huaxing.dto.PatrolMissionQueryDTO;
import com.huaxing.service.PatrolMissionService;
import com.huaxing.util.NgtDefine.MissionStatus;
import com.huaxing.vo.PatrolMissionVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@Api(tags = { "能管在线：巡检任务接口" })
@RestController
@RequestMapping("/api/patrol_mission")
@Validated
public class PatrolMissionController extends BaseController<PatrolScheme, Serializable> {
	@Autowired
	private PatrolMissionService patrolMissionService;

	@ApiOperation(value = "查询巡检任务列表", notes = "")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<PagingList<PatrolMissionVO>> queryList(@Validated PatrolMissionQueryDTO queryMission, PagingAttribute pagAttr) {
		PatrolMission missionQuery = queryMission.toObject(PatrolMission.class);
		missionQuery.setCompanyId(this.getCompanyId());
		PagingList<PatrolMissionVO> patrolMissionList = patrolMissionService.queryList(missionQuery, pagAttr);
		return RestResultUtil.ok(patrolMissionList);
	}

	@ApiOperation(value = "按照ID查询巡检任务详情", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<PatrolMissionVO> info(@PathVariable("id") String id) {
		PatrolMissionVO patrolMissionVO = patrolMissionService.getPatrolMissionVo(id);
		return RestResultUtil.ok(patrolMissionVO);
	}

	@ApiOperation(value = "接单", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public RestResult<String> order(@PathVariable("id") String id) {
		PatrolMission mission = new PatrolMission();
		mission.setId(id);
		mission.setHandlerId(getUserId());
		mission.setUpdate(getUserId());
		RestResult<String> orderResult = patrolMissionService.order(mission);
		return orderResult;
	}

	@ApiOperation(value = "终止任务", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/pass/{id}", method = RequestMethod.POST)
	public RestResult<String> pass(@PathVariable("id") String id) {
		PatrolMission mission = new PatrolMission();
		mission.setId(id);
		mission.setUpdate(getUserId());
		RestResult<String> passResult = patrolMissionService.pass(mission);
		return passResult;
	}

	@ApiOperation(value = "保存巡检记录", notes = "")
	@RequestMapping(value = "/record/save", method = RequestMethod.POST)
	public RestResult<String> saveRecord(@Validated @RequestBody PatrolMissionDTO patrolMissionDTO) {
		PatrolMission mission = patrolMissionDTO.toObject(PatrolMission.class);
		mission.setCreate(getUserId());
		RestResult<String> updateResult = patrolMissionService.saveRecord(mission);
		return updateResult;
	}

	@ApiOperation(value = "保存并提交巡检记录", notes = "")
	@RequestMapping(value = "/record/save_submit", method = RequestMethod.POST)
	public RestResult<String> saveAndSubmitRecord(@Validated @RequestBody PatrolMissionDTO patrolMissionDTO) {
		PatrolMission mission = patrolMissionDTO.toObject(PatrolMission.class);
		mission.setUpdate(getUserId());
		RestResult<String> updateResult = patrolMissionService.saveRecord(mission);
		if (updateResult.getCode() != ResponseStatus.OK.getCode())
			return updateResult;
		RestResult<String> setStatusResult = patrolMissionService.setMissionStatus(mission.getId(), MissionStatus.WAIT_CHECK);
		return setStatusResult;
	}

	@ApiOperation(value = "提交巡检记录", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/submit/{id}", method = RequestMethod.POST)
	public RestResult<String> submit(@PathVariable("id") String id) {
		RestResult<String> setStatusResult = patrolMissionService.setMissionStatus(id, MissionStatus.WAIT_CHECK);
		return setStatusResult;
	}

	@ApiOperation(value = "验收", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "id", value = "修复单ID ", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "string", name = "state", value = "通过(1)/不通过(0) ", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "string", name = "remark", value = "修复单ID ", required = true) })
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public RestResult<String> check(@NotBlank(message = "任务ID不能为空") String id,
			@Pattern(regexp = "^[0,1]{1}$", message = "验收结果仅可传入【0不通过,1通过】") String state, String remark) {
		PatrolMission mission = new PatrolMission();
		mission.setId(id);
		mission.setRemarks(remark);
		mission.setUpdate(getUserId());
		RestResult<String> updateResult = patrolMissionService.check(mission, state);
		return updateResult;
	}

}
