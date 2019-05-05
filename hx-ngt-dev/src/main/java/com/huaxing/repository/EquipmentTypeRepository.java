package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.EquipmentType;
import com.huaxing.common.repository.BaseRepository;
import com.huaxing.common.utils.RestResult;

/**
 * Create Date: 2018年7月27日 上午11:45:16
 * 
 * @version: V3.0.1
 * @author: feng yi
 */
public interface EquipmentTypeRepository extends BaseRepository<EquipmentType> {

	String getMaxId(EquipmentType equipmentType);

	int isExists(EquipmentType equipmentType);

	int isExistsByName(EquipmentType equipmentType);

	int isExistsChild(EquipmentType equipmentType);

	RestResult<List<EquipmentType>> getInit(EquipmentType equipmentType);

	String getType(String id);

}
