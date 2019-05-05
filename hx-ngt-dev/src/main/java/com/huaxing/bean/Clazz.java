package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 班次实体类
 * 
 * @author Xie Ning
 * @date 2018-06-25 09:17:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Clazz extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 班次编号
	private String code;
	// 班次名称
	private String name;
	// 开始时间
	private Date startTime;
	// 结束时间
	private Date endTime;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 逻辑删除标记（0：显示；1：隐藏）
	private String delFlag;
	// 使能标记（0：启用；1：隐藏）
	private String enableFlag;
}
