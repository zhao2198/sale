package com.huaxing.vo;

import java.math.BigDecimal;

import com.huaxing.bean.AlarmSetting;
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
@ApiModel(value = "告警条件设置详情表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class AlarmSettingVO extends TransferObject<AlarmSetting> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 设备id
	@ApiModelProperty(value = "设备id", required = false)
	private String equipment;
	// 参数名称
	@ApiModelProperty(value = "参数名称", required = false)
	private String paramName;
	// 告警类型
	@ApiModelProperty(value = "告警类型", required = false)
	private String alarmType;
	// 设定值
	@ApiModelProperty(value = "设定值", required = false)
	private BigDecimal settingValue;
	// 告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	private String alarmGrade;
	// 铃声告警
	@ApiModelProperty(value = "是否铃声告警", required = false)
	private String alarmRing;
	// 参数标签
	@ApiModelProperty(value = "参数标签", required = false)
	private String measuretag;

	@ApiModelProperty(value = "数据类型（0，用电设备，1变压器高，2变压器低）", required = false)
	private String dataType;
	// for query

	@ApiModelProperty(value = "告警类型名称", required = false)
	private String alarmTypeName;

	@ApiModelProperty(value = "告警类型名称", required = false)
	private String equipmentName;

}
