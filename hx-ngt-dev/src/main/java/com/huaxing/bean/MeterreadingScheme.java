package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 保存当前的抄表计划; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingScheme extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	/*
	 * //主键,也用于删除 private String id;
	 */
	// 表计ID,也用于删除
	private String meterId;
	// 抄表日期
	private Date day;
	// 时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）,也用于删除
	private String time;
	// 抄表人ID
	private String handlerIds;
	/*
	 * //创建者 private String createBy; //创建时间 private Date createDate; //更新者 private String updateBy; //更新时间 private Date updateDate;
	 */
	// 备注信息
	private String memo;

	// for query
	// 公司ID
	private String companyId;
	// 时间s
	private String[] times;
	// 开始日期
	private Date startDate;
	// //结束日期（含）
	private Date endDate;

	// for view
	private String handlerNames;// 处理人的名字
}
