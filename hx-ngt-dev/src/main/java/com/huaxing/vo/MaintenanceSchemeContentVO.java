package com.huaxing.vo;

import com.huaxing.bean.MaintenanceSchemeContent;
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
@ApiModel(value = "定保内容主要用于显示")
public class MaintenanceSchemeContentVO extends TransferObject<MaintenanceSchemeContent> {
	private static final long serialVersionUID = 1L;

	// id
	@ApiModelProperty(value = "id", required = false)
	private String id;
	// 定保单
	@ApiModelProperty(value = "定保单", required = false)
	private String periodicMaintenanceId;
	// 排序
	@ApiModelProperty(value = "排序", required = false)
	private String sort;
	// 设备id
	@ApiModelProperty(value = "设备id", required = false)
	private String equipmentId;
	// 设备名
	@ApiModelProperty(value = "设备名", required = false)
	private String equipmentName;
	// 检查部位
	@ApiModelProperty(value = "检查部位", required = false)
	private String checkPoint;
	// 检查项目
	@ApiModelProperty(value = "检查项目", required = false)
	private String checkItem;
	// 检查要点
	@ApiModelProperty(value = "检查要点", required = false)
	private String keyPoint;
	// 检查标准
	@ApiModelProperty(value = "检查标准", required = false)
	private String checkStandard;
	// 内容id
	@ApiModelProperty(value = "内容id", required = false)
	private String pid;

}
