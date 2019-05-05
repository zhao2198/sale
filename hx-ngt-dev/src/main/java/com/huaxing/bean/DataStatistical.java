package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
/**
 * 能管在线统计数据bean
 * 
 * Create Date:	2018年10月16日 上午10:16:46
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class DataStatistical extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	private String equipmentId;//设备id
	private String companyId;//公司id
	private String dataType; //数据类型（0设备1高压侧2低压侧）
	private BigDecimal maxValue;//数据最大值
	private BigDecimal minValue;//最小值
	private BigDecimal avgValue;//平均值
	private Date maxDate;//最大值发生时间
	private Date minDate; //最小值发生时间
	private String columnFlag;//统计哪个字段 标志  功率因数：sum_power_factor  视在功率：sum_apparent_power(用来计算负载率=视在功率/变压器额定容量)  有功功率总（负荷）：sum_active_power
	private String createDateFormat;//创建日期格式化
	private String startDate;
	private String endDate;
}
