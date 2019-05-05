package com.huaxing.service;

import com.huaxing.bean.PatrolSchemeContent;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.BaseService;
import com.huaxing.vo.PatrolSchemeContentVO;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
public interface PatrolSchemeContentService extends BaseService<PatrolSchemeContent> {

	PagingList<PatrolSchemeContentVO> queryList(PatrolSchemeContent patrolSchemeContent, PagingAttribute pageAttr);

}
