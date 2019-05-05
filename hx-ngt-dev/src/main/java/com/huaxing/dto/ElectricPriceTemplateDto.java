package com.huaxing.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.huaxing.bean.ElectricPriceTemplate;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 电价模板dto
 * Create Date:	2018年6月27日 上午10:54:00
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="电价模板dto")
public class ElectricPriceTemplateDto extends TransferObject<ElectricPriceTemplate> {
	private String id;
	//设备id（变压器id）
	@ApiModelProperty(value="变压器id",required=true)
	@NotBlank(message="变压器id不能为空")
	private String equipmentId;
	//模板编号
	@ApiModelProperty(value="模板编号",required=true)
	@NotBlank(message="模板编号不能为空")
	private String templateCode;
	//模板名称
	@ApiModelProperty(value="模板名称",required=true)
	@NotBlank(message="模板名称不能为空")
	private String templateName;
	@ApiModelProperty(value="电度电价",required=true)
	@NotNull(message="电度电价不能为空")
	private ElectricPricePowerDto powerPrice;//电度电价dto
	@ApiModelProperty(value="阶梯电价",required=false)
	private ElectricPriceLadderDto powerPriceLadderPrice;//阶梯电价dto
	@ApiModelProperty(value="基本电价",required=true)
	@NotNull(message="基本电价不能为空")
	private ElectricPriceBasicDto basicPrice;//基本电价dto
	@ApiModelProperty(value="力调电价",required=true)
	@NotNull(message="力调电价不能为空")
	private ElectricPriceForceDto forcePrice;//力调电价dto
	
	
	
}
