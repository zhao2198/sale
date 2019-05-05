package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表
 * 
 * @author zhao wei
 * @date 2018-06-27 09:46:45
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NgtUser extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 归属公司
	private String companyId;
	// 归属部门
	private String officeId;
	// 登录名
	private String loginName;
	// 密码
	private String password;
	// 工号
	private String no;
	// 身份证号
	private String idCode;
	// 姓名
	private String name;
	// 邮箱
	private String email;
	// 电话
	private String phone;
	// 手机
	private String mobile;
	// 用户类型
	private String userType;
	// 用户头像
	private String photo;
	// 最后登陆IP
	private String loginIp;
	// 最后登陆时间
	private Date loginDate;
	// 是否可登录
	private String loginFlag;

	// 备注信息
	private String remarks;
	// 删除标记
	private String delFlag;
	// 二维码
	private String qrcode;
	// 默认为企业分配
	private String datasource;
	// 个性签名
	private String sign;
	// 商城开通状态(0未开通 1已开通)
	private String mallState;
	// 合伙人开通状态(0未开通 1已开通)
	private String partnerState;
	// 项目开通状态(0未开通 1已开通)
	private String projectState;
	// 能管在线开通状态(0未开通 1已开通)
	private String ngtOnlineState;
	// 微信号
	private String wechat;
	// 地址
	private String address;
	// 用户所属的区域
	private String regionId;
	// 能管在线用户类型（0未开通能管通服务 1管理员 2内部用户 ）
	private String ngtUserType;
	// 所属的系统 1--能管在线、2--分销、3--商城、4--项目
	private String sysTypes;
	// 从事行业
	private String trade;
	// 昵称
	private String dearName;
	// 性别
	private String sex;

}
