package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EnergyConsumptionAnalysis extends DateTimeEntity {

	private static final long serialVersionUID = 1L;
	// 名称
	private String name;
	// 总能耗
	private BigDecimal value;
	// 能耗占比
	private String percent;
	// 电费
	private BigDecimal cost;
	// 设备类型的平均负荷
	private BigDecimal avgLoad;
	// 开始时间
	private Date startDate;
	// 结束时间
	private Date endDate;
	// 日期类型
	private String typeDate;
	// 所属公司
	private String companyId;
	// 设备类型
	private String type;
	// 设备id
	private String equipmentId;
	// 设备类型属性
	private String equipmentTypeAttribute;

	private String queryDateStart;
	private String queryDateEnd;
}
