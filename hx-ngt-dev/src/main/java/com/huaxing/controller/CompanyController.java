package com.huaxing.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.Company;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.CompanyDto;
import com.huaxing.modules.annotation.NGTJSON;
import com.huaxing.modules.annotation.NGTJSONS;
import com.huaxing.service.CompanyService;
import com.huaxing.vo.CompanyVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * 客户公司列表
 * 
 * @author zhao wei
 * @date 2018-06-22 09:24:15
 */
@Api(tags = { "能管在线：公司接口" })
@RestController
@RequestMapping("/api/company")
@Slf4j
public class CompanyController extends BaseController<Company, Serializable> {
	@Autowired
	private CompanyService companyService;

	/**
	 * 公司列表
	 */
	@ApiOperation(value = "公司列表信息", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "name", value = "公司名称", required = false) })

	@NGTJSONS({ @NGTJSON(type = Company.class, include = "name,type") })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<PagingList<CompanyVO>> list(String name, PagingAttribute pageAttr) {
		// 查询列表数据

		Company company = new Company();
		company.setName(name);
		company.setId(this.getCompanyId());
		PagingList<CompanyVO> companyList = companyService.queryList(company, pageAttr);

		return RestResultUtil.ok(companyList);
	}

	/**
	 * 公司详情
	 */
	@ApiOperation(value = "根据ID获取公司详情", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "公司ID", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<Company> info(@PathVariable("id") String id) {
		Company ngtCompany = companyService.getById(id);

		return RestResultUtil.ok(ngtCompany);
	}

	/**
	 * 保存公司
	 */
	@ApiOperation(value = "添加公司", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> save(@Validated(value = { AddGroup.class }) @RequestBody @ApiParam(value = "参数需要以json传入") CompanyDto companyDTO) {
		Company company = companyDTO.toObject(Company.class);
		company.setCreate(this.getUserId());
		return companyService.saveCompany(company);
	}

	/**
	 * 修改公司
	 */
	@ApiOperation(value = "修改公司", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestResult<String> update(@Validated(value = { UpdateGroup.class }) @RequestBody @ApiParam(value = "参数需要以json传入") CompanyDto companyDTO) {

		Company company = companyDTO.toObject(Company.class);
		company.setUpdate(this.getUserId());
		return companyService.updateCompany(company);

	}

	/**
	 * 删除公司
	 */
	@ApiOperation(value = "批量删除公司", notes = "")
	@RequestMapping(value = "/delete_batch", method = RequestMethod.DELETE)
	public RestResult<String> delete(@RequestBody @ApiParam(value = "参数需要以json传入") String[] ids) {

		return companyService.deleteBatch(ids);

	}

}
