package com.huaxing.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.huaxing.bean.AlarmType;

/**
 * 告警类型dto
 * Create Date:	2018年7月13日 上午11:07:25
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@ApiModel(value = "告警类型接收表单")
@Data
public class AlarmTypeDTO extends TransferObject<AlarmType> {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(value = "主键", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;
	//类别名称
	@ApiModelProperty(value = "类别名称", required = false)
	@NotBlank(message = "类型名称不能为空", groups = { UpdateGroup.class,AddGroup.class })
	private String name;
	//排序
	@ApiModelProperty(value = "排序", required = false)
	private BigDecimal sort;
	//运算符
	@ApiModelProperty(value = "运算符", required = false)
	@NotBlank(message = "运算符不能为空", groups = { UpdateGroup.class,AddGroup.class })
	private String operator;
	//备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	//父级编号
	@ApiModelProperty(value = "父级编号", required = false)
	@NotBlank(message = "父级id不能为空", groups = { UpdateGroup.class,AddGroup.class })
	private String parentId;

}
