package com.huaxing.dto;

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
public class AlarmFaultHistoryEchartQueryDTO extends TransferObject<AlarmFault> {
	private static final long serialVersionUID = 1L;
	// 告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	private String alarmGradeId;
	// 时间类型
	@ApiModelProperty(value = "告警时间类型 0 日 1 月 2年", required = false)
	private String dateType;
	// 告警时间
	@ApiModelProperty(value = "告警开始时间", required = false)
	private String alarmTimeStart;
	@ApiModelProperty(value = "告警结束时间", required = false)
	private String alarmTimeEnd;
	// 设备名称
	@ApiModelProperty(value = "设备名称(id)", required = false)
	private String equipmentId;
	// 告警名称
	@ApiModelProperty(value = "告警名称（类型）", required = false)
	private String alarmTypeId;
}
