package com.huaxing.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.DutyMission;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-04 15:43:49
 */
@Data
@ApiModel(value = "值班任务")
public class DutyMissionDTO extends TransferObject<DutyMission> {
	private static final long serialVersionUID = 1L;
	// 值班编号
	@ApiModelProperty(value = "值班编号", required = false)
	private String code;
	// 值班人员
	@ApiModelProperty(value = "值班人员的ids", required = false)
	private String ondutyUserIds;
	// 开始时间
	@ApiModelProperty(value = "开始时间", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	// 结束时间
	@ApiModelProperty(value = "结束时间", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	@ApiModelProperty(value = "任务的执行状态  0---未执行  1--申请调班（执行受阻）   2---已执行", required = false)
	private String executeStatus;

}
