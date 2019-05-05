package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.EnergyRank;

/**
 * 用能总览能耗排名dao（类别能耗排名、组织能耗排名、建筑能耗排名）
 * Create Date:	2018年7月20日 下午2:17:47
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface EnergyRankRepository {
	/**
	 * 获取公司下所有的类别包括设备id 王晓超 2018年7月24日09:46:50
	 * @param entity
	 * @return
	 */
	List<EnergyRank> getCategoryList(EnergyRank entity);
	/**
	 * 获取能耗排名（类别、建筑、组织）所需原始数据  王晓超 2018年7月24日09:46:47
	 * @param entity
	 * @return
	 */
	List<EnergyRank> getEnergyRankEcharDataList(EnergyRank entity);
	/**
	 * 查询能耗排名（类别、建筑、组织）列表  王晓超 2018年7月24日09:46:44
	 * @param entity
	 * @return
	 */
	List<EnergyRank> getEnergyRankList(EnergyRank entity);
	/**
	 * 获取公司下所有的组织  王晓超 2018年7月24日09:46:41
	 * @param entity
	 * @return
	 */
	List<EnergyRank> getDepartmentList(EnergyRank entity);
	/**
	 * 获取公司下所有的建筑
	 * 王晓超 2018年7月24日09:46:35
	 * @param entity
	 * @return
	 */
	List<EnergyRank> getBuildingList(EnergyRank entity);

}
