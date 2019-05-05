package com.huaxing.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.huaxing.bean.MeterreadingMission;

@ApiModel(value = "查询任务详情")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingMissionInfoDTO extends TransferObject<MeterreadingMission> {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	//表计ID
	@ApiModelProperty(value = "表计ID", required = false)
	private String meterId;
	//时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）
	@ApiModelProperty(value = "时间点（从0000-1230前面两位代表整点，后面两位00代表整点30代表整半）", required = false)
	@Pattern(regexp="^([0-1]\\d|2[0-3])(00|30)$",message="times:时间点格式错误，支持【1200,1230】，分钟仅支持00和30")
	private String time;
	//所属日期
	@ApiModelProperty(value = "所属日期", required = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date day;

}
