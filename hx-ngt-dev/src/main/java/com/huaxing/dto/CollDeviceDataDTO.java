package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.CollDeviceData;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InnoDB free: 8192 kB
 * 
 * @author feng yi
 * @date 2018-07-16 16:29:36
 */
@ApiModel(value = "在线监测 查询其他参数列表")
@Data
@EqualsAndHashCode(callSuper = false)
public class CollDeviceDataDTO extends TransferObject<CollDeviceData> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备id", required = true)
	@NotBlank(message = "设备Id不能为空")
	private String equipmentId;

	@ApiModelProperty(value = "数据类型（1高压侧，2低压侧，其他不传）", required = false)
	private String dataType;

	@ApiModelProperty(value = "是否启用(0未启用，1已启用)", required = false)
	private String enableFlag;

}
