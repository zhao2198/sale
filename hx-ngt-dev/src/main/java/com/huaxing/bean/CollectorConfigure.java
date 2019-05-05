package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采集器配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CollectorConfigure extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 所属采集器
	private String collector;
	// 采集卡
	private String acquisitionCard;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 启用标记
	private String enableFlag;

	// for query

	private String acquisitionCardName;

	private String acquisitionCardType;
}
