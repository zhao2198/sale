package com.huaxing.bean;

import java.math.BigDecimal;

import com.huaxing.common.entity.DateTimeEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 类别能耗排名、建筑能耗排名、组织能耗排名（虚拟对象）
 * Create Date:	2018年7月13日 上午11:04:55
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class EnergyRank extends DateTimeEntity{
	private static final long serialVersionUID = 1L;
	private String name; //名称（建筑、类别、组织）
	private BigDecimal sharpElectricQuantity; //尖能耗(电量)
	private BigDecimal peakElectricQuantity;//峰能耗（电量）
	private BigDecimal flatElectricQuantity;//平能耗（电量）
	private BigDecimal valleyElectricQuantity;//谷能耗（电量）
	private BigDecimal totalElectricQuantity;//总能耗（电量）
	
	
	
	private String startDate;//查询数据开始时间
	private String endDate;//查询数据结束时间
	private String companyId; //公司id（查询时使用）
	private String dataType;//数据类型0其它设备1高压侧2低压侧
	private String equipmentId;//设备id（不包括变压器）
	
	private String buildingName;//建筑名称
	private String categoryName;//类别名称
	private String departmentName;//部门（组织）名称
	
	
}
