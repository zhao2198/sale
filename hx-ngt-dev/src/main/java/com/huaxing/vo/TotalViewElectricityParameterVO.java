package com.huaxing.vo;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用能总览用电参数vo
 * Create Date:	2018年8月3日 上午10:31:55
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@ApiModel(value="用能总览用电参数返回信息")
@Data
public class TotalViewElectricityParameterVO {
	@ApiModelProperty(value = "功率因数",required=true)
	private BigDecimal sumPowerFactor;//功率因数
	@ApiModelProperty(value = "负载率",required=true)
	private BigDecimal loadRate;//负载率
	@ApiModelProperty(value = "电价",required=true)
	private BigDecimal electricPrice;//电价
}
