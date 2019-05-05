package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.bean.TotalLoad;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="总负荷界面列表数据返回")
public class LoadListVO extends TransferObject<TotalLoad>{
	private static final long serialVersionUID = 1L;
	//采集时间
	@ApiModelProperty(value="数据采集时间",required=false)
	private String acquisitionTime;
	//总负荷
	@ApiModelProperty(value="总负荷",required=false)
	private BigDecimal totalLoad;
	//平均负荷
	@ApiModelProperty(value="平均负荷",required=false)
	private BigDecimal avgLoad;
	//最大负荷
	@ApiModelProperty(value="最大负荷",required=false)
	private BigDecimal maxLoad;
	//最大负荷发生时间
	@ApiModelProperty(value="最大负荷发生时间",required=false)
	private Date maxDate;
	//最小负荷
	@ApiModelProperty(value="最小负荷",required=false)
	private BigDecimal minLoad;
	//最小负荷发生时间
	@ApiModelProperty(value="最小负荷发生时间",required=false)
	private Date minDate;
}
