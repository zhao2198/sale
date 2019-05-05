package com.huaxing.repository;

import com.huaxing.bean.AcquisitioncardChannel;
import com.huaxing.common.repository.BaseRepository;

/**
 * 采集卡配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
public interface AcquisitioncardChannelRepository extends BaseRepository<AcquisitioncardChannel> {

	int deleteBatchByEqu(String[] ids);

	String getProjectCodeById(String id);

	int isExists(AcquisitioncardChannel acquisitioncardChannel);

}
