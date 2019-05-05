package com.huaxing.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.Shiftclass;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@ApiModel(value = "调班的详情")
@Data
@EqualsAndHashCode(callSuper = false)
public class ShiftclassVO extends TransferObject<Shiftclass> {
	private static final long serialVersionUID = 1L;

	// 调班标识
	@ApiModelProperty(value = "调班标识", required = false)
	private String id;
	// 调班编号
	@ApiModelProperty(value = "调班编号", required = false)
	private String code;
	/*
	 * // 值班任务标识
	 * 
	 * @ApiModelProperty(value = "值班任务标识", required = false) private String missionId;
	 */
	@ApiModelProperty(value = "值班人的姓名", required = false)
	private String applyName;// 值班人的姓名
	// 原开始时间
	@ApiModelProperty(value = "原开始时间", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date oldstarttime;
	// 原结束时间
	@ApiModelProperty(value = "原结束时间", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date oldendtime;
	// 新值班日期
	@ApiModelProperty(value = "新值班日期", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date newdate;
	// 新班次标识
	/*
	 * @ApiModelProperty(value = "新班次标识", required = false) private String classId;
	 * 
	 * @ApiModelProperty(value = "新班次名称", required = false) private String className;
	 */
	@ApiModelProperty(value = "新开始时间点", required = false)
	@JsonFormat(pattern = "hh:mm:ss")
	private Date start;
	@ApiModelProperty(value = "新结束时间点", required = false)
	@JsonFormat(pattern = "hh:mm:ss")
	private Date end;
	// 申请理由
	@ApiModelProperty(value = "申请理由", required = false)
	private String reasonApply;
	// (申请状态)0-未审批、1-已审批通过、2-退回
	@ApiModelProperty(value = "(申请状态)0-未审批、1-已审批通过、2-退回", required = false)
	private String applyStatus;
	// 审批意见 （通过意见）
	@ApiModelProperty(value = "审批意见 （通过意见）", required = false)
	private String approve;
	// 退回原因
	@ApiModelProperty(value = "退回原因", required = false)
	private String reasonReject;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
}
