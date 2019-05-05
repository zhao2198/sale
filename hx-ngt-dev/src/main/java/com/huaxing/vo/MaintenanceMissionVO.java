package com.huaxing.vo;

import java.util.Date;
import java.util.List;

import com.huaxing.bean.MaintenanceMission;
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
@ApiModel(value = "定保审批主要用于显示")
public class MaintenanceMissionVO extends TransferObject<MaintenanceMission> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键")
	private String id;
	// 编号
	@ApiModelProperty(value = "编号")
	private String code;
	// 受理人
	@ApiModelProperty(value = "受理人")
	private String handlerId;
	// 受理人
	@ApiModelProperty(value = "受理人姓名")
	private String handlerName;
	// 希完工日
	@ApiModelProperty(value = "希完工日")
	private String hopeTime;

	// 模板的id
	@ApiModelProperty(value = "模板的id")
	private String templateId;
	// 状态0新创建1待修复2待验收3已验收已通过4验收未通过
	@ApiModelProperty(value = "状态0新创建1待修复2待验收3已验收已通过4验收未通过")
	private String state;
	//
	@ApiModelProperty(value = "定保内容列表")
	private List<MaintenanceMissionContentVO> contentList;
	// 审批意见
	@ApiModelProperty(value = "审批意见")
	private String command;

	@ApiModelProperty(value = "任务创建时间")
	private Date createDate;
	@ApiModelProperty(value = "任务创建人ID")
	private String createBy;
	@ApiModelProperty(value = "任务创建人姓名")
	private String createName;

}
