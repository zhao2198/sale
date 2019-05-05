package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.TodoCenterContent;
import com.huaxing.common.repository.BaseRepository;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-02 09:37:51
 */
public interface TodoCenterContentRepository extends BaseRepository<TodoCenterContent> {

	@Override
	List<TodoCenterContent> queryList(TodoCenterContent content);

}
