package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 根据采集器传回的电量计算出的基本电费存放entity Create Date: 2018年5月29日 上午10:11:55
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BasicCost extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	private String equipmentId; // 变压器id
	private String companyId; // 公司id
	private String type; // 类型（0按容量1按需量）
	private BigDecimal cost; // 电费
	private BigDecimal electrovalence; // 电价
	private String month; // 月份
	private String dataType; // 数据类型（0其它设备1高压侧2低压侧）
	private Date createDate; // 创建时间

}
