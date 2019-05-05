package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.bean.AlarmFault;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 告警中心告警故障信息相关返回信息 Create Date: 2018年7月11日 上午11:19:00
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@ApiModel(value = "告警中心展示告警信息返回（未确认告警、已确认告警、已屏蔽告警、撤销屏蔽的告警）")
@Data
public class AlarmFaultVO extends TransferObject<AlarmFault> {
	private static final long serialVersionUID = 1L;
	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 告警时间
	@ApiModelProperty(value = "告警时间", required = false)
	private Date alarmTime;
	// 设备名称
	@ApiModelProperty(value = "设备ID", required = false)
	private String equipmentId;
	// 参数名称
	@ApiModelProperty(value = "参数名称", required = false)
	private String paramName;
	// 告警名称
	@ApiModelProperty(value = "告警类型ID", required = false)
	private String alarmTypeId;
	// 告警等级
	@ApiModelProperty(value = "告警等级ID", required = false)
	private String alarmGradeId;
	// 告警状态
	@ApiModelProperty(value = "告警状态", required = false)
	private String alarmState;
	// 开单状态
	@ApiModelProperty(value = "开单状态", required = false)
	private String newformState;
	// 屏蔽原因
	@ApiModelProperty(value = "屏蔽原因", required = false)
	private String shieldingReason;
	// 当前值
	@ApiModelProperty(value = "当前值", required = false)
	private BigDecimal nowValue;
	// 设定值
	@ApiModelProperty(value = "设定值", required = false)
	private BigDecimal settingValue;
	// 告警是否恢复，0已恢复，1未恢复
	@ApiModelProperty(value = "告警是否恢复，0已恢复，1未恢复", required = false)
	private String returnNormal;
	// 参数标签
	@ApiModelProperty(value = "参数标签", required = false)
	private String measuretag;

	// 更新时间
	@ApiModelProperty(value = "更新时间", required = false)
	private Date updateDate;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	// 告警颜色
	@ApiModelProperty(value = "告警颜色", required = false)
	private String color;
	// 告警重要等级
	@ApiModelProperty(value = "告警重要等级", required = false)
	private String importantLevel;
	// 告警声音
	@ApiModelProperty(value = "告警声音", required = false)
	private String sound;

	// 设备名称
	@ApiModelProperty(value = "设备名称", required = false)
	private String equipmentName;
	// 告警名称
	@ApiModelProperty(value = "告警名称", required = false)
	private String alarmTypeName;
	// 告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	private String alarmGradeName;

}
