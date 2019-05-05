package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.DutyStatistics;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 值班统计实体类
 * 
 * @author Xie Ning
 * @date 2018-06-25 09:17:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "值班统计")
public class DutyStatisticsDTO extends TransferObject<DutyStatistics> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "值班开始时间", required = true)
	private String start;// 开始时间
	@ApiModelProperty(value = "值班结束时间", required = true)
	private String end;// 结束时间
	@ApiModelProperty(value = "时间单位", required = true)
	@NotBlank(message = "时间单位不能为空")
	private String timeUnit;// 时间单位 0--年 1--月 2--日
	@ApiModelProperty(value = "值班人ID", required = false)
	private String ondutyUserIds;// 值班人
}
