package com.huaxing.dto;

import com.huaxing.bean.EquipmentParamConfig;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备参数配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@ApiModel(value = "设备参数配置其他参数表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentParamConfigOtherParamDTO extends TransferObject<EquipmentParamConfig> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数配置Id", required = false)
	private String id;

	@ApiModelProperty(value = "是否启用(0代表不启用，1代表启用)", required = false)
	private String enableFlag;

}
