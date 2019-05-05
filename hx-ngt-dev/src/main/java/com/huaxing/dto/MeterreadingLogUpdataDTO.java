package com.huaxing.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.huaxing.bean.MeterreadingLogUpdata;

/**
 * 抄表任务操作记录表之数据修改记录; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@ApiModel(value = "抄表任务操作记录表之数据修改记录; InnoDB free: 8192 kB")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingLogUpdataDTO extends TransferObject<MeterreadingLogUpdata> {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	//对应的抄表任务ID
	@ApiModelProperty(value = "对应的抄表任务ID", required = false)
	private String missionId;
	//表数
	@ApiModelProperty(value = "表数", required = false)
	private BigDecimal beforeValue;
	//表数
	@ApiModelProperty(value = "表数", required = false)
	private BigDecimal afterValue;
	//原抄表数提供者
	@ApiModelProperty(value = "原抄表数提供者", required = false)
	private String beforeHandlerId;
	//现抄表数提供者
	@ApiModelProperty(value = "现抄表数提供者", required = false)
	private String afterHandlerId;
	//原创建时间
	@ApiModelProperty(value = "原创建时间", required = false)
	private Date beforeCreateDate;
	//现创建时间
	@ApiModelProperty(value = "现创建时间", required = false)
	private Date afterCreateDate;

}
