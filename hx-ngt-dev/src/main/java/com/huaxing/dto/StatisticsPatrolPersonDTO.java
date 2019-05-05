package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.StatisticsPatrolPerson;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "查询巡检")
public class StatisticsPatrolPersonDTO extends TransferObject<StatisticsPatrolPerson> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "巡检性质 (全部 -all,计划巡检-0,故障巡检-1,特巡-2,夜间巡检-3,监察巡检-4,临时巡检-5,定期巡检-6)", required = true)
	@NotBlank(message = "必须输入巡检性质 (全部 -all,计划巡检-0,故障巡检-1,特巡-2,夜间巡检-3,监察巡检-4,临时巡检-5,定期巡检-6)")
	private String patrolSchemeType;
	@ApiModelProperty(value = "状态(全部-all,未受理-0,待巡检-1,已巡检-2,已终止-3)", required = true)
	@NotBlank(message = "必须输入巡检状态(全部-all,未受理-0,待巡检-1,已巡检-2,已终止-3)")
	private String state;
	@ApiModelProperty(value = "时间日期单位", required = false)
	@NotBlank(message = "时间日期单位,日-0    月-1  年-2")
	private String dateTimeUnit;
	// 时间日期单位,有日月年
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
	@ApiModelProperty(value = "巡检人的id", required = false)
	private String handlerId;
}
