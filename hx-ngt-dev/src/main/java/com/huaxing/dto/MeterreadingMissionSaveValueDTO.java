package com.huaxing.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import com.huaxing.bean.MeterreadingMission;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(value = "查询抄表的日用电量")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingMissionSaveValueDTO extends TransferObject<MeterreadingMission> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键", required = true)
	@NotBlank(message = "任务ID不能为空")
	private String id;
	// @JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "表数", required = false)
	@PositiveOrZero(message = "抄表数不能小于0")
	private BigDecimal value;

}
