package com.huaxing.controller;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.MeterreadingScheme;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.utils.StringUtils;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.MeterreadingSchemeCreateDTO;
import com.huaxing.dto.MeterreadingSchemeDeleteDTO;
import com.huaxing.dto.MeterreadingSchemeUpdateDTO;
import com.huaxing.service.MeterreadingSchemeService;
import com.huaxing.vo.MeterreadingSchemeEquipmentTimeDetailListVO;
import com.huaxing.vo.MeterreadingSchemeEquipmentTimeListVO;
import com.huaxing.vo.MeterreadingSchemeMeterListVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 保存当前的抄表计划; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@RestController
@Api(tags = "能管在线：抄表计划")
@RequestMapping("/api/meterreading/scheme")
@Slf4j
public class MeterreadingSchemeController extends BaseController<MeterreadingScheme, Serializable> {
	@Autowired
	private MeterreadingSchemeService schemeService;

	/**
	 * 保存
	 */
	@ApiOperation(value = "创建", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<MeterreadingScheme> create(@Valid @RequestBody MeterreadingSchemeCreateDTO meterreadingScheme) {
		meterreadingScheme.setCreateBy(getUserId());
		schemeService.save(meterreadingScheme);
		return RestResultUtil.ok();
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "修改", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public RestResult<MeterreadingScheme> update(@Valid @RequestBody MeterreadingSchemeUpdateDTO updateDTO) {
		schemeService.update(updateDTO, this.getUserId());
		return RestResultUtil.ok();
	}

	/**
	 * 列表
	 */
	@ApiOperation(value = "以表计为单位，显示抄表计划列表", notes = "进入抄表计划页面后，默认显示设定了抄表的表计列表，并显示表计当天是否有抄表任务")
	@RequestMapping(value = "/list/meter_view", method = RequestMethod.GET)
	public RestResult<PagingList<MeterreadingSchemeMeterListVO>> getMeterViewVoList(PagingAttribute pagAttr) {
		PagingList<MeterreadingSchemeMeterListVO> voList = schemeService.getMeterListHasScheme(getCompanyId(), pagAttr);
		return RestResultUtil.ok(voList);
	}

	@ApiOperation(value = "显示指定表计的以时间点为单位的列表", notes = "在抄表计划页面，点击一个表计，显示以时间为单位的列表")
	@RequestMapping(value = "/list/meter/time_view", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", value = "表计ID", name = "meterId", required = true), })
	public RestResult<PagingList<MeterreadingSchemeEquipmentTimeListVO>> getEquipmentDateViewVoList(@NotBlank(message = "表计ID不能为空") String meterId,
			PagingAttribute pagAttr) {
		PagingList<MeterreadingSchemeEquipmentTimeListVO> voList = schemeService.getEquipmentDateViewVoList(meterId, pagAttr);
		return RestResultUtil.ok(voList);
	}

	@ApiOperation(value = "显示指定表计，指定时间点的所有计划列表", notes = "在抄表计划页面，点击表计、点击时间后，显示该时间点下的所有计划列表")
	@RequestMapping(value = "/list/meter/time/detail_view", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", value = "表计ID", name = "meterId", required = true),
			@ApiImplicitParam(paramType = "query", value = "时间点【格式0100;0130】", name = "time", required = true), })
	public RestResult<PagingList<MeterreadingSchemeEquipmentTimeDetailListVO>> getEquipmentDateDetailViewVoList(
			@NotBlank(message = "表计ID不能为空") String meterId,
			@Pattern(regexp = "^([0-1]\\d|2[0-3])(00|30)$", message = "time:时间点格式错误，支持【1200,1230】，分钟仅支持00和30") String time, PagingAttribute pagAttr) {
		PagingList<MeterreadingSchemeEquipmentTimeDetailListVO> voList = schemeService.getEquipmentDateDetailViewVoList(meterId, time, pagAttr);
		return RestResultUtil.ok(voList);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "详情", notes = "")
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<MeterreadingSchemeEquipmentTimeDetailListVO> info(@PathVariable("id") String id) {
		MeterreadingSchemeEquipmentTimeDetailListVO meterreadingScheme = schemeService.getById(id);
		return RestResultUtil.ok(meterreadingScheme);
	}

	/**
	 * 删除
	 */
	@ApiOperation(value = "删除计划，根据需要传入相关参数", notes = "1，传入id，则可以根据id删除计划；2传入meterId，则可以删除一个表计所有的计划；3,传入meterId和time，则可以删除表计指定时间的所有计划")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public RestResult<String> delete(@RequestBody MeterreadingSchemeDeleteDTO deleteParam) {
		String id = deleteParam.getId();
		String meterId = deleteParam.getMeterId();
		String time = deleteParam.getTime();
		if (StringUtils.allIsEmpty(id, meterId)) {
			return RestResultUtil.failed("id和meterId至少需要传入一个");
		}
		if (StringUtils.isNotBlank(id)) {
			return schemeService.deleteById(id);
		} else if (StringUtils.isNotBlank(meterId) && StringUtils.isNotBlank(time)) {
			return schemeService.deleteByMeterIdAndTime(meterId, time);
		} else {
			return schemeService.deleteByMeterId(meterId);
		}
	}

	/**
	 * 批量删除
	 */
	@ApiOperation(value = "删除计划，根据需要传入相关参数", notes = "1，传入id，则可以根据id删除计划；2传入meterId，则可以删除一个表计所有的计划；3,传入meterId和time，则可以删除表计指定时间的所有计划")
	@RequestMapping(value = "/delete_batch", method = RequestMethod.DELETE)
	public RestResult<String> deleteBatch(@RequestBody MeterreadingSchemeDeleteDTO[] deleteParamS) {
		RestResult<String> res = new RestResult<String>();
		for (MeterreadingSchemeDeleteDTO deleteParam : deleteParamS) {
			String id = deleteParam.getId();
			String meterId = deleteParam.getMeterId();
			String time = deleteParam.getTime();
			if (StringUtils.allIsEmpty(id, meterId)) {
				res = RestResultUtil.failed("id和meterId至少需要传入一个");
			}
			if (StringUtils.isNotBlank(id)) {
				res = schemeService.deleteById(id);
			} else if (StringUtils.isNotBlank(meterId) && StringUtils.isNotBlank(time)) {
				res = schemeService.deleteByMeterIdAndTime(meterId, time);
			} else {
				res = schemeService.deleteByMeterId(meterId);
			}
		}
		return res;
	}

}
