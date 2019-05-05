package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.CollectorConfigure;
import com.huaxing.common.repository.BaseRepository;

/**
 * 采集器配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
public interface CollectorConfigureRepository extends BaseRepository<CollectorConfigure> {

	List<String> queryAcquisitioncardChannelById(String id);

}
