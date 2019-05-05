package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;

/**
 * 出入库记录; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-09 09:10:19
 */
@Data
public class EquipmentStockRecord extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 物料
	private String materiel;

	// 物料编号
	private String code;
	// 数量
	private String number;
	// 理由
	private String desciption;
	// 操作
	private String operation;
	// 领用人
	private String useUser;
	// 领用时间
	private Date useTime;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 启用标记
	private String enableFlag;

	// for select
	private String materielName;

	private Date beginUsetime;

	private Date endUsetime;

	private String useUserName;
}
