package com.huaxing.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "值班任务信息")
public class DutyMissionDayDTO {
	@ApiModelProperty(value = "值班日期", required = true)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@ApiModelProperty(value = "值班人的Id", required = false)
	String userId;
}
