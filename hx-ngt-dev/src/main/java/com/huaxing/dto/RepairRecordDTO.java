package com.huaxing.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.RepairRecord;
import com.huaxing.bean.RepairRecordEquipmentStockRecord;
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
 * @date 2018-07-05 09:23:20
 */
@Data
@ApiModel(value = "修复单记录，主要用于添加修改")
public class RepairRecordDTO extends TransferObject<RepairRecord> {
	private static final long serialVersionUID = 1L;

	// 主键
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 修复单主键
	@ApiModelProperty(value = "修复单主键", required = false)
	private String repairFormId;
	// 修复开始时间
	@ApiModelProperty(value = "修复开始时间", required = false)
	@JsonFormat(pattern = "yyy-MM-dd hh:mm:ss")
	private Date startTime;
	// 修复完毕时间
	@ApiModelProperty(value = "修复完毕时间", required = false)
	@JsonFormat(pattern = "yyy-MM-dd hh:mm:ss")
	private Date endTime;
	// 现场恢复时间
	@ApiModelProperty(value = "现场恢复时间", required = false)
	@JsonFormat(pattern = "yyy-MM-dd hh:mm:ss")
	private Date recoveryTime;
	// 修复结果(1已修复,0未修复)
	@ApiModelProperty(value = "修复结果(1已修复,0未修复)", required = false)
	@Size(min = 1, max = 1, groups = { AddGroup.class, UpdateGroup.class }, message = "修复结果长度只能为1")
	private String result;
	// 是否已提交(0未提交,1已提交)
	@ApiModelProperty(value = "是否已提交(0未提交,1已提交)", required = false)
	private String submitFlag;
	// 附件的路径,以逗号分割
	@ApiModelProperty(value = "附件的路径,以逗号分割", required = false)
	private String url;

	// 备注信息
	@NotBlank(message = "修复说明不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@ApiModelProperty(value = "修复说明", required = false)
	private String remarks;

	@ApiModelProperty(value = "耗材列表", required = false)
	private List<RepairRecordEquipmentStockRecordDTO> stockList;

	@ApiModelProperty(value = "创建日期，前台不需要传入", required = false)
	private Date CreateDate;

	@ApiModelProperty(value = "图片列表", required = false)
	private List<String> files;

	@Override
	public RepairRecord toObject(Class<RepairRecord> clazz) {
		RepairRecord record = super.toObject(clazz);
		if (null != this.getStockList() && this.stockList.size() > 0) {
			List<RepairRecordEquipmentStockRecord> stockList = new ArrayList<RepairRecordEquipmentStockRecord>();

			for (RepairRecordEquipmentStockRecordDTO recordDTO : this.stockList) {
				stockList.add(recordDTO.toObject(RepairRecordEquipmentStockRecord.class));
			}

			record.setStockList(stockList);
		}
		return record;
	}

}
