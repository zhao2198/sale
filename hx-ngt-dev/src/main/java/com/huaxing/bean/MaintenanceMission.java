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
 * @date 2018-07-06 14:34:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MaintenanceMission extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 编号
	private String code;
	// 受理人
	private String handlerId;
	// 希完工日
	private String hopeTime;

	// 公司
	private String companyId;
	// 模板的id
	private String templateId;
	// 状态0新创建1待修复2待验收3已验收已通过4验收未通过
	private String state;
	// 审批意见
	private String command;

	// 定保内容
	private List<MaintenanceMissionContent> contentList;

	// 查询使用
	private Date startDate;
	private Date endDate;

	private String handlerName;
	private String createName;
}
