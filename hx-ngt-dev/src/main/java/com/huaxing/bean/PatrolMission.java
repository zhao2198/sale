package com.huaxing.bean;

import java.util.Date;
import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PatrolMission extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 任务单编号
	private String code;
	// 巡检类别(计划,夜间,故障,临时等)
	private String type;
	// 受理人
	private String handlerId;
	// 巡检任务单主键
	private String patrolSchemeId;
	// 状态(0未接单1待完成2已巡检3已终止)
	private String state;
	// 所属公司主键
	private String companyId;

	// 备注信息
	private String remarks;

	// 启用标记 任务不存在启用与否
	// private String enableFlag;

	// 巡检内容
	private List<PatrolMissionContent> contentList;
	private String handlerName;
	private String createName;
	// 查询使用
	private Date startDate;
	private Date endDate;

}
