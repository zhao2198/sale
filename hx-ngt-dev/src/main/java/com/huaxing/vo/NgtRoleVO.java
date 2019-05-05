package com.huaxing.vo;

import com.huaxing.bean.NgtRole;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
@Data
@ApiModel(value = "角色返回信息")
public class NgtRoleVO extends TransferObject<NgtRole> {
	private static final long serialVersionUID = 1L;

	// 编号
	@ApiModelProperty(value = "编号", required = false)
	private String id;
	// 归属机构
	private String officeIdNotuse;
	// 角色名称
	@ApiModelProperty(value = "角色名称", required = false)
	private String name;
	// 英文名称
	@ApiModelProperty(value = "英文名称", required = false)
	private String enname;

	// 是否系统数据
	@ApiModelProperty(value = "是否系统数据", required = false)
	private String isSys;
	// 是否可用
	@ApiModelProperty(value = "是否可用", required = false)
	private String useable;
	// 创建者
	@ApiModelProperty(value = "创建者", required = false)
	private String createBy;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

	// 组织名称
	private String officeName;
	
	private boolean checked = false;

}
