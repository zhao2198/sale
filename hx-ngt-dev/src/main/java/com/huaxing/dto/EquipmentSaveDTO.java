package com.huaxing.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.huaxing.bean.Equipment;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "设备接收信息")
public class EquipmentSaveDTO extends TransferObject<Equipment> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备ID", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;

	@ApiModelProperty(value = "设备编号", required = true)
	@NotBlank(message = "设备编号不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 64, message = "设备编号长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String code;

	@ApiModelProperty(value = "设备名称", required = true)
	@NotBlank(message = "设备名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 100, message = "设备名称长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String name;

	@ApiModelProperty(value = "设备型号", required = true)
	@NotBlank(message = "设备型号不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 64, message = "设备型号长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String model;

	@ApiModelProperty(value = "设备分类", required = false)
	@Size(max = 100, message = "设备分类长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String type;

	@ApiModelProperty(value = "额定电压", required = false)
	@Size(max = 64, message = "额定电压长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String equV;

	@ApiModelProperty(value = "额定电流", required = false)
	@Size(max = 64, message = "额定电流长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String equC;

	@ApiModelProperty(value = "额定功率", required = false)
	@Size(max = 64, message = "额定功率长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String equP;

	@ApiModelProperty(value = "所属变压器", required = true)
	@Size(max = 100, message = "所属变压器长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String transformer;

	@Past(message = "时间不能大于当前时间")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "购买日期", required = false)
	private Date purchaseyear;

	@Past(message = "时间不能大于当前时间")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "出厂日期", required = false)
	private Date manufacturedate;

	@ApiModelProperty(value = "设备单价", required = false)
	@Digits(integer = 10, fraction = 2, message = "不是数字", groups = { AddGroup.class, UpdateGroup.class })
	private BigDecimal price;

	@ApiModelProperty(value = "设备说明", required = false)
	@Size(max = 100, message = "设备说明长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String desciption;

	@ApiModelProperty(value = "设备图片路径", required = false)
	private List<String> files;

	@ApiModelProperty(value = "设备二维码路径", required = false)
	private String qrcode;

	@ApiModelProperty(value = "负责人Id", required = false)
	private String userId;

	@Past(message = "时间不能大于当前时间")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "投运日期", required = false, dataType = "Date")
	private Date beginruntime;

	@ApiModelProperty(value = "是否属于监测设备", required = true)
	@NotBlank(message = "是否属于监测设备不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 1, message = "是否属于监测设备长度不能大于1", groups = { AddGroup.class, UpdateGroup.class })
	private String monitorstate;

	@ApiModelProperty(value = "运行状态", required = true)
	@NotBlank(message = "运行状态不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(min = 0, max = 1, message = "运行状态长度不能大于1", groups = { AddGroup.class, UpdateGroup.class })
	private String state;

	@ApiModelProperty(value = "所属建筑", required = true)
	@NotBlank(message = "所属建筑不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String building;

	@ApiModelProperty(value = "所属组织", required = true)
	@NotBlank(message = "所属组织不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String organization;

	@ApiModelProperty(value = "所属类别", required = false)
	private String category;

	@ApiModelProperty(value = "所属配电房", required = false)
	private String distributionRoom;

	@ApiModelProperty(value = "所属采集器", required = false)
	private String collector;

	@ApiModelProperty(value = "用能类别", required = false)
	@Size(max = 64, message = "用能类别长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String energyClass;

	@ApiModelProperty(value = "生产厂家", required = false)
	@Size(max = 64, message = "生产厂家长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String manufacturer;

}
