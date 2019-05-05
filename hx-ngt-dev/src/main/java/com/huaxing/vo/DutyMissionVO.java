package com.huaxing.vo;

import java.util.Date;

import com.huaxing.bean.DutyMission;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 值班任务的详情
 * 
 * @author Xie Ning
 * @date 2018-07-04 15:43:49
 */
@Data
@ApiModel(value = "值班人员界面上的值班任务")
public class DutyMissionVO extends TransferObject<DutyMission> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "值班任务的标识", required = false)
	private String id;
	// 值班编号
	@ApiModelProperty(value = "值班编号", required = false)
	private String code;
	// 值班人员
	@ApiModelProperty(value = "值班人员", required = false)
	private String userName;
	// 值班的执行状态
	@ApiModelProperty(value = "任务的执行状态 （ 0---未执行  1--申请调班（执行受阻）   2---已执行）  ", required = false)
	private String executeStatus;
	// 值班内容
	@ApiModelProperty(value = "值班内容", required = false)
	private String dutyContent;
	// 开始时间
	@ApiModelProperty(value = "开始时间", required = false)
	private Date startTime;
	// 结束时间
	@ApiModelProperty(value = "结束时间", required = false)
	private Date endTime;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	// 值班签到表
	@ApiModelProperty(value = "值班签到表", required = false)
	private DutySignVO signVo;
}
