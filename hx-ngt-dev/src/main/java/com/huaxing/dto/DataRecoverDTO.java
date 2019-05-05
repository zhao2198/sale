package com.huaxing.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="电费数据恢复条件")
@Data
public class DataRecoverDTO {
	@ApiModelProperty(value = "开始时间", required = true)
	@NotNull(message="开始时间不能为空")
	private String startDate;
	@NotNull(message="结束时间不能为空")
	@ApiModelProperty(value = "结束时间", required = true)
	private String endDate;
	@NotNull(message="公司id不能为空")
	@ApiModelProperty(value = "公司id", required = true)
	private String companyId;
}
