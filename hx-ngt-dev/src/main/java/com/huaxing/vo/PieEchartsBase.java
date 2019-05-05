package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
/**
 * 饼图所需基础数据格式
 * Create Date:	2018年7月23日 上午11:13:02
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class PieEchartsBase {
	private BigDecimal value;
	private String name;
	
	
	
	//mine
	//在环形图时使用该字段
	private List<String> titleNameList;
	
	public PieEchartsBase(String name) {
		super();
		this.name = name;
	}
	
	public void add(String value) {
		if(null == titleNameList) {
			titleNameList = new ArrayList<String>();
		}
		titleNameList.add(value);
	}
}
