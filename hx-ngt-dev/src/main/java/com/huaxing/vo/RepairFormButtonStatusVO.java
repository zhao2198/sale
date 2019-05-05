package com.huaxing.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 修复单中各个功能是否可用
 * Create Date:	2018年7月12日 下午2:25:07
 * @version:	V3.0.1
 * @author:		Lian weimao
 */
@ApiModel(value = "修复单功能模块中各个子功能是否可用")
@Data
@EqualsAndHashCode(callSuper = false)
public class RepairFormButtonStatusVO {


	@ApiModelProperty(value = "当前是否允许提交修复单")
	private boolean submitRepairRecordStatus;
	
	@ApiModelProperty(value = "当前是否允许验收修复单")
	private boolean checkStatus;
	
	@ApiModelProperty(value = "当前是否增加修复记录")
	private boolean createRepairRecordStatus;

}
