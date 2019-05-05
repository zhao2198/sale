package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备表; InnoDB free: 16384 kB; InnoDB free: 10240 kB
 * 
 * @author Feng Yi
 * @date 2018-06-26 11:24:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Equipment extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 设备编号
	private String code;
	// 设备名称
	private String name;
	// 设备型号
	private String model;
	// 设备分类
	private String type;
	// 额定电压
	private String equV;
	// 额定电流
	private String equC;
	// 额定功率
	private String equP;
	// 所属变压器
	private String transformer;
	// 购买日期
	private Date purchaseyear;
	// 出厂日期
	private Date manufacturedate;
	// 设备单价
	private BigDecimal price;
	// 设备说明
	private String desciption;
	// 设备图片
	private String picture;
	// 设备二维码
	private String qrcode;
	// 负责人
	private String userId;
	// 投运日期
	private Date beginruntime;
	// 监测设备
	private String monitorstate;
	// 运行状态
	private String state;
	// 用能类别
	private String energyClass;
	// 所属建筑
	private String building;
	// 所属组织
	private String organization;
	// 所属类别
	private String category;
	// 所属配电房
	private String distributionRoom;
	// 所属采集器
	private String collector;
	// 生产厂家
	private String manufacturer;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 启用标记
	private String enableFlag;

	// for select
	private Date beginBeginruntime;

	private Date endBeginruntime;

	private String typeDictName;

	private String userName;

	private String monitorstateDictName;

	private String stateDictName;

	private String energyClassDictName;

	private String buildingName;

	private String organizationName;

	private String categoryName;

	private String distributionRoomName;

	private String collectorName;

	private String updateUserName;
	// 设备类型的属性
	private String equipmentTypeAttribute;
	// 设备类型的属性id
	private String equipmentTypeAttributeId;

	private List<String> files;
}
