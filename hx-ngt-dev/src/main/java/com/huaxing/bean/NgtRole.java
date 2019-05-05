package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NgtRole extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 归属机构
	private String officeIdNotuse;
	// 角色名称
	private String name;
	// 英文名称
	private String enname;
	// 角色类型
	private String roleType;
	// 数据范围
	private String dataScope;
	// 是否系统数据
	private String isSys;
	// 是否可用
	private String useable;

	// 备注信息
	private String remarks;
	// 删除标记
	private String delFlag;
	//
	private String commonFlag;
	// 默认为能管在线
	private String datasource;
	// 公司id
	private String companyId;
	// 所属的系统 1--能管在线、2--分销、3--商城、4--项目
	private Integer sysType;

}
