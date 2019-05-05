package com.huaxing.repository;

import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
public interface MaintenanceSchemeRepository extends BaseRepository<MaintenanceScheme> {

	/**
	 * 根据定保计划ID获取详情包括定保内容列表
	 * 
	 * @param id
	 * @return
	 */
	MaintenanceScheme getDetailById(String id);

}
