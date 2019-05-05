package com.huaxing.vo;

import java.util.Date;

import com.huaxing.bean.NgtUser;
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
@ApiModel(value = "用户返回信息")
public class NgtUserVO extends TransferObject<NgtUser> {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "主键")
	private String id;
	// 归属公司
	@ApiModelProperty(value = "公司ID")
	private String companyId;
	// 归属部门
	@ApiModelProperty(value = "组织ID")
	private String officeId;
	// 登录名
	@ApiModelProperty(value = "登录名")
	private String loginName;
	// 工号
	@ApiModelProperty(value = "工号")
	private String no;
	// 身份证号
	@ApiModelProperty(value = "身份证号")
	private String idCode;
	// 姓名
	@ApiModelProperty(value = "姓名")
	private String name;
	// 邮箱
	@ApiModelProperty(value = "邮箱")
	private String email;
	// 电话
	@ApiModelProperty(value = "电话")
	private String phone;
	// 手机
	@ApiModelProperty(value = "手机")
	private String mobile;
	// 用户头像
	@ApiModelProperty(value = "头像地址")
	private String photo;
	// 最后登陆IP
	@ApiModelProperty(value = "最后登陆IP")
	private String loginIp;
	// 最后登陆时间
	@ApiModelProperty(value = "最后登陆时间")
	private Date loginDate;
	// 是否可登录
	@ApiModelProperty(value = "是否可登录")
	private String loginFlag;

	// 备注信息
	@ApiModelProperty(value = "备注")
	private String remarks;
	// 二维码
	@ApiModelProperty(value = "二维码")
	private String qrcode;

	// 地址
	@ApiModelProperty(value = "地址")
	private String address;
	@ApiModelProperty(value = "组织名称")
	private String officeName;
	
	@ApiModelProperty(value = "头像全路径")
	private String photoUrl;

}
