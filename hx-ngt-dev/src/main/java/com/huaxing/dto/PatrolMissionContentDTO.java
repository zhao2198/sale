package com.huaxing.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.PatrolMissionContent;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@ApiModel(value = "")
@Data
@EqualsAndHashCode(callSuper = false)
public class PatrolMissionContentDTO extends TransferObject<PatrolMissionContent> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = true)
	@NotBlank(message="任务ID不能为空")
	private String id;
	
	// 工作开始时间
//	@ApiModelProperty(value = "工作开始时间", required = false)
//	private Date startTime;
//	
//	// 工作结束时间
//	@ApiModelProperty(value = "工作结束时间", required = false)
//	private Date endTime;
	

	// 确认人姓名
	@ApiModelProperty(value = "确认人姓名", required = false)
	private String confirmorName;
	// 确认者电话
	@ApiModelProperty(value = "确认者电话", required = false)
	private String confirmorPhone;

	// 花费的时间
//	@ApiModelProperty(value = "花费的时间", required = false)
//	private String time;
	// 巡检记录
	@ApiModelProperty(value = "巡检记录", required = false)
	private String content;



}
