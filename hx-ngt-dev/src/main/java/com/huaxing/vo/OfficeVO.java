package com.huaxing.vo;

import com.huaxing.bean.Office;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 区域表; InnoDB free: 5120 kB
 * 
 * @author li xiao long
 * @date 2018-05-11 09:18:52
 */
@Data
public class OfficeVO extends TransferObject<Office> {

	@ApiModelProperty(value = "组织ID", required = false)
	private String id;

	// 父级编号
	@ApiModelProperty(value = "上级菜单ID", required = true)
	private String parentId;

	// 名称
	@ApiModelProperty(value = "组织名称", required = true)
	private String name;
	// 区域编码
	@ApiModelProperty(value = "编码", required = false)
	private String code;
	// 备注信息
	@ApiModelProperty(value = "备注", required = false)
	private String remarks;

}
