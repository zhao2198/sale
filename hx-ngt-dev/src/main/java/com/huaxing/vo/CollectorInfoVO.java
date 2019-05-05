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
@ApiModel(value = "网关详情表")
public class CollectorInfoVO extends TransferObject<Collector> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "网关Id", required = false)
	private String id;

	@ApiModelProperty(value = "编号", required = false)
	private String code;

	@ApiModelProperty(value = "采集器名称", required = false)
	private String name;

	@ApiModelProperty(value = "采集器型号", required = false)
	private String collectorModel;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "投运时间", required = false)
	private Date startTime;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "购买日期", required = false)
	private Date buyTime;

	@ApiModelProperty(value = "所属建筑", required = false)
	private String building;

	@ApiModelProperty(value = "所属组织", required = false)
	private String organization;

	@ApiModelProperty(value = "所属配电房", required = false)
	private String distributionRoom;

	@ApiModelProperty(value = "所属类别", required = false)
	private String category;

	@ApiModelProperty(value = "设备图片", required = false)
	private String picture;

	@ApiModelProperty(value = "采集器二维码", required = false)
	private String qrcode;

	@ApiModelProperty(value = "运行状态", required = false)
	private String collState;

	@ApiModelProperty(value = "项目编号", required = false)
	private String projectCode;

	@ApiModelProperty(value = "用途类型", required = false)
	private String useType;

	@ApiModelProperty(value = "版本号", required = false)
	private String version;

	@ApiModelProperty(value = "省", required = false)
	private String provinceCode;

	@ApiModelProperty(value = "市", required = false)
	private String cityCode;

	@ApiModelProperty(value = "区", required = false)
	private String areaCode;

	// for select
	@ApiModelProperty(value = "采集器型号名称", required = false)
	private String collectorModelName;

	@ApiModelProperty(value = "运行状态名称", required = false)
	private String collStateDictName;

	@ApiModelProperty(value = "所属建筑名称", required = false)
	private String buildingName;

	@ApiModelProperty(value = "所属组织名称", required = false)
	private String organizationName;

	@ApiModelProperty(value = "所属类别名称", required = false)
	private String categoryName;

	@ApiModelProperty(value = "所属配电房名称", required = false)
	private String distributionRoomName;
}
