package com.huaxing.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

import com.huaxing.common.entity.DateTimeEntity;
import com.huaxing.common.entity.IdEntity;


/**
 * 抄表任务操作记录表之数据提交记录; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingLogSubmit extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	//对应的抄表任务ID
	private String missionId;
/*	//抄表人ID
	private String createBy;
	//提交时间
	private Date createDate;*/

}
