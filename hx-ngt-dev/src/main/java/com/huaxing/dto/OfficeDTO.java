package com.huaxing.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.huaxing.bean.Office;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 区域表; InnoDB free: 5120 kB
 * 
 * @author li xiao long
 * @date 2018-05-11 09:18:52
 */
@Data
@ApiModel(value = "组织信息")
public class OfficeDTO extends TransferObject<Office> {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "ID不能为空", groups = { UpdateGroup.class })
	@ApiModelProperty(value = "组织ID", required = false)
	private String id;

	// 父级编号
	@NotEmpty(message = "上级菜单不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@ApiModelProperty(value = "上级菜单ID", required = true)
	private String parentId;

	// 名称
	@NotEmpty(message = "组织名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Length(min = 1, message = "组织名称长度为1~50个字符", max = 50, groups = { AddGroup.class, UpdateGroup.class })
	@ApiModelProperty(value = "组织名称", required = true)
	private String name;
	// 区域编码
	@ApiModelProperty(value = "编码", required = false)
	private String code;
	// 备注信息
	@ApiModelProperty(value = "备注", required = false)
	// @Length(min = 1, message = "组织名称长度为1~100个字符", max = 100)
	private String remarks;

}
