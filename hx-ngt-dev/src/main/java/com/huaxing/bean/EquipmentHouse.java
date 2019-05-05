package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;

/**
 * 库存管理; InnoDB free: 10240 kB; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-09 09:10:19
 */
@Data
public class EquipmentHouse extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 物料名称
	private String name;
	// 物料编号
	private String code;
	// 生产厂家
	private String manufacturer;
	// 设备型号
	private String type;
	// 出厂日期
	private Date manufacturedate;
	// 购买日期
	private Date purchaseyear;
	// 设备单价
	private BigDecimal price;
	// 设备说明
	private String desciption;
	// 设备图片
	private String picture;
	// 设备类型
	private String category;
	// 库存数
	private String stocknumber;
	// 最小库存数
	private String minStocknumber;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 启用标记
	private String enableFlag;

	// for select
	private String categoryDictName;

	private Date beginPurchaseyear;

	private Date endPurchaseyear;

	// 出入库的数量
	private String stockNumPlus;
}
