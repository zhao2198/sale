package com.huaxing.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.Menu;
import com.huaxing.bean.Permissions;
import com.huaxing.bean.TreeNode;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.RoleMenuDTO;
import com.huaxing.service.NgtMenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户表
 * 
 * @author zhaowei
 * @date 2018-06-27 09:46:45
 */
@Api(tags = { "能管在线：菜单接口" })
@RestController
@RequestMapping("/api/menu")
public class NgtMenuController extends BaseController<Menu, Serializable> {
	@Autowired
	private NgtMenuService menuService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "查询当前用户所有权限", notes = "")
	// @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "roleId", value = "角色ID", required = false) })
	@RequestMapping(value = "/current/permissions", method = RequestMethod.GET)
	public RestResult<List<Permissions>> list() {

		List<Permissions> list = menuService.getPermissionsByUserId(this.getUserId(), null);

		return RestResultUtil.ok(list);
	}

	@ApiOperation(value = "添加角色权限", notes = "")
	@RequestMapping(value = "/role/permission/create", method = RequestMethod.POST)
	public RestResult<String> saveRoleMenu(@Valid @RequestBody RoleMenuDTO roleMenuDTO) {
		return menuService.createRoleMenus(roleMenuDTO.getRoleId(), roleMenuDTO.getMenuIds());
	}

	/**
	 * 获取当前用户组织树
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	@ApiOperation(value = "获取当前用户权限树", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "roleId", value = "角色ID", required = false) })
	public List<TreeNode> tree(String roleId) {

		List<TreeNode> list = menuService.getCurrentMenuTreeByRoleId(this.getUserId(), roleId);
		return list;
	}

}
