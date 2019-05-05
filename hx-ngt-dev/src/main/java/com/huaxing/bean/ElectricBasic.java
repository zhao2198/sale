package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;
/**
 * 基本电价entity
 * Create Date:	2018年6月26日 下午3:04:17
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ElectricBasic extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 电费模板主表id（ngt_electric_cost_template_setting）
	private String templateId;
	//mine
		//阶梯电价起始电量
		private String firstStart;
		//阶梯电价结束电量
		private String firstEnd;
		//递增电价值
		private String firstLadderPrice;
		private String secondStart;
		//阶梯电价结束电量
		private String secondEnd;
		//递增电价值
		private String secondLadderPrice;
		private String thirdStart;
		//阶梯电价结束电量
		private String thirdEnd;
		//递增电价值
		private String thirdLadderPrice;
		private String fourthStart;
		//阶梯电价结束电量
		private String fourthEnd;
		//递增电价值
		private String fourthLadderPrice;
	
}
