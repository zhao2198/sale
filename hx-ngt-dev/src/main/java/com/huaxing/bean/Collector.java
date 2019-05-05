package com.huaxing.bean;

import java.util.Date;
import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 采集器表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-06 14:06:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Collector extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 编号
	private String code;
	// 采集器名称
	private String name;
	// 采集器型号
	private String collectorModel;
	// 投运时间
	private Date startTime;
	// 购买日期
	private Date buyTime;
	// 所属建筑
	private String building;
	// 所属组织
	private String organization;
	// 所属配电房
	private String distributionRoom;
	// 所属类别
	private String category;
	// 设备图片
	private String picture;
	// 采集器二维码
	private String qrcode;
	// 运行状态
	private String collState;
	// 用途类型
	private String useType;
	// 版本号
	private String version;
	// 省
	private String provinceCode;
	// 市
	private String cityCode;
	// 区
	private String areaCode;
	// 项目编号
	private String projectCode;
	// 所属公司
	private String companyId;
	// 创建者
	private String createBy;
	// 创建时间
	private Date createDate;
	// 更新者
	private String updateBy;
	// 更新时间
	private Date updateDate;
	// 备注信息
	private String remarks;
	// 启用标记
	private String enableFlag;
	// 在线状态（0代表离线，1代表在线）
	private String onlineState;

	// for select
	private Date beginBeginruntime;

	private Date endBeginruntime;

	private String updateByName;

	private String collectorModelName;

	private String collStateDictName;

	private String buildingName;

	private String organizationName;

	private String categoryName;

	private String distributionRoomName;

	private List<String> files;
}
