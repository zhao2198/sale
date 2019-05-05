package com.huaxing.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.huaxing.bean.PatrolSchemeContent;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-07 15:18:37
 */
@ApiModel(value = "巡检内容")
@Data
@EqualsAndHashCode(callSuper = false)
public class PatrolSchemeContentDTO extends TransferObject<PatrolSchemeContent> {
	private static final long serialVersionUID = 1L;

/*	// 虚拟父id,用来分组
	@ApiModelProperty(value = "虚拟父id,用来分组", required = false)
	private String pid;*/
	// 建筑物id
	@ApiModelProperty(value = "建筑物id", required = false)
	private String locationId;
	// 建筑物名称
	@ApiModelProperty(value = "建筑物名称", required = false)
	private String locationName;
	// 花费的时间

	@ApiModelProperty(value = "巡检时长", required = false)
	@NotEmpty(message = "巡检时长不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String time;
	// 设备id
	@ApiModelProperty(value = "设备id", required = false)
	@NotBlank(message = "设备不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String equipmentId;

}
