package com.huaxing.dto;

import com.huaxing.bean.NgtUser;
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
@ApiModel(value = "用户查询信息")
public class NgtQueryUserDTO extends TransferObject<NgtUser> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "登录名", required = false)
	private String loginName;
	@ApiModelProperty(value = "用户名称", required = false)
	private String name;
	@ApiModelProperty(value = "组织ID", required = false)
	private String officeId;

}
