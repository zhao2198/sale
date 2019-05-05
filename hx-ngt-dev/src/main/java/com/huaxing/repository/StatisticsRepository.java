package com.huaxing.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.huaxing.bean.Detail;
import com.huaxing.bean.RepairForm;
import com.huaxing.bean.StaticsPatrolPersion;
import com.huaxing.bean.StaticsRepairPerson;
import com.huaxing.bean.StatisticsPatrolPerson;
import com.huaxing.bean.StatisticsRepairForm;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.repository.BaseRepository;
import com.huaxing.vo.Series;

/**
 * Create Date: 2018年7月24日 上午8:55:43
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
public interface StatisticsRepository extends BaseRepository<StatisticsPatrolPerson> {





	/**
	 * 修复单按人员统计
	 * 
	 * @param person
	 * @param page
	 * @return
	 */
	List<StaticsRepairPerson> queryRepairStaticPersons(@Param("person") StatisticsRepairForm person, @Param("page") PagingAttribute page);

	/**
	 * 修复单按人员统计人数
	 * 
	 * @param person
	 * @return
	 */
	List<Integer> queryRepairStaticPersonsCount(@Param("person") StatisticsRepairForm person);

	/**
	 * 修复单按设备统计
	 * 
	 * @param person
	 * @param page
	 * @return
	 */
	List<StaticsRepairPerson> queryRepairStaticEquiments(@Param("person") StatisticsRepairForm person, @Param("page") PagingAttribute page);

	/**
	 * 修复单按设备统计设备数
	 * 
	 * @param person
	 * @return
	 */
	List<Integer> queryRepairStaticEquimentsCount(@Param("person") StatisticsRepairForm person);

	/**
	 * 统计人员巡检详情
	 * 
	 * @param person
	 * @param page
	 * @return
	 */
	List<StaticsPatrolPersion> queryPatrolStaticPersons(@Param("person") StatisticsPatrolPerson person, @Param("page") PagingAttribute page);

	/**
	 * 统计人数
	 * 
	 * @param person
	 * @return
	 */
	List<Integer> queryPatrolStaticPersonsCount(@Param("person") StatisticsPatrolPerson person);
	/**
	 * 按天统计各个巡检次数
	 * @param entity
	 * @return
	 */
	List<StatisticsPatrolPerson> getPatrolDataCount(StatisticsPatrolPerson entity);
	/**
	 * 按天统计各种情况修复单数量
	 * @param entity
	 * @return
	 */
	List<StatisticsRepairForm> getDataCount(StatisticsRepairForm entity);
}
