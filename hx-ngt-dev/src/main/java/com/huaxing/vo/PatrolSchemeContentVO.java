package com.huaxing.vo;

import com.huaxing.bean.PatrolSchemeContent;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@Data
@ApiModel(value = "")
public class PatrolSchemeContentVO extends TransferObject<PatrolSchemeContent> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 排序
	@ApiModelProperty(value = "排序", required = false)
	private String sort;
	// 建筑物id
	@ApiModelProperty(value = "建筑物id", required = false)
	private String locationId;
	// 建筑物名称
	@ApiModelProperty(value = "建筑物名称", required = false)
	private String locationName;
	// 花费的时间
	@ApiModelProperty(value = "花费的时间", required = false)
	private String time;
	// 设备id
	@ApiModelProperty(value = "设备id", required = false)
	private String equipmentId;
	// 设备id
	@ApiModelProperty(value = "设备名称", required = false)
	private String equipmentName;

	// 设备id
	@ApiModelProperty(value = "设备编码", required = false)
	private String equipmentCode;

}
