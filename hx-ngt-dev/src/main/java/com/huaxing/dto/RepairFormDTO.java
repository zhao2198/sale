package com.huaxing.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.RepairForm;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
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
@ApiModel(value = "修复单表单,用于添加和修改")
public class RepairFormDTO extends TransferObject<RepairForm> {
	private static final long serialVersionUID = 1L;

	// id
	@ApiModelProperty(value = "id", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;
	// 受理人id
	@ApiModelProperty(value = "受理人id", required = false)
	private String handlerId;
	// 设备表主键
	@ApiModelProperty(value = "设备表主键", required = true)
	@NotBlank(message = "设备不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String equipmentId;

	@ApiModelProperty(value = "设备表名称", required = true)
	@NotBlank(message = "设备名称不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String equipmentName;
	// 建筑
	@ApiModelProperty(value = "建筑", required = true)
	// @NotBlank(message = "建筑不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String buildingId;
	// 组织
	@ApiModelProperty(value = "组织", required = true)
	// @NotBlank(message = "组织不能为空", groups = { UpdateGroup.class, AddGroup.class })
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
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date findTime;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

	// 启用标记
	@ApiModelProperty(value = "启用标记", required = false)
	private String enableFlag;
	// 发布标记 0未发布 1已发布
	@ApiModelProperty(value = "发布标记 0未发布 1已发布", required = false)
	private String publishFlag;

	@ApiModelProperty(value = "图片列表", required = false)
	private List<String> files;

}
