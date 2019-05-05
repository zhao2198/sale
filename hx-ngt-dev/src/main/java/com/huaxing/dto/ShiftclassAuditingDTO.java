package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.Shiftclass;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@ApiModel(value = "调班审批信息")
@Data
@EqualsAndHashCode(callSuper = false)
public class ShiftclassAuditingDTO extends TransferObject<Shiftclass> {
	private static final long serialVersionUID = 1L;

	// 调班标识
	@ApiModelProperty(value = "调班标识", required = false)
	@NotBlank(message = "调班标识不能为空", groups = { UpdateGroup.class })
	private String id;
	@ApiModelProperty(value = "通过意见", required = false)
	private String approve;
	@ApiModelProperty(value = "申请状态", required = false)
	private String applyStatus;
	// 退回原因
	@ApiModelProperty(value = "退回原因", required = false)
	private String reasonReject;
}
