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
 * @date 2018-07-07 15:18:37
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PatrolSchemeContent extends IdEntity {
	private static final long serialVersionUID = 1L;

	//建筑物ID
	private String locationId;
	// 建筑物名称
	private String locationName;
	//巡检计划的项目
//	sprivate List<PatrolSchemeContentItem> items;
	
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
