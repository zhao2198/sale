package com.huaxing.vo;

import java.math.BigDecimal;

import com.huaxing.bean.EnergyConsumptionAnalysis;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采集器配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@ApiModel(value = "网关配置表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class EnergyConsumptionAnalysisVO extends TransferObject<EnergyConsumptionAnalysis> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "类别Id", required = false)
	private String id;

	@ApiModelProperty(value = "名称", required = false)
	private String name;

	@ApiModelProperty(value = "总能耗", required = false)
	private BigDecimal value;

	@ApiModelProperty(value = "能耗占比", required = false)
	private String percent;

	@ApiModelProperty(value = "折标煤", required = false)
	private BigDecimal demolitionStandardCoal;

	@ApiModelProperty(value = "电费", required = false)
	private BigDecimal cost;

	@ApiModelProperty(value = "总负荷", required = false)
	private BigDecimal sumLoad;

}
