package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.Clazz;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 班次新增的实体类
 * 
 * @author Xie Ning
 * @date 2018-06-25 09:17:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "班次信息")
public class ClazzDto extends TransferObject<Clazz> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "班次ID", required = false)
	@NotBlank(message = "班次id不能为空", groups = { UpdateGroup.class })
	private String id;
	@ApiModelProperty(value = "班次编号", required = false)
	@NotBlank(message = "班次编号不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String code;// 班次编号
	@ApiModelProperty(value = "班次名称", required = false)
	@NotBlank(message = "班次名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String name;// 班次名称
	@ApiModelProperty(value = "班次开始时间", required = false)
	@JsonFormat(pattern = "HH:mm")
	private Date startTime;// 开始时间
	@ApiModelProperty(value = "班次结束时间", required = false)
	@JsonFormat(pattern = "HH:mm")
	private Date endTime;// 结束时间
	@ApiModelProperty(value = "备注", required = false)
	private String remarks;
}
