package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.ParamconfigData;
import com.huaxing.common.repository.BaseRepository;

/**
 * 配置采集器传回参数; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
public interface ParamconfigDataRepository extends BaseRepository<ParamconfigData> {

	ParamconfigData findByProjectCode(ParamconfigData paramconfigData);

	int deleteBatchByProjectCode(List<String> list);

	int deleteConfig(ParamconfigData paramconfigData);

}
