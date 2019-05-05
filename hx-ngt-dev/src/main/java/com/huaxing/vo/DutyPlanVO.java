package com.huaxing.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.DutyPlan;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Create Date: 2018年6月29日 下午3:42:37
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@Data
@ApiModel(value = "值班计划的详情")
public class DutyPlanVO extends TransferObject<DutyPlan> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "计划的标识")
	private String id;
	@ApiModelProperty(value = "计划编号")
	private String code;
	@ApiModelProperty(value = "班次标识")
	private String clazzId;
	@ApiModelProperty(value = "班次名称")
	private String clazzName;
	@ApiModelProperty(value = "班组标识")
	private String teamId;
	@ApiModelProperty(value = "班组名称")
	private String teamName;
	@ApiModelProperty(value = "值班内容")
	private String dutyContent;
	@ApiModelProperty(value = "开始日期")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	@ApiModelProperty(value = "结束日期")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	@ApiModelProperty(value = "间隔天数")
	private Integer intervalDay;
	@ApiModelProperty(value = "发布状态")
	private String publishStatus;

}
