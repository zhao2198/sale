package com.huaxing.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.huaxing.bean.TodoCenterContent;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-02 09:37:51
 */
@Data
@ApiModel(value = "")
public class TodoQueryContentDTO extends TransferObject<TodoCenterContent> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "开始日期", required = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@ApiModelProperty(value = "结束日期", required = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	// 主题名(比如模块名)
	@ApiModelProperty(value = "主题名(比如模块名)", required = false)
	private String theme;
	@ApiModelProperty(value = "已读标志 0 未读 1已读", required = false)
	private String readFlag;

}
