package com.huaxing.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.MaintenanceScheme;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.MaintanceSchemeQueryDTO;
import com.huaxing.dto.MaintenanceSchemeDTO;
import com.huaxing.modules.annotation.NGTJSON;
import com.huaxing.modules.annotation.NGTJSONS;
import com.huaxing.service.MaintenanceSchemeService;
import com.huaxing.vo.MaintenanceSchemeVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
@Api(tags = { "能管在线：定保计划接口" })
@RestController
@RequestMapping("/api/maintenance/scheme")
@Validated
public class MaintenanceSchemeController extends BaseController<MaintenanceScheme, Serializable> {
	@Autowired
	private MaintenanceSchemeService maintenanceSchemeService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "定保计划列表", notes = "")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@NGTJSONS({ @NGTJSON(type = MaintenanceSchemeVO.class, filter = "contents") })
	public RestResult<PagingList<MaintenanceSchemeVO>> list(@Validated MaintanceSchemeQueryDTO periodicMaintanceQueryDTO,
			@ApiIgnore PagingAttribute pageAttr) {
		// 查询列表数据
		MaintenanceScheme periodicMaintenance = periodicMaintanceQueryDTO.toObject(MaintenanceScheme.class);
		periodicMaintenance.setCompanyId(this.getCompanyId());
		PagingList<MaintenanceSchemeVO> pagingList = maintenanceSchemeService.queryList(periodicMaintenance, pageAttr);
		// int total = periodicMaintenanceService.queryTotal(params);

		return RestResultUtil.ok(pagingList);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "定保计划详情", notes = "")
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<MaintenanceSchemeVO> info(@PathVariable("id") String id) {
		MaintenanceSchemeVO periodicMaintenanceVO = maintenanceSchemeService.getSchemeVo(id);

		return RestResultUtil.ok(periodicMaintenanceVO);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "创建定保计划", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> create(@Validated(value = { AddGroup.class }) @RequestBody MaintenanceSchemeDTO periodicMaintenanceDTO) {
		MaintenanceScheme maintenance = periodicMaintenanceDTO.toObject(MaintenanceScheme.class);
		maintenance.setCreate(this.getUserId());
		maintenance.setCompanyId(this.getCompanyId());
		return maintenanceSchemeService.createPeriodic(maintenance);
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "修改定保计划", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestResult<String> update(@Validated(value = { AddGroup.class }) @RequestBody MaintenanceSchemeDTO periodicMaintenanceDTO) {

		MaintenanceScheme maintenance = periodicMaintenanceDTO.toObject(MaintenanceScheme.class);
		maintenance.setUpdate(this.getUserId());
		return maintenanceSchemeService.modifyPeriodic(maintenance);

	}

	@ApiOperation(value = "删除某一巡检计划", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public RestResult<String> delete(@PathVariable(value = "id") String id) {
		return maintenanceSchemeService.removeScheme(id);
	}

	@ApiOperation(value = "暂停某一巡检计划", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/pause/{id}", method = RequestMethod.POST)
	public RestResult<String> pause(@PathVariable(value = "id") String id) {
		return maintenanceSchemeService.pauseScheme(id);
	}

	@ApiOperation(value = "恢复某一巡检计划", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/resume/{id}", method = RequestMethod.POST)
	public RestResult<String> resume(@PathVariable(value = "id") String id) {
		return maintenanceSchemeService.resumeScheme(id);
	}

}
