package com.huaxing.vo;


import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.huaxing.bean.AlarmGrade;

/**
 * 告警等级设置
 * Create Date:	2018年7月10日 下午2:59:02
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
 @ApiModel(value = "告警等级返回信息")
@Data
public class AlarmGradeVo extends TransferObject<AlarmGrade> {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	//告警等级
	@ApiModelProperty(value = "告警等级", required = false)
	private String grade;
	//告警颜色
	@ApiModelProperty(value = "告警颜色", required = false)
	private String color;
	//告警声音
	@ApiModelProperty(value = "告警声音", required = false)
	private String sound;
	//重要级别
	@ApiModelProperty(value = "重要级别", required = false)
	private String importantLevel;
	//所属公司id
	@ApiModelProperty(value = "所属公司id", required = false)
	private String companyId;
	//备注信息
	@ApiModelProperty(value = "备注信息", required = false)
	private String remarks;

}
