package com.huaxing.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.huaxing.bean.NgtUser;
import com.huaxing.common.validator.group.AddGroup;
import com.huaxing.common.validator.group.UpdateGroup;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
@Data
@ApiModel(value = "用户信息")
public class NgtUserDTO extends TransferObject<NgtUser> {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID", required = false)
	@NotBlank(message = "ID不能为空", groups = { UpdateGroup.class })
	private String id;
	// 归属部门
	@ApiModelProperty(value = "归属部门", required = true)
	@NotBlank(message = "归属部门不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String officeId;
	// 登录名
	@ApiModelProperty(value = "登录名", required = true)
	@NotBlank(message = "登录名不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Length(max = 20, message = "登录名长度最大支持20", groups = { AddGroup.class, UpdateGroup.class })
	private String loginName;
	// 工号
	@ApiModelProperty(value = "工号", required = false)
	@Length(max = 50, message = "工号长度最大支持50", groups = { AddGroup.class, UpdateGroup.class })
	private String no;
	// 身份证号
	@ApiModelProperty(value = "身份证号", required = false)
	private String idCode;
	// 姓名
	@ApiModelProperty(value = "名称", required = true)
	@NotBlank(message = "名称不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Length(max = 30, message = "名称长度最大支持30", groups = { AddGroup.class, UpdateGroup.class })
	private String name;
	// 邮箱
	@ApiModelProperty(value = "邮箱", required = false)
	@Pattern(regexp = "\\s*|^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "邮箱校验失败", groups = { AddGroup.class,
			UpdateGroup.class })
	private String email;
	// 电话
	@ApiModelProperty(value = "电话", required = false)
	@Pattern(regexp = "\\s*|^0\\d{2,3}-\\d{7,8}$", message = "电话校验失败", groups = { AddGroup.class, UpdateGroup.class })
	private String phone;
	// 手机
	@ApiModelProperty(value = "手机", required = false)
	@Pattern(regexp = "\\s*|^(13[0-9]|14[5,7,9]|15[0-3,5-9]|16[6]|17[0,1,3,5,6,7,8]|18[0-9]|19[8|9])\\d{8}$", message = "手机校验失败", groups = {
			AddGroup.class, UpdateGroup.class })
	private String mobile;
	// 用户头像
	@ApiModelProperty(value = "头像", required = false)
	private String photo;

	// 是否可登录
	@ApiModelProperty(value = "是否可登录", required = false)
	private String loginFlag = "1";

	// 备注信息
	@ApiModelProperty(value = "备注", required = false)
	@Length(max = 200, message = "备注长度最大支持200", groups = { AddGroup.class, UpdateGroup.class })
	private String remarks;

	// 地址
	@ApiModelProperty(value = "地址", required = false)
	@Length(max = 200, message = "地址长度最大支持200", groups = { AddGroup.class, UpdateGroup.class })
	private String address;

}
