package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

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
public class PeriodicMaintenanceContentTemplate extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 检查部位
	private String checkPoint;
	// 检查项目
	private String checkItem;
	// 检查要点
	private String keyPoint;
	// 检查标准
	private String checkStandard;
	// 排序
	private String sort;
	// 模板名称
	private String templateName;
	// 设备类型id
	private String equipmentCategory;
	// 公司名
	private String companyId;
	// 搜索用的关键词
	private String keyWord;

	// 0未删除 1已删除
	private String delFlag;
	// 模板提供者 系统或者用户自定义
	private String type;

}
