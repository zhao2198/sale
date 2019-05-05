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
public class TodoCenter extends IdEntity {
	private static final long serialVersionUID = 1L;
	// 内容id
	private String contentId;
	// 接收人id
	private String receiverId;
	// 阅读标记 0未读 1已读
	private String readFlag;
	// 删除标记 0未删 1已删
	private String delFlag;

}
