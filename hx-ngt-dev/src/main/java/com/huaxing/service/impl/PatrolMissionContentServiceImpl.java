package com.huaxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxing.bean.PatrolMission;
import com.huaxing.bean.PatrolMissionContent;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.RestResult;
import com.huaxing.repository.PatrolMissionContentRepository;
import com.huaxing.service.PatrolMissionContentService;
import com.huaxing.vo.PatrolMissionContentVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatrolMissionContentServiceImpl extends BaseServiceImpl<PatrolMissionContent> implements PatrolMissionContentService {
	@Autowired
	private PatrolMissionContentRepository patrolMissionContentRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = patrolMissionContentRepository;
	}

	@Override
	public PagingList<PatrolMissionContentVO> queryList(PatrolMissionContent patrolMissionContent, PagingAttribute pageAttr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult<String> save(PatrolMission template) {
		int rows = patrolMissionContentRepository.save(template);
		return result(rows);
	}

}
