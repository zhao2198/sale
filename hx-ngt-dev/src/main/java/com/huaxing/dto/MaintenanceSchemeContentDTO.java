package com.huaxing.dto;

import javax.validation.constraints.NotEmpty;

import com.huaxing.bean.MaintenanceSchemeContent;
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
 * @date 2018-07-06 14:34:54
 */
@Data
@ApiModel(value = "定保内容")
public class MaintenanceSchemeContentDTO extends TransferObject<MaintenanceSchemeContent> {
	private static final long serialVersionUID = 1L;

	// 设备id
	@ApiModelProperty(value = "设备id", required = true)
	@NotEmpty(message = "设备id不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String equipmentId;
//	// 设备名
//	@ApiModelProperty(value = "设备名", required = false)
//	private String equipmentName;
	// 检查部位
	@ApiModelProperty(value = "检查部位", required = true)
	@NotEmpty(message = "检查部位不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String checkPoint;
	// 检查项目
	@ApiModelProperty(value = "检查项目", required = true)
	@NotEmpty(message = "检查项目不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String checkItem;
	// 检查要点
	@ApiModelProperty(value = "检查要点", required = true)
	@NotEmpty(message = "检查要点不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String keyPoint;
	// 检查标准
	@ApiModelProperty(value = "检查标准", required = true)
	@NotEmpty(message = "检查标准不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String checkStandard;
	// 内容id
//	@ApiModelProperty(value = "内容id", required = false)
//	private String pid;

}
