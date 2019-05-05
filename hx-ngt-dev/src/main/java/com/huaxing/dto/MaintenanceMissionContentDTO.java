package com.huaxing.dto;

import com.huaxing.bean.MaintenanceMissionContent;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
@Data
@ApiModel(value = "")
public class MaintenanceMissionContentDTO extends TransferObject<MaintenanceMissionContent> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
//	// 定保任务单id
//	@ApiModelProperty(value = "定保任务单id", required = false)
//	private String missionId;
	// 修复结果
	@ApiModelProperty(value = "修复结果", required = false)
	private String repairResult;
	// 解决对策
	@ApiModelProperty(value = "解决对策", required = false)
	private String solution;
	// 排序
//	@ApiModelProperty(value = "排序", required = false)
//	private String sort;
//	 设备id
//	@ApiModelProperty(value = "设备id", required = false)
//	private String equipmentId;
//	// 设备名
//	@ApiModelProperty(value = "设备名", required = false)
//	private String equipmentName;
//	// 检查部位
//	@ApiModelProperty(value = "检查部位", required = false)
//	private String checkPoint;
//	// 检查项目
//	@ApiModelProperty(value = "检查项目", required = false)
//	private String checkItem;
//	// 检查要点
//	@ApiModelProperty(value = "检查要点", required = false)
//	private String keyPoint;
//	// 检查标准
//	@ApiModelProperty(value = "检查标准", required = false)
//	private String checkStandard;
//	// 分组id
//	@ApiModelProperty(value = "分组id", required = false)
//	private String pid;

}
