package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 抄表任务表; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingMission extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 表计ID
	private String meterId;
	// 时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）
	private String time;
	// 所属日期
	private Date day;
	// 表数
	private BigDecimal value;
	// 抄表人ID
	private String handlerId;
	// 抄表人员IDS
	private String handlerIds;
	// 状态位(0等待填写数据 1已经填写数据等待提交 2已经提交)
	private String state;
	// 备注信息
	private String memo;

	// for select
	// 时间s
	private String[] times;
	// 开始日期
	private Date startDate;
	// //结束日期（含）
	private Date endDate;
	// for stastics
	private String meterIds;
	// 表计的id
	/*
	 * private String startime;// 开始时间 private String endime;// 结束时间
	 */
	private String[] meterIdArr;// 表计的id的集合
	private String meterName;// 设备名称
	private String companyId;// 设备所在的公司的id
	private String dayTime;// 查询时的具体某一天或者某个月的抄表

}
