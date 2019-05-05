package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.CollDeviceData;
import com.huaxing.common.repository.BaseRepository;

/**
 * InnoDB free: 8192 kB
 * 
 * @author feng yi
 * @date 2018-07-16 16:29:36
 */
public interface CollDeviceDataRepository extends BaseRepository<CollDeviceData> {

	CollDeviceData queryDivceData(CollDeviceData collDeviceData);

	List<CollDeviceData> queryCountDataByDate(CollDeviceData collDeviceData);

	List<CollDeviceData> queryCountDataByMonth(CollDeviceData collDeviceData);

	List<CollDeviceData> queryCountDataByYear(CollDeviceData collDeviceData);

}
