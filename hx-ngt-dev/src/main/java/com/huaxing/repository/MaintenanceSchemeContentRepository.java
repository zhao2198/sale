package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.bean.MaintenanceSchemeContent;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
public interface MaintenanceSchemeContentRepository extends BaseRepository<MaintenanceSchemeContent> {

	/*
	 * 批量插入定保内容 Create Date 2018年7月6日 下午3:17:16
	 * 
	 * @author zhao wei
	 * 
	 * @see com.huaxing.common.repository.BaseRepository#saveBatch(java.util.List)
	 */
	@Override
	int saveBatch(List<MaintenanceSchemeContent> list);

	/**
	 * 
	 * @param mainId
	 * @return
	 */
	int deleteByMainId(String mainId);
	/**
	 * 从定保计划中保存具体内容
	 * Lian weimao CreateTime:2018年7月17日 上午11:34:29
	 * @param maintenance
	 * @return
	 */
	int saveContent(MaintenanceScheme maintenance);

}
