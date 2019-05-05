package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;

/**
 * 设备参数entity Create Date: 2018年7月9日 下午2:12:16
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
public class EquipmentParam extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 参数名称
	private String name;
	// 参数类型
	private String type;
	// 二进制编号
	private String code;
	// 是否主要参数
	private String ismain;
	// 单位
	private String unit;
	// 备注信息
	private String remarks;
	// 是否启用
	private String enableFlag;

}
