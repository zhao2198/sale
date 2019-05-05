package com.huaxing.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.huaxing.bean.EquipmentStockRecord;
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
@ApiModel(value = "查询出入库记录; InnoDB free: 9216 kB")
public class EquipmentStockRecordQueryDTO extends TransferObject<EquipmentStockRecord> {
	private static final long serialVersionUID = 1L;

	// 物料
	@ApiModelProperty(value = "物料", required = false)
	private String materiel;

	@ApiModelProperty(value = "物料编号", required = false)
	private String code;
	// 操作
	@ApiModelProperty(value = "操作", required = false)
	private String operation;
	// 领用人
	@ApiModelProperty(value = "领用人", required = false)
	private String useUser;
	// for select
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "开始 领用日期", required = false)
	private Date beginUsetime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "结束 领用日期", required = false)
	private Date endUsetime;
}
