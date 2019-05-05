package com.huaxing.vo;

import java.util.List;

import lombok.Data;

@Data
public class EchartsOption {
	private List<Series> series; // 详细数据
	private List<String> xAxis_data; // X轴所需的数据,范例[2017-01,2017-02....]
	private Legend legend; // 图例,图例的data长度应该于series的size相同

}
