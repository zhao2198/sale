package com.huaxing.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.AlarmFault;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
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
@ApiModel(value = "告警中心告警相关表单")
@Data
public class AlarmFaultDTO extends TransferObject<AlarmFault> {
	private static final long serialVersionUID = 1L;
	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 告警时间
	@ApiModelProperty(value = "告警时间", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "告警时间不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private Date alarmTime;
	// 设备名称
	@ApiModelProperty(value = "设备名称", required = false)
	@NotBlank(message = "设备名称不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String equipmentId;
	// 参数名称
	@ApiModelProperty(value = "参数名称", required = false)
	@NotBlank(message = "参数名称不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String paramName;
	// 告警名称
	@ApiModelProperty(value = "告警名称", required = false)
	@NotBlank(message = "告警名称不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String alarmTypeId;
	// 告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	@NotBlank(message = "告警等级不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String alarmGradeId;
	// 告警状态
	@ApiModelProperty(value = "告警状态", required = false)
	@NotBlank(message = "告警状态不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String alarmState;
	// 开单状态
	@ApiModelProperty(value = "开单状态（0未开单，1已开单）", required = false)
	@NotBlank(message = "开单状态不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String newformState;
	// 屏蔽原因
	@ApiModelProperty(value = "屏蔽原因", required = false)
	@NotBlank(message = "屏蔽原因不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String shieldingReason;
	// 当前值
	@ApiModelProperty(value = "当前值", required = false)
	@NotBlank(message = "当前值不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private BigDecimal nowValue;
	// 设定值
	@ApiModelProperty(value = "设定值", required = false)
	@NotBlank(message = "设定值不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private BigDecimal settingValue;
	// 告警是否恢复，0已恢复，1未恢复
	@ApiModelProperty(value = "告警是否恢复，0已恢复，1未恢复", required = false)
	@NotBlank(message = "告警是否恢复不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String returnNormal;
	// 参数标签
	@ApiModelProperty(value = "参数标签", required = false)
	private String measuretag;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

}
