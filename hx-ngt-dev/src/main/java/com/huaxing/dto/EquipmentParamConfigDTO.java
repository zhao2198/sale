package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

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
@ApiModel(value = "设备参数配置查询表; ")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentParamConfigDTO extends TransferObject<EquipmentParamConfig> {
	private static final long serialVersionUID = 1L;

	// 数采仪的地址
	@ApiModelProperty(value = "测点地址", required = true)
	@NotBlank(message = "测点地址不能为空")
	private String branchCode;

	@ApiModelProperty(value = "变压器高低压侧数据来源", required = false)
	private String paramSource;

	@ApiModelProperty(value = "网关编号", required = false)
	private String projectCode;

}
