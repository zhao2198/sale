package com.huaxing.repository;

import com.huaxing.bean.TodoCenter;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-02 09:37:51
 */
public interface TodoCenterRepository extends BaseRepository<TodoCenter> {

	/**
	 * 批量逻辑删除
	 * 
	 * @param ids
	 * @return
	 */
	int deleteLogicBatch(String[] ids);

	/**
	 * 批量修改只读状态
	 * 
	 * @param ids
	 * @return
	 */
	int updateBatchReadFlag(String[] ids);

	/**
	 * 单条逻辑删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteLogic(String id);

	/**
	 * 单条修改
	 * 
	 * @param id
	 * @return
	 */
	int updateReadFlag(String id);

}
