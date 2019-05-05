package com.huaxing.dto;

import com.huaxing.bean.EquipmentParamAnalysis;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "设备参数分析查询条件")
public class EquipmentParamAnalysisDTO extends TransferObject<EquipmentParamAnalysis> {
	private static final long serialVersionUID = 1L;
	// 传入选择的设备id
	private String[] ids;
	// 开始时间
	private String startDate;
	// 结束时间
	private String endDate;
	// 日期类型
	private String typeDate;
	// 传入的参数属性名
	private String[] equParamAttr;
}
