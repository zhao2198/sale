package com.huaxing.vo;

import com.huaxing.bean.DutyStatistics;
import com.huaxing.common.web.transfer.TransferObject;

import lombok.Data;

@Data
public class DutyStatisticsVO extends TransferObject<DutyStatistics> {
	private static final long serialVersionUID = 1L;
	public String planCount;// 计划值班次数
	public String ondutyCount;// 实际值班次数
	public String normalCount;// 正常值班次数
	public String unNormalCount;// 异常值班次数
	public String ondutyId;// 值班人id
	public String ondutyName;// 值班人姓名
}
