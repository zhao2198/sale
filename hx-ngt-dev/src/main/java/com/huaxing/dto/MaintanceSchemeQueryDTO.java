package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.common.web.transfer.TransferObject;
import com.huaxing.modules.annotation.QueryEndDate;
import com.huaxing.modules.utils.DateFormatterPattrenEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-04 09:41:30
 */
@Data
@ApiModel(value = "定保计划,用于query")
public class MaintanceSchemeQueryDTO extends TransferObject<MaintenanceScheme> {
	private static final long serialVersionUID = 1L;

	// 修复单单号
	@ApiModelProperty(value = "编号", required = false)
	private String code;

	// 开始日期
	@ApiModelProperty(value = "开始日期(计划创建日期)", required = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	// 结束日期
	@ApiModelProperty(value = "结束日期(计划创建日期)", required = false)
	@QueryEndDate(pattern= {DateFormatterPattrenEnum.yyyyMMdd})
	private Date endDate;

	@ApiModelProperty(value = "计划状态【0可编辑，1已派发任务，等待执行，2已执行任务，等待下次派发，3计划终止，4计划暂停，5计划恢复】", required = false)
	@Pattern(regexp="^\\s*$|^[0,1,2,3,4,5]{1}$",message = "计划状态校验失败，仅可传入【0可编辑，1已派发任务，等待执行，2已执行任务，等待下次派发，3计划终止，4计划暂停，5计划恢复】")
	private String state;

}
