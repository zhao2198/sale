package com.huaxing.bean;

import java.util.Date;
import java.util.List;

import com.huaxing.common.entity.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-02 09:37:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TodoCenterContent extends IdEntity {
	private static final long serialVersionUID = 1L;
	// 主要内容
	private String content;
	// 发送人
	private String createBy;
	// 发送时间
	private Date createDate;
	// 主题名(比如模块名)
	private String theme;

	// for view
	private TodoCenterOperation Operation;
	private String readFlag;
	private String createName;

	// for select

	private Date startDate;
	private Date endDate;

	// for insert
	List<String> receiverIds;
	String refId;// 相关联的id 例如：值班任务的id

}
