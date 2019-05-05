package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.EquipmentHouse;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 库存管理; InnoDB free: 10240 kB; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-09 09:10:19
 */
@Data
@ApiModel(value = "库存管理; ")
public class EquipmentHouseVO extends TransferObject<EquipmentHouse> {
	private static final long serialVersionUID = 1L;

	// id
	@ApiModelProperty(value = "id", required = false)
	private String id;
	// 设备名称
	@ApiModelProperty(value = "物料名称", required = false)
	private String name;

	@ApiModelProperty(value = "物料编号", required = false)
	private String code;
	// 生产厂家
	@ApiModelProperty(value = "生产厂家", required = false)
	private String manufacturer;
	// 设备型号
	@ApiModelProperty(value = "设备型号", required = false)
	private String type;
	// 出厂日期
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "出厂日期", required = false)
	private Date manufacturedate;
	// 购买日期
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "购买日期", required = false)
	private Date purchaseyear;
	// 设备单价
	@ApiModelProperty(value = "设备单价", required = false)
	private BigDecimal price;
	// 设备说明
	@ApiModelProperty(value = "设备说明", required = false)
	private String desciption;
	// 设备图片
	@ApiModelProperty(value = "设备图片", required = false)
	private String picture;

	// 设备类型
	@ApiModelProperty(value = "设备类型", required = false)
	private String category;
	// 库存数
	@ApiModelProperty(value = "库存数", required = false)
	private String stocknumber;
	// 最小库存数
	@ApiModelProperty(value = "最小库存数", required = false)
	private String minStocknumber;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

	// for select
	@ApiModelProperty(value = "设备类型名称", required = false)
	private String categoryDictName;

}
