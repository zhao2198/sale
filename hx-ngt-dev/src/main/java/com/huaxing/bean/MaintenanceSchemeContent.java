package com.huaxing.bean;

import com.huaxing.common.entity.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MaintenanceSchemeContent extends IdEntity {
	private static final long serialVersionUID = 1L;

	// 排序
	private String sort;
	// 设备id
	private String equipmentId;
	// 设备名
	private String equipmentName;
	// 检查部位
	private String checkPoint;
	// 检查项目
	private String checkItem;
	// 检查要点
	private String keyPoint;
	// 检查标准
	private String checkStandard;


}
