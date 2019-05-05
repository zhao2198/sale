package com.huaxing.dto;

import java.util.Date;

import com.huaxing.bean.DutyRecords;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 值班记录的保存类
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@ApiModel(value = "值班记录_保存")
@Data
@EqualsAndHashCode(callSuper = false)
public class DutyRecordsDTO extends TransferObject<DutyRecords> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "值班记录标识", required = false)
	private String id;
	@ApiModelProperty(value = "关联值班任务标识", required = true)
	private String missionId;
	@ApiModelProperty(value = "值班记录编号", required = true)
	private String code;
	@ApiModelProperty(value = "值班记录的内容", required = true)
	private String dutyContent;
	@ApiModelProperty(value = "开始时间", required = false)
	private Date startTime;
	@ApiModelProperty(value = "结束时间", required = false)
	private Date endTime;
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	@ApiModelProperty(value = "值班人的ids", required = false)
	private String userIds;
}
