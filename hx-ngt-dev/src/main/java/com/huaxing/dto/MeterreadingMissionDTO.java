package com.huaxing.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.huaxing.bean.MeterreadingMission;

/**
 * 抄表任务表; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@ApiModel(value = "抄表任务表; InnoDB free: 8192 kB")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingMissionDTO extends TransferObject<MeterreadingMission> {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	//表计ID
	@ApiModelProperty(value = "表计ID", required = false)
	private String meterId;
	//时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）
	@ApiModelProperty(value = "时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）", required = false)
	private String time;
	//所属日期
	@ApiModelProperty(value = "所属日期", required = false)
	private Date day;
	//表数
	@ApiModelProperty(value = "表数", required = false)
	private BigDecimal value;
	//抄表人ID
	@ApiModelProperty(value = "抄表人ID", required = false)
	private String handlerId;
	//抄表人员IDS
	@ApiModelProperty(value = "抄表人员IDS", required = false)
	private String handlerIds;
	//状态位(0等待填写数据 1已经填写数据等待提交 2已经提交)
	@ApiModelProperty(value = "状态位(0等待填写数据 1已经填写数据等待提交 2已经提交)", required = false)
	private String state;
	//创建者
	@ApiModelProperty(value = "创建者", required = false)
	private String createBy;
	//创建时间
	@ApiModelProperty(value = "创建时间", required = false)
	private Date createDate;
	//更新时间
	@ApiModelProperty(value = "更新时间", required = false)
	private Date updateDate;
	//备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String memo;

}
