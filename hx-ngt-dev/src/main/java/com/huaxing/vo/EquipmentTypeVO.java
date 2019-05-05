package com.huaxing.vo;

import java.math.BigDecimal;

import com.huaxing.bean.EquipmentType;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Create Date: 2018年7月31日 下午5:59:42
 * 
 * @version: V3.0.1
 * @author: feng yi
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "设备类型树表;")
public class EquipmentTypeVO extends TransferObject<EquipmentType> {

	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 类别名称
	@ApiModelProperty(value = "类别名称", required = false)
	private String name;
	// 排序
	@ApiModelProperty(value = "排序", required = false)
	private BigDecimal sort;
	// 分类的标识
	@ApiModelProperty(value = "分类的标识", required = false)
	private String type;
	// 父级编号
	@ApiModelProperty(value = "父级编号", required = false)
	private String parentId;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

	@ApiModelProperty(value = "备注信息", required = false)
	private String tid;

}
