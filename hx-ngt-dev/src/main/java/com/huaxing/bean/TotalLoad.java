package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;

/**
 * 用能总览总负荷所需entity
 * Create Date:	2018年7月24日 下午2:17:37
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class TotalLoad extends DateTimeEntity{
	private static final long serialVersionUID = 1L;
	//采集时间
	private String acquisitionTime;
	//总负荷
	private BigDecimal totalLoad;
	//平均负荷
	private BigDecimal avgLoad;
	//最大负荷
	private BigDecimal maxLoad;
	//最大负荷发生时间
	private Date maxDate;
	//最小负荷
	private BigDecimal minLoad;
	//最小负荷发生时间
	private Date minDate;
	private String columnFlag;//统计哪个字段 标志  功率因数：sum_power_factor  视在功率：sum_apparent_power(用来计算负载率=视在功率/变压器额定容量)  有功功率总（负荷）：sum_active_power
	
	
	
	private String startDate;//查询数据开始时间
	private String endDate;//查询数据结束时间
	private String companyId; //公司id（查询时使用）
	private String dataType;//数据类型0其它设备1高压侧2低压侧
	private String equipmentId;//设备id（不包括变压器）
	private String dateFormatStr;//sql中用来格式化日期的字符串
	private String dateType;//日月年类型 0日1月2年
	
}
