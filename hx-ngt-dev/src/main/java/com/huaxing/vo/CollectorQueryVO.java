package com.huaxing.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.Collector;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采集器表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-06 14:06:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "网关列表")
public class CollectorQueryVO extends TransferObject<Collector> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "网关Id", required = false)
	private String id;

	@ApiModelProperty(value = "编号", required = false)
	private String code;

	@ApiModelProperty(value = "采集器名称", required = false)
	private String name;

	@ApiModelProperty(value = "所属建筑", required = false)
	private String building;

	@ApiModelProperty(value = "所属组织", required = false)
	private String organization;

	@ApiModelProperty(value = "设备图片", required = false)
	private String picture;

	@ApiModelProperty(value = "采集器二维码", required = false)
	private String qrcode;

	@ApiModelProperty(value = "运行状态", required = false)
	private String collState;

	@ApiModelProperty(value = "网关编号", required = false)
	private String projectCode;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "更新时间", required = false)
	private Date updateDate;

	// for select
	@ApiModelProperty(value = "采集器型号名称", required = false)
	private String collectorModelName;

	@ApiModelProperty(value = "更新人", required = false)
	private String updateByName;

	@ApiModelProperty(value = "运行状态名称", required = false)
	private String collStateDictName;

	@ApiModelProperty(value = "所属建筑名称", required = false)
	private String buildingName;

	@ApiModelProperty(value = "所属组织名称", required = false)
	private String organizationName;

}
