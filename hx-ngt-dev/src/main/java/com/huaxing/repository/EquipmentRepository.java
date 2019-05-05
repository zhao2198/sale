package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.Equipment;
import com.huaxing.common.repository.BaseRepository;

/**
 * 设备表; InnoDB free: 16384 kB; InnoDB free: 10240 kB
 * 
 * @author Feng Yi
 * @date 2018-06-26 11:24:30
 */
public interface EquipmentRepository extends BaseRepository<Equipment> {

	/**
	 * 判断设备编号是否重复
	 * 
	 * @param equipment
	 * @return
	 */
	int isExists(Equipment equipment);

	/**
	 * 根据传入的ids逻辑删除设备
	 * 
	 * @param ids
	 * @return
	 */
	int deleteBatchByLogic(String[] ids);

	/**
	 * 获取变压器列表
	 * 
	 * @param companyId
	 * @return
	 */
	List<Equipment> getTransformerList(String companyId);

	/**
	 * 根据各种类型查询设备列表
	 * 
	 * @param equipment
	 * @return
	 */
	List<Equipment> queryListByTypeId(Equipment equipment);

	/**
	 * 删除采集卡配置表和设备参数配置表中的和设备关联的数据
	 * 
	 * @param ids
	 * @return
	 */
	int deleteBatchById(String[] ids);

	/**
	 * 查询设备ids对应的去查采集器ids
	 * 
	 * @param ids
	 * @return
	 */
	List<String> getCollectorProjectCode(String[] ids);

	/**
	 * @param 根据设备类型查询对应的设备id
	 * @return
	 */
	List<String> getEquIdByEquipmentType(Equipment equipment);

	/**
	 * @param equipment
	 *            传入name查询是否存在
	 * @return
	 */
	int isNameExists(Equipment equipment);

}
