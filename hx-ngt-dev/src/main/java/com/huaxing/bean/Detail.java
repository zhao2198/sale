package com.huaxing.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "修单单统计详情")
public class Detail implements Serializable {

	private static final long serialVersionUID = 1L;
	// for selectResult
	private String type;// 巡检的类型
	private String patrolTypeCount;// 巡检的类型对应的巡检数
	private String userName;// 人的姓名
	private String userId;// 人的id

	// for repairform
	private int totalAll = 0; // 总接单数
	private int totalSuccess = 0;// 成功修复数
	private int totalFailed = 0; // 未成功修复数
	private int totalUnHandle = 0; // 未处理数
	private long totalTakeTime; // 总修复时长
	private long meanTakeTime; // 平均修复时长
}
