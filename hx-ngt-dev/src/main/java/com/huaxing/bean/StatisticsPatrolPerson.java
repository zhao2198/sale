package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;

@Data
public class StatisticsPatrolPerson extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// for select
	private String patrolSchemeType;// 巡检性质 (全部 -all,计划巡检-0,故障巡检-1,特巡-2,夜间巡检-3,监察巡检-4,临时巡检-5,定期巡检-6
	private String state; // 状态,全部-all,未受理-0,待巡检-1,已巡检-2,已终止-3
	private String dateTimeUnit; // 时间日期单位,有日月年
	private String startDate; // 开始日期
	private String endDate; // 结束日期
	private String handlerId;
	private String companyId; // 巡检单位的id
	private String typeLabel;
	private String dateFormatStr;//日期格式化格式
	// for view
	private String handlerName;
	private String count;// 总巡检次数
	private String planPatrolCount;// 计划巡检
	private String errorPatrolCount;// 故障巡检
	private String specilPatrolCount;// 特巡
	private String nightPatrolCount;// 夜间巡检
	private String watchPatrolCount;// 监察巡检
	private String oncePatrolCount;// 临时巡检
	private String dutyPatrolCount;// 定期巡检
	
	private String createDateStr;	//创建时间str
	private Integer totalCount;//巡检次数int型
}
