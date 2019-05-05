package com.huaxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxing.bean.MaintenanceMission;
import com.huaxing.bean.MaintenanceMissionContent;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.RestResult;
import com.huaxing.repository.MaintenanceMissionContentRepository;
import com.huaxing.service.MaintenanceMissionContentService;
import com.huaxing.vo.MaintenanceMissionContentVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceMissionContentServiceImpl extends BaseServiceImpl<MaintenanceMissionContent> implements MaintenanceMissionContentService {
	@Autowired
	private MaintenanceMissionContentRepository periodicMaintenanceContentRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = periodicMaintenanceContentRepository;
	}

	@Override
	public PagingList<MaintenanceMissionContentVO> queryList(MaintenanceMissionContent periodicMaintenanceRecord, PagingAttribute pageAttr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public RestResult<String> save(MaintenanceMission template) {
		int rows = periodicMaintenanceContentRepository.save(template);
		return result(rows);
	}

}
