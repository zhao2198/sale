package com.huaxing.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huaxing.bean.Permissions;
import com.huaxing.common.repository.BaseRepository;

/**
 * 角色表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
public interface NgtMenuRepository extends BaseRepository<Permissions> {

	List<Permissions> getPermissionsByUserId(String userId);

	int saveRoleMenus(@Param("roleId") String roleId, @Param("menuIds") List<String> menuIds);

	int deletRoleMenuId(String roleId);
}
