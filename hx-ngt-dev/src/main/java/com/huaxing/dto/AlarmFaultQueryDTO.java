package com.huaxing.dto;

import java.util.Date;

import com.huaxing.bean.AlarmFault;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 告警中心告警信息展示dto Create Date: 2018年7月11日 上午11:10:03
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@ApiModel(value = "告警中心告警信息查询条件")
@Data
public class AlarmFaultQueryDTO extends TransferObject<AlarmFault> {
	private static final long serialVersionUID = 1L;

	// 开始日期
	@ApiModelProperty(value = "开始日期", required = false)
	private Date startDate;

	// 结束日期
	@ApiModelProperty(value = "结束日期", required = false)
	private Date endDate;
	// 设备名称
	@ApiModelProperty(value = "设备名称(id)", required = false)
	private String equipmentId;
	// 告警名称
	@ApiModelProperty(value = "告警名称", required = false)
	private String alarmTypeId;
	// 告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	private String alarmGradeId;
	// 告警状态
	@ApiModelProperty(value = "告警状态", required = false)
	private String alarmState;

}
