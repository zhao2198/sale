package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用能总览电量entity
 * Create Date:	2018年7月26日 下午6:52:15
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class ElectricQuantity extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	private String acquisitionTime;//数据采集时间，power_cost表中的创建时间
	private BigDecimal sharpElectricQuantity;//尖电量
	private BigDecimal peakElectricQuantity;//峰电量
	private BigDecimal flatElectricQuantity;//平电量
	private BigDecimal valleyElectricQuantity;//谷电量
	private BigDecimal totalElectricQuantity;//总电量
	
	
	
	
	
	
	//mine query
	private String startDate;//查询数据开始时间
	private String endDate;//查询数据结束时间
	private String companyId; //公司id（查询时使用）
	private String dataType;//数据类型0其它设备1高压侧2低压侧
	private String equipmentId;//设备id（不包括变压器）
	private String dateFormatStr;//sql中用来格式化日期的字符串
	private String dateType;//日月年类型 0日1月2年
	
	
	private String countType;//大屏投放综合数据统计的共用type
}
