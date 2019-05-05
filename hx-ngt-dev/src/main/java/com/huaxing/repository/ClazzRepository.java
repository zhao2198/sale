package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.Clazz;
import com.huaxing.common.repository.BaseRepository;

/**
 * 班次crud接口
 * 
 * @author Xie Ning
 * @date 2018-06-25 09:17:23
 */
public interface ClazzRepository extends BaseRepository<Clazz> {
	/***
	 * 
	 * @param clazz
	 * @return
	 */
	int isExists(Clazz clazz);

	/***
	 * 
	 * @param clazz
	 * @return
	 */
	List<String> getLikelyCodes(Clazz clazz);

}
