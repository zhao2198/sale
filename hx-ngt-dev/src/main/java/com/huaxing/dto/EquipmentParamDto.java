package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.EquipmentParam;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 设备参数dto Create Date: 2018年7月9日 下午2:22:20
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@ApiModel(value = "设备参数表单")
public class EquipmentParamDto extends TransferObject<EquipmentParam> {
	private static final long serialVersionUID = 1L;
	// 主键
	@ApiModelProperty(value = "主键", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;
	// 参数名称
	@ApiModelProperty(value = "参数名称", required = false)
	@NotBlank(message = "参数名称不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String name;
	// 参数类型
	@ApiModelProperty(value = "参数类型", required = false)
	@NotBlank(message = "参数类型不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String type;
	// 二进制编号
	@ApiModelProperty(value = "二进制编号", required = false)
	@NotBlank(message = "参数编号不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String code;
	// 是否主要参数
	@ApiModelProperty(value = "是否主要参数", required = false)
	@NotBlank(message = "是否主要参数不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String ismain;
	//
	@ApiModelProperty(value = "参数单位", required = false)
	private String unit;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	// 备注信息
	@ApiModelProperty(value = "是否启用（1是，0否）", required = false)
	private String enableFlag;

}
