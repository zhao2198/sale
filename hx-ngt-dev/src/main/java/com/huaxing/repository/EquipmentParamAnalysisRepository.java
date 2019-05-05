package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.CollDeviceData;
import com.huaxing.bean.EquipmentParam;
import com.huaxing.bean.EquipmentParamAnalysis;
import com.huaxing.common.repository.BaseRepository;

/**
 * Create Date: 2018年8月2日 下午7:42:37
 * 
 * @version: V3.0.1
 * @author: feng yi
 */
public interface EquipmentParamAnalysisRepository extends BaseRepository<EquipmentParamAnalysis> {

	List<EquipmentParamAnalysis> getEquipmentParamList(EquipmentParamAnalysis equipmentparamAnalysis);

	List<CollDeviceData> getDeviceDataByEquipment(EquipmentParamAnalysis equipmentparamAnalysis);

	List<EquipmentParam> queryParamList();

	List<EquipmentParamAnalysis> getListByparamAttr(EquipmentParamAnalysis equipmentparamAnalysis);

	List<EquipmentParamAnalysis> getListByAcmultElectr(EquipmentParamAnalysis equipmentparamAnalysis);

}
