package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.CollDeviceData;

/**
 * 电费数据恢复dao
 * Create Date:	2018年8月28日 上午10:42:28
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface DataRecoverRepository {
	/**
	 * 根据条件获取原始数据
	 * @param entity
	 * @return
	 */
	List<CollDeviceData> getCollDeviceDataList(CollDeviceData entity);
	/**
	 * 统计出电费表中的数据，用来支撑电费数据恢复条件
	 * @param entity
	 * @return
	 */
	int getPowerCostData(CollDeviceData entity);

}
