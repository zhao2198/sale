package com.huaxing.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 饼图返回信息
 * Create Date:	2018年7月23日 上午11:39:46
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@ApiModel(value = "饼图返回信息")
@Data
public class PieEchartsVO {
	@ApiModelProperty(value = "图表标题", required = false)
	private String titleName;
	@ApiModelProperty(value = "图例", required = false)
	private List<String> legendName;
	 //x轴数据
	@ApiModelProperty(value = "图表数据", required = true)
	private List<PieEchartsBase> data;
}
