package com.huaxing.repository;

import com.huaxing.bean.PatrolScheme;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
public interface PatrolSchemeRepository extends BaseRepository<PatrolScheme> {

	/**
	 * 获取巡检详情
	 * 
	 * @param id
	 * @return
	 */
	PatrolScheme getDetailById(String id);

}
