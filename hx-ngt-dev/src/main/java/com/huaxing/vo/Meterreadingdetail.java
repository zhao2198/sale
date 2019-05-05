package com.huaxing.vo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Meterreadingdetail {
	private String time;// 时间点
	private BigDecimal value; // 时间点对应的值
}
