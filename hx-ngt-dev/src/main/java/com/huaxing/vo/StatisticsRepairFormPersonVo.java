package com.huaxing.vo;

import com.huaxing.bean.Detail;
import com.huaxing.bean.StatisticsRepairForm;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 修复单按人员统计
 * 
 * @author Xie Ning
 * @date 2018-06-25 09:17:23
 */
@Data
@ApiModel(value = "修复单按人员统计")
public class StatisticsRepairFormPersonVo extends TransferObject<StatisticsRepairForm> {
	private static final long serialVersionUID = 1L;
	private String handlerId;// 受理人主键
	@ApiModelProperty(value = "受理人")
	private String handlerName;// 受理人名称
	@ApiModelProperty(value = "总数")
	private Detail sum;// 总的统计=缺陷+故障单
	@ApiModelProperty(value = "故障单统计")
	private Detail error;// 故障单统计
	@ApiModelProperty(value = "缺陷单统计")
	private Detail defect;// 缺陷单统计

	public StatisticsRepairFormPersonVo() {
		this.sum = new Detail();
		this.error = new Detail();
		this.defect = new Detail();
	}
}
