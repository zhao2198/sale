package com.huaxing.vo;

import com.huaxing.bean.StatisticsPatrolPerson;
import com.huaxing.common.web.transfer.TransferObject;

import lombok.Data;

/**
 * 巡检统计
 * 
 * @author Xie Ning
 * @date 2018-06-25 09:17:23
 */
@Data
public class StatisticsPatrolPersonVo extends TransferObject<StatisticsPatrolPerson> {
	private static final long serialVersionUID = 1L;
	// for view
	// private EchartsOption option;// echarts图所需数据
	private String handlerName;
	private String count;// 总巡检次数
	private String planPatrolCount;// 计划巡检
	private String errorPatrolCount;// 故障巡检
	private String specilPatrolCount;// 特巡
	private String nightPatrolCount;// 夜间巡检
	private String watchPatrolCount;// 监察巡检
	private String oncePatrolCount;// 临时巡检
	private String dutyPatrolCount;// 定期巡检
}
