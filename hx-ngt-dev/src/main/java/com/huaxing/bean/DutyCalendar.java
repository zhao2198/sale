package com.huaxing.bean;

import com.huaxing.common.entity.IdEntity;

import lombok.Data;

@Data
public class DutyCalendar extends IdEntity {
	private static final long serialVersionUID = 1L;
	private String title; // 值班内容，事件的标题
	private String start; // 事件开始时间
	private String end; // 事件结束时间
	private String allDay; // 是否为全天时间
	private String color; // 事件的背景色
}
