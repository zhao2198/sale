package com.huaxing.repository;

import java.util.Map;

import com.huaxing.bean.MaintenanceMission;
import com.huaxing.bean.MaintenanceMissionContent;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
public interface MaintenanceMissionContentRepository extends BaseRepository<MaintenanceMissionContent> {
	/**
	 * 保存定保记录
	 * Lian weimao CreateTime:2018年7月17日 下午2:04:05
	 * @param template
	 * @return
	 */
	int save(MaintenanceMission template);

	@Override
	@Deprecated
	default int save(MaintenanceMissionContent t) {
		return 0;
	}

	@Override
	@Deprecated
	default int save(Map<String, Object> map) {
		return 0;
	}
	
}
