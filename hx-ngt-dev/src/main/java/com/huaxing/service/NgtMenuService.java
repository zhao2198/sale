package com.huaxing.service;

import java.util.List;

import com.huaxing.bean.Permissions;
import com.huaxing.bean.TreeNode;
import com.huaxing.common.service.BaseService;
import com.huaxing.common.utils.RestResult;

/**
 * 角色表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
public interface NgtMenuService extends BaseService<Permissions> {

	List<Permissions> getPermissionsByUserId(String userId, String roleId);

	RestResult<String> createRoleMenus(String roleId, List<String> menuIds);
	
	List<TreeNode> getCurrentMenuTreeByRoleId(String userId, String roleId);

}
