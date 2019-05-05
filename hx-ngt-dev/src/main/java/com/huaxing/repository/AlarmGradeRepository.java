package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.AlarmGrade;
import com.huaxing.common.repository.BaseRepository;

/**
 * 告警等级表
 * 
 * @author zhao wei
 * @date 2018-07-10 14:37:05
 */
public interface AlarmGradeRepository extends BaseRepository<AlarmGrade> {
	/**
	 * 查询告警等级设置列表
	 * 
	 * @param entity
	 * @return
	 */
	List<AlarmGrade> getAlarmGradeList(AlarmGrade entity);

	/**
	 * 查看告警等级设置详情
	 * 
	 * @param entity
	 * @return
	 */
	AlarmGrade getAlarmGradeInfo(AlarmGrade entity);

	/**
	 * 新增告警等级设置
	 * 
	 * @param entity
	 * @return
	 */
	int createAlarmGrade(AlarmGrade entity);

	/**
	 * 修改告警等级设置
	 * 
	 * @param entity
	 * @return
	 */
	int updateAlarmGrade(AlarmGrade entity);

	/**
	 * 删除告警等级设置
	 * 
	 * @param id
	 * @return
	 */
	int deleteAlarmGrade(String id);

	/**
	 * 判断是否存在相同级别
	 * 
	 * @param entity
	 * @return
	 */
	int isExists(AlarmGrade entity);

}
