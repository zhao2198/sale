package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;

@Data
public class StatisticsRepairFormEmp extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// for select
	private String empId;// 设备id
	private String type;// 修复单类型（0 故障开单 1 缺陷开单）
	private String dateTimeUnit; // 时间日期单位,有日月年
	private Date startDate; // 开始日期
	private Date endDate; // 结束日期

	// for view and select
	private String repairState;// 修复结果 修复单状态（0未受理 1已受理 2 待验收 3 已验收 4验收未通过）？？
	private int total_all; // 总数
	private int total_successRepair;// 成功修复数
	private int total_faileRepair; // 未成功修复数
	private int total_unHandle; // 未处理数
	private String remarks;// 备注
}
