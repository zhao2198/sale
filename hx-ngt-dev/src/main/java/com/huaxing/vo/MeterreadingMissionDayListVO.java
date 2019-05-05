package com.huaxing.vo;

import java.util.Date;
import java.util.List;

import com.huaxing.bean.MeterreadingMission;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(value = "抄表任务以天为单位查询时的vo")
@Data
@EqualsAndHashCode(callSuper = false)
public class MeterreadingMissionDayListVO extends TransferObject<MeterreadingMission> {
	private static final long serialVersionUID = 1L;
	
	
	//表计ID
	@ApiModelProperty(value = "表计ID")
	private String meterId;
	//表计名称
	@ApiModelProperty(value = "表计名称")
	private String meterName;
	//所属日期
	@ApiModelProperty(value = "所属日期")
	private Date day;
	//表数
	@ApiModelProperty(value = "任务列表")
	private List<MeterreadingMissionContentVO> missionList;

}
