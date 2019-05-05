package com.huaxing.repository;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.huaxing.bean.RepairRecord;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-04 09:41:31
 */
public interface RepairRecordRepository extends BaseRepository<RepairRecord> {

	/**
	 * 修改状态及意见
	 * 
	 * @param record
	 * @return
	 */
	int updateState(RepairRecord record);

	/**
	 * 获取提交数量
	 * 
	 * @param repairFormId
	 * @return
	 */
	@Select(value = "SELECT COUNT(*) FROM ngt_repair_record WHERE repair_form_id = #{repairFormId} AND submit_flag = '1' AND del_flag = '0' ")
	int getSubmitCount(@Param("repairFormId") String repairFormId);

	/**
	 * 获取未提交的数量 Lian weimao CreateTime:2018年7月12日 下午3:22:29
	 * 
	 * @param repairFormId
	 * @return
	 */
	@Select(value = "SELECT COUNT(*) FROM ngt_repair_record WHERE repair_form_id = #{repairFormId} AND submit_flag = '0' AND del_flag = '0' ")
	int getUnSubmitCount(@Param("repairFormId") String repairFormId);

	/**
	 * 获取修复记录的数量 Lian weimao CreateTime:2018年7月12日 下午2:38:50
	 * 
	 * @param record
	 * @return
	 */
	int getCount(RepairRecord record);

	/**
	 * 根据记录获取领料详情
	 * 
	 * @param id
	 * @return
	 */
	RepairRecord getDetailById(String id);

}
