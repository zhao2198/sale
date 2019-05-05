package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.bean.AlarmFault;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 告警历史记录列表返回信息 Create Date: 2018年7月12日 上午9:54:50
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@ApiModel(value = "告警历史记录列表返回信息")
@Data
public class AlarmFaultHistoryVO extends TransferObject<AlarmFault> {
	private static final long serialVersionUID = 1L;
	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 告警时间
	@ApiModelProperty(value = "告警时间", required = false)
	private Date alarmTime;
	// 设备名称
	@ApiModelProperty(value = "设备名称", required = false)
	private String equipmentId;
	// 参数名称
	@ApiModelProperty(value = "参数名称", required = false)
	private String paramName;
	// 告警名称
	@ApiModelProperty(value = "告警名称", required = false)
	private String alarmTypeId;
	// 告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	private String alarmGradeId;
	// 当前值
	@ApiModelProperty(value = "当前值", required = false)
	private BigDecimal nowValue;
	// 设定值
	@ApiModelProperty(value = "设定值", required = false)
	private BigDecimal settingValue;
	// 告警是否恢复，0已恢复，1未恢复
	@ApiModelProperty(value = "告警是否恢复，0已恢复，1未恢复", required = false)
	private String returnNormal;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

	// 设备名称
	@ApiModelProperty(value = "设备名称", required = false)
	private String equipmentName;

	// 告警名称
	@ApiModelProperty(value = "告警名称", required = false)
	private String alarmTypeName;
	// 告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	private String alarmGradeName;
	// 告警颜色
	@ApiModelProperty(value = "告警颜色", required = false)
	private String color;
}
