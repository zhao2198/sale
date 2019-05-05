package com.huaxing.vo;
import com.huaxing.common.web.transfer.TransferObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.huaxing.bean.CollectorModel;

/**
 * 采集器型号表; InnoDB free: 9216 kB
 * 
 * @author zhao wei
 * @date 2018-07-07 15:04:22
 */
@Data
@ApiModel(value = "采集器型号表; InnoDB free: 9216 kB")
public class CollectorModelVo extends TransferObject<CollectorModel> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "采集器编号")
	private String id;
	//采集器名称
	@ApiModelProperty(value = "采集器名称", required = false)
	private String name;
	//数量（有多少插槽、多少通道）
	@ApiModelProperty(value = "数量（有多少插槽、多少通道）", required = false)
	private String configureNum;
	//类型（插槽或分支）
	@ApiModelProperty(value = "类型（插槽或分支）", required = false)
	private String type;
	//生产厂家
	@ApiModelProperty(value = "生产厂家", required = false)
	private String manufacturer;
	
	//备注信息
	@ApiModelProperty(value = "备注", required = false)
		private String remarks;
	//所属公司
	@ApiModelProperty(value = "类型名称", required = false)
	private String typeName;

}
