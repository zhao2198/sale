package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;
import com.huaxing.vo.DutySignVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-04 15:43:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DutyMission extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 值班编号
	private String code;
	// 值班人员
	private String userId;
	// 值班内容
	private String dutyContent;
	// 开始时间
	private Date startTime;
	// 结束时间
	private Date endTime;
	// 所属公司
	private String companyId;
	// 关联的值班计划
	private String dutyplanId;
	// 备注信息
	private String remarks;

	// for select 值班签到
	private DutySignVO signVo;
	// for save
	private DutySign sign;
	// 任务的执行状态 0---未执行 1--申请调班（执行受阻） 2---已执行
	private String executeStatus;

	// for select
	private String userName;

	// for select calendar
	private String ondutyUserIds;
	private String[] userArr;// 值班人的集合

}
