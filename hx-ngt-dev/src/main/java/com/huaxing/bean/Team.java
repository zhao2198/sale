package com.huaxing.bean;

import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;
import com.huaxing.vo.UserVo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Create Date: 2018年6月22日 下午1:47:48
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Team extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	private String code; // 班组编号
	private String name; // 班组名称
	private UserVo monitor; // 值班班长
	private String companyId; // 所属公司
	private String remarks; // 备注信息
	private String delFlag; // 逻辑删除标记（0：显示；1：隐藏）
	private String enableFlag; // 启用标记 （0：启用；1：隐藏）

	// for select
	private List<UserVo> members;// 班组成员
	private String monitorId; // 值班班长id
	private String monitorName; // 值班班长
	private List<String> memberNames;// 班组成员的名字
	private List<String> memberIds;// 班组成员的ids

	// for view
	// private String moNames;// 班长的名字
	private String memNames;// 班组成员的名字
	private String memIds;// 班组成员的名字

	// for update
	private String[] memIdsArr;// 班组成员id的数组
}
