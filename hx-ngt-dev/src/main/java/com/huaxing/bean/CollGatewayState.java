package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InnoDB free: 8192 kB
 * 
 * @author feng yi
 * @date 2018-07-16 16:29:36
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CollGatewayState extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 网关Id
	private String collectorId;
	// 采集仪表id
	private String acquisitionChannelId;
	// 设备Id
	private String equipmentId;
	// 运行状态（0断开，1正常）
	private String runningState;
	// 采集时间
	private Date acquisitionTime;
	// 公司主键
	private String companyId;
	// 网关用途
	private String gatewayType;
	// 网关版本号
	private String gatewayVersion;
	// 项目编号
	private String gatewayCode;

	// for query select
	@ApiModelProperty(value = "设备ID", required = false)
	private String id;

	@ApiModelProperty(value = "设备编号", required = false)
	private String code;

	@ApiModelProperty(value = "设备名称", required = false)
	private String name;

	@ApiModelProperty(value = "设备型号", required = false)
	private String model;

	@ApiModelProperty(value = "所属建筑", required = false)
	private String building;

	@ApiModelProperty(value = "所属组织", required = false)
	private String organization;

	@ApiModelProperty(value = "所属配电房", required = false)
	private String distributionRoom;

	@ApiModelProperty(value = "所属类别", required = false)
	private Date category;

	private String type;//
}
