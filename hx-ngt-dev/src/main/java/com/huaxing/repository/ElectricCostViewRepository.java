package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.ElectricCostView;

/**
 * 用能总览 电费dao
 * Create Date:	2018年7月30日 上午11:58:45
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface ElectricCostViewRepository {
	/**
	 * 获取尖峰平谷电费原始数据
	 * @param entity
	 * @return
	 */
	List<ElectricCostView> getElectricCostViewDataList(ElectricCostView entity);
	/**
	 * 获取尖峰平谷饼图数据
	 * @param entity
	 * @return
	 */
	ElectricCostView getPieData(ElectricCostView entity);
	/**
	 * 获取基本力调电费原始数据
	 * @param entity
	 * @return
	 */
	List<ElectricCostView> getBasicAndForceCostList(ElectricCostView entity);
	/**
	 * 获取基本力调电费饼图数据
	 * @param entity
	 * @return
	 */
	ElectricCostView getBasicAndForceData(ElectricCostView entity);
	/**
	 * 获取基本电费列表数据
	 * @param entity
	 * @return
	 */
	List<ElectricCostView> getBasicCostList(ElectricCostView entity);
	/**
	 * 获取力调电费列表数据
	 * @param entity
	 * @return
	 */
	List<ElectricCostView> getForceCostList(ElectricCostView entity);

}
