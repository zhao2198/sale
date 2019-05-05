package com.huaxing.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.RepairForm;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-04 09:41:30
 */
@Data
@ApiModel(value = "")
public class RepairFormVO extends TransferObject<RepairForm> {
	private static final long serialVersionUID = 1L;

	// id
	@ApiModelProperty(value = "id", required = false)
	private String id;
	// 受理人id
	@ApiModelProperty(value = "受理人id", required = false)
	private String handlerId;

	// 设备名成
	@ApiModelProperty(value = "设备名称", required = false)
	private String equipmentName;
	// 设备表主键
	@ApiModelProperty(value = "设备表主键", required = false)
	private String equipmentId;
	// 建筑
	@ApiModelProperty(value = "建筑", required = false)
	private String buildingId;
	// 组织
	@ApiModelProperty(value = "组织", required = false)
	private String organizationId;
	// 分类
	@ApiModelProperty(value = "分类", required = false)
	private String categoryId;
	// 配电房
	@ApiModelProperty(value = "配电房", required = false)
	private String distributionRoomId;
	// 修复单单号
	@ApiModelProperty(value = "修复单单号", required = false)
	private String code;
	// 修复单类型（0 故障开单 1 缺陷开单）
	@ApiModelProperty(value = "修复单类型（0 故障开单 1 缺陷开单）", required = false)
	private String type;
	// 紧急程度（0 一般 1 重要 2紧急）
	@ApiModelProperty(value = "紧急程度（0 一般 1 重要 2紧急）", required = false)
	private String urgency;
	// 原始希完工日
	@ApiModelProperty(value = "原始希完工日", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date historyHopeTime;
	// 希望完工日
	@ApiModelProperty(value = "希望完工日", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hopeTime;
	// 附件路径
	@ApiModelProperty(value = "附件路径", required = false)
	private String url;
	// 发现人
	@ApiModelProperty(value = "发现人", required = false)
	private String findPeople;
	// 是否转记（0未转记 1 已转记）
	@ApiModelProperty(value = "是否转记（0未转记 1 已转记）", required = false)
	private String isTurnDown;
	// 发现时间
	@ApiModelProperty(value = "发现时间", required = false)
	private Date findTime;
	// 修复单状态（0未受理 1已受理 2 待验收 3 已验收 4验收未通过）
	@ApiModelProperty(value = "修复单状态（0未受理 1已受理 2 待验收 3 已验收 4验收未通过）", required = false)
	private String state;
	// 创建者
	@ApiModelProperty(value = "创建者", required = false)
	private String createBy;
	// 创建时间
	@ApiModelProperty(value = "创建时间", required = false)
	private Date createDate;
	// 更新者
	@ApiModelProperty(value = "更新者", required = false)
	private String updateBy;
	// 更新时间
	@ApiModelProperty(value = "更新时间", required = false)
	private Date updateDate;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

	@ApiModelProperty(value = "设备编码", required = false)
	private String equipmentCode;

	// 发布标记 0未发布 1已发布
	@ApiModelProperty(value = "发布标记 0未发布 1已发布", required = false)
	private String publishFlag;

	@ApiModelProperty(value = "创建人", required = false)
	private String createName;
	@ApiModelProperty(value = "处理人", required = false)
	private String handName;
	@ApiModelProperty(value = "修复状态 0 失败1成功", required = false)
	private String repairResult;

	@ApiModelProperty(value = "所属建筑名称", required = false)
	private String buildingName;

	@ApiModelProperty(value = "所属组织名称", required = false)
	private String organizationName;

	@ApiModelProperty(value = "所属类别名称", required = false)
	private String categoryName;

	@ApiModelProperty(value = "所属配电房名称", required = false)
	private String distributionRoomName;

	@ApiModelProperty(value = "图片地址", required = false)
	private String photoUrl;

}
