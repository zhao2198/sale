package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.huaxing.bean.PatrolMission;
import com.huaxing.common.web.transfer.TransferObject;
import com.huaxing.modules.annotation.QueryEndDate;
import com.huaxing.modules.utils.DateFormatterPattrenEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-04 09:41:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "巡检任务,用于query")
public class PatrolMissionQueryDTO extends TransferObject<PatrolMission> {
	private static final long serialVersionUID = 1L;

	// 修复单单号
	@ApiModelProperty(value = "单号", required = false)
	private String code;

	// 开始日期
	@ApiModelProperty(value = "开始日期(任务创建日期)", required = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	// 结束日期
	@ApiModelProperty(value = "结束日期(任务创建日期)", required = false)
	@QueryEndDate(pattern= {DateFormatterPattrenEnum.yyyyMMdd})
	private Date endDate;

	@ApiModelProperty(value = "状态【0未受理,1修复中,2待验收,3已验收已通过,4已验收未通过,5已终止】", required = false)
	@Pattern(regexp="^\\s*$|^[0,1,2,3,4,5]{1}$",message="任务状态校验失败，仅可接收【0未受理,1修复中,2待验收,3已验收已通过,4已验收未通过,5已终止】")
	private String state;

	@ApiModelProperty(value = "巡检类别(0计划巡检,1故障巡检，2特巡，3夜间巡检，4检查巡检，5临时巡检，6定期巡检)", required = false)
	@Pattern(regexp="^\\s*$|^[0,1,2,3,4,5,6]{1}$",message = "巡检类别仅可传入【0计划巡检,1故障巡检，2特巡，3夜间巡检，4检查巡检，5临时巡检，6定期巡检】")
	private String type;
}
