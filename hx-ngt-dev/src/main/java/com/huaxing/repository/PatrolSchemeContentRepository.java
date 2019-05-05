package com.huaxing.repository;

import com.huaxing.bean.PatrolScheme;
import com.huaxing.bean.PatrolSchemeContent;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
public interface PatrolSchemeContentRepository extends BaseRepository<PatrolSchemeContent> {

	/**
	 * 根据巡查ID删除全部子内容
	 * 
	 * @param patrolId
	 *            巡检ID
	 * @return
	 */
	int deleteByPatrolId(String patrolId);
	/**
	 * 从巡检计划中保存具体内容
	 * Lian weimao CreateTime:2018年7月14日 下午1:55:33
	 * @param patrol
	 * @return
	 */
	int saveContent(PatrolScheme patrol);
	
	

}
