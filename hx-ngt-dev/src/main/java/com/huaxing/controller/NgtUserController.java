package com.huaxing.controller;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.util.StringUtil;
import com.huaxing.bean.NgtUser;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.NgtQueryUserDTO;
import com.huaxing.dto.NgtUserDTO;
import com.huaxing.modules.annotation.NGTJSON;
import com.huaxing.modules.util.FileCopyUtil;
import com.huaxing.service.NgtUserService;
import com.huaxing.vo.NgtUserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户表
 * 
 * @author zhaowei
 * @date 2018-06-27 09:46:45
 */
@Api(tags = { "能管在线：用户接口" })
@RestController
@RequestMapping("/api/user")
@Validated
public class NgtUserController extends BaseController<NgtUser, Serializable> {
	@Autowired
	private NgtUserService userService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "能管在线用户查询", notes = "")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<PagingList<NgtUserVO>> list(NgtQueryUserDTO userDTO, @ApiIgnore PagingAttribute pageAttr) {
		// 查询列表数据

		// List<NgtUser> userList = userService.queryList(params);
		// int total = userService.queryTotal(params);
		NgtUser user = userDTO.toObject(NgtUser.class);
		user.setCompanyId(this.getCompanyId());
		user.setId(this.getUserId());
		PagingList<NgtUserVO> list = userService.queryList(user, pageAttr);

		return RestResultUtil.ok(list);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "根据ID获取用户详情", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "用户ID", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<NgtUserVO> info(@PathVariable("id") String id) {
		NgtUserVO userVO = userService.getNgtUserById(id);

		return RestResultUtil.ok(userVO);
	}

	@ApiOperation(value = "重置用户密码", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "用户ID", required = true) })
	@RequestMapping(value = "/pass/reset/{id}", method = RequestMethod.POST)
	public RestResult<String> reset(@PathVariable("id") String id) {
		return userService.modifyPassword(id);

	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "添加能管在线用户", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> create(@Validated(value = { AddGroup.class }) NgtUserDTO userDTO,
			@RequestParam(value = "file", required = false) MultipartFile file) {

		NgtUser ngtUser = userDTO.toObject(NgtUser.class);
		String officeId = userDTO.getOfficeId();
		if (StringUtil.isNotEmpty(officeId) && officeId.length() >= 6) {
			ngtUser.setCompanyId(officeId.substring(0, 6));
		}

		ngtUser.setCreate(this.getUserId());
		if (null != file) {
			String path = FileCopyUtil.copy(file);
			ngtUser.setPhoto(path);
		}
		return userService.createUser(ngtUser);
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "根据ID修改能管在线用户", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public RestResult<String> update(@Validated(value = { UpdateGroup.class }) NgtUserDTO userDTO,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		NgtUser ngtUser = userDTO.toObject(NgtUser.class);
		ngtUser.setUpdate(this.getUserId());
		if (null != file) {
			String path = FileCopyUtil.copy(file);
			ngtUser.setPhoto(path);
		}
		return userService.modifyUser(ngtUser);
	}

	/**
	 * 批量删除
	 */
	@ApiOperation(value = "批量删除能管在线用户", notes = "")
	@RequestMapping(value = "/delete_batch", method = RequestMethod.DELETE)
	public RestResult<String> delete(@NotEmpty(message = "ID不能为空") @RequestBody @ApiParam(value = "参数需要以json传入") String[] ids) {
		return userService.deleteBatch(ids);
	}

	@ApiOperation(value = "查询某一角色下所有用户", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "角色ID", required = true) })
	@NGTJSON(type = NgtUserVO.class, filter = "photo,loginIp,loginDate,qrcode,address")
	@RequestMapping(value = "/role/{id}/list", method = RequestMethod.GET)
	public RestResult<PagingList<NgtUserVO>> listByRole(@NotBlank(message = "角色ID不能为空") @PathVariable("id") String roleId, NgtQueryUserDTO userDTO,
			@ApiIgnore PagingAttribute pageAttr) {
		// 查询列表数据

		// List<NgtUser> userList = userService.queryList(params);
		// int total = userService.queryTotal(params);
		NgtUser user = userDTO.toObject(NgtUser.class);
		user.setCompanyId(this.getCompanyId());
		PagingList<NgtUserVO> list = userService.queryListByRoleId(user, roleId, pageAttr);

		return RestResultUtil.ok(list);
	}

}
