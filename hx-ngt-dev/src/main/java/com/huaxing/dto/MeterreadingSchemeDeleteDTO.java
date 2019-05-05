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

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MeterreadingSchemeDeleteDTO extends TransferObject<MeterreadingScheme> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "ID", required = false)
	private String id;
	//表计ID
	@ApiModelProperty(value = "表计ID", required = false)
	private String meterId;
	//时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）
	@ApiModelProperty(value = "时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）", required = false)
	@Pattern(regexp="^\\s*$|^([0-1]\\d|2[0-3])(00|30)$",message="times:时间点格式错误，支持【1200,1230】，分钟仅支持00和30")
	private String time;
	

}
