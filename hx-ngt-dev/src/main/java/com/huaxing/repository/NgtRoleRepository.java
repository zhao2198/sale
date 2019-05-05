package com.huaxing.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huaxing.bean.NgtRole;
import com.huaxing.common.repository.BaseRepository;

/**
 * 角色表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
public interface NgtRoleRepository extends BaseRepository<NgtRole> {

	/**
	 * 判断是否存在相同的角色名
	 * 
	 * @param role
	 * @return
	 */
	int isExists(NgtRole role);

	/**
	 * 是否存在用户
	 * 
	 * @param roleId
	 * @return
	 */
	int isExistUser(String roleId);

	/**
	 * 角色分配多个用户
	 * 
	 * @param roleId
	 * @param userIds
	 * @return
	 */
	int saveRoleUser(@Param("roleId") String roleId, @Param("list") List<String> userIds);

	/**
	 * 用户分配多个角色
	 * 
	 * @param roleId
	 * @param roleIds
	 * @return
	 */
	int saveUserRole(@Param("userId") String userId, @Param("list") List<String> roleIds);

	/**
	 * 删除用户下所有角色
	 * 
	 * @param userId
	 * @return
	 */
	int deleteUserRole(String userId);
	
	/**
	 * 根据用户ID获取所拥有角色
	 * @author zhaowei
	 *
	 * 14:54:11 2018 M07 27
	 */
	List<NgtRole> queryListByUserId(String userId);
}
