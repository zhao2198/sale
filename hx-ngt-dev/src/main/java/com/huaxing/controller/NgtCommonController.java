package com.huaxing.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.service.DictService;
import com.huaxing.vo.DictItemVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 文件上传接口 Create Date: 2018年7月4日 上午10:46:12
 * 
 * @version: V3.0.1
 * @author: zhao wei
 */
@Api(tags = { "能管在线：公共部分接口" })
@RestController
@RequestMapping("/api/common")
@Validated
public class NgtCommonController {

	@Autowired
	private DictService dictService;

	@ApiOperation(value = "根据类型获取字典下所有子项", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "types", value = "字典类型(可以传入多个types)", required = true) })
	@RequestMapping(value = "/dictitem", method = RequestMethod.GET)
	public RestResult<List<DictItemVO>> upload(@NotEmpty(message = "类型不能为空") String[] types) {
		List<DictItemVO> itemList = dictService.getDictItemByTypes(types);
		return RestResultUtil.ok(itemList);
	}

}
