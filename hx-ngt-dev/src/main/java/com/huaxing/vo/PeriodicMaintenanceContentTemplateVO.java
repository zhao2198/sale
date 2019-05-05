package com.huaxing.vo;

import com.huaxing.bean.PeriodicMaintenanceContentTemplate;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
@Data
@ApiModel(value = "定保模板主要用于显示")
public class PeriodicMaintenanceContentTemplateVO extends TransferObject<PeriodicMaintenanceContentTemplate> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 检查部位
	@ApiModelProperty(value = "检查部位", required = false)
	private String checkPoint;
	// 检查项目
	@ApiModelProperty(value = "检查项目", required = false)
	private String checkItem;
	// 检查要点
	@ApiModelProperty(value = "检查要点", required = false)
	private String keyPoint;
	// 检查标准
	@ApiModelProperty(value = "检查标准", required = false)
	private String checkStandard;
	// 排序
	@ApiModelProperty(value = "排序", required = false)
	private String sort;
	// 模板名称
	@ApiModelProperty(value = "模板名称", required = false)
	private String templateName;
	// 设备类型id
	@ApiModelProperty(value = "设备类型id", required = false)
	private String equipmentCategory;
	// 公司名
	@ApiModelProperty(value = "公司名", required = false)
	private String companyId;
	// 搜索用的关键词
	@ApiModelProperty(value = "搜索用的关键词", required = false)
	private String keyWord;

}
