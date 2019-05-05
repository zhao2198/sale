package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.TransformerConfig;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 变压器参数配置dto
 * Create Date:	2018年7月2日 下午3:12:41
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="变压器参数配置dto")
public class TransformerConfigDto extends TransferObject<TransformerConfig> {
	@ApiModelProperty(value = "变压器运行容量", required = true)
	@NotBlank(message = "变压器运行容量不能为空")
	private String operatingCapacity;//运行容量
	@ApiModelProperty(value = "变压器额定容量", required = true)
	@NotBlank(message = "变压器额定容量不能为空")
	private String ratedCapacity;//额定容量
	@ApiModelProperty(value = "变压器合同容量", required = true)
	@NotBlank(message = "变压器合同容量不能为空")
	private String contractCapacity;//合同容量
}
