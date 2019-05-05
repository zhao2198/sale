package com.huaxing.vo;

import java.util.Date;
import java.util.List;

import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
@Data
@ApiModel(value = "定保记录用于显示")
public class MaintenanceSchemeVO extends TransferObject<MaintenanceScheme> {
	private static final long serialVersionUID = 1L;

	// id
	@ApiModelProperty(value = "id", required = false)
	private String id;
	// 编号
	@ApiModelProperty(value = "编号", required = false)
	private String code;

	// 启用标志
	@ApiModelProperty(value = "启用标志", required = false)
	private String enableFlag;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

	// 状态码0可编辑1已生成定保单(待完成)2本次定保单已完成3订报计划已终止
	@ApiModelProperty(value = "状态码0可编辑1已生成定保单(待完成)2本次定保单已完成3订报计划已终止", required = false)
	private String state;

	// 开始日期
	@ApiModelProperty(value = "开始日期", required = false)
	private Date startDate;
	// 周期
	@ApiModelProperty(value = "周期", required = false)
	private String period;
	// 希完工日
	@ApiModelProperty(value = "希完工日", required = false)
	private String hopeTime;
	// 受理人
	@ApiModelProperty(value = "受理人", required = false)
	private String handlerId;

	@ApiModelProperty(value = "定保内容列表", required = false)
	private List<MaintenanceSchemeContentVO> contentList;

	@ApiModelProperty(value = "受理人", required = false)
	private String handlerName;
	@ApiModelProperty(value = "创建人", required = false)
	private String createName;

}
