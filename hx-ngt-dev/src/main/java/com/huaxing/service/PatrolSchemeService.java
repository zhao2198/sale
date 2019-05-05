package com.huaxing.service;

import com.huaxing.bean.PatrolScheme;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.BaseService;
import com.huaxing.common.utils.RestResult;
import com.huaxing.util.NgtDefine.SchemeStatus;
import com.huaxing.vo.PatrolSchemeVO;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
public interface PatrolSchemeService extends BaseService<PatrolScheme> {

	PagingList<PatrolSchemeVO> queryList(PatrolScheme patrolScheme, PagingAttribute pageAttr);

	RestResult<String> createPatrol(PatrolScheme patrol);

	RestResult<String> modifyPatrol(PatrolScheme patrol);

	RestResult<String> removePatrol(String id);

	PatrolSchemeVO getPatrolSchemeVo(String id);

	RestResult<String> removeBatchPatrol(String[] ids);
	/**
	 * 设置巡检计划的状态
	 * Lian weimao CreateTime:2018年7月16日 上午9:29:35
	 * @param scheme
	 * @param schemeStatus
	 * @return
	 */
	RestResult<String> setSchemeStatus(PatrolScheme scheme,SchemeStatus schemeStatus);
	/**
	 * 暂停一个巡检计划
	 * Lian weimao CreateTime:2018年7月16日 上午9:27:31
	 * @param id
	 * @return
	 */
	RestResult<String> pausePatrol(String id);
	/**
	 * 恢复一个巡检计划
	 * Lian weimao CreateTime:2018年7月16日 上午9:40:01
	 * @param id
	 * @return
	 */
	RestResult<String> resumePatrol(String id);
	/**
	 * 增加计划运行次数
	 * Lian weimao CreateTime:2018年7月17日 下午12:01:02
	 * @param scheme
	 * @param beforeCount
	 * @return
	 */
	RestResult<String> plusExecutationCount(PatrolScheme scheme,int beforeCount);
}
