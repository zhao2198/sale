package com.huaxing.vo;

import java.util.List;

import lombok.Data;

@Data
public class MeterreadingStatisticsVo {
	private String meterId;// 表计的id
	private String meterName;// 表计的名字
	private List<Meterreadingdetail> metersDetail;// 表计及表计对应的各个时间点的数据
}
