package com.huaxing.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huaxing.bean.EquipmentType;
import com.huaxing.bean.TreeNode;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.controller.BaseController;
import com.huaxing.dto.EquipmentTypeDTO;
import com.huaxing.service.EquipmentTypeService;
import com.huaxing.util.NgtDefine;
import com.huaxing.vo.EquipmentTypeVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 设备分类
 * 
 * @author hebo
 *
 *         上午9:15:02 2018年7月10日
 */
// @JsonIgnoreProperties(ignoreUnknown = true)
@Api(tags = { "能管在线：设备类型接口" })
@RestController
@RequestMapping("/api/equipment_type")
public class EquipmentTypeController extends BaseController<EquipmentType, Serializable> {

	@Autowired
	private EquipmentTypeService equipmentTypeService;

	/**
	 * 设备分类列表
	 * 
	 * @author hebo
	 *
	 *         下午5:00:05 2018年7月11日
	 */
	@ApiOperation(value = "设备分类列表信息", notes = "")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RestResult<List<EquipmentTypeVO>> list() {
		EquipmentType equipment = new EquipmentType();
		equipment.setCompanyId(this.getCompanyId());
		List<EquipmentTypeVO> queryList = equipmentTypeService.queryList(equipment);
		return RestResultUtil.ok(queryList);
	}

	/**
	 * 初始
	 * 
	 * @author hebo
	 *
	 *         13:38:48 2018 M07 12
	 */
	@ApiOperation(value = "初始设备类型")
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public RestResult<String> initEquipmentType() {
		int id = 10;
		List<EquipmentType> list = new ArrayList<EquipmentType>();
		for (int i = 1; i < 5; i++, id++) {
			EquipmentType equipmentType = new EquipmentType();
			equipmentType.setUUID();
			equipmentType.setTid(id + "");
			equipmentType.setName(NgtDefine.getEquipmentTypeMap().get(i + ""));
			equipmentType.setParentId("0");
			equipmentType.setType(i + "");
			equipmentType.setCreate(this.getUserId());
			equipmentType.setCompanyId(this.getCompanyId());
			list.add(equipmentType);
		}
		return equipmentTypeService.createEquipmentType(list);

	}

	/**
	 * 增加
	 * 
	 * @author hebo
	 *
	 *         下午4:59:54 2018年7月11日
	 */
	@ApiOperation(value = "增加设备子节点")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RestResult<String> createEquipmentType(@Validated(AddGroup.class) @RequestBody EquipmentTypeDTO equipmentTypeDTO) {
		EquipmentType equipmentType = equipmentTypeDTO.toObject(EquipmentType.class);
		equipmentType.setCreate(this.getUserId());
		equipmentType.setCompanyId(this.getCompanyId());
		return equipmentTypeService.createEquipmentType(equipmentType);
	}

	/**
	 * 删除
	 * 
	 * @author hebo 下午2:28:12 2018年7月10日
	 */
	@ApiOperation(value = "删除设备类型")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public RestResult<String> deleteEquipmentType(@PathVariable("id") String id) {
		return equipmentTypeService.delete(id);
	}

	/**
	 * 设备类型详情
	 */
	@ApiOperation(value = "根据ID设备类型详情", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "string", name = "id", value = "设备类型ID", required = true) })
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public RestResult<EquipmentTypeVO> info(@PathVariable("id") String id) {
		EquipmentTypeVO equipmentTypeVO = equipmentTypeService.getById(id);

		return RestResultUtil.ok(equipmentTypeVO);
	}

	/**
	 * 修改
	 * 
	 * @author hebo
	 *
	 *         下午4:59:42 2018年7月11日
	 */
	@ApiOperation(value = "修改设备类型", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestResult<String> update(@Validated(value = { UpdateGroup.class }) @RequestBody EquipmentTypeDTO equipmentTypeDTO) {
		EquipmentType equipmentType = equipmentTypeDTO.toObject(EquipmentType.class);
		equipmentType.setUpdate(this.getUserId());
		equipmentType.setCompanyId(this.getCompanyId());
		return equipmentTypeService.updateequipmentType(equipmentType);

	}

	/**
	 * @author fengyi
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	@ApiOperation(value = "获取当前用户设备及组织树", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "string", name = "type", value = "设备类型type(1,2,3,4)", required = false) })
	public List<TreeNode> tree(String type) {
		EquipmentType equipmentType = new EquipmentType();
		equipmentType.setCompanyId(this.getCompanyId());
		equipmentType.setType(type);
		List<TreeNode> list = equipmentTypeService.getTreeList(equipmentType);
		return list;
	}
}
