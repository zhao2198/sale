package com.huaxing.repository;

import java.util.Map;

import com.huaxing.bean.ScheduleJobEntity;
import com.huaxing.common.repository.BaseRepository;

/**
 * 定时任务
 * 
 */
public interface ScheduleJobDao extends BaseRepository<ScheduleJobEntity> {

	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
