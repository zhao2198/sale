package com.huaxing.bean;

import java.util.List;

import com.huaxing.common.entity.DateTimeEntity;
import com.huaxing.dto.EquipmentConfigParamDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备参数配置表;
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentParamConfig extends DateTimeEntity {
	private static final long serialVersionUID = 1L;

	// 通道状态
	private String channelState;
	// 参数名称
	private String paramName;
	// 相位（A、B、C、N）
	private String phase;
	// 测点地址
	private String branchCode;
	// 测点类型(电压、电流等)
	private String paramType;
	// 是否传输
	private String transmission;
	// 重要等级
	private String grade;
	// 传送周期
	private String cycle;
	// 所属采集卡
	private String acquisitioncardChannel;
	// 是否重要参数
	private String ismain;
	// 参数标签（在线监测用）
	private String measuretag;
	// 变压器高低压侧数据来源
	private String paramSource;
	// 参数单位
	private String paramUnit;
	// 项目编号
	private String projectCode;
	// 所属公司
	private String companyId;
	// 备注信息
	private String remarks;
	// 启用标记
	private String enableFlag;
	// 接收前台传入的设备参数对象私有属性List
	private List<EquipmentConfigParamDTO> list;
}
