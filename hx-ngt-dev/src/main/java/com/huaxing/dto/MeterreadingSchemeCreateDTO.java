package com.huaxing.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import springfox.documentation.annotations.ApiIgnore;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.huaxing.bean.MeterreadingScheme;

/**
 * 保存当前的抄表计划; InnoDB free: 8192 kB
 * 
 * @author zhao wei
 * @date 2018-07-18 09:07:19
 */
@ApiModel(value = "创建抄表计划DTO")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingSchemeCreateDTO extends TransferObject<MeterreadingScheme> {
	private static final long serialVersionUID = 1L;
	//表计ID
	@ApiModelProperty(value = "表计ID", required = false)
	@NotBlank(message="表计ID不能为空")
	private String meterId;
	//开始日期
	@ApiModelProperty(value = "开始日期", required = false)
	@NotNull(message="开始日期不能为空")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	//结束日期（含）
	@ApiModelProperty(value = "结束日期（含）", required = false)
	@NotNull(message="结束日期不能为空")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	//时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）
	@ApiModelProperty(value = "时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）,以半角逗号分割", required = false)
	@Size(min=1,message="times:抄表时间点最少为1个")
	//@Pattern(regexp="^([0-1]\\d|2[0-3])(00|30)$",message="times:时间点格式错误，支持【1200,1230】，分钟仅支持00和30")
	private String[] times;
	//抄表人ID
	@ApiModelProperty(value = "抄表人IDs字符串，以半角逗号分割", required = false)
	@Size(min=1,message="handlerIds:抄表人ID最少为1个")
	private String[] handlerIds;
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	private String createBy;

}
