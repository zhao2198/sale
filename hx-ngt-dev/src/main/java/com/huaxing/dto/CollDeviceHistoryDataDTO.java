package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.CollDeviceData;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InnoDB free: 8192 kB
 * 
 * @author feng yi
 * @date 2018-07-16 16:29:36
 */
@ApiModel(value = "查询历史数据列表")
@Data
@EqualsAndHashCode(callSuper = false)
public class CollDeviceHistoryDataDTO extends TransferObject<CollDeviceData> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "时间类型(0日，1月，2年)", required = true)
	@NotBlank(message = "时间类型不能为空")
	private String typeDate;

	@ApiModelProperty(value = "数据类型（1高压侧，2低压侧，其他不传）", required = false)
	private String dataType;

	@ApiModelProperty(value = "参数标签", required = true)
	@NotBlank(message = "参数标签不能为空")
	private String measuretag;

	@ApiModelProperty(value = "开始时间", required = false)
	private String startTime;

	@ApiModelProperty(value = "结束时间", required = false)
	private String endTime;

	@ApiModelProperty(value = "设备Id", required = true)
	@NotBlank(message = "设备Id不能为空")
	private String equipment;

}
