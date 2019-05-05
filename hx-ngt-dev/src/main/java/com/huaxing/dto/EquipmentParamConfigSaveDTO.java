package com.huaxing.dto;

import java.util.List;

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
@ApiModel(value = "设备参数配置数据表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentParamConfigSaveDTO extends TransferObject<EquipmentParamConfig> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "所属采集卡", required = true)
	@NotBlank(message = "所属采集卡不能为空", groups = { AddGroup.class })
	private String acquisitioncardChannel;

	@ApiModelProperty(value = "分支号", required = true)
	@Digits(message = "必须为数字，精度为（8,0）", groups = { AddGroup.class }, fraction = 0, integer = 10)
	private String branchCode;

	@ApiModelProperty(value = "通道状态", required = true)
	@Digits(message = "必须为数字，精度为（1,0）", groups = { AddGroup.class }, fraction = 0, integer = 10)
	private String channelState;

	@ApiModelProperty(value = "数据来源(1代表变压器高压侧，2代表变压器低压侧，0代表设备)", required = true)
	@NotBlank(message = "数据来源不能为空", groups = { AddGroup.class })
	private String paramSource;

	@ApiModelProperty(value = "重要等级", required = true)
	@Digits(message = "必须为数字，精度为（4,0）", groups = { AddGroup.class }, fraction = 0, integer = 10)
	private String grade;

	@ApiModelProperty(value = "传输周期", required = true)
	@Digits(message = "必须为数字，精度为（8,0）", groups = { AddGroup.class }, fraction = 0, integer = 10)
	private String cycle;

	@ApiModelProperty(value = "网关编号", required = true)
	@NotBlank(message = "网关编号")
	private String projectCode;

	// 接收前台传入的设备参数对象私有属性List
	private List<EquipmentConfigParamDTO> list;
}
