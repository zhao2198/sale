package com.huaxing.dto;

import java.util.List;

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
@ApiModel(value = "在线监测 保存其他参数")
@Data
@EqualsAndHashCode(callSuper = false)
public class CollDeviceDataOtherParamDTO extends TransferObject<CollDeviceData> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "数据类型（1高压侧，2低压侧，其他不传）", required = false)
	private String dataType;

	@ApiModelProperty(value = "其他参数配置集合", required = false)
	private List<EquipmentParamConfigOtherParamDTO> list;

}
