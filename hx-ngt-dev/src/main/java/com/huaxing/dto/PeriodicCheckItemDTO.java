package com.huaxing.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(value = "定保检查内容模板项")
@Data
@EqualsAndHashCode(callSuper = false)
public class PeriodicCheckItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 检查部位
	@ApiModelProperty(value = "检查部位", required = false)
	@NotEmpty(message = "检查部位不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String checkPoint;
	// 检查项目
	@ApiModelProperty(value = "检查项目", required = false)
	@NotEmpty(message = "检查项目不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String checkItem;
	// 检查要点
	@ApiModelProperty(value = "检查要点", required = false)
	@NotEmpty(message = "检查要点不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String keyPoint;
	// 检查标准
	@ApiModelProperty(value = "检查要点", required = false)
	@NotEmpty(message = "检查要点不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String checkStandard;
	// 排序
	@ApiModelProperty(value = "排序", required = false)
	private String sort;
}
