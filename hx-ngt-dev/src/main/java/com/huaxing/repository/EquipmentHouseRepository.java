package com.huaxing.repository;

import com.huaxing.bean.EquipmentHouse;
import com.huaxing.common.repository.BaseRepository;

/**
 * 库存管理; InnoDB free: 10240 kB; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-09 09:10:19
 */
public interface EquipmentHouseRepository extends BaseRepository<EquipmentHouse> {

	int isExists(EquipmentHouse equipmentHouse);

	int deleteBatchByLogic(String[] ids);

}
