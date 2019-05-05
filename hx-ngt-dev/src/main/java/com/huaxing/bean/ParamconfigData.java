package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 配置采集器传回参数; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ParamconfigData extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 项目编号
	private String projectCode;
	// 下发参数配置报文
	private String paramConfigData;
	// 所属公司
	private String companyId;
	// 启用标记
	private String enableFlag;

}
