package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用电参数列表返回信息
 * Create Date:	2018年7月26日 下午4:08:41
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="用电参数列表返回数据")
public class ElectricityParameterListVO {
	//采集时间
	@ApiModelProperty(value="数据统计时间",required=true)
	private String acquisitionTime;
	//平均数据
	@ApiModelProperty(value="数据平均值",required=true)
	private BigDecimal avgValue;
	//最大数据
	@ApiModelProperty(value="数据最大值",required=true)
	private BigDecimal maxValue;
	//最小数据
	@ApiModelProperty(value="数据最小值",required=true)
	private BigDecimal minValue;
	//最大数据发生时间
	@ApiModelProperty(value="最大数据发生时间",required=true)
	private Date maxDate;
	//最小数据发生时间
	@ApiModelProperty(value="最小数据发生时间",required=true)
	private Date minDate;
	//返给前台的数据类型
	@ApiModelProperty(value="数据类型（0功率因数1负载率）",required=true)
	private String parameterType;
}
