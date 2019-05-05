package com.huaxing.repository;

import java.util.List;
import java.util.Map;

import com.huaxing.bean.DutySign;
import com.huaxing.bean.DutyStatistics;
import com.huaxing.common.repository.BaseRepository;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
public interface DutySignRepository extends BaseRepository<DutySign> {
	/***
	 * 查询已知人的 在一定时间范围内的值班次数
	 * 
	 * @param queryParam
	 * @return
	 */
	List<DutySign> queryForDutyStatistics_person(Map<String, Object> queryParam);

	/***
	 * 获取计划值班的次数
	 * 
	 * @param queryParam
	 * @return
	 */
	List<DutyStatistics> getPlanPersonSta(Map<String, Object> queryParam);

	/***
	 * 查询实际值班的次数
	 * 
	 * @param queryParam
	 * @return
	 */
	List<DutySign> getPersonSta(Map<String, Object> queryParam);

	/**
	 * 查询值班正常的次数
	 * 
	 * @param queryParam
	 * @return
	 */
	List<DutySign> getNormalPersonSta(Map<String, Object> queryParam);

	/***
	 * 查询值班异常的次数
	 * 
	 * @param queryParam
	 * @return
	 */
	List<DutySign> getUnNormalPersonSta(Map<String, Object> queryParam);

}
