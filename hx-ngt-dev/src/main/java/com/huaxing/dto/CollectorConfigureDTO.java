package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

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
@ApiModel(value = "网关配置表查询条件;")
@Data
@EqualsAndHashCode(callSuper = false)
public class CollectorConfigureDTO extends TransferObject<CollectorConfigure> {
	private static final long serialVersionUID = 1L;

	//
	@ApiModelProperty(value = "采集卡", required = false)
	@NotBlank(message = "采集卡Id不能为空")
	private String acquisitionCard;
	// 所属采集器
	@ApiModelProperty(value = "所属网关", required = false)
	@NotBlank(message = "所属网关Id不能为空")
	private String collector;

}
