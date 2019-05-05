package com.huaxing.vo;

import com.huaxing.common.paging.PagingList;

import lombok.Data;

@Data
public class PatrolStatisticsVo {
	private PagingList<StatisticsPatrolPersonVo> rows;
	private EchartsOption option;
	private int total;
}
