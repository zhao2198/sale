package com.huaxing.bean;

import java.math.BigDecimal;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 根据采集器传回的电量计算出的电度电费存放entity Create Date: 2018年5月29日 上午10:11:55
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PowerCost extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	private String dataId; // 数据表id
	private String equipmentId; // 设备id
	private String companyId; // 公司id
	private BigDecimal currentElectr; // 本次电量
	private BigDecimal cost; // 电费
	private BigDecimal electrovalence; // 电价
	private String dataType; // 数据类型（0其它设备1高压侧数据2低压侧数据）
	private String type; // 所属时间段（0尖1峰2平3谷）
}
