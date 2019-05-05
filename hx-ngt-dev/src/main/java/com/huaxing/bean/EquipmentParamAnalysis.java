package com.huaxing.bean;

import java.math.BigDecimal;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentParamAnalysis extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 传入选择的设备id
	private String[] ids;
	// 传入选择的设备id
	private String equipmentId;
	// 传入的参数属性名
	private String[] equParamAttr;
	// 开始时间
	private String startDate;
	// 结束时间
	private String endDate;
	// 日期类型
	private String typeDate;
	// 所属公司
	private String companyId;
	// 参数名称
	private String paramName;
	// 相位编码
	private String phase;
	// 参数编码
	private String paramtype;
	// 参数属性
	private String paramAttr;
	// 参数值
	private BigDecimal value;
	// 参数时间
	private String time;

	private String dateFormatStr;// sql中用来格式化日期的字符串
}
