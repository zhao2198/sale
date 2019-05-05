package com.huaxing.bean;

import java.math.BigDecimal;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备分类实体类
 * 
 * @author hebo
 *
 *         上午9:28:17 2018年7月10日
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentType extends DateTimeEntity {

	private static final long serialVersionUID = 1L;

	private String tid;
	// 类别名称
	private String name;

	// 排序
	private BigDecimal sort;

	// 所属公司
	private String companyId;

	// 分类的标识
	private String type;

	// 父级编号
	private String parentId;

	// 所有父级编号
	private String parentIds;

	// 备注信息
	private String remarks;

	// 删除标记
	private String delFlag;

	// 启用标记
	private String enableFlag;

}
