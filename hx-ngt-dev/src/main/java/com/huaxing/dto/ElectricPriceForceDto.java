package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.ElectricPriceForce;
import com.huaxing.common.web.transfer.TransferObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 力调电价dto
 * Create Date:	2018年6月26日 下午3:02:33
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="力调电价dto")
public class ElectricPriceForceDto extends TransferObject<ElectricPriceForce> {
	//力调电费功率因数值
	@ApiModelProperty(value="力调电价功率因数标准（）",required=true)
	@NotBlank(message="力调电价功率因数标准不能为空")
	private String electricCostForceValue;
	//力调电费参考表的url
	@ApiModelProperty(value="力调电价功率因数url",required=true)
	@NotBlank(message="功率因数url不能为空")
	private String electricCostForceUrl;
}
