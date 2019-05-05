package com.huaxing.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 抄表计划以设备为单位查看时的VO
 * Create Date:	2018年7月18日 上午10:33:33
 * @version:	V3.0.1
 * @author:		Lian weimao
 */
@ApiModel(value = "设备所有抄表计划以时间为单位查看时的VO")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingSchemeEquipmentTimeListVO {

	@ApiModelProperty(value = "抄表日期格式化")
	private String daysStr;

	@ApiModelProperty(value = "抄表人名称")
	private String handlerNames;
	
	@ApiModelProperty(value = "抄表时间")
	@JsonFormat(pattern="HHmm")
	private Date time;
	
	@ApiModelProperty(value = "抄表时间格式化")
	@JsonFormat(pattern="HH:mm")
	private Date timeStr;
	
	@ApiModelProperty(value = "开始日期")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@ApiModelProperty(value = "结束日期")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	public void setTime(Date time) {
		this.time=time;
		setTimeStr(time);
	}
	
	
}
