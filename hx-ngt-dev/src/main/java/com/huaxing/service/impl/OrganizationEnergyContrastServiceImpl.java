package com.huaxing.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.huaxing.bean.Equipment;
import com.huaxing.bean.OrganizationEnergyContrast;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.repository.EquipmentRepository;
import com.huaxing.repository.OrganizationEnergyContrastRepository;
import com.huaxing.service.OrganizationEnergyContrastService;
import com.huaxing.vo.OrganizationEnergyContrastVO;

/**
 * Create Date: 2018年7月24日 下午5:22:31
 * 
 * @version: V3.0.1
 * @author: feng yi
 */
@Service
public class OrganizationEnergyContrastServiceImpl extends BaseServiceImpl<OrganizationEnergyContrast> implements OrganizationEnergyContrastService {
	@Autowired
	private OrganizationEnergyContrastRepository organizationEnergyContrastRepository;
	@Autowired
	private EquipmentRepository equipmentRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = organizationEnergyContrastRepository;
	}

	@Override
	public PagingList<OrganizationEnergyContrastVO> queryList(OrganizationEnergyContrast organizationEnergyContrast, PagingAttribute pageAttr) {
		Page<?> page = pageAttr.toPage();
		List<OrganizationEnergyContrast> list = null;
		String type = organizationEnergyContrast.getType();
		if ("2".equals(type)) {
			list = organizationEnergyContrastRepository.queryListByOrg(organizationEnergyContrast);
		} else {
			list = organizationEnergyContrastRepository.queryList(organizationEnergyContrast);
		}
		List<OrganizationEnergyContrastVO> listVO = this.toListVO(list, OrganizationEnergyContrastVO.class);
		Map<String, BigDecimal> typeMap = new HashMap<String, BigDecimal>();// 存入设备类型和该类型的总负荷对应关系
		getEquipmentTypeSumload(organizationEnergyContrast, listVO, typeMap, type);
		for (OrganizationEnergyContrastVO vo : listVO) {
			vo.setPeakCost(vo.getPeakCost().setScale(2, BigDecimal.ROUND_HALF_UP));
			vo.setFlatCost(vo.getFlatCost().setScale(2, BigDecimal.ROUND_HALF_UP));
			vo.setSharpCost(vo.getSharpCost().setScale(2, BigDecimal.ROUND_HALF_UP));
			vo.setValleyCost(vo.getValleyCost().setScale(2, BigDecimal.ROUND_HALF_UP));
			vo.setTotalCost(vo.getTotalCost().setScale(2, BigDecimal.ROUND_HALF_UP));
			for (Map.Entry<String, BigDecimal> map : typeMap.entrySet()) {
				if (map.getKey().equals(vo.getId())) {
					vo.setSumLoad(map.getValue().setScale(2, BigDecimal.ROUND_HALF_UP));
				}
			}
		}
		Paging paging = new Paging(page.getTotal(), pageAttr);
		return new PagingList<OrganizationEnergyContrastVO>(listVO, paging);
	}

	private void getEquipmentTypeSumload(OrganizationEnergyContrast organizationEnergyContrast, List<OrganizationEnergyContrastVO> listVO,
			Map<String, BigDecimal> typeMap, String type) {
		Equipment equipment = new Equipment();
		equipment.setCompanyId(organizationEnergyContrast.getCompanyId());
		List<Equipment> equList = equipmentRepository.queryList(equipment);
		List<OrganizationEnergyContrast> energyList = organizationEnergyContrastRepository.queryAvgLoad(organizationEnergyContrast);
		for (OrganizationEnergyContrastVO vo : listVO) {
			String attrId = "";
			List<String> ids = new ArrayList<String>();
			// 根据类型id获取设备id
			for (Equipment equ : equList) {
				switch (type) {
				case "1":
					attrId = equ.getBuilding();
					break;
				case "2":
					attrId = equ.getOrganization();
					break;
				case "3":
					attrId = equ.getDistributionRoom();
					break;
				case "4":
					attrId = equ.getCategory();
					break;
				}
				if (vo.getId().equals(attrId)) {
					ids.add(equ.getId());
				}
			}
			BigDecimal avgLoad = new BigDecimal("0.00");// 本类型下所有设备的平均负荷
			if (ids.size() > 0) { // 该类型下所有设备总负荷的平均值
				for (String id : ids) {
					for (OrganizationEnergyContrast energy : energyList) {
						if (energy.getEquipmentId().equals(id)) {
							avgLoad = avgLoad.add(energy.getAvgLoad());
						}
					}
				}
			}

			typeMap.put(vo.getId(), avgLoad);
		}
	}
}
