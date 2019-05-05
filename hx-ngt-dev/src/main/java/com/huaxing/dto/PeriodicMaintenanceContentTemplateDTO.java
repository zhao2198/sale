package com.huaxing.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.huaxing.bean.PeriodicMaintenanceContentTemplate;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
@Data
@ApiModel(value = "定保计划模板主要用于添加")
public class PeriodicMaintenanceContentTemplateDTO extends TransferObject<PeriodicMaintenanceContentTemplate> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键ID", required = false)
	@NotEmpty(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;

	// 模板名称
	@ApiModelProperty(value = "模板名称", required = false)
	@NotEmpty(message = "模板类型不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(min = 2, max = 50, message = "模板名称最多50个字符", groups = { AddGroup.class, UpdateGroup.class })
	private String templateName;
	// 设备类型id
	@ApiModelProperty(value = "设备类型id", required = false)
	@NotEmpty(message = "设备类型id不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String equipmentCategory;

	// 搜索用的关键词
	@ApiModelProperty(value = "搜索用的关键词", required = false)
	private String keyWord;

	// 模板提供者 系统或者用户自定义
	@ApiModelProperty(value = "模板提供者 系统或者用户自定义", required = false)
	private String type;

	@Valid
	@ApiModelProperty(value = "检查项", required = true)
	@Size(min = 1, message = "检查项至少为一个", groups = { AddGroup.class, UpdateGroup.class })
	List<PeriodicCheckItemDTO> list;

}
