package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.AcquisitionCard;
import com.huaxing.bean.CollectorModel;
import com.huaxing.common.repository.BaseRepository;

/**
 * 采集卡dao
 * Create Date:	2018年7月9日 上午10:00:57
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface AcquisitionCardRepository extends BaseRepository<AcquisitionCard> {
	int isExists(AcquisitionCard acquisitionCard);
	
}
