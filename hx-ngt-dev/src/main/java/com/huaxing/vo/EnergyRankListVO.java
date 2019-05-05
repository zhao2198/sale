package com.huaxing.vo;

import java.math.BigDecimal;

import com.huaxing.bean.AlarmType;
import com.huaxing.bean.EnergyRank;
import com.huaxing.common.entity.DateTimeEntity;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 类别能耗排名、建筑能耗排名、组织能耗排名（虚拟对象）
 * Create Date:	2018年7月13日 上午11:04:55
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="用能总览能耗排名列表返回（类别能耗排名、组织能耗排名、建筑能耗排名）")
public class EnergyRankListVO extends TransferObject<EnergyRank>{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="建筑名称",required=false)
	private String buildingName;//建筑名称
	@ApiModelProperty(value="类别名称",required=false)
	private String categoryName;//类别名称
	@ApiModelProperty(value="部门名称",required=false)
	private String departmentName;//部门（组织）名称
	@ApiModelProperty(value="尖时段能耗",required=false)
	private BigDecimal sharpElectricQuantity; //尖能耗(电量)
	@ApiModelProperty(value="峰时段能耗",required=false)
	private BigDecimal peakElectricQuantity;//峰能耗（电量）
	@ApiModelProperty(value="平时段能耗",required=false)
	private BigDecimal flatElectricQuantity;//平能耗（电量）
	@ApiModelProperty(value="谷时段能耗",required=false)
	private BigDecimal valleyElectricQuantity;//谷能耗（电量）
	@ApiModelProperty(value="总能耗",required=false)
	private BigDecimal totalElectricQuantity;//总能耗（电量）
	
	
}
