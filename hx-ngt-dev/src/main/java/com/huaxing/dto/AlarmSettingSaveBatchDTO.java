package com.huaxing.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

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
@ApiModel(value = "告警条件设置批量保存表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class AlarmSettingSaveBatchDTO extends TransferObject<AlarmSetting> {
	private static final long serialVersionUID = 1L;

	// 设备id
	@ApiModelProperty(value = "设备id", required = false)
	@NotBlank(message = "设备id不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String equipment;

	@ApiModelProperty(value = "告警设置集合", required = false)
	private List<AlarmSettingSaveDTO> list;
}
