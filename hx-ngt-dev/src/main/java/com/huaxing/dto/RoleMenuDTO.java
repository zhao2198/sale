package com.huaxing.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.huaxing.bean.Office;
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
@ApiModel(value = "角色权限信息")
public class RoleMenuDTO extends TransferObject<Office> {

	private static final long serialVersionUID = 1L;
	@NotBlank(message = "角色ID不能为空")
	@ApiModelProperty(value = "角色ID", required = true)
	private String roleId;
	@Size(min = 1, message = "菜单权限不能为空")
	@ApiModelProperty(value = "菜单权限ID集合", required = true)
	private List<String> menuIds;

}
