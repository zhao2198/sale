package com.huaxing.vo;

import java.util.Date;
import java.util.List;

import com.huaxing.bean.PatrolScheme;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@Data
@ApiModel(value = "")
public class PatrolSchemeVO extends TransferObject<PatrolScheme> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 公司主键
	@ApiModelProperty(value = "公司主键", required = false)
	private String companyId;
	// 编号
	@ApiModelProperty(value = "编号", required = false)
	private String code;
	// 巡检类别(计划,夜间,故障,临时等)
	@ApiModelProperty(value = "巡检类别(计划,夜间,故障,临时等)", required = false)
	private String type;
	// 周期
	@ApiModelProperty(value = "周期", required = false)
	private Integer period;
	// 计划开始执行的日期
	@ApiModelProperty(value = "计划开始执行的日期", required = false)
	private Date startDate;
	// 巡检人id
	@ApiModelProperty(value = "巡检人id", required = false)
	private String handlerId;
	// 计划终止方式(0始终运行,1按次数,2按日期)
	@ApiModelProperty(value = "计划终止方式(0始终运行,1按次数,2按日期)", required = false)
	private String terminationCondition;
	// 计划终止的参数
	@ApiModelProperty(value = "计划终止的参数", required = false)
	private String terminationParameter;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	// 计划状态(状态码0可编辑1已生成巡检单(待完成)2本次巡检单已完成3计划已终止))
	@ApiModelProperty(value = "计划状态(状态码0可编辑1已生成巡检单(待完成)2本次巡检单已完成3计划已终止))", required = false)
	private String state;
	@ApiModelProperty(value = "巡检人", required = false)
	private String handlerName;

	@ApiModelProperty(value = "巡检内容集合", required = false)
	private List<PatrolSchemeContentVO> contentList;

}
