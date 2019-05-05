package com.huaxing.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huaxing.bean.CollDeviceData;
import com.huaxing.bean.EquipmentParamConfig;
import com.huaxing.common.repository.BaseRepository;

/**
 * 设备参数配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
public interface EquipmentParamConfigRepository extends BaseRepository<EquipmentParamConfig> {

	void deleteBatchByCode(List<EquipmentParamConfig> upConfigList);

	int getCountByProjectCode(@Param("projectCode") String projectCode, @Param("companyId") String companyId);

	List<EquipmentParamConfig> queryOtherParam(CollDeviceData collDeviceData);

	int updateBatch(@Param("list") List<EquipmentParamConfig> list, @Param("paramSource") String paramSource);

	int deleteByAcquisitonCardId(@Param("acquisitioncardChannelId") String acquisitioncardChannelId, @Param("paramSource") String paramSource);

}
