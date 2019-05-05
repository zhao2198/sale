package com.huaxing.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.TurnDown;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-05 09:23:20
 */
@Data
@ApiModel(value = "转交记录用于显示")
public class TurnDownVO extends TransferObject<TurnDown> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;

	// 修复单表主键
	@ApiModelProperty(value = "修复单表主键", required = false)
	private String repairFormId;
	// 转记类别（数据字典）,已废除
	@ApiModelProperty(value = "转记类别（数据字典）,已废除", required = false)
	private String type;
	// 希完工日
	@ApiModelProperty(value = "希完工日", required = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hopeTime;

	// 备注信息
	@ApiModelProperty(value = "原因", required = false)
	private String remarks;

	@ApiModelProperty(value = "创建者ID", required = false)
	private String createBy; // 更新者
	@ApiModelProperty(value = "创建者时间", required = false)
	private Date createDate; // 更新者
	@ApiModelProperty(value = "创建者", required = false)
	private String createName;

}
