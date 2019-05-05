package com.huaxing.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.repository.BaseRepository;

/**
 * 用户表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
public interface NgtUserRepository extends BaseRepository<NgtUser> {

	/**
	 * 判断是否存在相同的用户名
	 * 
	 * @param user
	 * @return
	 */
	int isExists(NgtUser user);

	/**
	 * update pwssword
	 * 
	 * @param user
	 * @return
	 */
	int updatePassword(NgtUser user);

	/**
	 * 获取当前角色下的所有能管通用户
	 * 
	 * @param roleId
	 * @return
	 */
	List<NgtUser> queryListByRoleId(@Param("user") NgtUser user, @Param("roleId") String roleId);

}
