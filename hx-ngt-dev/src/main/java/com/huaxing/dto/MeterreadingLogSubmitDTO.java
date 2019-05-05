package com.huaxing.dto;

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
import com.huaxing.bean.MeterreadingLogSubmit;

/**
 * 抄表任务操作记录表之数据提交记录; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@ApiModel(value = "抄表任务操作记录表之数据提交记录; InnoDB free: 8192 kB")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingLogSubmitDTO extends TransferObject<MeterreadingLogSubmit> {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	//对应的抄表任务ID
	@ApiModelProperty(value = "对应的抄表任务ID", required = false)
	private String missionId;
	//抄表人ID
	@ApiModelProperty(value = "抄表人ID", required = false)
	private String createBy;
	//提交时间
	@ApiModelProperty(value = "提交时间", required = false)
	private Date createDate;

}
