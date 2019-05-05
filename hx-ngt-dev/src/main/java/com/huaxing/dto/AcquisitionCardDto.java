package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.huaxing.bean.AcquisitionCard;

/**
 * 采集卡dto
 * Create Date:	2018年7月9日 上午10:00:18
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value = "采集卡表单")
public class AcquisitionCardDto extends TransferObject<AcquisitionCard> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;
	//名称
	@ApiModelProperty(value = "采集卡名称", required = true)
	@NotBlank(message = "采集卡名称不能为空", groups = { UpdateGroup.class,AddGroup.class })
	private String name;
	//接口数
	@ApiModelProperty(value = "通道数量", required = true)
	@NotBlank(message = "通道数量不能为空", groups = { UpdateGroup.class,AddGroup.class })
	private String channelNum;
	//类型
	@ApiModelProperty(value = "采集卡类型", required = true)
	@NotBlank(message = "采集卡类型不能为空", groups = { UpdateGroup.class,AddGroup.class })
	private String type;
	
	@ApiModelProperty(value = "备注", required = false)
	private String remarks;

}
