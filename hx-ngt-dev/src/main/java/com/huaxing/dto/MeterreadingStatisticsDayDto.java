package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.MeterreadingMission;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Create Date: 2018年7月31日 上午9:26:38
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@ApiModel(value = "抄表任务以天/月为单位查询dto")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingStatisticsDayDto extends TransferObject<MeterreadingMission> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "表计ids", required = true)
	@NotBlank(message = "表计ids不能为空")
	private String meterIds;// 表计的id
	@ApiModelProperty(value = "日期", required = true)
	@NotBlank(message = "日期") // 2018-07-24-按天 2017-07-按月
	private String dayTime;
}
