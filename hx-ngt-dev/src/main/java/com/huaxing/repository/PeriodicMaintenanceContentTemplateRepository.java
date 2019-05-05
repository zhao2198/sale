package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.PeriodicMaintenanceContentTemplate;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
public interface PeriodicMaintenanceContentTemplateRepository extends BaseRepository<PeriodicMaintenanceContentTemplate> {

	/**
	 * 
	 * @param template
	 * @return
	 */
	int isExists(PeriodicMaintenanceContentTemplate template);

	List<PeriodicMaintenanceContentTemplate> queryMyList(PeriodicMaintenanceContentTemplate template);

	List<PeriodicMaintenanceContentTemplate> getByName(String templateName);

	List<PeriodicMaintenanceContentTemplate> queryListByEquimentId(PeriodicMaintenanceContentTemplate template);

}
