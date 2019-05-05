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
public class MaintenanceScheme extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 编号
	private String code;

	// 启用标志
	private String enableFlag;

	// 备注信息
	private String remarks;

	// 状态码0可编辑1已生成定保单(待完成)2本次定保单已完成3订报计划已终止
	private String state;
	// 所属公司
	private String companyId;
	// 开始日期
	private Date startDate;
	// 周期
	private String period;
	// 希完工日
	private String hopeTime;
	// 受理人
	private String handlerId;
	// 计划已执行次数
	private int executionCount;
	// 计划任务的ID
	private Long taskId;
	// 定保内容
	private List<MaintenanceSchemeContent> contentList;

	// for select

	// 结束日期
	private Date endDate;

	private String handlerName;
	private String createName;

}
