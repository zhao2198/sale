package com.huaxing.vo;

import java.util.Date;

import com.huaxing.bean.PatrolMissionContent;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@Data
@ApiModel(value = "")
public class PatrolMissionContentVO extends TransferObject<PatrolMissionContent> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 巡检任务单主键
	@ApiModelProperty(value = "巡检任务单主键", required = false)
	private String missionId;
	// 设备主键
	@ApiModelProperty(value = "设备主键", required = false)
	private String equipmentId;
	// 工作开始时间
	@ApiModelProperty(value = "工作开始时间", required = false)
	private Date startTime;
	// 工作结束时间
	@ApiModelProperty(value = "工作结束时间", required = false)
	private Date endTime;
	// 状态(0未巡检,1已巡检)
	@ApiModelProperty(value = "状态(0未巡检,1已巡检)", required = false)
	private String state;
	// 是否已提交(0未提交,1已提交)
	@ApiModelProperty(value = "是否已提交(0未提交,1已提交)", required = false)
	private String submitFlag;

	// 启用标记
	@ApiModelProperty(value = "启用标记", required = false)
	private String enableFlag;
	// 虚拟父id,用来分组
	@ApiModelProperty(value = "虚拟父id,用来分组", required = false)
	private String pid;
	// 确认人姓名
	@ApiModelProperty(value = "确认人姓名", required = false)
	private String confirmorName;
	// 确认者电话
	@ApiModelProperty(value = "确认者电话", required = false)
	private String confirmorPhone;
	// 建筑物id
	@ApiModelProperty(value = "建筑物id", required = false)
	private String locationId;
	// 建筑物名称
	@ApiModelProperty(value = "建筑物名称", required = false)
	private String locationName;
	// 花费的时间
	@ApiModelProperty(value = "花费的时间", required = false)
	private String time;
	// 巡检记录
	@ApiModelProperty(value = "巡检记录", required = false)
	private String content;
	// 排序
	@ApiModelProperty(value = "排序", required = false)
	private String sort;

	// 设备主键
	@ApiModelProperty(value = "设备名称", required = false)
	private String equipmentName;

	// 设备主键
	@ApiModelProperty(value = "设备编码", required = false)
	private String equipmentCode;

}
