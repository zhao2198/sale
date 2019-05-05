package com.huaxing.dto;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 能管在线公共查询条件
 * Create Date:	2018年7月19日 下午2:47:42
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@ApiModel(value = "用能总览公共查询条件")
@Data
public class CommonQueryDTO {
	//时间类型
	@ApiModelProperty(value = "时间类型 0 日 1 月 2年", required = true)
	@NotNull(message="时间类型不能为空")
	private String dateType;
	//告警时间
	@ApiModelProperty(value = "开始时间", required = true)
	@NotNull(message="开始时间不能为空")
	private String queryDateStart;
	@NotNull(message="结束时间不能为空")
	@ApiModelProperty(value = "结束时间", required = true)
	private String queryDateEnd;
	//设备id		//TODO 查看总负荷的时候不传变压器id是可以查询所有的变压器的负荷，但是电费那里不一定能做到，所以现在不确定变压器id是否为必传项
	@ApiModelProperty(value = "设备（变压器）id", required = false)
	private String equipmentId;
	@ApiModelProperty(value = "用电参数类型（0功率因数1负载率）", required = false)
	private String parameterType;
}
