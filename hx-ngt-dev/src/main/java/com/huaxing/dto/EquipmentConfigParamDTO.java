package com.huaxing.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.huaxing.bean.EquipmentParamConfig;
import com.huaxing.common.validator.group.AddGroup;
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
@ApiModel(value = "设备参数配置私有属性表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentConfigParamDTO extends TransferObject<EquipmentParamConfig> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数名称", required = true)
	@NotBlank(message = "参数名称不能为空", groups = { AddGroup.class })
	private String paramName;

	@ApiModelProperty(value = "相位a/b/c/n", required = true)
	@Digits(message = "必须为数字，精度为（2,0）", groups = { AddGroup.class }, fraction = 0, integer = 10)
	private String phase;

	@ApiModelProperty(value = "测点类型(电压、电流等)", required = true)
	@Digits(message = "必须为数字，精度为（5,0）", groups = { AddGroup.class }, fraction = 0, integer = 10)
	private String paramType;

	@ApiModelProperty(value = "是否传输", required = true)
	@Digits(message = "必须为数字，精度为（4,0）", groups = { AddGroup.class }, fraction = 0, integer = 10)
	private String transmission;

}
