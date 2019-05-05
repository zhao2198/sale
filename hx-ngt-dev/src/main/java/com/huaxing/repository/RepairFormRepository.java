package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.RepairForm;
import com.huaxing.bean.RepairRecordEquipmentStockRecord;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-04 09:41:30
 */
public interface RepairFormRepository extends BaseRepository<RepairForm> {

	/**
	 * 修改存在记录标志
	 * 
	 * @param id
	 * @return
	 */
	int updateRecordIsNotExist(String id);

	/**
	 * 修改修复结果
	 * 
	 * @param repairForm
	 * @return
	 */
	int updateResult(RepairForm repairForm);

	/**
	 * 
	 * Lian weimao CreateTime:2018年7月12日 下午1:45:13
	 * 
	 * @param repairFormId
	 * @return
	 */
	List<RepairRecordEquipmentStockRecord> queryMaterialRecordList(String repairFormId);
}
