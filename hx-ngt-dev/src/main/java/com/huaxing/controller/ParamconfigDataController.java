package com.huaxing.controller;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.ParamconfigData;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.service.ParamconfigDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 配置采集器传回参数; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@RestController
@RequestMapping("/api/paramconfig")
@Api(tags = { "能管在线：下发参数配置接口" })
public class ParamconfigDataController extends BaseController<ParamconfigData, Serializable> {
	@Autowired
	private ParamconfigDataService paramconfigDataService;

	/**
	 * 下发网关配置
	 * 
	 * @return
	 */
	@ApiOperation(value = "下发网关配置")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "网关编号", required = true) })
	@RequestMapping(value = "/down", method = RequestMethod.POST)
	public RestResult<String> downGateWayConfig(@RequestBody @NotBlank String projectCode) {
		String companyId = getCompanyId();
		String userId = getUserId();
		return paramconfigDataService.downGateWayConfig(companyId, projectCode, userId);

	}

}
