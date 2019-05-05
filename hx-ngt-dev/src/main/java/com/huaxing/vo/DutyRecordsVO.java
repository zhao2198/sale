package com.huaxing.vo;

import java.util.Date;

import com.huaxing.bean.DutyRecords;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 值班记录详情
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@ApiModel(value = "值班记录详情")
@Data
@EqualsAndHashCode(callSuper = false)
public class DutyRecordsVO extends TransferObject<DutyRecords> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "记录标识")
	private String id;
	@ApiModelProperty(value = "记录编号")
	private String code;
	@ApiModelProperty(value = "记录内容")
	private String dutyContent;
	@ApiModelProperty(value = "值班人姓名")
	private String userName;
	@ApiModelProperty(value = "记录时间")
	private Date createDate;
	@ApiModelProperty(value = "计划签到时间")
	private Date planSignTime;
	@ApiModelProperty(value = "值班人的姓名")
	private Date signInTime;
	@ApiModelProperty(value = "备注")
	private String remarks;
}
