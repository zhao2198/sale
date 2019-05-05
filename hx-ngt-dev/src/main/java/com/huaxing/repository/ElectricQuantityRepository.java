package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.ElectricPricePower;
import com.huaxing.bean.ElectricQuantity;

/**
 * 用能总览电量dao
 * Create Date:	2018年7月26日 下午7:05:19
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface ElectricQuantityRepository {
	/**
	 * 获取电量原始数据
	 * @param entity
	 * @return
	 */
	List<ElectricQuantity> getElectricQuanTityDataList(ElectricQuantity entity);
	/**
	 * 获取电量饼图数据，因为需要根据日月年来统计，sql用到了sum函数
	 * @param entity
	 * @return
	 */
	ElectricQuantity getPieData(ElectricQuantity entity);
	/**
	 * 查询电价模板中的尖峰平谷各时段，用来在环形图上显示,只返回time和time_type用来操作
	 * @param entity
	 * @return
	 */
	List<ElectricPricePower> getTimeList(ElectricQuantity entity);

}
