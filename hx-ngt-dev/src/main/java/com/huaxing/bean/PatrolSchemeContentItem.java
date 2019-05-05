package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * Create Date:	2018年7月14日 上午10:26:41
 * @version:	V3.0.1
 * @author:		Lian weimao
 */
@Data
@Deprecated
@EqualsAndHashCode(callSuper = false)
public class PatrolSchemeContentItem extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	private String sort;			//排序
	private String equipmentId;		//设备
	private String equipmentName;	//设备名称
	private String time;			//耗时(分钟)
	private String content;			//巡检记录
	private String confirmorName;	//确认人姓名
	private String confirmorPhone;	//确认人电话
	private Date startTime;			//工作开始时间
	private Date endTime;			//工作结束时间

}
