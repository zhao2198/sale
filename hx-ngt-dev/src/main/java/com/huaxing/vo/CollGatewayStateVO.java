package com.huaxing.vo;

import java.util.Date;

import com.huaxing.bean.CollGatewayState;
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
@ApiModel(value = "网关状态")
@Data
@EqualsAndHashCode(callSuper = false)
public class CollGatewayStateVO extends TransferObject<CollGatewayState> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "运行状态（0断开，1正常）", required = false)
	private String runningState;

	@ApiModelProperty(value = "采集时间", required = false)
	private Date acquisitionTime;

	// for query
	@ApiModelProperty(value = "设备ID", required = false)
	private String id;

	@ApiModelProperty(value = "设备编号", required = false)
	private String code;

	@ApiModelProperty(value = "设备名称", required = false)
	private String name;

	@ApiModelProperty(value = "设备型号", required = false)
	private String model;

	private String type;//
}
