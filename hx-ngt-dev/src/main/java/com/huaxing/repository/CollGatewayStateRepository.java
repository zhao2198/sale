package com.huaxing.repository;

import java.util.List;

import com.huaxing.bean.CollGatewayState;
import com.huaxing.bean.Collector;
import com.huaxing.common.repository.BaseRepository;

/**
 * InnoDB free: 8192 kB
 * 
 * @author feng yi
 * @date 2018-07-16 16:29:36
 */
public interface CollGatewayStateRepository extends BaseRepository<CollGatewayState> {

	List<CollGatewayState> findStateList(CollGatewayState collGatewayState);

	List<Collector> findCollectorOnlingStateList(CollGatewayState collGatewayState);

}
