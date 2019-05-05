package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.AlarmFault;
import com.huaxing.common.repository.BaseRepository;

/**
 * 告警中心告警信息相关 dao Create Date: 2018年7月11日 上午11:17:16
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
public interface AlarmFaultRepository extends BaseRepository<AlarmFault> {
	/**
	 * 查看告警列表
	 * 
	 * @param entity
	 * @return
	 */
	List<AlarmFault> getAlarmFaultList(AlarmFault entity);

	/**
	 * 确认告警故障
	 * 
	 * @param entity
	 * @return
	 */
	int confirmAlarmFault(AlarmFault entity);

	/**
	 * 屏蔽告警故障
	 * 
	 * @param entity
	 * @return
	 */
	int shieldingAlarmFault(AlarmFault entity);

	/**
	 * 取消已屏蔽的告警故障
	 * 
	 * @param entity
	 * @return
	 */
	int cancelShieldingAlarmFault(AlarmFault entity);

	/**
	 * 查看告警历史记录列表
	 * 
	 * @param entity
	 * @return
	 */
	List<AlarmFault> getAlarmFaultHistoryList(AlarmFault entity);

	/**
	 * 查看历史告警echart图
	 * 
	 * @param entity
	 * @return
	 */
	List<AlarmFault> getAlarmFaultHistoryEchart(AlarmFault entity);

	/**
	 * @param alarmFault
	 * @return 更新为开单状态数量
	 */
	int updateNewFormState(AlarmFault alarmFault);

	/**
	 * @param entity
	 * @return 告警类型的数量
	 */
	String getAlarmNum(AlarmFault entity);

}
