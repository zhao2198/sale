package com.huaxing.vo;

import com.huaxing.bean.CollectorConfigure;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采集器配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@ApiModel(value = "网关配置列表; ")
@Data
@EqualsAndHashCode(callSuper = false)
public class CollectorConfigureVO extends TransferObject<CollectorConfigure> {
	private static final long serialVersionUID = 1L;

	//
	@ApiModelProperty(value = "网关配置Id", required = false)
	private String id;

	// 采集卡
	@ApiModelProperty(value = "采集卡", required = false)
	private String acquisitionCard;

	// for query

	@ApiModelProperty(value = "采集卡名称", required = false)
	private String acquisitionCardName;

	@ApiModelProperty(value = "采集卡类型", required = false)
	private String acquisitionCardType;

}
