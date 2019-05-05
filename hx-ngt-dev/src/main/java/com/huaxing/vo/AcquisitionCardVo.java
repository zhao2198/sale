package com.huaxing.vo;
import com.huaxing.common.web.transfer.TransferObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.huaxing.bean.AcquisitionCard;

/**
 * 采集卡vo
 * Create Date:	2018年7月9日 上午9:58:39
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value = "采集卡返回信息")
public class AcquisitionCardVo extends TransferObject<AcquisitionCard> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "采集卡主键", required = true)
	private String id;
	//名称
	@ApiModelProperty(value = "名称", required = true)
	private String name;
	//接口数
	@ApiModelProperty(value = "接口数", required = true)
	private String channelNum;
	//类型
	@ApiModelProperty(value = "类型", required = true)
	private String type;
	//备注
	@ApiModelProperty(value = "备注", required = false)
	private String remarks;
	
	@ApiModelProperty(value = "类型名称")
	private String typeName;
	
	

}
