package com.huaxing.repository;

import java.util.Map;

import com.huaxing.bean.PatrolMission;
import com.huaxing.bean.PatrolMissionContent;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
public interface PatrolMissionContentRepository extends BaseRepository<PatrolMissionContent> {

	int save(PatrolMission template);

	@Override
	@Deprecated
	default int save(PatrolMissionContent t) {
		return 0;
	}

	@Override
	@Deprecated
	default int save(Map<String, Object> map) {
		return 0;
	}
	
	
	
}
