package com.huaxing.vo;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用能总览电量返回数据
 * Create Date:	2018年8月4日 上午9:40:33
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@ApiModel(value="用能总览电量返回数据")
@Data
public class TotalViewElectricQuantityVO {
	@ApiModelProperty(value="今日电量",required = true)
	private BigDecimal todayElectricQuantity;//今日电量
	@ApiModelProperty(value="昨日电量",required = true)
	private BigDecimal yesterdayElectricQuantity;//昨日电量
	@ApiModelProperty(value="今日碳排放",required = true)
	private BigDecimal todayCarbonEmission; //今日碳排放
	@ApiModelProperty(value="日百分比",required = true)
	private BigDecimal todayOnToday;	//今日百分比
	@ApiModelProperty(value="本月电量",required = true)
	private BigDecimal nowMonthElectricQuantity;//本月电量
	@ApiModelProperty(value="上月电量",required = true)
	private BigDecimal lastMonthElectricQuantity;//上月电量
	@ApiModelProperty(value="本月碳排放",required = true)
	private BigDecimal nowMonthCarbonEmission;	//本月碳排放
	@ApiModelProperty(value="月百分比",required = true)
	private BigDecimal monthOnMonth;		//月百分比
	@ApiModelProperty(value="本年电量",required = true)
	private BigDecimal nowYearElectricQuantity;//本年电量
	@ApiModelProperty(value="去年电量",required = true)
	private BigDecimal lastYearElectricQuantity;//上年电量
	@ApiModelProperty(value="本年碳排放",required = true)
	private BigDecimal nowYearCarbonEmission;//本年碳排放
	@ApiModelProperty(value="年百分比",required = true)
	private BigDecimal yearOnYear;	//年百分比
	
	
	
}
