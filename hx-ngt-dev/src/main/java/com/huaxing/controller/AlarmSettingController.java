package com.huaxing.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.AlarmSetting;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.AlarmSettingQueryDTO;
import com.huaxing.dto.AlarmSettingSaveBatchDTO;
import com.huaxing.dto.AlarmSettingSaveDTO;
import com.huaxing.modules.annotation.NGTJSON;
import com.huaxing.modules.annotation.NGTJSONS;
import com.huaxing.service.AlarmSettingService;
import com.huaxing.vo.AlarmSettingVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 告警条件设置表; InnoDB free: 12288 kB; InnoDB free: 9216 kB
 * 
 * @author zhao wei
 * @date 2018-07-14 10:16:16
 */
@Api(tags = { "能管在线：告警条件设置接口" })
@RestController
@RequestMapping("/api/alarmsetting")
@Validated
public class AlarmSettingController extends BaseController<AlarmSetting, Serializable> {
	@Autowired
	private AlarmSettingService alarmSettingService;

	/**
	 * 告警设置列表
	 */
	@ApiOperation(value = "告警设置列表", notes = "")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<PagingList<AlarmSettingVO>> list(AlarmSettingQueryDTO alarmSettingDTO, PagingAttribute pageAttr) {
		AlarmSetting alarmSetting = alarmSettingDTO.toObject(AlarmSetting.class);
		alarmSetting.setCompanyId(getCompanyId());
		PagingList<AlarmSettingVO> alarmSettingList = alarmSettingService.queryList(alarmSetting, pageAttr);
		return RestResultUtil.ok(alarmSettingList);
	}

	/**
	 * 告警设置详情
	 */
	@ApiOperation(value = "告警设置详情", notes = "")
	@ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "告警设置id", required = true)
	@NGTJSONS({ @NGTJSON(type = AlarmSettingVO.class, include = "id,equipmentName,paramName,alarmTypeName,settingValue,alarmGrade,alarmRing") })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<AlarmSettingVO> info(@PathVariable("id") String id) {
		String companyId = getCompanyId();
		AlarmSettingVO alarmSetting = alarmSettingService.getAlarmSettingInfoById(id, companyId);
		return RestResultUtil.ok(alarmSetting);
	}

	/**
	 * 设备参数名称
	 */
	@ApiOperation(value = "设备参数名称", notes = "")
	@ApiImplicitParam(paramType = "query", dataType = "string", name = "equipmentId", value = "设备Id", required = true)
	@NGTJSONS({ @NGTJSON(type = AlarmSettingVO.class, include = "paramName,measuretag,dataType") })
	@RequestMapping(value = "/equParamName", method = RequestMethod.GET)
	public RestResult<List<AlarmSettingVO>> equParamName(@NotBlank String equipment) {
		AlarmSetting alarmSetting = new AlarmSetting();
		alarmSetting.setCompanyId(getCompanyId());
		alarmSetting.setEquipment(equipment);
		List<AlarmSettingVO> alarmSettingVOList = alarmSettingService.getEquParamName(alarmSetting);
		return RestResultUtil.ok(alarmSettingVOList);
	}

	/**
	 * 保存告警设置
	 */
	@ApiOperation(value = "批量保存告警设置", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> create(
			@Validated(value = { AddGroup.class }) @RequestBody @ApiParam(value = "参数需要以json传入") AlarmSettingSaveBatchDTO alarmSettingSaveBatchDTO) {
		String companyId = getCompanyId();
		String userId = getUserId();
		return alarmSettingService.saveBatchAlarmSetting(alarmSettingSaveBatchDTO, companyId, userId);
	}

	/**
	 * 修改告警设置
	 */
	@ApiOperation(value = "修改告警设置", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestResult<String> update(@Validated(value = { UpdateGroup.class }) @RequestBody AlarmSettingSaveDTO alarmSettingSaveDTO) {
		AlarmSetting alarmSetting = alarmSettingSaveDTO.toObject(AlarmSetting.class);
		alarmSetting.setUpdate(getUserId());
		alarmSetting.setCompanyId(getCompanyId());
		return alarmSettingService.updateAlarmSetting(alarmSetting);
	}

	/**
	 * 删除
	 */
	@ApiOperation(value = "删除告警设置", notes = "")
	@ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "告警设置id", required = true)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public RestResult<String> delete(@PathVariable("id") String id) {
		String companyId = getCompanyId();
		return alarmSettingService.delete(id, companyId);
	}

	/**
	 * 批量删除设备
	 */
	@ApiOperation(value = "批量删除告警设置")
	@ApiImplicitParam(paramType = "query", dataType = "string[]", name = "ids", value = "告警设置id的数组", required = true)
	@RequestMapping(value = "/delete_batch", method = RequestMethod.DELETE)
	public RestResult<String> deleteBatch(@RequestBody String[] ids) {
		String companyId = getCompanyId();
		return alarmSettingService.deleteBatch(ids, companyId);
	}

}
