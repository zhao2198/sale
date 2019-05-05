package com.huaxing.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.huaxing.bean.NgtRole;
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
@ApiModel(value = "用户与角色分配关系")
public class NgtUserRoleDTO extends TransferObject<NgtRole> {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "用户ID不能为空")
	@ApiModelProperty(value = "用户ID", required = true)
	private String userId;
	@Size(min = 1, message = "角色不能为空")
	@ApiModelProperty(value = "分配角色集合", required = true)
	private List<String> roleIds;

}
