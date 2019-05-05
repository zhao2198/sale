package com.huaxing.vo;

import java.math.BigDecimal;

import com.huaxing.bean.OrganizationEnergyContrast;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(value = "机构对比结果")
@Data
@EqualsAndHashCode(callSuper = false)
public class OrganizationEnergyContrastVO extends TransferObject<OrganizationEnergyContrast> {
	private static final long serialVersionUID = 1L;
	// 编号
	@ApiModelProperty(value = "编号", required = false)
	private String id;

	// 角色名称
	@ApiModelProperty(value = "设备类型名称", required = false)
	private String name;

	// 总电费
	@ApiModelProperty(value = "总电费", required = false)
	private BigDecimal totalCost;
	// 尖电费
	@ApiModelProperty(value = "尖电费", required = false)
	private BigDecimal sharpCost;
	// 峰电费
	@ApiModelProperty(value = "峰电费", required = false)
	private BigDecimal peakCost;
	// 平电费
	@ApiModelProperty(value = "平电费", required = false)
	private BigDecimal flatCost;
	// 谷电费
	@ApiModelProperty(value = "谷电费", required = false)
	private BigDecimal valleyCost;
	// 总负荷
	@ApiModelProperty(value = "总负荷", required = false)
	private BigDecimal sumLoad;
	// 总电量
	@ApiModelProperty(value = "总电量", required = false)
	private BigDecimal totalElectricQuantity;
}
