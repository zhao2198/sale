package com.huaxing.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value = "保存库存;")
public class EquipmentHouseSaveDTO extends TransferObject<EquipmentHouse> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id", required = false)
	@NotBlank(message = "id不能为空", groups = { UpdateGroup.class })
	private String id;

	@ApiModelProperty(value = "物料编号", required = false)
	// @NotBlank(message = "物料编号不能为空", groups = { UpdateGroup.class })
	private String code;

	@ApiModelProperty(value = "物料名称", required = false)
	@NotBlank(message = "物料名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 100, message = "长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String name;

	@ApiModelProperty(value = "生产厂家", required = false)
	@Size(max = 64, message = "长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String manufacturer;

	@ApiModelProperty(value = "设备型号", required = false)
	@Size(max = 100, message = "长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String type;

	@ApiModelProperty(value = "出厂日期", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date manufacturedate;

	@ApiModelProperty(value = "购买日期", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date purchaseyear;

	@ApiModelProperty(value = "设备单价", required = false)
	@Digits(message = "必须为数字，精度为（10,2）", groups = { AddGroup.class, UpdateGroup.class }, fraction = 2, integer = 10)
	private BigDecimal price;

	@ApiModelProperty(value = "出入库说明", required = false)
	@Size(max = 100, message = "长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String desciption;

	@ApiModelProperty(value = "设备图片", required = false)
	@Size(max = 500, message = "长度不能大于500", groups = { AddGroup.class, UpdateGroup.class })
	private String picture;

	@ApiModelProperty(value = "设备类型", required = false)
	@Size(max = 64, message = "长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String category;

	@ApiModelProperty(value = "库存数", required = false)
	@NotBlank(message = "库存数不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Digits(message = "必须为数字，精度为（10,0）", groups = { AddGroup.class, UpdateGroup.class }, fraction = 0, integer = 10)
	private String stocknumber;

	@ApiModelProperty(value = "最小库存数", required = false)
	@NotBlank(message = "库存数不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Digits(message = "必须为数字，精度为（10,0）", groups = { AddGroup.class, UpdateGroup.class }, fraction = 0, integer = 10)
	private String minStocknumber;

	@ApiModelProperty(value = "备注信息", required = false)
	@Size(max = 255, message = "长度不能大于255", groups = { AddGroup.class, UpdateGroup.class })
	private String remarks;

	@ApiModelProperty(value = "出入库数量", required = false)
	@Digits(message = "必须为数字，精度为（10,0）", groups = { AddGroup.class, UpdateGroup.class }, fraction = 0, integer = 10)
	private String stockNumPlus;

}
