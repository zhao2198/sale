package com.huaxing.bean;

import com.huaxing.common.entity.IdEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-02 09:37:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TodoCenterOperation extends IdEntity {
	private static final long serialVersionUID = 1L;
	// 待办事项id
	private String todoId;
	// 操作类
	private String operate;
	// 排序
	private String sort;
	// 按钮名
	private String labelName;
	// 操作的类型1直接执行2打开新窗口3在标签打开新页面
	private String type;
	// 参数
	private String param;
	// 样式
	private String style;
	// 大小
	private String size;
	// 操作后续:0无,1删除本条
	private String nextStep;

}
