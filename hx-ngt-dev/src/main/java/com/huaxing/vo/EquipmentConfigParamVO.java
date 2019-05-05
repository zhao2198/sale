package com.huaxing.vo;

import com.huaxing.bean.EquipmentParamConfig;

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
@ApiModel(value = "设备配置中心参数配置展示表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentConfigParamVO {

	// 设备参数名称
	@ApiModelProperty(value = "设备参数名称", required = false)
	private String equipmentParamName;

	@ApiModelProperty(value = "设备参数编码", required = false)
	private String equipmentParamCode;
	// 共用编号
	@ApiModelProperty(value = "共用编号", required = false)
	private EquipmentParamConfig common;
	// A相
	@ApiModelProperty(value = "A相", required = false)
	private EquipmentParamConfig a;
	// B相
	@ApiModelProperty(value = "B相", required = false)
	private EquipmentParamConfig b;
	// C相
	@ApiModelProperty(value = "C相", required = false)
	private EquipmentParamConfig c;

}
