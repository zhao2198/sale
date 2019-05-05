package com.huaxing.vo;

import java.util.Date;

import com.huaxing.bean.RepairRecordEquipmentStockRecord;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-05 09:23:20
 */
@Data
@ApiModel(value = "用料记录")
public class RepairRecordStockVO extends TransferObject<RepairRecordEquipmentStockRecord> {
	private static final long serialVersionUID = 1L;

	// 耗材使用数量
	private Integer stockNum;
	// 耗材id
	private String equipmentId;

	// 领料理由
	private String desciption;

	// for view
	// 用料名称
	private String name;
	// 用料类型
	private String type;
	// 库存数量
	private String stocknumber;

	private Date createDate;

}
