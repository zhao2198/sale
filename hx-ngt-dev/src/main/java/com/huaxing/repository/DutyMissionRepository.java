package com.huaxing.repository;

import java.util.List;
import java.util.Map;

import com.huaxing.bean.DutyCalendar;
import com.huaxing.bean.DutyMission;
import com.huaxing.common.repository.BaseRepository;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-04 15:43:49
 */
public interface DutyMissionRepository extends BaseRepository<DutyMission> {
	/***
	 * 查询值班任务为值班日历列表显示 先显示一条（如果每天的值班任务不止一条）
	 * 
	 * @param mission
	 * @return
	 */
	List<DutyCalendar> getListForCalendar(DutyMission mission);

	/***
	 * 具体的某一天查询所有的值班任务
	 * 
	 * @param map
	 * @return
	 */
	List<DutyMission> queryDayMissions(Map<String, Object> map);

	/***
	 * 模糊查询值班任务的编号
	 * 
	 * @param mission
	 * @return
	 */
	List<String> getLikelyCodes(DutyMission mission);

	/***
	 * 获取当天所有的值班任务
	 * 
	 * @param companyId
	 * 
	 * @return
	 */
	List<DutyMission> getTodayMissions(String companyId);
}
