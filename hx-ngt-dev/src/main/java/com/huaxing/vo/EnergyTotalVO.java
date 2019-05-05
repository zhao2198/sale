package com.huaxing.vo;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 用能分析中用来返回总能耗和初始化时间的vo
 * Create Date:	2018年8月30日 下午7:33:03
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="用能分析中返回总能耗及初始化时间")
public class EnergyTotalVO {
	@ApiModelProperty(value = "初始化的查询开始时间", required = true)
	private String initQueryDateStart;
	@ApiModelProperty(value = "初始化的查询结束时间", required = true)
	private String initQueryDateEnd;
	@ApiModelProperty(value = "总能耗", required = true)
	private BigDecimal totalEnergy;
}
