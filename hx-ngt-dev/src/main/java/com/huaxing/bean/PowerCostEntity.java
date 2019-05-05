package com.huaxing.bean;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import com.huaxing.common.entity.DateTimeEntity;
/**
 * 电度电费entity  （新）
 * Create Date:	2018年7月17日 下午3:15:50
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class PowerCostEntity extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	//设备id
	private String equipmentId;
	//公司id
	private String companyId;
	//数据类型（0其它设备1高压侧2低压侧）
	private String dataType;
	//尖电费
	private BigDecimal sharpCost;
	//峰电费
	private BigDecimal peakCost;
	//平电费
	private BigDecimal flatCost;
	//谷电费
	private BigDecimal valleyCost;
	//尖电量
	private BigDecimal sharpElectricQuantity;
	//峰电量
	private BigDecimal peakElectricQuantity;
	//平电量
	private BigDecimal flatElectricQuantity;
	//谷电量
	private BigDecimal valleyElectricQuantity;
	//总电费
	private BigDecimal totalCost;
	//总电量
	private BigDecimal totalElectricQuantity;
	//年
	private Integer year;
	//月
	private Integer month;
	//日
	private Integer day;
	//创建时间
	
	
	//mine
	private String createDateFormat;//库中用来查询的时间，格式化为“yyyy-MM-dd”
}
