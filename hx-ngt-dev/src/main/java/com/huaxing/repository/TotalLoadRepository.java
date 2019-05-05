package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.TotalLoad;

/**
 * 用能总览总负荷情况dao
 * Create Date:	2018年7月24日 下午2:50:05
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface TotalLoadRepository {
	/**
	 * 查询总负荷list
	 * @param entity
	 * @return
	 */
	List<TotalLoad> getTotalLoadBarOrLineEchart(TotalLoad entity);
	/**
	 * 获取最大负荷list数据
	 * @param entity
	 * @return
	 */
	List<TotalLoad> getMaxLoadList(TotalLoad entity);
	/**
	 * 获取平均负荷list数据
	 * @param entity
	 * @return
	 */
	List<TotalLoad> getAvgLoadList(TotalLoad entity);
	/**
	 * 获取最小负荷list数据
	 * @param entity
	 * @return
	 */
	List<TotalLoad> getMinLoadList(TotalLoad entity);
	/**
	 * 最新获取负荷原始数据
	 * @param entity
	 * @return
	 */
	List<TotalLoad> getDataList(TotalLoad entity);
}
