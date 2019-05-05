package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.MeterreadingScheme;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 保存当前的抄表计划; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@ApiModel(value = "修改抄表计划DTO")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingSchemeUpdateDTO extends TransferObject<MeterreadingScheme> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "id", required = true)
	@NotBlank(message = "ID不能为空")
	private String id;
	// 开始日期
	@ApiModelProperty(value = "抄表日期", required = false)
	@NotNull(message = "抄表日期不能为空")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date day;
	// 抄表人ID
	@ApiModelProperty(value = "抄表人IDs字符串，以半角逗号分割", required = false)
	@Size(min = 1, message = "handlerIds:抄表人ID最少为1个")
	private String[] handlerIds;
	/*
	 * @JsonIgnore
	 * 
	 * @ApiModelProperty(hidden=true) private String createBy;
	 */
}
