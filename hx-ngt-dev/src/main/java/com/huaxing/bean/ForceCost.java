package com.huaxing.bean;

import java.math.BigDecimal;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 根据采集器传回的电量计算出的力调电费存放entity Create Date: 2018年5月29日 上午10:11:55
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ForceCost extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	private String equipmentId; // 设备id
	private String companyId; // 公司id
	private BigDecimal forceCost; // 力调电费
	private BigDecimal basicCost; // 基本电费
	private BigDecimal powerCost; // 电度电费
	private String factorType; // 功率因数标准（0. 0.80 1. 0.85 2. 0.90）
	private BigDecimal factorValue; // 功率因数系数
	private String month; // 月份
	private String dataType; // 数据类型（0其它设备 1 变压器高压侧数据 2 变压器低压侧数据）
}
