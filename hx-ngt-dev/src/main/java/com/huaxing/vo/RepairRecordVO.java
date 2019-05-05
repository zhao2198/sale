package com.huaxing.vo;

import java.util.Date;
import java.util.List;

import com.huaxing.bean.RepairRecord;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-05 09:23:20
 */
@Data
@ApiModel(value = "修复单修复记录，用于显示")
public class RepairRecordVO extends TransferObject<RepairRecord> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 修复单主键
	@ApiModelProperty(value = "修复单主键", required = false)
	private String repairFormId;
	// 修复开始时间
	@ApiModelProperty(value = "修复开始时间", required = false)
	private Date startTime;
	// 修复完毕时间
	@ApiModelProperty(value = "修复完毕时间", required = false)
	private Date endTime;
	// 花费的时间
	@ApiModelProperty(value = "花费的时间", required = false)
	private Long takeTime;
	// 现场恢复时间
	@ApiModelProperty(value = "现场恢复时间", required = false)
	private Date recoveryTime;
	// 修复结果(1已修复,0未修复)
	@ApiModelProperty(value = "修复结果(1已修复,0未修复)", required = false)
	private String result;
	// 是否已提交(0未提交,1已提交)
	@ApiModelProperty(value = "是否已提交(0未提交,1已提交)", required = false)
	private String submitFlag;
	// 附件的路径,以逗号分割
	@ApiModelProperty(value = "附件的路径,以逗号分割", required = false)
	private String url;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	// 删除标记
	@ApiModelProperty(value = "创建日期", required = false)
	private Date createDate;

	// 状态0未提交 1待验收 2不通过 3通过
	@ApiModelProperty(value = "状态0未提交 1待验收 2不通过 3通过", required = false)
	private String state;
	// 审批意见
	@ApiModelProperty(value = "审批意见", required = false)
	private String command;

	List<RepairRecordStockVO> stockList;

}
