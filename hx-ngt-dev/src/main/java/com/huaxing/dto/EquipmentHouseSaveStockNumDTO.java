package com.huaxing.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.huaxing.bean.EquipmentHouse;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 库存管理; InnoDB free: 10240 kB; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-09 09:10:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "保存出入库数量;")
public class EquipmentHouseSaveStockNumDTO extends TransferObject<EquipmentHouse> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id", required = false)
	@NotBlank(message = "id不能为空", groups = { UpdateGroup.class })
	private String id;

	@ApiModelProperty(value = "出入库说明", required = false)
	@Size(max = 100, message = "长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String desciption;

	@ApiModelProperty(value = "出入库数量", required = false)
	@Digits(message = "必须为数字，精度为（10,0）", groups = { AddGroup.class, UpdateGroup.class }, fraction = 0, integer = 10)
	private String stockNumPlus;

}
