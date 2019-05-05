package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Shiftclass extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 调班编号
	private String code;
	// 值班任务标识
	private String missionId;
	// 原开始时间
	private Date oldstarttime;
	// 原结束时间
	private Date oldendtime;
	// 新值班日期
	private Date newdate;
	// 新班次标识
	private String classId;

	// 申请理由
	private String reasonApply;
	// (申请状态)0-未审批、1-已审批通过、2-退回
	private String applyStatus;
	// 审批意见 （通过意见）
	private String approve;
	// 退回原因
	private String reasonReject;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 删除标记
	private String delFlag;
	// 启用标记
	private String enableFlag;

	// for select
	private String applyId;// 申请人的id
	// private String code; 调班编号
	private Date startTime;// 申请开始时间
	private Date endTime;// 申请结束时间
	private String[] applyArr;// 申请人的集合
	// private String applyStatus; 申请状态 0-未审批、1-已审批通过、2-退回

	// for view1
	private String applyName;// 申请人
	private Date applyDate;// 申请日期
	// for view2
	private String className;// 新班次标识
	private Date start;// 目标班次开始时间
	private Date end;// 目标班次结束时间
}
