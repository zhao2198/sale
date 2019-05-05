package com.huaxing.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.RepairForm;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.utils.StringUtils;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.RepairFormDTO;
import com.huaxing.dto.RepairFormQueryDTO;
import com.huaxing.modules.annotation.NGTJSON;
import com.huaxing.modules.annotation.NGTJSONS;
import com.huaxing.modules.util.FileCopyUtil;
import com.huaxing.service.RepairFormService;
import com.huaxing.service.RepairRecordService;
import com.huaxing.vo.EquipmentStockrecordVO;
import com.huaxing.vo.RepairFormButtonStatusVO;
import com.huaxing.vo.RepairFormVO;
import com.huaxing.vo.RepairRecordStockVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-04 09:41:30
 */
@Api(tags = { "能管在线：修复单" })
@RestController
@RequestMapping("/api/repairform")
@Validated
public class RepairFormController extends BaseController<RepairForm, Serializable> {
	@Autowired
	private RepairFormService repairFormService;

	@Autowired
	private RepairRecordService recordService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "查询修复单")
	@RequestMapping(value = "{pstate}/list", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "state", value = "发布状态0待发布 1发布 ", required = false) })
	public RestResult<PagingList<RepairFormVO>> list(@PathVariable("pstate") String pstate, @Valid RepairFormQueryDTO queryDTO,
			PagingAttribute pageAttr) {
		RepairForm repairForm = queryDTO.toObject(RepairForm.class);
		repairForm.setCompanyId(this.getCompanyId());
		repairForm.setPublishFlag(pstate);
		PagingList<RepairFormVO> repList = repairFormService.queryList(repairForm, pageAttr);

		return RestResultUtil.ok(repList);

	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "根据ID获取修复单详情", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "修复单ID ", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<RepairFormVO> info(@PathVariable("id") String id) {
		RepairFormVO repairFormVO = repairFormService.getRepairById(id);

		return RestResultUtil.ok(repairFormVO);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "保存修复单,暂存和发布接口合一", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> create(@RequestBody @Validated(value = { AddGroup.class }) RepairFormDTO repairFormDTO) {
		RepairForm repairForm = repairFormDTO.toObject(RepairForm.class);
		repairForm.setCreate(this.getUserId());
		repairForm.setCompanyId(this.getCompanyId());
		repairForm.setState("0");
		repairForm.setIsTurnDown("0");
		repairForm.setHistoryHopeTime(repairFormDTO.getHopeTime());
		List<String> files = repairFormDTO.getFiles();
		if (null != files && files.size() > 0) {
			StringBuffer sb = new StringBuffer();
			for (String file : files) {
				String path = "";
				try {
					path = FileCopyUtil.copy(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return RestResultUtil.failed(e.getMessage());
				}
				sb.append(path);
				sb.append(";");
			}
			sb.deleteCharAt(sb.length() - 1);

			repairForm.setUrl(sb.toString());
		}
		return repairFormService.createRepair(repairForm);
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "修改未发布修复单", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public RestResult<String> update(@RequestBody @Validated(value = { UpdateGroup.class }) RepairFormDTO repairFormDTO) {

		RepairForm repairForm = repairFormDTO.toObject(RepairForm.class);
		repairForm.setUpdate(this.getUserId());
		repairForm.setHistoryHopeTime(repairFormDTO.getHopeTime());
		List<String> files = repairFormDTO.getFiles();
		if (null != files && files.size() > 0) {
			StringBuffer sb = new StringBuffer();
			for (String file : files) {
				if (file.contains("data:")) {
					String path = "";
					try {
						path = FileCopyUtil.copy(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return RestResultUtil.failed(e.getMessage());
					}
					sb.append(path);
				} else {
					sb.append(file);
				}
				sb.append(";");
			}
			sb.deleteCharAt(sb.length() - 1);

			repairForm.setUrl(sb.toString());
		}
		return repairFormService.modifyRepair(repairForm);
	}

	/**
	 * 发布
	 */
	@ApiOperation(value = "发布未发布修复单", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "id", value = "修复单ID ", required = true) })
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public RestResult<String> publish(String id) {

		RepairForm repairForm = new RepairForm();
		repairForm.setId(id);
		repairForm.setPublishFlag("1");
		return repairFormService.modifyPublishFlag(repairForm);
	}

	/**
	 * 通过
	 */
	@ApiOperation(value = "强制修改修复单状态", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "id", value = "修复单ID ", required = true) })
	@RequestMapping(value = "/pass", method = RequestMethod.POST)
	public RestResult<String> pass(String id) {

		RepairForm repairForm = new RepairForm();
		repairForm.setId(id);
		return repairFormService.modifyRepairToPass(repairForm);
	}

	/**
	 * 验收
	 */
	@ApiOperation(value = "验收收复单", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "id", value = "修复单ID ", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "string", name = "state", value = "通过(1)/不通过(0) ", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "string", name = "remark", value = "修复单ID ", required = true) })
	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public RestResult<String> accept(@NotBlank(message = "修复单ID不能为空") String id, String state, String remark) {
		RepairForm repairForm = new RepairForm();
		repairForm.setId(id);
		repairForm.setState(state);
		repairForm.setRemarks(remark);
		return repairFormService.modifyRepairToAccept(repairForm);
	}

	/**
	 * 删除
	 */
	@ApiOperation(value = "删除未发布修复单", notes = "")
	@RequestMapping(value = "/delete_batch", method = RequestMethod.DELETE)
	public RestResult<String> delete(@NotEmpty(message = "ID不能为空") @RequestBody String[] ids) {
		return repairFormService.removeRepair(ids);
	}

	@ApiOperation(value = "获取原始希完工日", notes = "")
	@RequestMapping(value = "/original_hopetime", method = RequestMethod.POST)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "id", value = "修复单ID", required = true) })
	@NGTJSON(type = RepairFormVO.class, include = "historyHopeTime")
	public RestResult<RepairFormVO> getRFOriginalHopeTime(@NotBlank(message = "修复单ID不能为空") String id) {
		RepairFormVO repairFormVO = repairFormService.getRepairById(id);
		return RestResultUtil.ok(repairFormVO);
	}

	@ApiOperation(value = "获取用料记录", notes = "")
	@RequestMapping(value = "/material/list", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "id", value = "修复单ID", required = true), })
	@NGTJSONS({ @NGTJSON(type = EquipmentStockrecordVO.class, filter = "operation"), })
	public RestResult<PagingList<RepairRecordStockVO>> getMaterialRecordList(@NotBlank(message = "修复单ID不能为空") String id, PagingAttribute page) {
		PagingList<RepairRecordStockVO> materialRecordList = repairFormService.getMaterialRecordList(id, page);
		return RestResultUtil.ok(materialRecordList);
	}

	@ApiOperation(value = "获取修复单功能中各个子功能当前是否可用", notes = "")
	@RequestMapping(value = "/module/status", method = RequestMethod.POST)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "id", value = "修复单ID", required = true), })
	public RestResult<RepairFormButtonStatusVO> getModuleStatus(@NotBlank(message = "修复单ID不能为空") String id) {
		RepairForm rForm = repairFormService.getById(id);
		String state = rForm.getState();
		int unSubmitCount = recordService.getUnSubmitCount(id);
		int submitCount = recordService.getSubmitCount(id);
		RepairFormButtonStatusVO vo = new RepairFormButtonStatusVO();
		if (unSubmitCount > 0) {// 如果存在没有提交的修复记录，则允许提交修复记录
			vo.setSubmitRepairRecordStatus(true);
		} else {// 如果不存在未提交的修复记录，则允许新建修复记录
			vo.setCreateRepairRecordStatus(true);
		}
		if (submitCount > 0) {// 如果存在提交的修复记录，则允许验收修复记录
			vo.setCheckStatus(true);
		}
		return RestResultUtil.ok(vo);
	}

	@ApiOperation(value = "接单", notes = "")
	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "修复单ID", required = true), })
	public RestResult<RepairFormButtonStatusVO> orderRepairForm(@NotBlank(message = "修复单ID不能为空") @PathVariable("id") String id) {
		RepairForm rForm = repairFormService.getById(id);
		if (rForm == null)
			return RestResultUtil.failed("修复单不存在");
		String handlerId = rForm.getHandlerId();
		RepairForm updateHandlerParam = new RepairForm();
		updateHandlerParam.setId(id);
		updateHandlerParam.setHandlerId(getUserId());
		updateHandlerParam.setState("1");
		if (StringUtils.isBlank(handlerId) || handlerId.equals(getUserId())) {
			repairFormService.update(updateHandlerParam);
		} else {
			return RestResultUtil.failed("已经存在指定受理人");
		}
		return RestResultUtil.ok();
	}

}
