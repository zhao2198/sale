package com.huaxing.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ElectricPriceBasic extends ElectricBasic {
	private static final long serialVersionUID = 1L;
	// 电费模板主表id（ngt_electric_cost_template_setting）
	// 基本电费电价类型 0 按容量 1 按需量
	private String electricCostBasicType;
	// 基本电费电价（值）
	private String electricCostBasicValue;
	// 起始阶梯电量
	private String electricStart;
	// 结束阶梯电量
	private String electricEnd;
	// 阶梯标志（1第一阶梯2第二阶梯3第三阶梯4第四阶梯）
	private String basicSign;

}
