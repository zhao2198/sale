package com.huaxing.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.huaxing.bean.ElectricQuantity;

/**
 * 首页数据dao
 * Create Date:	2018年7月4日 上午9:40:54
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface HomeRepository {
	/**
	 * 根据开始时间和结束时间查询某段时间内的用电量
	 * @param yearOnYearEntity
	 * @return
	 */
	BigDecimal getElectricQuantityByStartDateAndEndDate(ElectricQuantity yearOnYearEntity);
	/**
	 * 查询统计公司下的标记
	 * @param entity
	 * @return
	 */
	int getBiaoJiCount(ElectricQuantity entity);
	/**
	 * 查询电量原始数据，根据日期分组，用于柱状图
	 * @param entity
	 * @return
	 */
	List<ElectricQuantity> getElectricQuantityEchartData(ElectricQuantity entity);
	/**
	 * 统计告警总数（查询告警历史记录表）
	 * @param entity
	 * @return
	 */
	int getTotalAlarmFaultCount(ElectricQuantity entity);
	/**
	 * 统计告警未确认已确认等信息
	 * @param entity
	 * @return
	 */
	int getAlarmFaultCount(ElectricQuantity entity);
	/**
	 * 统计巡检各项数量
	 * @param entity
	 * @return
	 */
	int getPolling(ElectricQuantity entity);
	/**
	 * 统计定保单各项数量
	 * @param entity
	 * @return
	 */
	int getProtect(ElectricQuantity entity);
	/**
	 * 统计修复单各项数量
	 * @param entity
	 * @return
	 */
	int getRepairCount(ElectricQuantity entity);

}
