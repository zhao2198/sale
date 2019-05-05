package com.huaxing.bean;

import java.util.Date;
import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-04 09:41:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RepairRecord extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 修复单主键
	private String repairFormId;
	// 修复开始时间
	private Date startTime;
	// 修复完毕时间
	private Date endTime;
	// 花费的时间
	private Long takeTime;
	// 现场恢复时间
	private Date recoveryTime;
	// 修复结果(1已修复,0未修复)
	private String result;
	// 是否已提交(0未提交,1已提交)
	private String submitFlag;
	// 附件的路径,以逗号分割
	private String url;
	// 所属公司主键
	private String companyId;

	// 备注信息
	private String remarks;

	// 启用标记
	private String enableFlag;

	// 状态0未提交 1待验收 2不通过 3通过
	private String state;
	// 审批意见
	private String command;

	// for insert

	List<RepairRecordEquipmentStockRecord> stockList;

}
