package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.StatisticsRepairForm;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "查询修复单的人员统计")
public class StatisticsRepairFormEquipmentDTO extends TransferObject<StatisticsRepairForm> {
	private static final long serialVersionUID = 1L;
	// for select
	@ApiModelProperty(value = "设备id", required = false)
	private String equipmentId;
	@ApiModelProperty(value = "修复单类型（0 故障开单 1 缺陷开单）", required = true)
	@NotBlank(message = "修复单类型（0 故障开单 1 缺陷开单）")
	private String type;// 修复单类型（0 故障开单 1 缺陷开单）
	@ApiModelProperty(value = "修复结果(1已修复,0未修复)", required = true)
	@NotBlank(message = "修复结果")
	private String repairResult;// 修复结果 在修复记录中
	@ApiModelProperty(value = "时间日期单位 日-0    月-1  年-2", required = false)
	@NotBlank(message = "时间日期单位,日-0    月-1  年-2")
	private String dateTimeUnit; // 时间日期单位,有日月年
	@ApiModelProperty(value = "开始时间", required = false)
	/*
	 * @QueryStartDate(pattern = { DateFormatterPattrenEnum.yyyyMMdd, DateFormatterPattrenEnum.yyyyMM, DateFormatterPattrenEnum.yyyy }, message =
	 * "开始时间格式错误")
	 */
	private String startDate; // 开始日期
	/*
	 * @QueryEndDate(pattern = { DateFormatterPattrenEnum.yyyyMMdd, DateFormatterPattrenEnum.yyyyMM, DateFormatterPattrenEnum.yyyy }, message =
	 * "结束时间格式错误")
	 */
	private String endDate; // 结束日期
}
