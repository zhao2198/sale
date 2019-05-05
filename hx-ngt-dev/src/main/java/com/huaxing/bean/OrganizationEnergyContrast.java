package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采集卡entity Create Date: 2018年7月10日 下午3:53:30
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrganizationEnergyContrast extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 开始时间
	private Date startDate;
	// 结束时间
	private Date endDate;
	// 日期类型
	private String typeDate;
	// 设备类型名称
	private String name;
	// 设备类型id的集合
	private String[] equipmentTypeId;
	// 设备类型的类型
	private String type;
	// 所属公司id
	private String companyId;
	// 总电费
	@ApiModelProperty(value = "总电费", required = false)
	private BigDecimal totalCost;
	// 尖电费
	@ApiModelProperty(value = "尖电费", required = false)
	private BigDecimal sharpCost;
	// 峰电费
	@ApiModelProperty(value = "峰电费", required = false)
	private BigDecimal peakCost;
	// 平电费
	@ApiModelProperty(value = "平电费", required = false)
	private BigDecimal flatCost;
	// 谷电费
	@ApiModelProperty(value = "谷电费", required = false)
	private BigDecimal valleyCost;
	// 总负荷
	@ApiModelProperty(value = "总负荷", required = false)
	private BigDecimal sumLoad;

	@ApiModelProperty(value = "平均负荷", required = false)
	private BigDecimal avgLoad;

	// 总电量
	@ApiModelProperty(value = "总电量", required = false)
	private BigDecimal totalElectricQuantity;
	// 设备类型属性
	private String equipmentTypeAttribute;
	// 设备id
	private String equipmentId;
}
