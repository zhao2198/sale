package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;
import com.huaxing.dto.AlarmSettingSaveDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 告警条件设置表; InnoDB free: 12288 kB; InnoDB free: 9216 kB
 * 
 * @author zhao wei
 * @date 2018-07-14 10:16:16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AlarmSetting extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 设备id
	private String equipment;
	// 参数名称
	private String paramName;
	// 告警类型
	private String alarmType;
	// 设定值
	private BigDecimal settingValue;
	// 告警等级
	private String alarmGrade;
	// 铃声告警
	private String alarmRing;
	// 短信通知
	private String smsNotify;
	// 短信通知手机号
	private String telphone;
	// 参数标签
	private String measuretag;
	// 数据类型（0，用电设备，1变压器高，2变压器低）
	private String dataType;
	// 所属公司id
	private String companyId;
	// 备注信息
	private String remarks;
	// 启用标记
	private String enableFlag;

	// for query

	@ApiModelProperty(value = "告警类型名称", required = false)
	private String alarmTypeName;

	@ApiModelProperty(value = "告警设置集合", required = false)
	private List<AlarmSettingSaveDTO> list;

	private String equipmentName;
}
