package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.AcquisitioncardChannel;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采集卡配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@ApiModel(value = "采集卡配置表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class AcquisitioncardChannelDTO extends TransferObject<AcquisitioncardChannel> {
	private static final long serialVersionUID = 1L;

	// 设备
	@ApiModelProperty(value = "设备Id", required = false)
	@NotBlank(message = "设备Id不能为空", groups = { AddGroup.class })
	private String equipment;
	// 所属采集仪表
	@ApiModelProperty(value = "所属采集卡Id", required = false)
	@NotBlank(message = "采集卡Id不能为空", groups = { AddGroup.class })
	private String collectorConfigure;
	// 所属网关
	@ApiModelProperty(value = "所属网关Id", required = false)
	@NotBlank(message = "所属网关Id不能为空", groups = { AddGroup.class })
	private String collector;

	// for update
	// 采集卡Id
	@ApiModelProperty(value = "采集卡Id", required = true)
	@NotBlank(message = "采集卡Id不能为空", groups = { UpdateGroup.class })
	private String id;

	@ApiModelProperty(value = "测点类型", required = false)
	@NotBlank(message = "测点类型不能为空", groups = { UpdateGroup.class })
	private String stationType;

	@ApiModelProperty(value = "测点地址", required = false)
	private String equStationNum;

	@ApiModelProperty(value = "高压侧编号", required = false)
	private String highStationNum;

	@ApiModelProperty(value = "低压侧压侧编号", required = false)
	private String stationNum;
}
