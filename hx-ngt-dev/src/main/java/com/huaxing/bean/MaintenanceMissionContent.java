package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-06 14:34:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MaintenanceMissionContent extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 定保任务单id
	private String missionId;
	// 修复结果
	private String repairResult;
	// 解决对策
	private String solution;

	// 排序
	private String sort;
	// 设备id
	private String equipmentId;
	// 设备名
	private String equipmentName;
	// 检查部位
	private String checkPoint;
	// 检查项目
	private String checkItem;
	// 检查要点
	private String keyPoint;
	// 检查标准
	private String checkStandard;
	// 分组id
	private String pid;

}
