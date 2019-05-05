package com.huaxing.vo;

import java.util.Date;
import java.util.List;

import com.huaxing.bean.EquipmentParamConfig;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "设备参数分析;")
@EqualsAndHashCode(callSuper = false)
public class EquipmentParamAnalysisVO extends TransferObject<EquipmentParamConfig> {
	private static final long serialVersionUID = 1L;
	private String equipmentId;
	@ApiModelProperty(value = "图表标题", required = false)
	private String titleName;
	@ApiModelProperty(value = "图例", required = false)
	private List<String> legendName;
	// x轴数据
	@ApiModelProperty(value = "x轴数据", required = true)
	private List<Date> xDatas;
	// y轴数据
	@ApiModelProperty(value = "y轴数据", required = true)
	private List<String> yDatas;

}
