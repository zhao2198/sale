package com.huaxing.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.huaxing.bean.EquipmentStockRecord;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 出入库记录; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-09 09:10:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "保存出入库记录;")
public class EquipmentStockRecordSaveDTO extends TransferObject<EquipmentStockRecord> {
	private static final long serialVersionUID = 1L;

	// 物料
	@ApiModelProperty(value = "物料", required = false)
	@NotBlank(message = "物料id不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 100, message = "长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String materiel;
	// 物料
	@ApiModelProperty(value = "物料编号", required = false)
	@NotBlank(message = "物料编号", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 64, message = "长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String code;
	// 数量
	@ApiModelProperty(value = "数量", required = false)
	@NotBlank(message = "数量不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Digits(message = "必须为数字，精度为（10,0）", groups = { AddGroup.class, UpdateGroup.class }, fraction = 0, integer = 10)
	private String number;
	// 理由
	@ApiModelProperty(value = "出入库说明", required = false)
	@NotBlank(message = "说明不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 100, message = "长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String desciption;
	// 操作
	@ApiModelProperty(value = "操作", required = false)
	@NotBlank(message = "操作标志不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 64, message = "长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String operation;

}
