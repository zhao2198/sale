package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.TurnDown;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-05 09:23:20
 */
@Data
@ApiModel(value = "转记记录用于添加修改")
public class TurnDownDTO extends TransferObject<TurnDown> {
	private static final long serialVersionUID = 1L;

	// 修复单表主键
	@ApiModelProperty(value = "修复单表主键", required = true)
	@NotBlank(message = "修复ID不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String repairFormId;

	// 希完工日
	@ApiModelProperty(value = "希望完工日期", required = true)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hopeTime;

	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	@Size(min = 2, max = 200, groups = { AddGroup.class, UpdateGroup.class }, message = "备注信息长度在2-200之间")
	private String remarks;

}
