package com.huaxing.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.huaxing.bean.AlarmSetting;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 告警条件设置表; InnoDB free: 12288 kB; InnoDB free: 9216 kB
 * 
 * @author zhao wei
 * @date 2018-07-14 10:16:16
 */
@ApiModel(value = "告警条件设置保存表;")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlarmSettingSaveDTO extends TransferObject<AlarmSetting> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "告警设置id", required = false)
	@NotBlank(message = "告警设置id不能为空", groups = { UpdateGroup.class })
	private String id;

	// 参数名称
	@ApiModelProperty(value = "参数名称", required = false)
	@NotBlank(message = "参数名称不能为空", groups = { AddGroup.class })
	private String paramName;
	// 告警类型
	@ApiModelProperty(value = "告警类型", required = false)
	@NotBlank(message = "告警类型不能为空", groups = { AddGroup.class })
	private String alarmType;
	// 设定值
	@ApiModelProperty(value = "设定值", required = false)
	@Digits(message = "设定值必须为数字，精度为10,2", integer = 10, fraction = 2, groups = { AddGroup.class, UpdateGroup.class })
	private BigDecimal settingValue;
	// 告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	@NotBlank(message = "告警等级不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String alarmGrade;
	// 铃声告警
	@ApiModelProperty(value = "铃声告警", required = false)
	@NotBlank(message = "是否铃声告警不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String alarmRing;
	// 参数标签
	@ApiModelProperty(value = "参数标签", required = false)
	@NotBlank(message = "参数标签不能为空", groups = { AddGroup.class })
	private String measuretag;
	// 数据类型（0，用电设备，1变压器高，2变压器低）
	@ApiModelProperty(value = "数据类型（0，用电设备，1变压器高，2变压器低）", required = false)
	@NotBlank(message = "数据类型不能为空", groups = { AddGroup.class })
	private String dataType;
}
