package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.huaxing.bean.AlarmType;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 告警类型返回信息 Create Date: 2018年7月13日 上午11:29:13
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@ApiModel(value = "告警类型返回信息")
@Data
public class AlarmTypeVO extends TransferObject<AlarmType> {
	private static final long serialVersionUID = 1L;
	// 主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	// 类别名称
	@ApiModelProperty(value = "类别名称", required = false)
	private String name;
	// 排序
	@ApiModelProperty(value = "排序", required = false)
	private BigDecimal sort;
	// 运算符
	@ApiModelProperty(value = "运算符", required = false)
	private String operator;
	// 所属公司
	@ApiModelProperty(value = "所属公司", required = false)
	private String companyId;
	// 创建者
	@ApiModelProperty(value = "创建者", required = false)
	private String createBy;
	// 创建时间
	@ApiModelProperty(value = "创建时间", required = false)
	private Date createDate;
	// 更新者
	@ApiModelProperty(value = "更新者", required = false)
	private String updateBy;
	// 更新时间
	@ApiModelProperty(value = "更新时间", required = false)
	private Date updateDate;
	// 备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;
	// 父级编号
	@ApiModelProperty(value = "父级编号（id）", required = false)
	private String parentId;

	@ApiModelProperty(value = "树型ID", required = false)
	private String tid;

}
