package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.DutyPlan;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Create Date: 2018年6月29日 下午3:11:53
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@Data
@ApiModel(value = "值班计划信息_查询")
public class DutyPlanQueryDTO extends TransferObject<DutyPlan> {
	private static final long serialVersionUID = 1L;

	// 值班编号
	@ApiModelProperty(value = "值班计划的编号", required = false)
	@NotBlank(message = "值班计划的编号不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String code;
	// 班次编号
	@ApiModelProperty(value = "班次ID", required = false)
	@NotBlank(message = "班次ID不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String clazzId;
	// 班组编号
	@ApiModelProperty(value = "班组ID", required = false)
	@NotBlank(message = "班组ID不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String teamId;
	// 值班内容
	@ApiModelProperty(value = "值班内容", required = false)
	@NotBlank(message = "值班内容不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String dutyContent;
	// 开始日期
	@ApiModelProperty(value = "开始日期", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	// 结束日期
	@ApiModelProperty(value = "结束日期", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	@ApiModelProperty(value = "值班计划的发布状态 0---未发布 1--已经发布 2--已经生成任务 3--计划执行完毕", required = true)
	@NotBlank(message = "值班计划的发布状态", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 1, groups = { AddGroup.class, UpdateGroup.class }, message = "值班计划的发布状态：0或者1")
	private String publishStatus;
}
