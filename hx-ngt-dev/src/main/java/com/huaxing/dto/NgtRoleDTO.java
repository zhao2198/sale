package com.huaxing.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.huaxing.bean.NgtRole;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色表
 * 
 * @author zhao wei
 * @date 2018-06-28 09:12:45
 */
@Data
@ApiModel(value = "角色表")
public class NgtRoleDTO extends TransferObject<NgtRole> {
	private static final long serialVersionUID = 1L;

	// 编号
	@ApiModelProperty(value = "编号", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;
	// 角色名称
	@ApiModelProperty(value = "角色名称", required = false)
	@NotBlank(message = "角色名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Length(max = 30, message = "角色名称长度最大支持30", groups = { AddGroup.class, UpdateGroup.class })
	private String name;
	// 英文名称
	@ApiModelProperty(value = "英文名称", required = false)
	@Pattern(regexp = "^[a-zA-Z]+$", message = "英文名称只允许字母", groups = { AddGroup.class, UpdateGroup.class })
	@Length(max = 30, message = "英文名称长度最大支持30")
	@NotBlank(message = "英文名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String enname;
	// 是否可用
	@ApiModelProperty(value = "是否可用", required = false)
	@NotBlank(message = "可用状态不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String useable;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	@Length(max = 200, message = "备注长度最大支持200", groups = { AddGroup.class, UpdateGroup.class })
	private String remarks;

}
