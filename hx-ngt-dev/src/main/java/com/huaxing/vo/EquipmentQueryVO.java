package com.huaxing.vo;

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
@ApiModel(value = "设备信息列表")
public class EquipmentQueryVO extends TransferObject<Equipment> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备ID", required = false)
	private String id;

	@ApiModelProperty(value = "设备编号", required = false)
	private String code;

	@ApiModelProperty(value = "设备名称", required = false)
	private String name;

	@ApiModelProperty(value = "设备型号", required = false)
	private String model;

	@ApiModelProperty(value = "设备图片路径", required = false)
	private String picture;

	@ApiModelProperty(value = "设备二维码路径", required = false)
	private String qrcode;

	@ApiModelProperty(value = "负责人", required = false)
	private String userName;

	@ApiModelProperty(value = "设备分类字典", required = false)
	private String type;

	@ApiModelProperty(value = "设备分类字典名称", required = false)
	private String typeDictName;

	@ApiModelProperty(value = "是否属于监测设备子字典", required = false)
	private String monitorstate;

	@ApiModelProperty(value = "是否属于监测设备子字典名称", required = false)
	private String monitorstateDictName;

	@ApiModelProperty(value = "所属采集器", required = false)
	private String collectorName;

	@ApiModelProperty(value = "更新人", required = false)
	private String updateUserName;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "更新时间", required = false)
	private Date updateDate;

	// 所属建筑
	private String building;
	// 所属组织
	private String organization;
	// 所属类别
	private String category;
	// 所属配电房
	private String distributionRoom;

	// 所属建筑
	@ApiModelProperty(value = "建筑名称", required = false)
	private String buildingName;
	// 所属组织
	@ApiModelProperty(value = "组织名称", required = false)
	private String organizationName;
	// 所属类别
	@ApiModelProperty(value = "类别名称", required = false)
	private String categoryName;
	// 所属配电房
	@ApiModelProperty(value = "配电房名称", required = false)
	private String distributionRoomName;

}
