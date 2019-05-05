package com.huaxing.vo;

import java.util.Date;
import java.util.List;

import com.huaxing.bean.PatrolMission;
import com.huaxing.common.web.transfer.TransferObject;
import com.huaxing.util.NgtDefine;

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
public class PatrolMissionVO extends TransferObject<PatrolMission> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键")
	private String id;
	// 任务单编号
	@ApiModelProperty(value = "任务单编号")
	private String code;
	// 巡检类别(计划,夜间,故障,临时等)
	@ApiModelProperty(value = "巡检类别(计划,夜间,故障,临时等)")
	private String type;
	// 受理人
	@ApiModelProperty(value = "受理人")
	private String handlerId;
	@ApiModelProperty(value = "受理人名称")
	private String handlerName;
	// 巡检任务单主键
	@ApiModelProperty(value = "巡检任务单主键")
	private String patrolSchemeId;
	// 状态(0未接单1待完成2已巡检3已终止)
	@ApiModelProperty(value = "状态(0未接单1待完成2已巡检3已终止)")
	private String state;
	@ApiModelProperty(value = "状态格式化")
	private String stateStr;
	@ApiModelProperty(value = "巡检内容集合")
	private List<PatrolMissionContentVO> contentList;

	@ApiModelProperty(value = "任务创建时间")
	private Date createDate;
	@ApiModelProperty(value = "任务创建人ID")
	private String createBy;
	@ApiModelProperty(value = "任务创建人姓名")
	private String createName;

	// 备注信息
	@ApiModelProperty(value = "备注信息")
	private String remarks;

	public void setState(String state) {
		this.state = state;
		if (state != null)
			setStateStr(NgtDefine.getMissionStatusMap().get(state).getDescription());
	}

}
