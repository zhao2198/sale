package com.huaxing.bean;
import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;
import lombok.Data;
/**
 * 用电参数entity（虚拟）
 * Create Date:	2018年7月26日 上午9:51:02
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class ElectricityParameter extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	//采集时间
	private String acquisitionTime;
	//平均数据
	private BigDecimal avgValue;
	//最大数据
	private BigDecimal maxValue;
	//最小数据
	private BigDecimal minValue;
	//最大数据发生时间
	private Date maxDate;
	//最小数据发生时间
	private Date minDate;
	//视在功率总，用来计算负载率
	private BigDecimal sumApparentPower;
	//根据前台传来的参数类型来确定查询表中的哪个字段
	private String queryColumStr;
	//功率因数总（在用能总览的用电参数中使用）
	private BigDecimal sumPowerFactor;
	private String columnFlag;//统计哪个字段 标志  功率因数：sum_power_factor  视在功率：sum_apparent_power(用来计算负载率=视在功率/变压器额定容量)  有功功率总（负荷）：sum_active_power
	
	
	//mine query
	private String startDate;//查询数据开始时间
	private String endDate;//查询数据结束时间
	private String companyId; //公司id（查询时使用）
	private String dataType;//数据类型0其它设备1高压侧2低压侧
	private String equipmentId;//设备id（不包括变压器）
	private String dateFormatStr;//sql中用来格式化日期的字符串
	private String dateType;//日月年类型 0日1月2年
	private String parameterType;//查询类型 0 功率因数  1 负载率
}
