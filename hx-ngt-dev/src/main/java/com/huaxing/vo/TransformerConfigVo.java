package com.huaxing.vo;

import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 变压器参数配置vo
 * Create Date:	2018年7月2日 下午3:11:59
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="变压器参数配置相关信息")
public class TransformerConfigVo{
	@ApiModelProperty(value = "变压器运行容量", required = true)
	private String operatingCapacity;//运行容量
	@ApiModelProperty(value = "变压器额定容量", required = true)
	private String ratedCapacity;//额定容量
	@ApiModelProperty(value = "变压器合同容量", required = true)
	private String contractCapacity;//合同容量
}
