package com.huaxing.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huaxing.bean.AlarmSetting;
import com.huaxing.common.repository.BaseRepository;

/**
 * 告警条件设置表; InnoDB free: 12288 kB; InnoDB free: 9216 kB
 * 
 * @author zhao wei
 * @date 2018-07-14 10:16:16
 */
public interface AlarmSettingRepository extends BaseRepository<AlarmSetting> {

	List<AlarmSetting> queryEquParamName(AlarmSetting alarmSetting);

	int isExists(AlarmSetting alarmSetting);

	int deleteByEquipment(AlarmSetting alarmSetting);

	int deleteBatchByEqu(String[] ids);

	AlarmSetting getInfo(@Param("id") String id, @Param("companyId") String companyId);

}
