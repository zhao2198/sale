package com.huaxing.repository;

import java.math.BigDecimal;
import java.util.List;

import com.huaxing.bean.Equipment;
import com.huaxing.bean.MeterreadingMission;
import com.huaxing.common.repository.BaseRepository;

/**
 * 抄表任务表; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
public interface MeterreadingMissionRepository extends BaseRepository<MeterreadingMission> {
	/**
	 * 提交一个日期下所有有抄表数的任务 Lian weimao CreateTime:2018年7月19日 下午3:50:47
	 * 
	 * @param queryParam
	 * @return
	 */
	int submitDate(MeterreadingMission queryParam);

	/**
	 * 批量修改任务的执行人 Lian weimao CreateTime:2018年7月23日 上午10:29:19
	 * 
	 * @param paramList
	 * @return
	 */
	int updateHandlerIdsBatch(List<MeterreadingMission> paramList);

	/*****
	 * 查询一定时间的指定表计的抄表数值
	 * 
	 * @param queryData
	 * @return
	 */
	List<MeterreadingMission> queryMissionList(MeterreadingMission queryData);

	/****
	 * 获取最近的一次抄表的值
	 * 
	 * @param queryData
	 * @return
	 */
	BigDecimal getRecentValue(MeterreadingMission queryData);

	/****
	 * 获取所选表计列表
	 * 
	 * @param queryData
	 * @return
	 */
	List<Equipment> getEqps(MeterreadingMission queryData);

	/*****
	 * 获取 本月的各个设备的最后一次的抄表数
	 * 
	 * @param queryData
	 * @return
	 */
	List<MeterreadingMission> getRecentlyMeterreading(MeterreadingMission queryData);

	/*****
	 * 查询本月的各个设备的最开始的一条抄表
	 * 
	 * @param queryData
	 * @return
	 */
	List<MeterreadingMission> getRecentlyBaseMeterreading(MeterreadingMission queryData);

}
