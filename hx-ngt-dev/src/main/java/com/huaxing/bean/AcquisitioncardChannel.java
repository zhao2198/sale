package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采集卡配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AcquisitioncardChannel extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 设备
	private String equipment;
	// 所属采集仪表
	private String collectorConfigure;
	// 所属网关
	private String collector;
	// 高压侧编号
	private String highStationNum;
	// 低压侧编号
	private String stationNum;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 启用标记
	private String enableFlag;

	// for query
	// 设备名称
	private String equipmentName;
	// 设备类型
	private String equipmentType;
	// 网关编号
	private String projectCode;
	// for update
	// 测点类型
	private String stationType;
	// 测点地址
	private String equStationNum;
}
