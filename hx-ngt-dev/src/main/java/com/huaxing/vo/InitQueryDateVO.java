package com.huaxing.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 初始化的查询时间，如果有需要服务器返回初始化查询时间的继承此类
 * Create Date:	2018年8月22日 上午10:46:20
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class InitQueryDateVO {
	@ApiModelProperty(value = "初始化的查询开始时间", required = true)
	private String initQueryDateStart;
	@ApiModelProperty(value = "初始化的查询结束时间", required = true)
	private String initQueryDateEnd;
}
