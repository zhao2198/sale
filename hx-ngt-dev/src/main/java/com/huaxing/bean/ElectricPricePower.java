package com.huaxing.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 电度电价entity Create Date: 2018年6月26日 下午2:55:21
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ElectricPricePower extends ElectricBasic {
	private static final long serialVersionUID = 1L;
	// 电费模板主表id（ngt_electric_cost_template_setting）
	// 电度电价类型 0 单一 1 自定义
	private String type;
	// 电价
	private String value;
	// 分时（小时）
	private String time;
	// 分时类型（尖峰平谷）
	private String timeType;
	// 阶梯标志 0 不启用 1 启用
	private String isladder;

	// mine
	private String[] sharpTimeArr;// 尖时段
	private String[] peakTimeArr;// 峰时段
	private String[] flatTimeArr;// 平时段
	private String[] valleyTimeArr;// 谷时段
	private String sharpPrice;// 尖电价
	private String peakPrice;// 峰电价
	private String flatPrice;// 平电价
	private String valleyPrice;// 谷电价
}
