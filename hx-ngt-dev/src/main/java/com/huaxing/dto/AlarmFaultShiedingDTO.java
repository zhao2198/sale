package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.AlarmFault;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 告警中心告警信息展示dto Create Date: 2018年7月11日 上午11:10:03
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@ApiModel(value = "告警中心屏蔽原因")
@Data
@EqualsAndHashCode(callSuper = false)
public class AlarmFaultShiedingDTO extends TransferObject<AlarmFault> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "告警id", required = true)
	@NotBlank(message = "告警id")
	private String id;

	@ApiModelProperty(value = "屏蔽原因", required = true)
	@NotBlank(message = "屏蔽原因不能为空")
	private String shieldingReason;

}
