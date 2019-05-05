package com.huaxing.vo;
import com.huaxing.bean.ElectricPriceTemplate;
import com.huaxing.common.web.transfer.TransferObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value="电价模板返回信息")
@Data
public class ElectricPriceTemplateVo extends TransferObject<ElectricPriceTemplate> {
	private static final long serialVersionUID = 1L;
	//id
	@ApiModelProperty(value="id",required=true)
	private String id;
	@ApiModelProperty(value="变压器id",required=true)
	private String equipmentId;
	//模板编号
	@ApiModelProperty(value="模板编号",required=true)
	private String templateCode;
	//模板名称
	@ApiModelProperty(value="模板名称",required=true)
	private String templateName;
	@ApiModelProperty(value="电度电价",required=true)
	private ElectricPricePowerVo powerPrice;
	@ApiModelProperty(value="阶梯电价",required=false)
	private ElectricPriceLadderVo powerPriceLadderPrice;
	@ApiModelProperty(value="基本电价",required=true)
	private ElectricPriceBasicVo basicPrice;
	@ApiModelProperty(value="力调电价",required=true)
	private ElectricPriceForceVo forcePrice;
	
	@ApiModelProperty(value="公司id",required=true)
	private String companyId;
	@ApiModelProperty(value="公司名称",required=true)
	private String companyName;
	@ApiModelProperty(value="变压器名称",required=false)
	private String equipmentName;
}
