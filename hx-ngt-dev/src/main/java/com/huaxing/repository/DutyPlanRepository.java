package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.DutyPlan;
import com.huaxing.common.repository.BaseRepository;

/**
 * 值班计划的crud接口
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */

public interface DutyPlanRepository extends BaseRepository<DutyPlan> {
	/***
	 * 
	 * @param id
	 * @return
	 */
	int publish(String id);

	/***
	 * 模糊查询相似的计划编号
	 * 
	 * @param plan
	 * @return
	 */
	List<String> getLikelyCodes(DutyPlan plan);

	/***
	 * 通过值班计划的编码查询有无相通的编码
	 * 
	 * @param plan
	 * @return
	 */
	DutyPlan getPlanByCode(DutyPlan plan);

	/***
	 * 验证值班计划是否可被发布
	 * 
	 * @param plan
	 * @return
	 */
	int checkPlanPublish(DutyPlan plan);
}
