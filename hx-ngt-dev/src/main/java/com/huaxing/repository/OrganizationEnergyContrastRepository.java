package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.OrganizationEnergyContrast;
import com.huaxing.common.repository.BaseRepository;

/**
 * Create Date: 2018年8月1日 上午9:17:54
 * 
 * @version: V3.0.1
 * @author: feng yi
 */
public interface OrganizationEnergyContrastRepository extends BaseRepository<OrganizationEnergyContrast> {

	List<OrganizationEnergyContrast> queryListByOrg(OrganizationEnergyContrast organizationEnergyContrast);

	List<OrganizationEnergyContrast> queryAvgLoad(OrganizationEnergyContrast organizationEnergyContrast);

}
