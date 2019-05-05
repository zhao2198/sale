package com.huaxing.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.NgtRole;
import com.huaxing.common.entity.UserEntity;
import com.huaxing.common.exception.APIException;
import com.huaxing.common.exception.ResponseStatus;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.Constants;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.NgtRoleDTO;
import com.huaxing.dto.NgtRoleUserDTO;
import com.huaxing.dto.NgtUserRoleDTO;
import com.huaxing.modules.annotation.CurrentUser;
import com.huaxing.service.NgtRoleService;
import com.huaxing.vo.NgtRoleVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 角色表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
@Api(tags = { "能管在线：角色接口" })
@RestController
@RequestMapping("/api/role")
@Validated
public class NgtRoleController extends BaseController<NgtRole, Serializable> {
	@Autowired
	private NgtRoleService roleService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "角色列表信息", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "name", value = "角色名称", required = false) })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<PagingList<NgtRoleVO>> list(String name, PagingAttribute pageAttr) {
		// 查询列表数据
		NgtRole role = new NgtRole();
		role.setCompanyId(this.getCompanyId());
		//role.setOfficeIdNotuse(this.getOfficeId());
		role.setName(name);
		PagingList<NgtRoleVO> list = roleService.queryList(role, pageAttr);

		return RestResultUtil.ok(list);

	}
	
	@ApiOperation(value = "角色列表信息", notes = "")
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "userId", value = "用户编号", required = false) })
	public RestResult<List<NgtRoleVO>> curList(String userId) {
		// 查询列表数据
		NgtRole role = new NgtRole();
		role.setCompanyId(this.getCompanyId());
		//role.setOfficeIdNotuse(this.getOfficeId());
		
		List<NgtRoleVO> list = roleService.queryList(role, userId);

		return RestResultUtil.ok(list);

	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "根据ID获取角色详情", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "角色ID", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<NgtRole> info(@PathVariable("id") String id) {
		NgtRole role = roleService.getById(id);

		return RestResultUtil.ok(role);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "保存角色", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> create(@Validated(value = { AddGroup.class }) @RequestBody @ApiParam(value = "参数需要以json传入") NgtRoleDTO roleDTO) {

		NgtRole role = roleDTO.toObject(NgtRole.class);

		role.setSysType(Constants.SYSTYPE_NGTONLINE);
		role.setCompanyId(this.getCompanyId());
		role.setOfficeIdNotuse(this.getOfficeId());
		role.setDelFlag(Constants.SYSTEM_DELETE_FLAG);
		role.setIsSys(Constants.SYSTEM_IS_NOT_SYSTEM);
		role.setDataScope(Constants.SYSTEM_DEFAULT_DATA_SCOPE);
		role.setCreate(this.getUserId());
		return roleService.createRole(role);
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "修改角色", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestResult<String> update(@Validated(value = { UpdateGroup.class }) @RequestBody @ApiParam(value = "参数需要以json传入") NgtRoleDTO roleDTO) {
		NgtRole role = roleDTO.toObject(NgtRole.class);
		role.setUpdate(this.getUserId());
		return roleService.modifyRole(role);
	}

	/**
	 * 删除
	 */
	@ApiOperation(value = "批量删除角色", notes = "")
	@RequestMapping(value = "/delete_batch", method = RequestMethod.DELETE)
	public RestResult<String> delete(@NotEmpty(message = "ID不能为空") @RequestBody @ApiParam(value = "参数需要以json传入") String[] ids) {
		return roleService.deleteBatch(ids);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "给某一角色分配用户", notes = "")
	@RequestMapping(value = "/to_user/create", method = RequestMethod.POST)
	public RestResult<String> saveRoleUser(@Valid @RequestBody @ApiParam(value = "参数需要以json传入") NgtRoleUserDTO roleDTO) {
		if (null == roleDTO) {
			throw new APIException(ResponseStatus.MISS_REQUIRED_PARAMETE);
		}

		return roleService.saveRoleUser(roleDTO.getRoleId(), roleDTO.getUserIds());
	}
	
	@ApiOperation(value = "给某用户分配角色", notes = "")
	@RequestMapping(value = "/user_to_role/create", method = RequestMethod.POST)
	public RestResult<String> saveUserRole(@Valid @RequestBody @ApiParam(value = "参数需要以json传入") NgtUserRoleDTO roleDTO) {
		if (null == roleDTO) {
			throw new APIException(ResponseStatus.MISS_REQUIRED_PARAMETE);
		}
		return roleService.saveUserRole(roleDTO.getUserId(), roleDTO.getRoleIds());
	}

}
