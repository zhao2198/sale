package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-05 09:23:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RepairRecordEquipmentStockRecord extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 记录id
	private String recordId;
	// 耗材使用数量
	private Integer stockNum;
	// 耗材id
	private String equipmentId;

	// 领料理由
	private String desciption;

	// 提交仓库记录标记
	private String submitFlag;

	// for view
	// 用料名称
	private String name;
	// 用料类型
	private String type;
	// 库存数量
	private String stocknumber;

}
