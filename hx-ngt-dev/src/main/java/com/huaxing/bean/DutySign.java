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
public class DutySign extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	private String signPersonId;// 签到人的id
	// 签到时间
	private Date signinTime;
	// 签退时间
	private Date signoutTime;
	// 签到状态 0--正常，1--不正常
	private String signinStatus;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 值班任务的id
	private String missionId;

	// 显示
	private String signPersonName;// 签到人的名字

	// for DutyStatistics
	private String ondutyCount;// 值班统计值班的次数
	private String normalCount;// 值班统计值班正常的次数
	private String unnormalCount;// 值班不正常的次数
	private String countOnOneTime;// 某一时间点的签到总数
	private String time;//
}
