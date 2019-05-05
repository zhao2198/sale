package com.huaxing.dto;

import com.huaxing.bean.DutyRecords;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 值班记录的更新类 Create Date: 2018年8月28日 下午8:03:37
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@ApiModel(value = "值班记录_更新")
@Data
@EqualsAndHashCode(callSuper = false)
public class DutyRecordsUpdateDTO extends TransferObject<DutyRecords> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "值班记录标识", required = false)
	private String id;
	@ApiModelProperty(value = "值班记录编号", required = false)
	private String code;
	@ApiModelProperty(value = "值班记录的内容", required = false)
	private String dutyContent;
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
}
