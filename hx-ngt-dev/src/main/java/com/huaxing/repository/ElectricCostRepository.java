package com.huaxing.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.huaxing.bean.BasicCost;
import com.huaxing.bean.BasicCostTemplate;
import com.huaxing.bean.DataStatistical;
import com.huaxing.bean.ForceCost;
import com.huaxing.bean.PowerCost;
import com.huaxing.bean.PowerCostEntity;
import com.huaxing.bean.StatisticalCountAndSum;
/**
 * 计算电费相关dao
 * Create Date:	2018年5月30日 上午10:35:40
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface ElectricCostRepository {
	/**根据设备id查询此设备所属的变压器id 王晓超 2018年5月31日09:40:41*/
	String getEquipmentId(String equipmentId);
	/** 保存电度电费  王晓超 2018年5月31日09:40:37*/
	void savePowerCost(PowerCost powercostentity);
	/**查询系统中所有的变压器  王晓超 2018年6月1日09:51:13*/
	List<String> getTransformerList();
	/**获取电费系统设置  王晓超 2018年6月1日17:00:06*/
	List<BasicCostTemplate> getBasicCostConfig(Map<String, Object> queryParameter);
	/**保存基本电费  王晓超 2018年6月4日09:31:33*/
	void saveBasicCost(BasicCost basiccostentity);
	/**获取系统中每个变压器每个月的电度电费 王晓超  2018年6月4日10:09:16*/
	List<Map<String, Object>> getPowerCostListOnMonth(Map<String, Object> queryParameter);
	/**获取系统中每个变压器每个月的基本电费   王晓超 2018年6月4日10:29:47*/
	List<Map<String, Object>> getBasicCostListOnMonth(Map<String, Object> queryParameter);
	/**查询系统中给所有变压器的功率因数执行标准 ，用来查找功率因数计算系数值   王晓超  2018年6月4日11:09:59*/
	List<Map<String, Object>> getForceCriterion();
	/**获取系统中每个变压器的每月的有功电度和无功电度，用来确定变压器力调系数   王晓超 2018年6月4日15:48:43*/
	List<Map<String, Object>> getActivePowerAndReactivePowerList(Map<String, Object> queryParameter);
	/**根据功率因数标准和无功电度/有功电度的值去库里查找力调系数   王晓超 2018年6月4日16:58:26*/
	BigDecimal getFocerValue(@Param("forceCoefficient")BigDecimal forceCoefficient, @Param("factorType")String factorType);
	/**保存基本电费进库  王晓超 2018年6月4日17:11:47*/
	void saveForceCost(ForceCost forcecostentity);
	/**
	 * 根据变压器id和创建时间去电度电费表中查询当天的数据
	 * @param entity
	 * @return
	 */
	PowerCostEntity getPowerCostData(PowerCostEntity entity);
	/**
	 * 更新电度电费表
	 * @param entity
	 */
	void updatePowerCostOnToday(PowerCostEntity entity);
	/**
	 * 新增数据至电度电费表
	 * @param entity
	 */
	void savePowerCostOnToday(PowerCostEntity entity);
	/**
	 * 获取能管在线统计数据
	 * @param entity
	 * @return
	 */
	DataStatistical getDataStatistical(DataStatistical entity);
	/**
	 * 获取数据统计表的sum 和 count
	 * @param entity
	 * @return
	 */
	StatisticalCountAndSum getSumAndCount(DataStatistical entity);
	/**
	 * 新增数据至数据统计表
	 * @param entity
	 */
	void saveDataStatistical(DataStatistical entity);
	/**
	 * 更新数据至数据统计表
	 * @param entity
	 */
	void updateDataStatistical(DataStatistical entity);

}
