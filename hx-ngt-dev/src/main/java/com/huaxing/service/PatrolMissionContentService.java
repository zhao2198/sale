package com.huaxing.service;

import java.util.List;

import com.huaxing.bean.PatrolMission;
import com.huaxing.bean.PatrolMissionContent;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.BaseService;
import com.huaxing.common.utils.RestResult;
import com.huaxing.vo.PatrolMissionContentVO;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
public interface PatrolMissionContentService extends BaseService<PatrolMissionContent> {

	PagingList<PatrolMissionContentVO> queryList(PatrolMissionContent patrolMissionContent, PagingAttribute pageAttr);

	@Override
	@Deprecated
	default int save(PatrolMissionContent entity) {
		return 0;
	}

	@Override
	@Deprecated
	default void save(List<PatrolMissionContent> entities) {
	}
	/**
	 * 保存巡检任务
	 * Lian weimao CreateTime:2018年7月13日 下午5:08:26
	 * @param template
	 * @return
	 */
	public RestResult<String> save(PatrolMission template);
	
	

}
