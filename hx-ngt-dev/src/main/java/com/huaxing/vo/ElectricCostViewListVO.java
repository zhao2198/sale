package com.huaxing.vo;
import java.math.BigDecimal;

import com.huaxing.bean.ElectricQuantity;
import com.huaxing.common.web.transfer.TransferObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 用能总览电费中尖峰平谷电费列表返回信息
 * Create Date:	2018年7月30日 下午3:28:21
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="用能总览电费列表返回信息")
public class ElectricCostViewListVO extends TransferObject<ElectricQuantity>{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="数据采集时间",required=true)
	private String acquisitionTime;//数据采集时间，power_cost表中的创建时间
	@ApiModelProperty(value="尖时段电费",required=true)
	private BigDecimal sharpCost;//尖电费
	@ApiModelProperty(value="峰时段电费",required=true)
	private BigDecimal peakCost;//峰电费
	@ApiModelProperty(value="平时段电费",required=true)
	private BigDecimal flatCost;//平电费
	@ApiModelProperty(value="谷时段电费",required=true)
	private BigDecimal valleyCost;//谷电费
	@ApiModelProperty(value="总电费（按日统计时为尖峰平谷总电费，按月和年统计时为电度+基本+力调）",required=true)
	private BigDecimal totalCost;//总电费
	
	@ApiModelProperty(value="按月和年统计时的基本电费",required=false)
	private BigDecimal basicCost; //基本电费
	@ApiModelProperty(value="按月和年统计时的力调电费",required=false)
	private BigDecimal forceCost; //力调电费
	@ApiModelProperty(value="按月和年统计时的电度电费（尖峰平谷电费和）",required=false)
	private BigDecimal powerCost;//电度电费
	
	//查询基本电费时所需
	@ApiModelProperty(value="基本电费按容量按需量类型（0按容量1按需量）",required=false)
	private String basicCostType; //  0按容 1按需
	@ApiModelProperty(value="基本电费按容量",required=false)
	private BigDecimal capacityCost; //按容电费
	@ApiModelProperty(value="基本电费按需量",required=false)
	private BigDecimal demandCost;//需量电费
	
	
}
