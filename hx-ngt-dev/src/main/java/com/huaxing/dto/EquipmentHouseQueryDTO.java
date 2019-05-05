package com.huaxing.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.huaxing.bean.EquipmentHouse;
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
@ApiModel(value = "物料查询库存")
public class EquipmentHouseQueryDTO extends TransferObject<EquipmentHouse> {
	private static final long serialVersionUID = 1L;

	// 设备名称
	@ApiModelProperty(value = "物料名称", required = false)
	private String name;
	// 设备名称
	@ApiModelProperty(value = "物料编号", required = false)
	private String code;

	// 设备型号
	@ApiModelProperty(value = "设备型号", required = false)
	private String type;

	// 设备类型
	@ApiModelProperty(value = "设备类型", required = false)
	private String category;

	// for select
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "开始购买日期", required = false)
	private Date beginPurchaseyear;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "结束 购买日期", required = false)
	private Date endPurchaseyear;

}
