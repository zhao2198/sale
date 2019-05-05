package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.AlarmType;
import com.huaxing.common.repository.BaseRepository;

/**
 * 告警类型dao Create Date: 2018年7月13日 下午2:10:27
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
public interface AlarmTypeRepository extends BaseRepository<AlarmType> {
	/**
	 * 查看告警类型列表
	 * 
	 * @param entity
	 * @return
	 */
	List<AlarmType> getAlarmTypeList(AlarmType entity);

	/**
	 * 查看告警类型详情
	 * 
	 * @param id
	 * @return
	 */
	AlarmType getAlarmTypeInfo(String id);

	/**
	 * 新增告警类型
	 * 
	 * @param entity
	 * @return
	 */
	int createAlarmType(AlarmType entity);

	/**
	 * 修改告警类型
	 * 
	 * @param entity
	 * @return
	 */
	int updateAlarmType(AlarmType entity);

	/**
	 * 删除告警类型
	 * 
	 * @param id
	 * @return
	 */
	int deleteAlarmType(String id);

	/**
	 * get max id
	 * 
	 * @param entity
	 * @return
	 */
	String getMaxId(AlarmType entity);

	int isExistsByName(AlarmType entity);

	int isExistsChild(AlarmType entity);

	/**
	 * 判断是否存在相同类型
	 * 
	 * @param entity
	 * @return
	 */
	int isExists(AlarmType entity);

}
