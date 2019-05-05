package com.huaxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxing.bean.PatrolSchemeContent;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.repository.PatrolSchemeContentRepository;
import com.huaxing.service.PatrolSchemeContentService;
import com.huaxing.vo.PatrolSchemeContentVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatrolSchemeContentServiceImpl extends BaseServiceImpl<PatrolSchemeContent> implements PatrolSchemeContentService {
	@Autowired
	private PatrolSchemeContentRepository patrolSchemeContentRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = patrolSchemeContentRepository;
	}

	@Override
	public PagingList<PatrolSchemeContentVO> queryList(PatrolSchemeContent patrolSchemeContent, PagingAttribute pageAttr) {
		// TODO Auto-generated method stub
		return null;
	}

}
