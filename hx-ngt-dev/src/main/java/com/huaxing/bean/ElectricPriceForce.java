package com.huaxing.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 力调电价entity Create Date: 2018年6月26日 下午3:02:33
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ElectricPriceForce extends ElectricBasic {
	private static final long serialVersionUID = 1L;
	// 电费模板主表id（ngt_electric_cost_template_setting）
	// 力调电费功率因数值
	private String electricCostForceValue;
	// 力调电费参考表的url
	private String electricCostForceUrl;

	/**
	 * 格式化力调电价功率因数
	 */
	public void formatForcevalue() {
		if (this.electricCostForceValue.equals("0")) {
			this.electricCostForceValue = "0.80";
		} else if (this.electricCostForceValue.equals("1")) {
			this.electricCostForceValue = "0.85";
		} else {
			this.electricCostForceValue = "0.90";
		}
	}
}
