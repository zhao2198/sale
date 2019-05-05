package com.huaxing.vo;

import com.huaxing.bean.Detail;
import com.huaxing.bean.StatisticsRepairForm;
import com.huaxing.common.web.transfer.TransferObject;

import lombok.Data;

/**
 * 修复单按设备统计
 * 
 * @author Xie Ning
 * @date 2018-06-25 09:17:23
 */
@Data
public class StatisticsRepairFormEqpVo extends TransferObject<StatisticsRepairForm> {
	private static final long serialVersionUID = 1L;
	private String equipmentId;// 设备主键
	private String equipmentName;// 设备名称
	private Detail sum;// 总的统计=缺陷+故障单
	private Detail error;// 故障单统计
	private Detail defect;// 缺陷单统计
}
