package com.huaxing.vo;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="首页电量、碳排放、煤耗值数据返回")
public class HomeElectricQuantityVO {
	@ApiModelProperty(value="同比",required=true)
	private BigDecimal yearOnYear;//同比
	@ApiModelProperty(value="环比",required=true)
	private BigDecimal monthOnMonth; // 环比
	@ApiModelProperty(value="表记",required=true)
	private Integer meter;//表记
	@ApiModelProperty(value="本年总（电量、碳排放、煤耗值）",required=true)
	private BigDecimal totalElectricQuantity; //本年总电量
	@ApiModelProperty(value="本年电量、碳排放、煤耗值echart图数据",required=true)
	private BarAndLineEchartsVO echart;	//echart图数据
}
