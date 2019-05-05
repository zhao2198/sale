package com.huaxing.vo;

import java.util.Date;

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
public class TodoCenterContentVO extends TransferObject<TodoCenterContent> {
	private static final long serialVersionUID = 1L;

	// 主键
	@ApiModelProperty(value = "主键")
	private String id;
	// 主要内容
	@ApiModelProperty(value = "主要内容")
	private String content;
	// 发送人
	@ApiModelProperty(value = "发送人")
	private String createBy;
	// 发送时间
	@ApiModelProperty(value = "发送时间")
	private Date createDate;
	// 主题名(比如模块名)
	@ApiModelProperty(value = "主题名(比如模块名)")
	private String theme;

	// for view
	private TodoCenterOperationVO Operation;
	@ApiModelProperty(value = "只读标志0未读 1已读")
	private String readFlag;
	@ApiModelProperty(value = "发送人名称")
	private String createName;

}
