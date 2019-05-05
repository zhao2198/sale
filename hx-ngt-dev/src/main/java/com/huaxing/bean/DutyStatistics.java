package com.huaxing.bean;

import com.huaxing.common.entity.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DutyStatistics extends IdEntity {
	private static final long serialVersionUID = 1L;
	// 返回到页面上的属性
	public String planCount;// 计划值班次数
	public String dutyCount;// 实际值班次数
	public String normalCount;// 正常值班次数
	public String unNormalCount;// 异常值班次数

	// 查询条件
	public String start;// 开始时间
	public String end;// 结束时间
	public String timeUnit;// 时间单位
	public String ondutyUserIds;// 值班人id
	public String companyId;// 公司id
	// 显示
	public String ondutyName;// 值班人姓名
}
