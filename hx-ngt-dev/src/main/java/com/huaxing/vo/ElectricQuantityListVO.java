package com.huaxing.vo;
import java.math.BigDecimal;

import com.huaxing.bean.ElectricQuantity;
import com.huaxing.common.web.transfer.TransferObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 用能总览电量列表返回数据
 * Create Date:	2018年7月27日 下午2:35:17
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="用能总览电量列表返回")
public class ElectricQuantityListVO extends TransferObject<ElectricQuantity>{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="数据采集时间",required=true)
	private String acquisitionTime;//数据采集时间，power_cost表中的创建时间
	@ApiModelProperty(value="尖时段电量",required=true)
	private BigDecimal sharpElectricQuantity;//尖电量
	@ApiModelProperty(value="峰时段电量",required=true)
	private BigDecimal peakElectricQuantity;//峰电量
	@ApiModelProperty(value="平时段电量",required=true)
	private BigDecimal flatElectricQuantity;//平电量
	@ApiModelProperty(value="谷时段电量",required=true)
	private BigDecimal valleyElectricQuantity;//谷电量
	@ApiModelProperty(value="尖峰平谷时段总电量",required=true)
	private BigDecimal totalElectricQuantity;//总电量
	
}
