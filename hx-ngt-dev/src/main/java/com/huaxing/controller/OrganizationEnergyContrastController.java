package com.huaxing.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.OrganizationEnergyContrast;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.DateUtils;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.OrganizationEnergyContrastDTO;
import com.huaxing.service.OrganizationEnergyContrastService;
import com.huaxing.util.NgtDefine;
import com.huaxing.vo.InitQueryDateVO;
import com.huaxing.vo.OrganizationEnergyContrastVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Create Date: 2018年7月25日 上午9:38:00
 * 
 * @version: V3.0.1
 * @author: feng yi
 */
@Api(tags = { "能管在线：机构对比接口" })
@RestController
@RequestMapping("/api/orgenergy_contrast")
@Validated
public class OrganizationEnergyContrastController extends BaseController<OrganizationEnergyContrast, Serializable> {

	@Autowired
	public OrganizationEnergyContrastService organizationEnergyContrastService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "机构对比")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<PagingList<OrganizationEnergyContrastVO>> orgContrast(OrganizationEnergyContrastDTO orgDTO, @RequestParam("equipmentTypeId[]")String[] equipmentTypeId,PagingAttribute pageAttr) {
		Date date = DateUtils.getEndTime(orgDTO.getEndDate(), orgDTO.getTypeDate());
		String companyId = getCompanyId();
		OrganizationEnergyContrast energyConsumptionAnalysis = orgDTO.toObject(OrganizationEnergyContrast.class);
		String equipmentTypeName = NgtDefine.getEquipmentTypeNameMap().get(orgDTO.getType());
		energyConsumptionAnalysis.setEquipmentTypeAttribute(equipmentTypeName);
		energyConsumptionAnalysis.setCompanyId(companyId);
		energyConsumptionAnalysis.setEndDate(date);
		energyConsumptionAnalysis.setEquipmentTypeId(equipmentTypeId);
		PagingList<OrganizationEnergyContrastVO> organizationEnergyList = organizationEnergyContrastService.queryList(energyConsumptionAnalysis,
				pageAttr);
		return RestResultUtil.ok(organizationEnergyList);
	}
	/**
	 * 解决初始化时间的问题
	 * @return
	 */
	@ApiOperation(value = "获取机构对比的初始化时间")
	@RequestMapping(value = "/init_date", method = RequestMethod.GET)
	public RestResult<InitQueryDateVO> getInitDate(){
	   	String startDate = DateUtils.dateToString((DateUtils.getNowMonthFirstDay(new Date())));
		String endDate = DateUtils.dateToString(new Date());
		InitQueryDateVO vo = new InitQueryDateVO();
		vo.setInitQueryDateStart(startDate);
		vo.setInitQueryDateEnd(endDate);
		return RestResultUtil.ok(vo);
	}

}
