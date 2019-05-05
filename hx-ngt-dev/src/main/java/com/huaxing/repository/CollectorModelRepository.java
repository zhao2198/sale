package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.CollectorModel;
import com.huaxing.common.repository.BaseRepository;

/**
 * 采集器型号dao
 * Create Date:	2018年7月7日 下午3:11:19
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface CollectorModelRepository extends BaseRepository<CollectorModel> {
	
	int isExists(CollectorModel collectorModel);
	
}
