package com.huaxing.bean;

import lombok.Data;

import com.huaxing.common.entity.DateTimeEntity;


/**
 * 采集器型号entity
 * Create Date:	2018年7月7日 下午3:05:45
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class CollectorModel extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	//采集器名称
	private String name;
	//数量（有多少插槽、多少通道）
	private String configureNum;
	//类型（插槽或分支）
	private String type;
	//生产厂家
	private String manufacturer;
	//所属公司
	private String companyId;
	//备注信息
	private String remarks;
	
	
	//mine
	private String keyword;

}
