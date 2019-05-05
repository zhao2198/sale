package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.EquipmentType;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Create Date: 2018年8月1日 下午2:32:43
 * 
 * @version: V3.0.1
 * @author: feng yi
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "机构能耗对比的机构对象")
public class EquipmentTypeEnergyContrastDTO extends TransferObject<EquipmentType> {
	private static final long serialVersionUID = 1L;

	// 主键
	@NotBlank(message = "ID不能为空")
	@ApiModelProperty(value = "主键", required = false)
	private String id;

	// 分类的标识
	@ApiModelProperty(value = "分类的标识", required = false)
	@NotBlank(message = "ID不能为空")
	private String type;

}
