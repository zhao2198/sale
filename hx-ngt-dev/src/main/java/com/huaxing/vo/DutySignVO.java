package com.huaxing.vo;

import java.util.Date;

import com.huaxing.bean.DutySign;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InnoDB free: 9216 kB
 * 
 * @author Xie Ning
 * @date 2018-07-09 15:10:00
 */
@ApiModel(value = "值班签到表")
@Data
@EqualsAndHashCode(callSuper = false)
public class DutySignVO extends TransferObject<DutySign> {
	private static final long serialVersionUID = 1L;
	// 签到的id
	private String id;
	// 签到人
	@ApiModelProperty(value = "签到人", required = false)
	private String signPersonName;
	// 签到时间
	@ApiModelProperty(value = "签到时间", required = false)
	private Date signinTime;
	// 签到状态 0--正常，1--不正常
	@ApiModelProperty(value = "签到状态  0--正常，1--不正常", required = false)
	private String signinStatus;
}
