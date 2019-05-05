package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.Collector;
import com.huaxing.common.repository.BaseRepository;

/**
 * 采集器表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-06 14:06:07
 */
public interface CollectorRepository extends BaseRepository<Collector> {

	/**
	 * 判断网关编号是否重复
	 * 
	 * @param equipment
	 * @return
	 */
	int isExists(Collector collector);

	/**
	 * 批量逻辑删除网关
	 * 
	 * @param ids
	 * @return
	 */
	int deleteBatchByLogic(String[] ids);

	/**
	 * 删除网关配置表和采集卡配置表和设备参数配置表中的和网关关联的数据
	 * 
	 * @param ids
	 * @return
	 */
	int deleteBatchById(String[] ids);

	/**
	 * 根据网关的Id查找对应的网关编号
	 * 
	 * @param ids
	 * @return
	 */
	List<String> getProjectCodeById(String[] ids);
}
