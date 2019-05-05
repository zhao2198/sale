package com.huaxing.dto;

import java.util.Date;

import com.huaxing.bean.RepairRecordEquipmentStockRecord;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-05 09:23:20
 */
@Data
@ApiModel(value = "修复单材料，主要用于添加修改")
public class RepairRecordEquipmentStockRecordDTO extends TransferObject<RepairRecordEquipmentStockRecord> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "类型", required = false)
	private String type;
	@ApiModelProperty(value = "名称", required = false)
	private String name;
	// 耗材使用数量
	@ApiModelProperty(value = "耗材使用数量", required = false)
	private Integer stockNum;
	// 耗材id
	@ApiModelProperty(value = "耗材id", required = false)
	private String equipmentId;

	// 领料理由
	@ApiModelProperty(value = "领料理由", required = false)
	private String desciption;

	// 库存数量
	@ApiModelProperty(value = "库存数量，不需要传入", required = false)
	private String stocknumber;

	@ApiModelProperty(value = "创建日期，不需要传入", required = false)
	private Date createDate;

}
