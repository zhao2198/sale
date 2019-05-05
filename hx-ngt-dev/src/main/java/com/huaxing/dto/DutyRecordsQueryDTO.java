package com.huaxing.dto;

import java.util.Date;

import com.huaxing.bean.DutyRecords;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 值班记录的查询类
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@ApiModel(value = "值班记录_查询")
@Data
@EqualsAndHashCode(callSuper = false)
public class DutyRecordsQueryDTO extends TransferObject<DutyRecords> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "值班记录编号", required = false)
	private String code;
	@ApiModelProperty(value = "开始时间", required = false)
	private Date startTime;
	@ApiModelProperty(value = "结束时间", required = false)
	private Date endTime;
	@ApiModelProperty(value = "值班人", required = false)
	private String userIds;
}
