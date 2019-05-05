package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 堆叠柱状图或多线图y轴基础数据
 * Create Date:	2018年7月26日 上午10:20:48
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class BarsAndLinesEchartsBase {
	//柱子上需要显示的名称
	private String name;
	//值
	private List<BigDecimal> list;
	
	public BarsAndLinesEchartsBase() {
		
	}
	
	public BarsAndLinesEchartsBase(String name) {
		this.name = name;
	}
	
	public void add(BigDecimal value) {
		if(null == list) {
			list = new ArrayList<BigDecimal>();
		}
		list.add(value);
	}
}
