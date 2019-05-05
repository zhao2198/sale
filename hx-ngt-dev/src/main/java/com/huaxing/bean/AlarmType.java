package com.huaxing.bean;

import java.math.BigDecimal;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 告警类型entity Create Date: 2018年7月13日 上午11:04:55
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@NoArgsConstructor
public class AlarmType extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 类别名称
	private String name;
	// 排序
	private BigDecimal sort;
	// 运算符
	private String operator;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 父级编号
	private String parentId;

	private String tid;

	public AlarmType(String name, String operator, String parentId, String tid) {
		this.name = name;
		this.operator = operator;
		this.parentId = parentId;
		this.tid = tid;
	}
}
