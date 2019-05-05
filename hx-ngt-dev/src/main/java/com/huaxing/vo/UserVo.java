package com.huaxing.vo;

import com.huaxing.common.entity.UserEntity;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Create Date: 2018年6月25日 上午11:55:43
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@Data
@ApiModel(value = "人员信息")
public class UserVo extends TransferObject<UserEntity> {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "未排班的员工ID", required = false)
	private String id;// 用户id
	@ApiModelProperty(value = "未排班的员工姓名", required = false)
	private String name;// 用户名

}
