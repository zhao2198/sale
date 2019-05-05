package com.huaxing.service;

import java.util.List;

import com.huaxing.bean.NgtRole;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.BaseService;
import com.huaxing.common.utils.RestResult;
import com.huaxing.vo.NgtRoleVO;

/**
 * 角色表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
public interface NgtRoleService extends BaseService<NgtRole> {
	/**
	 * 批量删除角色
	 * 
	 * @param ids
	 * @return
	 */
	RestResult<String> deleteBatch(String[] ids);

	/**
	 * 创建能管通角色
	 * 
	 * @param role
	 * @return
	 */
	RestResult<String> createRole(NgtRole role);

	/**
	 * 修改某一角色
	 * 
	 * @param role
	 * @return
	 */
	RestResult<String> modifyRole(NgtRole role);

	/**
	 * 按照当前用户的组织查询角色列表
	 * 
	 * @param user
	 * @param page
	 * @return
	 */
	PagingList<NgtRoleVO> queryList(NgtRole role, PagingAttribute page);
	
	
	/**
	 * 获取全部角色
	 * 
	 *
	 * 14:32:22 2018 M07 27
	 */
	List<NgtRoleVO> queryList(NgtRole role, String userId);

	/**
	 * 根据ID获取某一角色
	 * 
	 * @param id
	 * @return
	 */
	NgtRoleVO getNgtRoleById(String id);

	/**
	 * 给某一角色分配用户
	 * 
	 * @param roleId
	 * @param userIds
	 * @return
	 */
	RestResult<String> saveRoleUser(String roleId, List<String> userIds);
	
	/**
	 * 给某一用户分配角色
	 *
	 * 15:12:11 2018 M07 27
	 */
	RestResult<String> saveUserRole(String userId, List<String> roleIds);

	/**
	 * 删除色色
	 * 
	 * @param id
	 * @return
	 */
	RestResult<String> delete(String id);

}
