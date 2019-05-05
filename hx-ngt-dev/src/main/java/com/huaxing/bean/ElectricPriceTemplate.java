package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 电费模板entity Create Date: 2018年6月26日 下午2:51:11
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ElectricPriceTemplate extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 设备id（变压器id）
	private String equipmentId;
	// 公司id
	private String companyId;
	// 模板编号
	private String templateCode;
	// 模板名称
	private String templateName;
	// 电价类型 1电度电费的电价，2基本电费的电价，3力调电费的电价
	private String electricCostType;

	// mine
	// 变压器名称
	private String equipmentName;
}
