package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.OrganizationEnergyContrast;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Create Date: 2018年7月31日 下午5:51:05
 * 
 * @version: V3.0.1
 * @author: feng yi
 */
@ApiModel(value = "机构对比;")
@Data
@EqualsAndHashCode(callSuper = false)
public class OrganizationEnergyContrastDTO extends TransferObject<OrganizationEnergyContrast> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "开始时间", required = true)
	private Date startDate;

	@ApiModelProperty(value = "结束时间", required = true)
	private Date endDate;

	@ApiModelProperty(value = "日期类型", required = true)
	@NotBlank(message = "日期类型不能为空")
	private String typeDate;

//	@ApiModelProperty(value = "设备类型Id的集合", required = true)
//	@NotBlank(message = "设备类型Id不能为空")
//	private String[] equipmentTypeId;

	@ApiModelProperty(value = "设备类型的类型", required = true)
	@NotBlank(message = "设备类型的类型不能为空")
	private String type;

}
