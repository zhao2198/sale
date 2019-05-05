package com.huaxing.dto;
import javax.validation.constraints.NotBlank;
import com.huaxing.bean.ElectricPriceBasic;
/**
 * 基本电价entity
 * Create Date:	2018年6月26日 下午3:04:17
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value="基本电价dto")
public class ElectricPriceBasicDto extends TransferObject<ElectricPriceBasic>{
	//基本电费电价类型 0 按容量 1 按需量
	@ApiModelProperty(value="基本电价类型（0按容量1按需量）",required=true)
	@NotBlank(message="基本电价类型不能为空")
	private String electricCostBasicType;
	//基本电费电价（值）
	@ApiModelProperty(value="基本电价值（按容量时传入）",required=false)
	private String electricCostBasicValue;
	//阶梯电价起始电量
	@ApiModelProperty(value="第一阶梯电价起始值（按需量时传入）",required=false)
	private String firstStart;
	//阶梯电价结束电量
	@ApiModelProperty(value="第一阶梯电价结束值（按需量时传入）",required=false)
	private String firstEnd;
	//递增电价值
	@ApiModelProperty(value="第一阶梯递增电价（按需量时传入）",required=false)
	private String firstLadderPrice;
	@ApiModelProperty(value="第二阶梯电价起始值（按需量时传入）",required=false)
	private String secondStart;
	//阶梯电价结束电量
	@ApiModelProperty(value="第二阶梯电价结束值（按需量时传入）",required=false)
	private String secondEnd;
	//递增电价值
	@ApiModelProperty(value="第二阶梯递增电价（按需量时传入）",required=false)
	private String secondLadderPrice;
	@ApiModelProperty(value="第三阶梯电价起始值（按需量时传入）",required=false)
	private String thirdStart;
	//阶梯电价结束电量
	@ApiModelProperty(value="第三阶梯电价结束值（按需量时传入）",required=false)
	private String thirdEnd;
	//递增电价值
	@ApiModelProperty(value="第三阶梯递增电价（按需量时传入）",required=false)
	private String thirdLadderPrice;
	@ApiModelProperty(value="第四阶梯电价起始值（按需量时传入）",required=false)
	private String fourthStart;
	//阶梯电价结束电量
	@ApiModelProperty(value="第四阶梯电价结束值（按需量时传入infinity）",required=false)
	private String fourthEnd;
	//递增电价值
	@ApiModelProperty(value="第四阶梯递增电价（按需量时传入）",required=false)
	private String fourthLadderPrice;
}
