package com.huaxing.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.RepairRecord;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.RepairRecordDTO;
import com.huaxing.modules.util.FileCopyUtil;
import com.huaxing.service.RepairRecordService;
import com.huaxing.vo.RepairRecordVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-05 09:23:20
 */
@Api(tags = { "能管在线：修复单记录" })
@RestController
@RequestMapping("/api/repairrecord")
@Validated
public class RepairRecordController extends BaseController<RepairRecord, Serializable> {
	@Autowired
	private RepairRecordService repairRecordService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "根据修复单ID获取修复记录", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "repairId", value = "修复单ID ", required = true) })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<List<RepairRecordVO>> list(@NotEmpty(message = "修复ID不能为空") @RequestParam("repairId") String repairFormId) {

		RepairRecord record = new RepairRecord();
		record.setRepairFormId(repairFormId);
		List<RepairRecordVO> list = repairRecordService.getListByRepairId(record);

		return RestResultUtil.ok(list);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "根据ID获取某一条修复记录", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "修复记录ID ", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<RepairRecordVO> info(@PathVariable("id") String id) {
		RepairRecordVO repairRecordVO = repairRecordService.getDetailById(id);

		return RestResultUtil.ok(repairRecordVO);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "创建修复记录", notes = "")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> create(@Validated(value = { AddGroup.class }) @RequestBody RepairRecordDTO repairRecordDTO) {

		RepairRecord record = repairRecordDTO.toObject(RepairRecord.class);
		record.setCreate(this.getUserId());
		List<String> files = repairRecordDTO.getFiles();
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

			record.setUrl(sb.toString());
		}
		return repairRecordService.createRecord(record);

	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "修改修复记录", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestResult<String> update(@Validated(value = { UpdateGroup.class }) @RequestBody RepairRecordDTO repairRecordDTO) {
		RepairRecord record = repairRecordDTO.toObject(RepairRecord.class);
		record.setUpdate(this.getUserId());
		List<String> files = repairRecordDTO.getFiles();
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

			record.setUrl(sb.toString());
		}
		return repairRecordService.modifyRecord(record);
	}

}
