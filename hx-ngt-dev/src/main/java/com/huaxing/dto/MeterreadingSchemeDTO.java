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
import com.huaxing.bean.MeterreadingScheme;

/**
 * 保存当前的抄表计划; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@ApiModel(value = "保存当前的抄表计划; InnoDB free: 8192 kB")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingSchemeDTO extends TransferObject<MeterreadingScheme> {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	//表计ID
	@ApiModelProperty(value = "表计ID", required = false)
	private String meterId;
	//开始日期
	@ApiModelProperty(value = "开始日期", required = false)
	private Date startDate;
	//结束日期（含）
	@ApiModelProperty(value = "结束日期（含）", required = false)
	private Date endDate;
	//时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）
	@ApiModelProperty(value = "时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）", required = false)
	private String time;
	//抄表人ID
	@ApiModelProperty(value = "抄表人ID", required = false)
	private String handlerId;
	//创建者
	@ApiModelProperty(value = "创建者", required = false)
	private String createBy;
	//创建时间
	@ApiModelProperty(value = "创建时间", required = false)
	private Date createDate;
	//更新者
	@ApiModelProperty(value = "更新者", required = false)
	private String updateBy;
	//更新时间
	@ApiModelProperty(value = "更新时间", required = false)
	private Date updateDate;
	//备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String memo;

}
