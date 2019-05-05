package com.huaxing.dto;

import java.util.Date;

import com.huaxing.bean.RepairForm;
import com.huaxing.common.web.transfer.TransferObject;
import com.huaxing.modules.annotation.QueryEndDate;
import com.huaxing.modules.utils.DateFormatterPattrenEnum;

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
@ApiModel(value = "修复单表单,用于query")
public class RepairFormQueryDTO extends TransferObject<RepairForm> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备名称", required = false)
	private String equipmentName;
	// 受理人id
	@ApiModelProperty(value = "受理人id", required = false)
	private String handlerId;

	// 分类
	@ApiModelProperty(value = "分类", required = false)
	private String categoryId;

	// 修复单单号
	@ApiModelProperty(value = "修复单单号", required = false)
	private String code;
	// 修复单类型（0 故障开单 1 缺陷开单）
	@ApiModelProperty(value = "修复单类型（0 故障开单 1 缺陷开单）", required = false)
	private String type;
	// 紧急程度（0 一般 1 重要 2紧急）
	@ApiModelProperty(value = "紧急程度（0 一般 1 重要 2紧急）", required = false)
	private String urgency;

	// 开始日期
	@ApiModelProperty(value = "开始日期", required = false)
	private Date startDate;

	// 结束日期
	@ApiModelProperty(value = "结束日期", required = false)
	@QueryEndDate(pattern = { DateFormatterPattrenEnum.yyyyMMdd, DateFormatterPattrenEnum.yyyyMM })
	private Date endDate;

	@ApiModelProperty(value = "修复结果", required = false)
	private String repairResult;

	@ApiModelProperty(value = "状态", required = false)
	private String state;

}
