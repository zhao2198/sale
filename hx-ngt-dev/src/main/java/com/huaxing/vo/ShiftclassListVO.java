package com.huaxing.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.Shiftclass;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@ApiModel(value = "调班列表的详情")
@Data
@EqualsAndHashCode(callSuper = false)
public class ShiftclassListVO extends TransferObject<Shiftclass> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "调班标识", required = false)
	private String id;// 调班标识
	@ApiModelProperty(value = "调班编号", required = false)
	private String code;// 调班编号
	@ApiModelProperty(value = "申请人", required = false)
	private String applyName;// 申请人
	@ApiModelProperty(value = "(申请状态)0-未审批、1-已审批通过、2-退回", required = false)
	private String applyStatus;// (申请状态)0-未审批、1-已审批通过、2-退回
	@ApiModelProperty(value = "申请日期", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date applyDate;
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;// 备注信息
}
