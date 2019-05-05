package com.huaxing.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.MeterreadingMission;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.MeterreadingStatisticsDayDto;
import com.huaxing.service.MeterreadingMissionService;
import com.huaxing.vo.MeterReadingStatistics;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Create Date: 2018年7月30日 上午11:37:55
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@RestController
@Api(tags = "能管在线：抄表统计")
@RequestMapping("/api/meterreading/sta")
@Slf4j
public class MeterreadingStatisticsController extends BaseController<MeterreadingMission, Serializable> {
	@Autowired
	private MeterreadingMissionService missionService;

	@ApiOperation(value = "以天为单位统计抄表", notes = "")
	@RequestMapping(value = "/day_view", method = RequestMethod.GET)
	public RestResult<MeterReadingStatistics> getDayViewMissionlist(MeterreadingStatisticsDayDto dto) {
		MeterreadingMission queryData = dto.toObject(MeterreadingMission.class);
		String meterIds = dto.getMeterIds();
		String[] meterIdArr = meterIds.split(",");
		queryData.setMeterIdArr(meterIdArr);
		queryData.setCompanyId(this.getCompanyId());
		MeterReadingStatistics vo = missionService.staDay(queryData);
		return RestResultUtil.ok(vo);
	}

	@ApiOperation(value = "以月为单位统计抄表", notes = "")
	@RequestMapping(value = "/month_view", method = RequestMethod.GET)
	public RestResult<MeterReadingStatistics> getMonthViewMissionlist(MeterreadingStatisticsDayDto dto) {
		MeterreadingMission queryData = dto.toObject(MeterreadingMission.class);
		String meterIds = dto.getMeterIds();
		String[] meterIdArr = meterIds.split(",");
		queryData.setMeterIdArr(meterIdArr);
		queryData.setCompanyId(this.getCompanyId());
		MeterReadingStatistics vo = missionService.staMonth(queryData);
		return RestResultUtil.ok(vo);
	}
}
