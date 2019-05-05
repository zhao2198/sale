package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.StatisticsRepairForm;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 按人员统计修复单dto
 * Create Date:	2018年9月13日 下午7:55:05
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value = "查询修复单的人员统计")
public class StatisticsRepairFormPersonDTO extends TransferObject<StatisticsRepairForm> {
	private static final long serialVersionUID = 1L;
	// for select
	@ApiModelProperty(value = "受理人id", required = false)
	private String handlerId;// 受理人ids
	@ApiModelProperty(value = "修复单类型（0 故障开单 1 缺陷开单 ‘’全部）", required = true)
	private String type;// 修复单类型（0 故障开单 1 缺陷开单）
	@ApiModelProperty(value = "修复结果(1已修复,0未修复 ‘’全部)", required = true)
	private String repairResult;// 修复结果 在修复记录中
	@ApiModelProperty(value = "时间日期单位0日1月2年", required = true)
	@NotBlank(message = "时间日期单位0日1月2年")
	private String dateType; // 时间日期单位,有日月年
	@ApiModelProperty(value = "开始时间", required = true)
	private String startDate; // 开始日期
	@ApiModelProperty(value = "结束时间", required = true)
	private String endDate; // 结束日期
}
