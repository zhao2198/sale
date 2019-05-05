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
public class PatrolScheme extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 公司主键
	private String companyId;
	// 编号
	private String code;
	// 巡检类别(计划,夜间,故障,临时等)
	private String type;
	// 周期
	private Integer period;
	// 计划开始执行的日期
	private Date startDate;
	// 巡检人id
	private String handlerId;
	// 计划终止方式(0始终运行,1按次数,2按日期)
	private String terminationCondition;
	// 计划终止的参数
	private String terminationParameter;

	// 备注信息
	private String remarks;
	// 计划状态(状态码0可编辑1已生成巡检单(待完成)2本次巡检单已完成3计划已终止))
	private String state;

	// 启用标记
	private String enableFlag;

	// 计划已执行次数
	private int executionCount;
	// 计划任务的ID
	private Long taskId;
	// for view

	// 巡检内容
	private List<PatrolSchemeContent> contentList;

	// for select

	// 结束日期
	private Date endDate;

	private String handlerName;

}
