package com.huaxing.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@ApiModel(value = "网关查询条件;")
public class CollectorQueryDTO extends TransferObject<Collector> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "编号", required = false)
	private String code;

	@ApiModelProperty(value = "采集器名称", required = false)
	private String name;

	@ApiModelProperty(value = "采集器型号", required = false)
	private String collectorModel;

	@ApiModelProperty(value = "所属建筑", required = false)
	private String building;

	@ApiModelProperty(value = "所属组织", required = false)
	private String organization;

	@ApiModelProperty(value = "所属配电房", required = false)
	private String distributionRoom;

	@ApiModelProperty(value = "所属类别", required = false)
	private String category;

	@ApiModelProperty(value = "运行状态", required = false)
	private String collState;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "开始 投运日期", required = false)
	private Date beginBeginruntime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "结束 投运日期", required = false)
	private Date endBeginruntime;
}
