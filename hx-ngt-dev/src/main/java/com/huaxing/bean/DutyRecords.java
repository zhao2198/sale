package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 值班记录的实体类
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DutyRecords extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 关联值班任务标识
	private String missionId;
	// 值班记录编号
	private String code;
	// 值班记录的内容
	private String dutyContent;
	// 所属公司
	private String companyId;
	// 签到标识
	private String signId;
	// 备注信息
	private String remarks;
	// 删除标记
	private String delFlag;

	// for select
	private Date startTime;// 开始时间
	private Date endTime;// 结束时间
	private String userIds;// 值班人的ids
	private String[] userIdArr;// 值班人的ids

	// for view
	private String userName;// 值班人的姓名
	// private Date createDate;// 值班记录的创建时间
	private Date planSignTime;// 计划签到时间
	private Date signInTime;// 实际签到时间
	// 备注信息private String remarks;

}
