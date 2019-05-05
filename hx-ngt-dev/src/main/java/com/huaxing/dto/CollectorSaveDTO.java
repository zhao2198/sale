package com.huaxing.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.huaxing.bean.Collector;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "网关信息保存表;")
public class CollectorSaveDTO extends TransferObject<Collector> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备ID", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;

	@ApiModelProperty(value = "编号", required = false)
	@NotBlank(message = "网关编号不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 64, message = "网关编号长度不能大于64", groups = { AddGroup.class, UpdateGroup.class })
	private String code;

	@ApiModelProperty(value = "网关名称", required = false)
	@NotBlank(message = "网关名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 100, message = "网关名称长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String name;

	@ApiModelProperty(value = "网关型号", required = false)
	@NotBlank(message = "网关型号不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(max = 100, message = "网关型号长度不能大于100", groups = { AddGroup.class, UpdateGroup.class })
	private String collectorModel;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "投运时间", required = false)
	private Date startTime;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "购买日期", required = false)
	private Date buyTime;

	@ApiModelProperty(value = "所属建筑", required = false)
	@NotBlank(message = "所属建筑", groups = { AddGroup.class, UpdateGroup.class })
	private String building;

	@ApiModelProperty(value = "所属组织", required = false)
	@NotBlank(message = "所属组织", groups = { AddGroup.class, UpdateGroup.class })
	private String organization;

	@ApiModelProperty(value = "所属配电房", required = false)
	private String distributionRoom;

	@ApiModelProperty(value = "所属类别", required = false)
	private String category;

	@ApiModelProperty(value = "设备图片", required = false)
	private List<String> files;

	@ApiModelProperty(value = "采集器二维码", required = false)
	@Size(max = 255, message = "采集器二维码长度不能大于255", groups = { AddGroup.class, UpdateGroup.class })
	private String qrcode;

	@ApiModelProperty(value = "运行状态", required = false)
	@Size(max = 1, message = "运行状态长度不能大于1", groups = { AddGroup.class, UpdateGroup.class })
	private String collState;

	@ApiModelProperty(value = "项目编号", required = false)
	@Size(min = 8, max = 12, message = "项目编号长度不能小于8大于12", groups = { AddGroup.class, UpdateGroup.class })
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

}
