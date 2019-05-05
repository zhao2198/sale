package com.huaxing.vo;

import java.util.Date;

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
@ApiModel(value = "出入库记录返回数据表;")
public class EquipmentStockrecordVO extends TransferObject<EquipmentStockRecord> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id", required = false)
	private String id;

	@ApiModelProperty(value = "物料", required = false)
	private String materiel;

	@ApiModelProperty(value = "物料编号", required = false)
	private String code;

	@ApiModelProperty(value = "数量", required = false)
	private String number;

	@ApiModelProperty(value = "操作", required = false)
	private String operation;

	@ApiModelProperty(value = "领用人", required = false)
	private String useUser;

	@ApiModelProperty(value = "说明", required = false)
	private String desciption;

	@ApiModelProperty(value = "操作时间", required = false)
	private Date useTime;

	// for select
	@ApiModelProperty(value = "物料名称", required = false)
	private String materielName;

	@ApiModelProperty(value = "领用人姓名", required = false)
	private String useUserName;
}
