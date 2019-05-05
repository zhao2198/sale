package com.huaxing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxing.bean.PeriodicMaintenanceContentTemplate;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.dto.PeriodicCheckItemDTO;
import com.huaxing.repository.PeriodicMaintenanceContentTemplateRepository;
import com.huaxing.service.PeriodicMaintenanceContentTemplateService;
import com.huaxing.util.NgtStatus;
import com.huaxing.vo.PeriodicMaintenanceContentTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PeriodicMaintenanceContentTemplateServiceImpl extends BaseServiceImpl<PeriodicMaintenanceContentTemplate>
		implements PeriodicMaintenanceContentTemplateService {
	@Autowired
	private PeriodicMaintenanceContentTemplateRepository periodicMaintenanceContentTemplateRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = periodicMaintenanceContentTemplateRepository;
	}

	@Override
	public PagingList<PeriodicMaintenanceContentTemplateVO> queryList(PeriodicMaintenanceContentTemplate periodicMaintenanceContentTemplate,
			PagingAttribute pageAttr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult<String> createTemplate(PeriodicMaintenanceContentTemplate template, List<PeriodicCheckItemDTO> list) {
		if (periodicMaintenanceContentTemplateRepository.isExists(template) > 0) {
			return RestResultUtil.getResult(NgtStatus.PERIODIC_MAIN_CONTENT_TEMPLATE_NAME_EXISTS);
		}
		List<PeriodicMaintenanceContentTemplate> templateList = new ArrayList<PeriodicMaintenanceContentTemplate>();
		int index = 1;
		for (PeriodicCheckItemDTO periodicCheckItemDTO : list) {
			PeriodicMaintenanceContentTemplate beanItem = new PeriodicMaintenanceContentTemplate();

			try {
				BeanUtils.copyProperties(beanItem, template);
				BeanUtils.copyProperties(beanItem, periodicCheckItemDTO);
				beanItem.setSort(index + "");
				beanItem.setUUID();
				index++;
				templateList.add(beanItem);
			} catch (Exception e) {

				log.error(e.getMessage());
			}
		}

		int count = periodicMaintenanceContentTemplateRepository.saveBatch(templateList);
		return this.result(count);
	}

	@Override
	public RestResult<String> modifyTemplate(PeriodicMaintenanceContentTemplate template) {
		if (periodicMaintenanceContentTemplateRepository.isExists(template) > 0) {
			return RestResultUtil.getResult(NgtStatus.PERIODIC_MAIN_CONTENT_TEMPLATE_NAME_EXISTS);
		}
		int count = periodicMaintenanceContentTemplateRepository.update(template);
		return this.result(count);
	}

	@Override
	public RestResult<String> removeTemplate(String id) {
		int count = periodicMaintenanceContentTemplateRepository.delete(id);
		return this.result(count);
	}

	@Override
	public List<PeriodicMaintenanceContentTemplateVO> queryMyList(PeriodicMaintenanceContentTemplate periodicMaintenanceContentTemplate) {
		List<PeriodicMaintenanceContentTemplate> list = periodicMaintenanceContentTemplateRepository.queryMyList(periodicMaintenanceContentTemplate);
		List<PeriodicMaintenanceContentTemplateVO> distList = this.toListVO(list, PeriodicMaintenanceContentTemplateVO.class);
		return distList;
	}

	@Override
	public List<PeriodicMaintenanceContentTemplateVO> getByTemplateName(String templateName) {
		List<PeriodicMaintenanceContentTemplate> list = periodicMaintenanceContentTemplateRepository.getByName(templateName);
		List<PeriodicMaintenanceContentTemplateVO> distList = this.toListVO(list, PeriodicMaintenanceContentTemplateVO.class);
		return distList;
	}

	@Override
	public List<PeriodicMaintenanceContentTemplateVO> queryListByEquimentId(PeriodicMaintenanceContentTemplate periodicMaintenanceContentTemplate) {
		List<PeriodicMaintenanceContentTemplate> list = periodicMaintenanceContentTemplateRepository
				.queryListByEquimentId(periodicMaintenanceContentTemplate);
		List<PeriodicMaintenanceContentTemplateVO> distList = this.toListVO(list, PeriodicMaintenanceContentTemplateVO.class);
		return distList;
	}

}
