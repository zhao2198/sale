package com.huaxing.vo;

import com.huaxing.bean.AcquisitioncardChannel;
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
@ApiModel(value = "采集卡配置查询表; ")
@Data
@EqualsAndHashCode(callSuper = false)
public class AcquisitioncardChannelVO extends TransferObject<AcquisitioncardChannel> {
	private static final long serialVersionUID = 1L;

	//
	@ApiModelProperty(value = "采集卡配置Id", required = false)
	private String id;
	// 设备
	@ApiModelProperty(value = "设备Id", required = false)
	private String equipment;
	// 所属采集仪表
	@ApiModelProperty(value = "所属采集仪表", required = false)
	private String collectorConfigure;
	// 所属网关
	@ApiModelProperty(value = "所属网关", required = false)
	private String collector;
	// 测点编号
	@ApiModelProperty(value = "高压侧编号", required = false)
	private String highStationNum;
	// 测点编号
	@ApiModelProperty(value = "低压侧编号", required = false)
	private String stationNum;

	// for query

	@ApiModelProperty(value = "设备名称", required = false)
	private String equipmentName;

	@ApiModelProperty(value = "设备类型", required = false)
	private String equipmentType;

}
