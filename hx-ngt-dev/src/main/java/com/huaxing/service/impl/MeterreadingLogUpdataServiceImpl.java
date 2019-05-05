package com.huaxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxing.bean.MeterreadingLogUpdata;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.repository.MeterreadingLogUpdataRepository;
import com.huaxing.service.MeterreadingLogUpdateService;
import com.huaxing.vo.MeterreadingLogUpdataVO;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class MeterreadingLogUpdataServiceImpl extends BaseServiceImpl<MeterreadingLogUpdata> implements MeterreadingLogUpdateService {
	@Autowired
	private MeterreadingLogUpdataRepository meterreadingLogUpdataRepository;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = meterreadingLogUpdataRepository;
	}
	
	@Override
	public PagingList<MeterreadingLogUpdataVO> queryList(MeterreadingLogUpdata meterreadingLogUpdata, PagingAttribute pageAttr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(MeterreadingLogUpdata entity) {
		entity.setUUID();
		return super.save(entity);
	}
	
	
}
