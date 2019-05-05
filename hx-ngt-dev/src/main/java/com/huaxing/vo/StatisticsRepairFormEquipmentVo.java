package com.huaxing.vo;

import com.huaxing.common.paging.PagingList;

import lombok.Data;

@Data
public class StatisticsRepairFormEquipmentVo {
	private PagingList<StatisticsRepairFormEqpVo> rows;
	private EchartsOption option;
	private int total;
}
