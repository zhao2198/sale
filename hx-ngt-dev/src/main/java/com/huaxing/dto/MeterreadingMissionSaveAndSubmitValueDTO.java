package com.huaxing.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.huaxing.bean.MeterreadingMission;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(value = "保存抄表数VO")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingMissionSaveAndSubmitValueDTO extends TransferObject<MeterreadingMission> {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "主键", required = true)
	@NotBlank(message="任务ID不能为空")
	private String id;
	
	@ApiModelProperty(value = "表数", required = true)
	@NotNull(message="抄表数不能为空")
	@PositiveOrZero(message="抄表数不能小于0")
	private BigDecimal value;

}
