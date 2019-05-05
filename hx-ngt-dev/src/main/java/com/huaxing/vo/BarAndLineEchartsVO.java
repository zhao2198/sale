package com.huaxing.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 柱状图和线性图返回信息
 * Create Date:	2018年7月19日 下午2:37:22
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
 @ApiModel(value = "柱状图或者线性图返回信息")
@Data
public class BarAndLineEchartsVO extends InitQueryDateVO{
	@ApiModelProperty(value = "图表标题", required = false)
	private String titleName;
	@ApiModelProperty(value = "图例", required = false)
	private List<String> legendName;
	 //x轴数据
	@ApiModelProperty(value = "x轴数据", required = true)
	private List<String> xData;
	//y轴数据
	@ApiModelProperty(value = "y轴数据", required = true)
	private List<BigDecimal> yData;

}
