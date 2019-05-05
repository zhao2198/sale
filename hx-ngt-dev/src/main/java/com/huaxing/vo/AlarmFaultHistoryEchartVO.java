package com.huaxing.vo;

import com.huaxing.common.web.transfer.TransferObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

import com.huaxing.bean.AlarmFault;
/**
 * 告警中心告警故障信息相关返回信息
 * Create Date:	2018年7月11日 上午11:19:00
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
 @ApiModel(value = "告警历史记录echart数据返回")
@Data
public class AlarmFaultHistoryEchartVO extends TransferObject<AlarmFault> {
	private static final long serialVersionUID = 1L;
	//x轴数据
	@ApiModelProperty(value = "x轴数据", required = true)
	private List<String> xData;
	//y轴数据
	@ApiModelProperty(value = "y轴数据", required = true)
	private List<Integer> yData;

}
