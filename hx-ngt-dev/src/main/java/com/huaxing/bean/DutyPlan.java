package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Create Date: 2018年7月2日 下午5:08:28
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DutyPlan extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 值班编号
	private String code;
	// 值班内容
	private String dutyContent;
	// 开始日期
	private Date startTime;
	// 结束日期
	private Date endTime;
	// 间隔天数
	private Integer intervalDay;
	// private Integer interval;
	// 值班计划的发布状态 0---未发布 1--已经发布 2--已经生成任务 3--计划执行完毕
	private String publishStatus;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 删除标记
	private String delFlag;

	// for save
	private String clazzId; // 班次标识
	private String teamId; // 班组标识

	// for select
	private Clazz clazz;
	private Team team;
	// 班次名称
	private String clazzName;
	// 班组名称
	private String teamName;
}
