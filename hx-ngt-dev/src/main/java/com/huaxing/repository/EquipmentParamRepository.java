package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.EquipmentParam;
import com.huaxing.common.repository.BaseRepository;

/**
 * 设备参数dao Create Date: 2018年7月9日 下午2:14:21
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
public interface EquipmentParamRepository extends BaseRepository<EquipmentParam> {

	int isExists(EquipmentParam param);

	/**
	 * 获得所有参数的集合
	 * 
	 * @return
	 */
	List<EquipmentParam> getParamList();

}
