package com.huaxing.service;

import com.huaxing.bean.PatrolMission;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.BaseService;
import com.huaxing.common.utils.RestResult;
import com.huaxing.util.NgtDefine.MissionStatus;
import com.huaxing.vo.PatrolMissionVO;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
public interface PatrolMissionService extends BaseService<PatrolMission> {

	PagingList<PatrolMissionVO> queryList(PatrolMission patrolMission, PagingAttribute pageAttr);
	/**
	 * 通过ID返回VO
	 * Lian weimao CreateTime:2018年7月16日 上午9:54:06
	 * @param id
	 * @return
	 */
	PatrolMissionVO getPatrolMissionVo(String id);
	/**
	 * 修改任务单的状态
	 * Lian weimao CreateTime:2018年7月16日 上午10:45:42
	 * @param missionid
	 * @param missionStatus
	 * @return
	 */
	RestResult<String> setMissionStatus(String missionid,MissionStatus missionStatus);
	/**
	 * 接单
	 * Lian weimao CreateTime:2018年7月16日 上午10:53:16
	 * @param mission
	 * @return
	 */
	RestResult<String> order(PatrolMission mission);
	/**
	 * 通过任务单
	 * Lian weimao CreateTime:2018年7月16日 上午11:07:34
	 * @param mission
	 * @return
	 */
	RestResult<String> pass(PatrolMission mission);
	/**
	 * 保存巡检记录
	 * Lian weimao CreateTime:2018年7月16日 上午11:36:41
	 * @param mission
	 * @return
	 */
	RestResult<String> saveRecord(PatrolMission mission);
	/**
	 * 验收
	 * Lian weimao CreateTime:2018年7月16日 上午11:56:11
	 * @param mission
	 * @param state 
	 * @return
	 */
	RestResult<String> check(PatrolMission mission, String state);
}
