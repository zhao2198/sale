package com.huaxing.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.huaxing.common.entity.IdEntity;


/**
 * 抄表任务操作记录表之数据修改记录; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingLogUpdata extends IdEntity {
	private static final long serialVersionUID = 1L;
	//对应的抄表任务ID
	private String missionId;
	//表数
	private BigDecimal beforeValue;
	//表数
	private BigDecimal afterValue;
	//原抄表数提供者
	private String beforeHandlerId;
	//现抄表数提供者
	private String afterHandlerId;
	//原创建时间
	private Date beforeCreateDate;
	//现创建时间
	private Date afterCreateDate;

}
