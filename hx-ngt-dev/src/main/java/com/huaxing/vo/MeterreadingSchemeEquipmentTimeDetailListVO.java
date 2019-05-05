package com.huaxing.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 表计指定时间下的抄表计划详细情况VO
 * Create Date:	2018年7月18日 上午10:33:33
 * @version:	V3.0.1
 * @author:		Lian weimao
 */
@ApiModel(value = "表计指定时间下的抄表计划详细情况VO")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingSchemeEquipmentTimeDetailListVO {

	@ApiModelProperty(value = "ID")
	private String id;
	
	@ApiModelProperty(value = "抄表人IDs")
	private String handlerIds;

	@ApiModelProperty(value = "抄表人名称s")
	private String handlerNames;
	
	@ApiModelProperty(value = "抄表日期")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date day;
}
