package com.huaxing.dto;

import com.huaxing.bean.Team;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Create Date: 2018年6月22日 下午1:47:48
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@Data
@ApiModel(value = "班组信息_查询")
public class TeamQueryDto extends TransferObject<Team> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "班组编号 code", required = false)
	private String code; // 班组编号
	@ApiModelProperty(value = "班组名称 name", required = false)
	private String name; // 班组名称
}
