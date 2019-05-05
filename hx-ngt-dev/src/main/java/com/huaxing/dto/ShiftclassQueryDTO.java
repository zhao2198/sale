package com.huaxing.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.Shiftclass;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@ApiModel(value = "查询调班信息")
@Data
@EqualsAndHashCode(callSuper = false)
public class ShiftclassQueryDTO extends TransferObject<Shiftclass> {
	private static final long serialVersionUID = 1L;

	// 调班标识
	@ApiModelProperty(value = "调班标识", required = false)
	private String id;
	// 申请人的id
	@ApiModelProperty(value = "申请人的id", required = false)
	private String applyId;
	// 调班编号
	@ApiModelProperty(value = "调班编号", required = false)
	private String code;
	// 申请开始时间
	@ApiModelProperty(value = "申请开始时间", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	// 申请结束时间
	@ApiModelProperty(value = "申请结束时间", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	// 申请状态 0-未审批、1-已审批通过、2-退回
	@ApiModelProperty(value = "(申请状态)0-未审批、1-已审批通过、2-退回", required = false)
	private String applyStatus;
}
