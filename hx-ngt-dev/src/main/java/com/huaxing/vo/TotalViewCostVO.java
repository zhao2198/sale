package com.huaxing.vo;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="用能总览中电费返回信息")
@Data
public class TotalViewCostVO {
	@ApiModelProperty(value="今日电费",required = true)
	private BigDecimal todayCost;//今日电费
	@ApiModelProperty(value="昨日电费",required = true)
	private BigDecimal yesterdayCost;//昨日电费
	@ApiModelProperty(value="日百分比",required = true)
	private BigDecimal todayOnToday;	//今日百分比
	@ApiModelProperty(value="本月电费",required = true)
	private BigDecimal nowMonthCost;//本月电费
	@ApiModelProperty(value="上月电费",required = true)
	private BigDecimal lastMonthCost;//上月电费
	@ApiModelProperty(value="月百分比",required = true)
	private BigDecimal monthOnMonth;		//月百分比
	@ApiModelProperty(value="本年电费",required = true)
	private BigDecimal nowYearCost;//本年电费
	@ApiModelProperty(value="去年电费",required = true)
	private BigDecimal lastYearCost;//去年电费
	@ApiModelProperty(value="年百分比",required = true)
	private BigDecimal yearOnYear;	//年百分比
}
