package com.huaxing.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 抄表计划以设备为单位查看时的VO
 * Create Date:	2018年7月18日 上午10:33:33
 * @version:	V3.0.1
 * @author:		Lian weimao
 */
@ApiModel(value = "抄表计划以设备为单位查看时的VO")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingSchemeMeterListVO {


	@ApiModelProperty(value = "表计ID")
	private String meterId;

	@ApiModelProperty(value = "表计名称")
	private String meterName;

	@ApiModelProperty(value = "今日是否有抄表任务")
	private boolean todayHasMission;


}
