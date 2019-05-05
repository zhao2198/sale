package com.huaxing.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huaxing.bean.Team;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
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
@ApiModel(value = "班组信息")
public class TeamDto extends TransferObject<Team> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "班组ID", required = false)
	@NotBlank(message = "班组id不能为空", groups = { UpdateGroup.class })
	private String id;
	@ApiModelProperty(value = "班组编号", required = true)
	@NotBlank(message = "班组编号不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String code; // 班组编号
	@ApiModelProperty(value = "班组名称", required = true)
	@NotNull(message = "班组名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String name; // 班组名称
	@ApiModelProperty(value = "值班班长ID", required = true)
	@NotNull(message = "值班班长不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@JsonProperty(value = "monitorId")
	private String monitorId; // 值班班长
	@ApiModelProperty(value = "班组成员Ids", required = true)
	@NotNull(message = "班组成员不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String memIds;// 班组成员
}
