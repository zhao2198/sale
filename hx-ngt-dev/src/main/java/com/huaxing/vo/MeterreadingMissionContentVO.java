package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.bean.MeterreadingMission;
import com.huaxing.common.utils.StringUtils;
import com.huaxing.common.web.transfer.TransferObject;
import com.huaxing.util.NgtDefine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(value = "返回的抄表任务的当个数据项VO")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingMissionContentVO extends TransferObject<MeterreadingMission> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）
	@ApiModelProperty(value = "时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）", required = false)
	private String time;
	// 表数
	@ApiModelProperty(value = "表数", required = false)
	private BigDecimal value;
	// 状态位(0等待填写数据 1已经填写数据等待提交 2已经提交)
	@ApiModelProperty(value = "状态位(0等待填写数据 1已经填写数据等待提交 2已经提交)", required = false)
	private String state;

	@ApiModelProperty(value = "状态位格式化(0等待填写数据 1已经填写数据等待提交 2已经提交)", required = false)
	private String stateStr;
	// 所属日期
	@ApiModelProperty(value = "所属日期", required = false)
	private Date day;
	/*
	 * //抄表人ID
	 * 
	 * @ApiModelProperty(value = "抄表人ID", required = false) private String handlerId; //抄表人员IDS
	 * 
	 * @ApiModelProperty(value = "抄表人员IDS", required = false) private String handlerIds;
	 */

	public void setState(String state) {
		this.state = state;
		if (StringUtils.isNotBlank(state))
			setStateStr(NgtDefine.getMeterreadingMissionStatusMap().get(state).getDescription());
	}

}
