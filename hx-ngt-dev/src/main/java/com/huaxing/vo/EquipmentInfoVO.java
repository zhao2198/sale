package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.Equipment;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备表;
 * 
 * @author Feng Yi
 * @date 2018-06-26 11:24:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "设备显示信息")
public class EquipmentInfoVO extends TransferObject<Equipment> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备ID", required = false)
	private String id;

	@ApiModelProperty(value = "设备编号", required = false)
	private String code;

	@ApiModelProperty(value = "设备名称", required = false)
	private String name;

	@ApiModelProperty(value = "设备型号", required = false)
	private String model;

	@ApiModelProperty(value = "设备分类", required = false)
	private String type;

	@ApiModelProperty(value = "设备图片路径", required = false)
	private String picture;

	@ApiModelProperty(value = "设备二维码路径", required = false)
	private String qrcode;

	@ApiModelProperty(value = "负责人Id", required = false)
	private String userId;

	@ApiModelProperty(value = "是否属于监测设备", required = false)
	private String monitorstate;

	@ApiModelProperty(value = "运行状态", required = false)
	private String state;

	@ApiModelProperty(value = "用能类别", required = false)
	private String energyClass;

	@ApiModelProperty(value = "所属建筑", required = false)
	private String building;

	@ApiModelProperty(value = "所属组织", required = false)
	private String organization;

	@ApiModelProperty(value = "所属类别", required = false)
	private String category;

	@ApiModelProperty(value = "所属配电房", required = false)
	private String distributionRoom;

	@ApiModelProperty(value = "所属采集器", required = false)
	private String collector;

	@ApiModelProperty(value = "额定电压", required = false)
	private String equV;

	@ApiModelProperty(value = "额定电流", required = false)
	private String equC;

	@ApiModelProperty(value = "额定功率", required = false)
	private String equP;

	@ApiModelProperty(value = "所属变压器", required = false)
	private String transformer;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "购买日期", required = false)
	private Date purchaseyear;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "出厂日期", required = false)
	private Date manufacturedate;

	@ApiModelProperty(value = "设备单价", required = false)
	private BigDecimal price;

	@ApiModelProperty(value = "设备说明", required = false)
	private String desciption;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "投运日期", required = false, dataType = "Date")
	private Date beginruntime;

	@ApiModelProperty(value = "生产厂家", required = false)
	private String manufacturer;

	// for select

	@ApiModelProperty(value = "设备分类字典名称", required = false)
	private String typeDictName;

	@ApiModelProperty(value = "负责人姓名", required = false)
	private String userName;

	@ApiModelProperty(value = "是否属于监测设备子字典名称", required = false)
	private String monitorstateDictName;

	@ApiModelProperty(value = "运行状态字典名称", required = false)
	private String stateDictName;

	@ApiModelProperty(value = "用能类别字典名称", required = false)
	private String energyClassDictName;

	@ApiModelProperty(value = "所属建筑名称", required = false)
	private String buildingName;

	@ApiModelProperty(value = "所属组织名称", required = false)
	private String organizationName;

	@ApiModelProperty(value = "所属类别名称", required = false)
	private String categoryName;

	@ApiModelProperty(value = "所属配电房名称", required = false)
	private String distributionRoomName;

	@ApiModelProperty(value = "所属采集器名称", required = false)
	private String collectorName;

}
