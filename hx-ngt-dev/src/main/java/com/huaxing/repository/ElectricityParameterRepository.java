package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.ElectricityParameter;

/**
 * 用能总览  用电参数dao
 * Create Date:	2018年7月26日 上午10:34:36
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface ElectricityParameterRepository {
	/**
	 * 查询用电参数最大数值list（动态查询视在功率或者功率因数）
	 * @param entity
	 * @return
	 */
	List<ElectricityParameter> getMaxList(ElectricityParameter entity);
	/**
	 * 查询用电参数最小数值list（动态查询视在功率或者功率因数）
	 * @param entity
	 * @return
	 */
	List<ElectricityParameter> getMinList(ElectricityParameter entity);
	/**
	 *  查询用电参数平均值list（动态查询视在功率或者功率因数）
	 * @param entity
	 * @return
	 */
	List<ElectricityParameter> getAvgList(ElectricityParameter entity);
	/**
	 * 获取用电参数的原始数据
	 * @param entity
	 * @return
	 */
	List<ElectricityParameter> getDataList(ElectricityParameter entity);

}
