package com.huaxing.bean;
import java.math.BigDecimal;
import lombok.Data;
/**
 * 能管在线统计数据所需要用到的count和sum
 * 
 * Create Date:	2018年10月16日 上午10:16:46
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class StatisticalCountAndSum{
	private BigDecimal sum;
	private Integer count;
}
