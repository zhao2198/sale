package com.huaxing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxing.bean.MeterreadingLogSubmit;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.repository.MeterreadingLogSubmitRepository;
import com.huaxing.service.MeterreadingLogSubmitService;
import com.huaxing.vo.MeterreadingLogSubmitVO;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class MeterreadingLogSubmitServiceImpl extends BaseServiceImpl<MeterreadingLogSubmit> implements MeterreadingLogSubmitService {
	@Autowired
	private MeterreadingLogSubmitRepository meterreadingLogSubmitRepository;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = meterreadingLogSubmitRepository;
	}
	

	@Override
	@Transactional
	public int save(MeterreadingLogSubmit log) {
		log.setUUID();
		log.setCreate(log.getCreateBy());
		return super.save(log);
	}
	
	@Override
	@Transactional
	public int saveBatch(List<MeterreadingLogSubmit> logList) {
		logList.forEach(log->{
			log.setUUID();
			log.setCreate(log.getCreateBy());
		});
		return meterreadingLogSubmitRepository.saveBatch(logList);
	}

	
	
	@Override
	public PagingList<MeterreadingLogSubmitVO> queryList(MeterreadingLogSubmit meterreadingLogSubmit,PagingAttribute pageAttr) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
