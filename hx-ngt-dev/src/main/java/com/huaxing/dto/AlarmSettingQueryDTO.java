package com.huaxing.dto;

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
@ApiModel(value = "告警条件设置查询表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class AlarmSettingQueryDTO extends TransferObject<AlarmSetting> {
	private static final long serialVersionUID = 1L;

	// 设备id
	@ApiModelProperty(value = "设备id", required = false)
	private String equipment;

}
