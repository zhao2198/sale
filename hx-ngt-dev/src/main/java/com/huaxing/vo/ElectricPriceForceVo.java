package com.huaxing.vo;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.ElectricPriceForce;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="力调电价信息")
@Data
public class ElectricPriceForceVo extends TransferObject<ElectricPriceForce> {
	private static final long serialVersionUID = 1L;
	//力调电费功率因数值
	@ApiModelProperty(value="力调电价功率因数标准（）",required=true)
	private String electricCostForceValue;
	//力调电费参考表的url
	@ApiModelProperty(value="力调电价功率因数url",required=true)
	private String electricCostForceUrl;
}
