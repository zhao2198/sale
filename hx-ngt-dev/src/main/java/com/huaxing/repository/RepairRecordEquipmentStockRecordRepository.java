package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.RepairRecordEquipmentStockRecord;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-05 09:23:20
 */
public interface RepairRecordEquipmentStockRecordRepository extends BaseRepository<RepairRecordEquipmentStockRecord> {

	/**
	 * 根据记录ID删除所有物料记录
	 * 
	 * @param id
	 * @return
	 */
	int deleteByRecordId(String id);

	/**
	 * 批量添加物料记录 Create Date 2018年7月5日 上午9:31:48
	 * 
	 * @param recordId
	 * @param list
	 * @return
	 */
	@Override
	int saveBatch(List<RepairRecordEquipmentStockRecord> list);
}
