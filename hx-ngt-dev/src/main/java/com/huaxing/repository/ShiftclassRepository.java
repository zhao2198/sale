package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.Shiftclass;
import com.huaxing.common.repository.BaseRepository;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
public interface ShiftclassRepository extends BaseRepository<Shiftclass> {
	/***
	 * 查询相似的调班编号的集合
	 * 
	 * @param clazz
	 * @return
	 */
	List<String> getLikelyCodes(Shiftclass clazz);

}
