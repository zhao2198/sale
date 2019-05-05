package com.huaxing.dto;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.DutySign;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
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
public class DutySignDTO extends TransferObject<DutySign> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "值班任务的ID", required = true)
	@NotBlank(message = "值班任务的id不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String missionId;// 值班任务的id
}
