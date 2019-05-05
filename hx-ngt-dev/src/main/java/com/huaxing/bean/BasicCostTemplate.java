package com.huaxing.bean;
/**
 * 基本电费模板entity
 * Create Date:	2018年6月1日 上午9:16:05
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class BasicCostTemplate {
	private String bianyaqiId;// 变压器id
	private String calcType;// 基本电费类型 0按容量 1 按需量
	private String companyId;// 公司id
	private List<BasicCostSign> basicCostSignList;
	private BigDecimal avgApparentPower; // 变压器一个月内每十五分钟平均视在功率取最大值
	private String hetongrongliang; // 变压器合同容量
	private String yunxingrongliang; // 变压器运行容量
}
