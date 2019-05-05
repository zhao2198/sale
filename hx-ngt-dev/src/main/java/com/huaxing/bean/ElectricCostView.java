package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用能总览  电费
 * Create Date:	2018年7月30日 上午11:52:30
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class ElectricCostView extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	private String acquisitionTime;//数据采集时间，power_cost表中的创建时间
	private BigDecimal sharpCost;//尖电费
	private BigDecimal peakCost;//峰电费
	private BigDecimal flatCost;//平电费
	private BigDecimal valleyCost;//谷电费
	private BigDecimal totalCost;//总电费
	
	private BigDecimal basicCost; //基本电费
	private BigDecimal forceCost; //力调电费
	private BigDecimal powerCost;//电度电费
	
	
	//查询基本电费时所需
	private BigDecimal capacityCost; //按容电费
	private BigDecimal demandCost;//需量电费
	private String basicCostType; //  0按容 1按需
	
	
	
	
	
	
	//mine query
	private String startDate;//查询数据开始时间
	private String endDate;//查询数据结束时间
	private String companyId; //公司id（查询时使用）
	private String dataType;//数据类型0其它设备1高压侧2低压侧
	private String equipmentId;//变压器id
	private String dateFormatStr;//sql中用来格式化日期的字符串
	private String dateType;//日月年类型 0日1月2年
}
