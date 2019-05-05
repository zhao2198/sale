package com.huaxing.service;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.BaseService;
import com.huaxing.common.utils.RestResult;
import com.huaxing.vo.NgtUserVO;

/**
 * 用户表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
public interface NgtUserService extends BaseService<NgtUser> {

	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 * @return
	 */
	RestResult<String> deleteBatch(String[] ids);

	/**
	 * 根据用户ID删除及其色色
	 * 
	 * @param userId
	 * @return
	 */
	RestResult<String> delete(String userId);

	/**
	 * 创建用户
	 * 
	 * @param user
	 * @return
	 */
	RestResult<String> createUser(NgtUser user);

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	RestResult<String> modifyUser(NgtUser user);

	/**
	 * 查询用户列表
	 * 
	 * @param user
	 * @param page
	 * @return
	 */
	PagingList<NgtUserVO> queryList(NgtUser user, PagingAttribute page);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @return
	 */
	RestResult<String> modifyPassword(String userId);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public NgtUserVO getNgtUserById(String id);

	/**
	 * 获取当前角色下所有用户
	 * 
	 * @param user
	 * @param page
	 * @return
	 */
	PagingList<NgtUserVO> queryListByRoleId(NgtUser user, String roleId, PagingAttribute page);

}
