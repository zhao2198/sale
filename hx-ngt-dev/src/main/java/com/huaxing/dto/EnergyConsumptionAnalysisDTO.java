package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.huaxing.bean.EnergyConsumptionAnalysis;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采集器配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@ApiModel(value = "机构能耗比例查询;")
@Data
@EqualsAndHashCode(callSuper = false)
public class EnergyConsumptionAnalysisDTO extends TransferObject<EnergyConsumptionAnalysis> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "开始时间", required = false)
	private Date startDate;

	@ApiModelProperty(value = "结束时间", required = false)
	private Date endDate;

	@ApiModelProperty(value = "日期类型", required = true)
	@NotBlank(message = "日期类型不能为空")
	private String typeDate;

	/*
	 * @ApiModelProperty(value = "日期类型", required = true)
	 * 
	 * @NotBlank(message = "设备类型不能为空") private String equipmentType;
	 */
	@ApiModelProperty(value = "开始时间", required = true)
	@NotNull(message="开始时间不能为空")
	private String queryDateStart;
	@NotNull(message="结束时间不能为空")
	@ApiModelProperty(value = "结束时间", required = true)
	private String queryDateEnd;
}
