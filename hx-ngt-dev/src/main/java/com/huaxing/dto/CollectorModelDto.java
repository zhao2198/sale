package com.huaxing.dto;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.CollectorModel;

/**
 * 采集器型号dto
 * Create Date:	2018年7月7日 下午3:10:00
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value = "采集器型号表单")

public class CollectorModelDto extends TransferObject<CollectorModel> {
	private static final long serialVersionUID = 1L;
	//id
	@ApiModelProperty(value = "公司ID", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;
	//采集器名称
	@ApiModelProperty(value = "采集器名称", required = true)
	@NotBlank(message = "采集器名称不能为空", groups = {UpdateGroup.class, AddGroup.class })
	private String name;
	//数量（有多少插槽、多少通道）
	@ApiModelProperty(value = "数量（有多少插槽、多少通道）", required = true)
	@NotBlank(message = "数量（有多少插槽、多少通道）不能为空", groups = {UpdateGroup.class, AddGroup.class })
	private String configureNum;
	//类型（插槽或分支）
	@ApiModelProperty(value = "类型（插槽或分支）", required = true)
	@NotBlank(message = "类型（插槽或分支）不能为空", groups = {UpdateGroup.class, AddGroup.class })
	private String type;
	//生产厂家
	@ApiModelProperty(value = "生产厂家", required = true)
	@NotBlank(message = "生产厂家不能为空", groups = {UpdateGroup.class, AddGroup.class })
	private String manufacturer;
	//备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

}
