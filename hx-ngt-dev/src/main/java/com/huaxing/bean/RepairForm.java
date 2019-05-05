package com.huaxing.bean;

import java.util.Date;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author zhao wei
 * @date 2018-07-04 09:41:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RepairForm extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// for statics select result
	private String handlerId;// 受理人id
	private String handlerName;// 受理人名字

	private String eqpId;// 设备id
	private String eqpName;// 设备的名字

	private String type;// 修复单类型（0 故障开单 1 缺陷开单）
	private String urgency;// 紧急程度（0 一般 1 重要 2紧急）
	private String state;// 修复单状态（0未受理 1已受理 2 待验收 3 已验收 4验收未通过）
	// repairResult
	private long takeTime; // 修复所花费的时间
	private String date;// 统计时从数据库中查询的结果
	private int count;// 查询到的数据

	// 所属公司id
	private String companyId;
	// 设备名成
	private String equipmentName;
	// 设备表主键
	private String equipmentId;
	// 建筑
	private String buildingId;
	// 组织
	private String organizationId;
	// 分类
	private String categoryId;
	// 配电房
	private String distributionRoomId;
	// 修复单单号
	private String code;

	// 原始希完工日
	private Date historyHopeTime;
	// 希望完工日
	private Date hopeTime;
	// 附件路径
	private String url;
	// 发现人
	private String findPeople;
	// 是否转记（0未转记 1 已转记）
	private String isTurnDown;
	// 发现时间
	private Date findTime;

	// 备注
	private String remarks;

	// 启用标记
	private String enableFlag;
	// 是否存在修复记录
	private String recordIsExitsFlag;
	// 发布标记 0未发布 1已发布
	private String publishFlag;

	// for view
	private String createName;
	private String handName;
	private String repairResult;

	// for select
	// 开始日期
	private Date startDate;

	// 结束日期
	private Date endDate;

}
