package com.huaxing.controller;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.PatrolScheme;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.Constants;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.utils.StringUtils;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.common.web.util.CookieUtils;
import com.huaxing.common.web.util.HttpClientHelper;
import com.huaxing.common.web.util.HttpClientHelper.HttpRespEntity;
import com.huaxing.dto.PatrolSchemeDTO;
import com.huaxing.dto.PatrolSchemeQueryDTO;
import com.huaxing.modules.annotation.IgnoreAuth;
import com.huaxing.service.PatrolSchemeService;
import com.huaxing.vo.PatrolSchemeVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@Api(tags = { "能管在线：巡检计划接口" })
@RestController
@RequestMapping("/api/patrol_scheme")
@Validated
public class PatrolSchemeController extends BaseController<PatrolScheme, Serializable> {
	@Autowired
	private PatrolSchemeService patrolSchemeService;

	@IgnoreAuth
	@RequestMapping(value = "/test_login", method = RequestMethod.GET)
	@ApiOperation(value = "①测试期间登陆系统,/api/patrol_scheme", tags = { "①登陆系统" })
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "username", value = "username", required = false),
			@ApiImplicitParam(paramType = "query", dataType = "string", name = "password", value = "password", required = false), })
	public RestResult login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
		String ip = getIpAddr(request);
		String port = String.valueOf(request.getServerPort());
		if (StringUtils.isBlank(username))
			username = "admin";
		if (StringUtils.isBlank(password))
			password = "admin";
		HttpClientHelper httpClientHelper = HttpClientHelper.getInstance();
		HttpRespEntity resp = httpClientHelper.get("http://192.168.0.115:9000/sso/user/login?username=" + username + "&password=" + password, null);
		Map<String, Object> entry = resp.getEntry();
		if (((int) entry.get("code")) == 10000) {
			CookieUtils.setCookie(request, response, Constants.TOKEN_KEY, String.valueOf(entry.get("data")));
			return RestResultUtil.ok(entry.get("data"));
		}
		return RestResultUtil.getResult((int) entry.get("code"), entry.get("data"), (String) entry.get("message"));
	}

	/**
	 * 列表
	 */
	@ApiOperation(value = "巡检计划列表", notes = "")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<PagingList<PatrolSchemeVO>> list(@Validated PatrolSchemeQueryDTO schemeDTO, PagingAttribute pagAttr) {
		PatrolScheme scheme = schemeDTO.toObject(PatrolScheme.class);
		scheme.setCompanyId(this.getCompanyId());
		PagingList<PatrolSchemeVO> patrolSchemeList = patrolSchemeService.queryList(scheme, pagAttr);
		return RestResultUtil.ok(patrolSchemeList);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "按照ID查找巡检计划详情", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<PatrolSchemeVO> info(@PathVariable("id") String id) {
		PatrolSchemeVO patrolSchemeVO = patrolSchemeService.getPatrolSchemeVo(id);
		return RestResultUtil.ok(patrolSchemeVO);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "创建巡检计划", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> save(@Validated(value = { AddGroup.class }) @RequestBody PatrolSchemeDTO patrolSchemeDTO) {
		PatrolScheme scheme = patrolSchemeDTO.toObject(PatrolScheme.class);
		scheme.setCompanyId(this.getCompanyId());
		scheme.setCreate(this.getUserId());
		return patrolSchemeService.createPatrol(scheme);

	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "修改巡检计划", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestResult<String> update(@Validated(value = { UpdateGroup.class }) @RequestBody PatrolSchemeDTO patrolSchemeDTO) {
		PatrolScheme scheme = patrolSchemeDTO.toObject(PatrolScheme.class);
		scheme.setCompanyId(this.getCompanyId());
		scheme.setUpdate(this.getUserId());
		return patrolSchemeService.modifyPatrol(scheme);
	}

	/**
	 * 删除
	 */
	@ApiOperation(value = "删除某一巡检计划", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public RestResult<String> delete(@PathVariable(value = "id") String id) {
		return patrolSchemeService.removePatrol(id);
	}

	@ApiOperation(value = "暂停某一巡检计划", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/pause/{id}", method = RequestMethod.POST)
	public RestResult<String> pause(@PathVariable(value = "id") String id) {
		return patrolSchemeService.pausePatrol(id);
	}

	@ApiOperation(value = "恢复某一巡检计划", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "巡检ID", required = true) })
	@RequestMapping(value = "/resume/{id}", method = RequestMethod.POST)
	public RestResult<String> resume(@PathVariable(value = "id") String id) {
		return patrolSchemeService.resumePatrol(id);
	}

	/*
	 * 批量删除
	 */
	@ApiOperation(value = "批量删除巡检计划", notes = "")
	@RequestMapping(value = "/delete_batch", method = RequestMethod.DELETE)
	public RestResult<String> deleteBatch(@NotEmpty(message = "ID不能为空") @RequestBody @ApiParam(value = "参数需要以json传入") String[] ids) {
		return patrolSchemeService.removeBatchPatrol(ids);
	}

}
