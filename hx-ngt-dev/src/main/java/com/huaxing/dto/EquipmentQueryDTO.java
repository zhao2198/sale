package com.huaxing.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@ApiModel(value = "设备信息查询条件")
public class EquipmentQueryDTO extends TransferObject<Equipment> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备编号", required = false)
	private String code;

	@ApiModelProperty(value = "设备名称", required = false)
	private String name;

	@ApiModelProperty(value = "设备型号", required = false)
	private String model;

	@ApiModelProperty(value = "负责人Id", required = false)
	private String userId;

	@ApiModelProperty(value = "是否属于监测设备", required = false)
	private String monitorstate;

	@ApiModelProperty(value = "运行状态", required = false)
	private String state;

	@ApiModelProperty(value = "所属建筑", required = false)
	private String building;

	@ApiModelProperty(value = "所属组织", required = false)
	private String organization;

	@ApiModelProperty(value = "所属类别", required = false)
	private String category;

	@ApiModelProperty(value = "所属配电房", required = false)
	private String distributionRoom;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "开始 投运日期", required = false)
	private Date beginBeginruntime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "结束 投运日期", required = false)
	private Date endBeginruntime;
}
