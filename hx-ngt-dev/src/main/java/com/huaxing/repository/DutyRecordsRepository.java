package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.DutyRecords;
import com.huaxing.common.repository.BaseRepository;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
public interface DutyRecordsRepository extends BaseRepository<DutyRecords> {
	/***
	 * 模糊查询相似的值班记录编号的集合
	 * 
	 * @param record
	 * @return
	 */
	List<String> getLikelyCodes(DutyRecords record);

}
