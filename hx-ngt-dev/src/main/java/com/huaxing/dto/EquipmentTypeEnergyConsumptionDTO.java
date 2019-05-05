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
@ApiModel(value = "网关配置表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentTypeEnergyConsumptionDTO extends TransferObject<EnergyConsumptionAnalysis> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "开始时间", required = false)
	private Date startDate;

	@ApiModelProperty(value = "结束时间", required = false)
	private Date endDate;

	@ApiModelProperty(value = "能源类别", required = false)
	@NotBlank(message = "能源类别不能为空")
	private String energyClass;

	@ApiModelProperty(value = "日期类型", required = false)
	@NotBlank(message = "日期类型不能为空")
	private String typeDate;

	@ApiModelProperty(value = "设备类型Type(值1,2,3,4)，分别代表建筑，组织，配电房，类别", required = false)
	@NotBlank(message = "设备类型不能为空")
	private String type;
	
	@ApiModelProperty(value = "开始时间", required = true)
	@NotNull(message="开始时间不能为空")
	private String queryDateStart;
	@NotNull(message="结束时间不能为空")
	@ApiModelProperty(value = "结束时间", required = true)
	private String queryDateEnd;

}
