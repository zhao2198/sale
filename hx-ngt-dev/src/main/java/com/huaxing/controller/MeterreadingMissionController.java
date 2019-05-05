package com.huaxing.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;

import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.utils.StringUtils;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.MeterreadingMissionDTO;
import com.huaxing.dto.MeterreadingMissionInfoDTO;
import com.huaxing.dto.MeterreadingMissionSaveAndSubmitValueDTO;
import com.huaxing.dto.MeterreadingMissionSaveValueDTO;
import com.huaxing.bean.MeterreadingMission;
import com.huaxing.service.MeterreadingMissionService;
import com.huaxing.vo.MeterreadingMissionContentVO;
import com.huaxing.vo.MeterreadingMissionDayListVO;
import com.huaxing.vo.MeterreadingMissionVO;
import com.huaxing.vo.MeterreadingSchemeMeterListVO;




/**
 * 抄表任务表; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@RestController
@Api(tags="能管在线：抄表任务")
@RequestMapping("/api/meterreading/mission")
@Slf4j
public class MeterreadingMissionController extends BaseController<MeterreadingMission, Serializable> {
	@Autowired
	private MeterreadingMissionService missionService;
	
	@ApiOperation(value = "查询指定日期的任务列表", notes = "")
	@RequestMapping(value = "/list/day_view", method = RequestMethod.GET)
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query",value="需查询的日期",name="date",required=true),
	})
	public RestResult<PagingList<MeterreadingMissionDayListVO>> getDayViewMissionlist(@DateTimeFormat(pattern="yyyy-MM-dd")Date date,PagingAttribute pagAttr){
		PagingList<MeterreadingMissionDayListVO> voList = missionService.getDayViewMissionlist(getUserId(),date,pagAttr);
		return RestResultUtil.ok(voList);
	}
	
	@ApiOperation(value = "查询指定表计，指定日期的任务列表", notes = "")
	@RequestMapping(value = "/list/meter/day_view", method = RequestMethod.GET)
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query",value="需查询的日期",name="date",required=true),
		@ApiImplicitParam(paramType="query",value="表计ID",name="meterId",required=true),
	})
	public RestResult<PagingList<MeterreadingMissionContentVO>> getMeterDayViewMissionlist(@DateTimeFormat(pattern="yyyy-MM-dd")Date date,
			@NotBlank(message="表计ID不能为空")String meterId,PagingAttribute pagAttr){
		PagingList<MeterreadingMissionContentVO> voList = missionService.getMeterDayViewMissionlist(meterId,getUserId(),date,pagAttr);
		return RestResultUtil.ok(voList);
	}
	
	
	/**
	 * 信息
	 */
	@ApiOperation(value = "详情", notes = "")
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public RestResult<MeterreadingMissionVO> info(MeterreadingMissionInfoDTO mission){
		String id = mission.getId();
		String meterId = mission.getMeterId();
		Date date = mission.getDay();
		String time = mission.getTime();
		if(StringUtils.allIsEmpty(id,meterId)) {
			return RestResultUtil.failed("id和meterId至少需要传入一个");
		}else if(StringUtils.isBlank(id)&&(StringUtils.hasEmpty(time)||date==null)) {
			return RestResultUtil.failed("meterId,date,time必须同时传入");
		}
		MeterreadingMission queryParam = new MeterreadingMission();
		if(StringUtils.isNotBlank(id)) {
			queryParam.setId(id);
		}else {
			queryParam.setMeterId(meterId);
			queryParam.setDay(date);
			queryParam.setTime(time);
		}
		MeterreadingMission meterreadingMission = missionService.getById(queryParam);
		if(meterreadingMission==null) {
			return RestResultUtil.failed("没有查询到数据");
		}
		MeterreadingMissionVO vo = new MeterreadingMissionVO();
		BeanUtils.copyProperties(meterreadingMission, vo);
		return RestResultUtil.ok(vo);
	}
	
	/**
	 * 保存
	 */
/*	@ApiOperation(value = "创建", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<MeterreadingMission> create(@RequestBody MeterreadingMission meterreadingMission){
		missionService.save(meterreadingMission);
		
		return RestResultUtil.ok();
	}*/
	
	@ApiOperation(value = "保存抄表数值", notes = "")
	@RequestMapping(value = "/value" , method = RequestMethod.POST)
	public RestResult<String> saveMeterValue(@RequestBody MeterreadingMissionSaveValueDTO meterreadingMission){
		MeterreadingMission mission = meterreadingMission.toObject(MeterreadingMission.class);
		mission.setHandlerId(getUserId());
		return missionService.saveMeterValue(mission);
	}
	
	@ApiOperation(value = "提交抄表数值", notes = "")
	@RequestMapping(value = "/value/submit" , method = RequestMethod.POST)
	public RestResult<String> saveMeterValue(@RequestBody MeterreadingMissionSaveAndSubmitValueDTO meterreadingMission){
		MeterreadingMission mission = meterreadingMission.toObject(MeterreadingMission.class);
		mission.setHandlerId(getUserId());
		return missionService.saveAndSubmitMeterValue(mission);
	}
	@ApiOperation(value = "提交某一天的所有保存了数值的任务", notes = "")
	@RequestMapping(value = "/date/submit" , method = RequestMethod.GET)
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query",value="日期",name="date",required=true),
	})
	public RestResult<String> submitDateValue(@NotNull(message="日期不能为空") @DateTimeFormat(pattern="yyyy-MM-dd")Date date){
		return missionService.submitDateValue(getUserId(),date);
	}
	/**
	 * 修改
	 */
/*	@ApiOperation(value = "修改", notes = "")
	@RequestMapping(value = "/update" , method = RequestMethod.PUT)
	public RestResult<MeterreadingMission> update(@RequestBody MeterreadingMission meterreadingMission){
		missionService.update(meterreadingMission);
		
		return RestResultUtil.ok();
	}*/
	
	/**
	 * 删除
	 */
/*	@ApiOperation(value = "删除", notes = "")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public RestResult delete(@RequestBody String[] ids){
		//meterreadingMissionService.deleteBatch(ids);
		
		return RestResultUtil.ok();
	}*/
	
}
