package com.huaxing.vo;

import java.util.List;

import lombok.Data;

@Data
public class MeterReadingStatistics {
	private List<MeterreadingStatisticsVo> rows;// 各个设备各个时间点的抄表值
	private EchartsOption option;// echarts图表数据
	private int total;
}
