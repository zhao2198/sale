package com.huaxing.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 堆叠柱状图或多线图vo
 * Create Date:	2018年7月26日 上午10:19:05
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@ApiModel(value = "堆叠柱状图或多线图返回数据")
@Data
public class BarsAndLinesEchartsVO extends InitQueryDateVO{
	@ApiModelProperty(value = "图表标题", required = false)
	private String titleName;
	@ApiModelProperty(value = "图例", required = false)
	private List<String> legendName;
	 //x轴数据
	@ApiModelProperty(value = "x轴数据", required = true)
	private List<String> xData;
	//y轴数据
	@ApiModelProperty(value = "y轴数据", required = true)
	private List<BarsAndLinesEchartsBase> yData;
}
