package com.huaxing.bean;
/**
 * 基本电费模板entity
 * Create Date:	2018年6月1日 上午9:16:05
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */

import java.math.BigDecimal;

import lombok.Data;
@Data
public class BasicCostSign {
	private BigDecimal basicPrice;
	private BigDecimal apparentPowerStart;
	private BigDecimal apparentPowerEnd;
	
}
