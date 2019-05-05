package com.huaxing.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.Office;
import com.huaxing.bean.TreeNode;
import com.huaxing.common.entity.UserEntity;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.OfficeDTO;
import com.huaxing.modules.annotation.CurrentUser;
import com.huaxing.service.OfficeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 组织管理 Create Date: 2018年6月25日 下午2:37:09
 * 
 * @version: V3.0.1
 * @author: zhao wei
 */
@Api(tags = { "能管在线：组织接口" })
@RestController
@RequestMapping("/api/office")
@Slf4j
public class OfficeController extends BaseController<Office, Serializable> {
	@Autowired
	private OfficeService officeService;

	/**
	 * 组织列表
	 */
	@ApiOperation(value = "组织列表信息", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "name", value = "组织名称", required = false) })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<List<Office>> list(String name) {
		// 查询列表数据

		Office office = new Office();
		office.setName(name);
		office.setId(this.getOfficeId());
		List<Office> officeList = officeService.queryList(office);

		return RestResultUtil.ok(officeList);
	}

	/**
	 * 获取当前用户组织树
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	@ApiOperation(value = "获取当前用户组织树", notes = "")
	public List<TreeNode> tree() {
		Office office = new Office();
		office.setId(this.getCompanyId());
		List<TreeNode> list = officeService.getOfficeTree(office);
		return list;
	}

	/**
	 * 组织详情
	 */
	@ApiOperation(value = "根据ID获取组织详情", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "id", value = "组织ID", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<Office> info(@PathVariable("id") String id) {
		Office office = officeService.getById(id);

		return RestResultUtil.ok(office);
	}

	/**
	 * 保存公司
	 */
	@ApiOperation(value = "添加组织", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> create(@Validated(value = { AddGroup.class }) @RequestBody @ApiParam(value = "参数需要以json传入") OfficeDTO offictDTO) {
		try {
			Office office = offictDTO.toObject(Office.class);
			office.setCreate(this.getUserId());
			office.setType("2");
			return officeService.createOffice(office);
		} catch (Exception e) {
			log.error("save office error", e);
			return RestResultUtil.failed();
		}

	}

	/**
	 * 修改组织
	 */
	@ApiOperation(value = "修改组织", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestResult<String> update(@Validated(value = { UpdateGroup.class }) @RequestBody @ApiParam(value = "参数需要以json传入") OfficeDTO offictDTO,
			@ApiIgnore @CurrentUser UserEntity user) {
		try {
			Office office = offictDTO.toObject(Office.class);
			office.setUpdate(user.getId());
			return officeService.updateOffice(office);
		} catch (Exception e) {
			log.error("update office error", e);
			return RestResultUtil.failed();
		}

	}

	/**
	 * 删除组织
	 */
	@ApiOperation(value = "批量删除组织", notes = "")
	@RequestMapping(value = "/delete_batch", method = RequestMethod.DELETE)
	public RestResult<String> delete(@RequestBody @ApiParam(value = "参数需要以json传入") String[] ids) {
		return officeService.deleteOffice(ids);
	}

}
