package com.huaxing.vo;

import javax.validation.constraints.NotBlank;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.huaxing.bean.TodoCenterOperation;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-02 09:37:51
 */
@Data
@ApiModel(value = "")
public class TodoCenterOperationVO extends TransferObject<TodoCenterOperation> {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(value = "主键", required = false)
	private String id;
	//待办事项id
	@ApiModelProperty(value = "待办事项id", required = false)
	private String todoId;
	//操作类
	@ApiModelProperty(value = "操作类", required = false)
	private String operate;
	//排序
	@ApiModelProperty(value = "排序", required = false)
	private String sort;
	//按钮名
	@ApiModelProperty(value = "按钮名", required = false)
	private String labelName;
	//操作的类型1直接执行2打开新窗口3在标签打开新页面
	@ApiModelProperty(value = "操作的类型1直接执行2打开新窗口3在标签打开新页面", required = false)
	private String type;
	//参数
	@ApiModelProperty(value = "参数", required = false)
	private String param;
	//样式
	@ApiModelProperty(value = "样式", required = false)
	private String style;
	//大小
	@ApiModelProperty(value = "大小", required = false)
	private String size;
	//操作后续:0无,1删除本条
	@ApiModelProperty(value = "操作后续:0无,1删除本条", required = false)
	private String nextStep;

}
