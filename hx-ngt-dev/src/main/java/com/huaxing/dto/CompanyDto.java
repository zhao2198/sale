package com.huaxing.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.huaxing.bean.Company;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公司 Create Date: 2018年6月22日 上午9:52:33
 * 
 * @version: V3.0.1
 * @author: zhao wei
 */
@Data
@ApiModel(value = "公司信息添加")
public class CompanyDto extends TransferObject<Company> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "公司ID", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;

	@NotBlank(message = "公司名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Size(min = 2, max = 50, groups = { AddGroup.class, UpdateGroup.class }, message = "公司名称长度在2-50之间")
	@ApiModelProperty(value = "公司名称", required = true)
	private String name;

	@NotBlank(message = "公司类型不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@ApiModelProperty(value = "公司类型，从字典表获取", required = true)
	private String type;

}
