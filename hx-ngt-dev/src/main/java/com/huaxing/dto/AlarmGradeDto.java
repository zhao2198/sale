package com.huaxing.dto;

import com.huaxing.bean.AlarmGrade;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 告警等级dto Create Date: 2018年7月10日 下午3:05:04
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@ApiModel(value = "告警等级设置表单")
@Data
public class AlarmGradeDto extends TransferObject<AlarmGrade> {

	private static final long serialVersionUID = 1L;
	// 主键
	@ApiModelProperty(value = "id", required = false)
	// @NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;
	// 告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	// @NotBlank(message = "告警等级不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String grade;
	// 告警颜色
	@ApiModelProperty(value = "告警颜色", required = false)
	// @NotBlank(message = "告警颜色不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String color;
	// 告警声音
	@ApiModelProperty(value = "告警声音", required = false)
	// @NotBlank(message = "告警声音不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String sound;
	// 重要级别
	@ApiModelProperty(value = "重要级别", required = false)
	// @NotBlank(message = "重要级别不能为空", groups = { UpdateGroup.class, AddGroup.class })
	private String importantLevel;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

}
