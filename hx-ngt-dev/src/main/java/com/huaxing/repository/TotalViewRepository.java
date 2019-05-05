package com.huaxing.repository;

import java.math.BigDecimal;

import com.huaxing.bean.ElectricCostView;
import com.huaxing.bean.ElectricQuantity;
import com.huaxing.bean.ElectricityParameter;

/**
 * 用能总览dao
 * Create Date:	2018年8月2日 下午6:41:08
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface TotalViewRepository {
	/**
	 * 查询数据表中的最新一条数据，取其中的功率因数和视在功率总
	 * @param entity
	 * @return
	 */
	ElectricityParameter getElectricityParameterInfo(ElectricityParameter entity);
	/**
	 * 统计日月年电量
	 * @param entity
	 * @return
	 */
	BigDecimal getElectricQuantity(ElectricQuantity entity);
	/**
	 * 统计日月年电度电费
	 * @param entity
	 * @return
	 */
	BigDecimal getPowerCost(ElectricCostView entity);
	/**
	 * 统计日月年基本电费
	 * @param entity
	 * @return
	 */
	BigDecimal getBasicCost(ElectricCostView entity);
	/**
	 * 统计日月年力调电费
	 * @param entity
	 * @return
	 */
	BigDecimal getForceCost(ElectricCostView entity);

}
