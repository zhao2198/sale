package com.huaxing.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.huaxing.bean.EquipmentType;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hebo
 *
 *         上午10:07:33 2018年7月10日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "设备")
public class EquipmentTypeDTO extends TransferObject<EquipmentType> {
	private static final long serialVersionUID = 1L;

	// 主键
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	
	// 类别名称
	@ApiModelProperty(value = "类别名称", required = false)
	@NotBlank(message = "类别名称不能为空", groups = {AddGroup.class,UpdateGroup.class })
	private String name;

	// 父级编号
	@ApiModelProperty(value = "父级编号", required = true)
	@NotBlank(message = "父级编号", groups = { UpdateGroup.class, AddGroup.class })
	private String parentId;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	@Size(max = 225, message = "长度不能大于225", groups = { AddGroup.class, UpdateGroup.class })
	private String remarks;

	// 排序
	@ApiModelProperty(value = "排序", required = false)
	private BigDecimal sort;

	// 分类的标识
	@ApiModelProperty(value = "分类的标识", required = false)
	private String type;



}
