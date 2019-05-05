package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-04 09:41:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TurnDown extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 所属公司主键
	private String companyId;
	// 修复单表主键
	private String repairFormId;
	// 转记类别（数据字典）,已废除
	private String type;
	// 希完工日
	private Date hopeTime;

	// 备注信息
	private String remarks;

	// 启用标记
	private String enableFlag;

	private String createName;

}
