package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class Series {
	private String name;
	private String type;
	private String stack;
	private String barWidth;// 宽度
	private List<Long> data;
	private List<BigDecimal> datas;
	private int yAxisIndex;
	// for select
	private Integer countNum;
	private String date;
}
