package com.huaxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxing.bean.MaintenanceSchemeContent;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.repository.MaintenanceSchemeContentRepository;
import com.huaxing.service.MaintenanceSchemeContentService;
import com.huaxing.vo.MaintenanceSchemeContentVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceSchemeContentServiceImpl extends BaseServiceImpl<MaintenanceSchemeContent> implements MaintenanceSchemeContentService {
	@Autowired
	private MaintenanceSchemeContentRepository periodicMaintenanceContentRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = periodicMaintenanceContentRepository;
	}

	@Override
	public PagingList<MaintenanceSchemeContentVO> queryList(MaintenanceSchemeContent periodicMaintenanceContent, PagingAttribute pageAttr) {
		// TODO Auto-generated method stub
		return null;
	}

}
