package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;

/**
 * 修复单统计所需entity Create Date: 2018年9月13日 下午7:30:46
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
public class StatisticsRepairForm extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	private String handlerId;// 受理人id
	private String companyId;// 公司id
	private String equipmentName;// 设备名称
	private String equipmentId; // 设备id
	private String buildingId;// 建筑id
	private String organizationId;// 组织id
	private String categoryId;// 分类id
	private String distributionRoomId;// 配电房
	private String code;// 修复单单号
	private String type;// 修复单类型 （0故障开单1缺陷开单）
	private String urgency;// 紧急程度（0一般1重要2紧急）
	private Date historyHopeTime;// 原希完工日
	private Date hopeTime;// 希望完工日
	private String url;// 附件路径
	private String findPeople;// 发现人
	private String isTurnDown;// 是否转记（0未转记1已转记）
	private Date findTime; // 发现时间
	private String state;// 修复单状态（0未接单1修复中2待验收3验收已通过4验收未通过）
	private String repairResult;// 修复结果（0修复失败1修复成功 null未处理）
	private String recordIsExitsFlag;// 是否存在修复记录
	private String publishFlag;// 发布标记（0未发布1已发布）

	// mine query
	private String[] handlerIds;// 受理人id的数组
	private String[] equipmentNames;// 设备id的数组
	private String startDate;// 查询数据开始时间
	private String endDate;// 查询数据结束时间
	private String dateFormatStr;// sql中用来格式化日期的字符串
	private String dateType;// 日月年类型 0日1月2年
	private String createDateStr;
	private Integer totalCount;//展示总修复数量
}
