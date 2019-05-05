package com.huaxing.vo;

import com.huaxing.bean.EquipmentParam;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备参数相关vo Create Date: 2018年7月9日 下午2:17:11
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "设备参数返回信息")
public class EquipmentParamVO extends TransferObject<EquipmentParam> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键")
	private String id;
	// 参数名称
	@ApiModelProperty(value = "参数名称", required = false)
	private String name;
	// 参数类型
	@ApiModelProperty(value = "参数类型", required = false)
	private String type;
	// 二进制编号
	@ApiModelProperty(value = "二进制编号", required = false)
	private String code;
	// 是否主要参数
	@ApiModelProperty(value = "是否主要参数", required = false)
	private String ismain;
	//
	@ApiModelProperty(value = "参数单位", required = false)
	private String unit;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	// 是否启用
	@ApiModelProperty(value = "是否启用（1是，0否）", required = false)
	private String enableFlag;

	// 参数类型
	@ApiModelProperty(value = "参数类型名称", required = false)
	private String typeName;
}
