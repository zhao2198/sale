package com.huaxing.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 阶梯电价entity Create Date: 2018年6月26日 下午3:01:12
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ElectricPriceLadder extends ElectricBasic {
	private static final long serialVersionUID = 1L;
	// 电费模板主表id（ngt_electric_cost_template_setting）
	// 阶梯电价起始电量
	private String electricCostLadderStart;
	// 阶梯电价结束电量
	private String electricCostLadderEnd;
	// 递增电价值
	private String electricCostLadderValue;
	// 阶梯类型 0 年 1 月
	private String electricCostLadderType;
	// 阶梯标志（1第一阶梯2第二阶梯3第三阶梯4第四阶梯）
	private String ladderSign;

}
