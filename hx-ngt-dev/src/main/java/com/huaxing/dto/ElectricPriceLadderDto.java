package com.huaxing.dto;
import com.huaxing.bean.ElectricPriceLadder;
import com.huaxing.common.web.transfer.TransferObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 阶梯电价entity
 * Create Date:	2018年6月26日 下午3:01:12
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="阶梯dto")
public class ElectricPriceLadderDto extends TransferObject<ElectricPriceLadder>{
	//阶梯电价起始电量
	@ApiModelProperty(value="第一阶梯电价起始值",required=false)
	private String firstStart;
	//阶梯电价结束电量
	@ApiModelProperty(value="第一阶梯电价结束值",required=false)
	private String firstEnd;
	//递增电价值
	@ApiModelProperty(value="第一阶梯递增电价",required=false)
	private String firstLadderPrice;
	@ApiModelProperty(value="第二阶梯电价起始值",required=false)
	private String secondStart;
	//阶梯电价结束电量
	@ApiModelProperty(value="第二阶梯电价结束值",required=false)
	private String secondEnd;
	//递增电价值
	@ApiModelProperty(value="第二阶梯递增电价",required=false)
	private String secondLadderPrice;
	@ApiModelProperty(value="第三阶梯电价起始值",required=false)
	private String thirdStart;
	//阶梯电价结束电量
	@ApiModelProperty(value="第三阶梯电价结束值",required=false)
	private String thirdEnd;
	//递增电价值
	@ApiModelProperty(value="第三阶梯递增电价",required=false)
	private String thirdLadderPrice;
	@ApiModelProperty(value="第四阶梯电价起始值",required=false)
	private String fourthStart;
	//阶梯电价结束电量
	@ApiModelProperty(value="第四阶梯电价结束值(infinity)",required=false)
	private String fourthEnd;
	//递增电价值
	@ApiModelProperty(value="第四阶梯递增电价",required=false)
	private String fourthLadderPrice;
	//阶梯类型 0 年 1 月
	@ApiModelProperty(value="阶梯电价类型（0年1月）",required=false)
	private String electricCostLadderType;
}
