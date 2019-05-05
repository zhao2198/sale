package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.Shiftclass;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@ApiModel(value = "申请调班信息")
@Data
@EqualsAndHashCode(callSuper = false)
public class ShiftclassSaveDTO extends TransferObject<Shiftclass> {
	private static final long serialVersionUID = 1L;

	// 调班标识
	@ApiModelProperty(value = "调班标识", required = false)
	@NotBlank(message = "调班标识不能为空", groups = { UpdateGroup.class })
	private String id;
	// 调班编号
	@ApiModelProperty(value = "调班编号", required = true)
	@NotBlank(message = "调班编号不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String code;
	// 值班任务标识
	@ApiModelProperty(value = "值班任务标识", required = true)
	@NotBlank(message = "值班任务标识不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String missionId;
	// 原开始时间
	@ApiModelProperty(value = "原开始时间", required = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date oldstarttime;
	// 原结束时间
	@ApiModelProperty(value = "原结束时间", required = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date oldendtime;
	// 新值班日期
	@ApiModelProperty(value = "新值班日期", required = true)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date newdate;
	// 新班次标识
	@ApiModelProperty(value = "新班次标识", required = true)
	@NotBlank(message = "新班次标识不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String classId;
	// 申请理由
	@ApiModelProperty(value = "申请理由", required = true)
	@NotBlank(message = "申请理由不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String reasonApply;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

}
