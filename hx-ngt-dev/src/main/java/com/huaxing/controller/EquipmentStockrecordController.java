package com.huaxing.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.EquipmentStockRecord;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.EquipmentStockRecordQueryDTO;
import com.huaxing.service.EquipmentStockrecordService;
import com.huaxing.vo.EquipmentStockrecordVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 出入库记录; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-09 09:10:19
 */
@Api(tags = { "能管在线：库存记录接口" })
@RestController
@RequestMapping("/api/equipmentstockrecord")
public class EquipmentStockrecordController extends BaseController<EquipmentStockRecord, Serializable> {
	@Autowired
	private EquipmentStockrecordService equipmentStockrecordService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "列表", notes = "")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "currentPage", value = "当前页码", required = false),
			@ApiImplicitParam(paramType = "query", dataType = "string", name = "pageSize", value = "页面容量", required = false), })

	public RestResult<PagingList<EquipmentStockrecordVO>> list(EquipmentStockRecordQueryDTO equipmentStockRecordQueryDTO,
			@ApiIgnore PagingAttribute pageAttr) {
		EquipmentStockRecord equipmentStockRecord = equipmentStockRecordQueryDTO.toObject(EquipmentStockRecord.class);
		equipmentStockRecord.setCompanyId(getCompanyId());
		PagingList<EquipmentStockrecordVO> equipmentStockRecordList = equipmentStockrecordService.queryList(equipmentStockRecord, pageAttr);
		return RestResultUtil.ok(equipmentStockRecordList);
	}

	/**
	 * 批量删除
	 */
	@ApiOperation(value = "批量删除", notes = "")
	@RequestMapping(value = "/delete_batch", method = RequestMethod.DELETE)
	public RestResult<String> delete(@RequestBody String[] ids) {

		return equipmentStockrecordService.deleteBatch(ids);
	}

}
