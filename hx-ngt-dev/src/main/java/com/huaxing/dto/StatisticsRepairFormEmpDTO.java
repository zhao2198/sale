package com.huaxing.dto;

import java.util.Date;

import com.huaxing.bean.StatisticsRepairForm;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "查询修复单按设备统计")
public class StatisticsRepairFormEmpDTO extends TransferObject<StatisticsRepairForm> {
	private static final long serialVersionUID = 1L;
	// for select
	private String empId;// 设备id
	private String type;// 修复单类型（0 故障开单 1 缺陷开单）
	private String dateTimeUnit; // 时间日期单位,有日月年
	private Date startDate; // 开始日期
	private Date endDate; // 结束日期
	// for view and select
	private String repairState;// 修复结果 修复单状态（0未受理 1已受理 2 待验收 3 已验收 4验收未通过）？？
}
