package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;

/**
 * 告警故障entity Create Date: 2018年7月11日 上午11:06:52
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
public class AlarmFault extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 告警时间
	private Date alarmTime;
	// 设备名称
	private String equipmentId;
	// 参数名称
	private String paramName;
	// 告警名称
	private String alarmTypeId;
	// 告警等级
	private String alarmGradeId;
	// 告警状态 0未确认 1 已确认 2已屏蔽 3取消屏蔽
	private String alarmState;
	// 开单状态 0未开单1 已开单
	private String newformState;
	// 屏蔽原因
	private String shieldingReason;
	// 当前值
	private BigDecimal nowValue;
	// 设定值
	private BigDecimal settingValue;
	// 告警是否恢复，0已恢复，1未恢复
	private String returnNormal;
	// 参数标签
	private String measuretag;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 时间类型
	private String dateType;
	// 告警时间开始时间
	private String alarmTimeStart;
	// 告警结束时间
	private String alarmTimeEnd;
	// 告警时间字符串，用于sql返回时
	private String alarmTimeStr;
	// 年月日格式化字符串
	private String formatStr;
	// 告警总数量
	private Integer alarmNum;
	// 开始日期
	private Date startDate;
	// 结束日期
	private Date endDate;
	// 告警颜色
	private String color;
	// 告警重要等级
	private String importantLevel;
	// 告警声音
	private String sound;

	// 设备名称
	private String equipmentName;
	// 告警名称
	private String alarmTypeName;
	// 告警等级
	private String alarmGradeName;
}
