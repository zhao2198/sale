package com.huaxing.bean;
import lombok.Data;

import com.huaxing.common.entity.DateTimeEntity;
/**
 * 告警等级entity
 * Create Date:	2018年7月10日 下午3:00:49
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class AlarmGrade extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	//告警等级
	private String grade;
	//告警颜色
	private String color;
	//告警声音
	private String sound;
	//重要级别
	private String importantLevel;
	//所属公司id
	private String companyId;
	//备注信息
	private String remarks;

}
