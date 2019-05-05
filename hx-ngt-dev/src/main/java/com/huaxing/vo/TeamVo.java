package com.huaxing.vo;

import com.huaxing.bean.Team;
import com.huaxing.common.web.transfer.TransferObject;

import lombok.Data;

/**
 * Create Date: 2018年6月22日 下午1:47:48
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@Data
public class TeamVo extends TransferObject<Team> {
	private static final long serialVersionUID = 1L;
	private String id;// 班组的id
	private String code; // 班组编号
	private String name; // 班组名称
	private String monitorId; // 值班班长id
	private String monitorName;// 值班班长姓名
	private String memNames;// 班组成员的名字
	private String memIds;// 班组成员的名字
}
