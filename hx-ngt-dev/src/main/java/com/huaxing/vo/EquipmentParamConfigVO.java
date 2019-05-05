package com.huaxing.vo;

import com.huaxing.bean.EquipmentParamConfig;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备参数配置表; InnoDB free: 9216 kB
 * 
 * @author feng yi
 * @date 2018-07-10 16:16:18
 */
@ApiModel(value = "设备参数配置展示表;")
@Data
@EqualsAndHashCode(callSuper = false)
public class EquipmentParamConfigVO extends TransferObject<EquipmentParamConfig> {
	private static final long serialVersionUID = 1L;

	// id
	@ApiModelProperty(value = "id", required = false)
	private String id;
	// 通道状态
	@ApiModelProperty(value = "通道状态", required = false)
	private String channelState;
	// 参数名称
	@ApiModelProperty(value = "参数名称", required = false)
	private String paramName;
	// 相位（A、B、C、N）
	@ApiModelProperty(value = "相位（A、B、C、N）", required = false)
	private String phase;
	// 分支编码
	@ApiModelProperty(value = "分支编码", required = false)
	private String branchCode;
	// 测点类型(电压、电流等)
	@ApiModelProperty(value = "测点类型(电压、电流等)", required = false)
	private String paramType;
	// 是否传输
	@ApiModelProperty(value = "是否传输", required = false)
	private String transmission;
	// 重要等级
	@ApiModelProperty(value = "重要等级", required = false)
	private String grade;
	// 传送周期
	@ApiModelProperty(value = "传送周期", required = false)
	private String cycle;
	// 所属采集卡
	@ApiModelProperty(value = "所属采集器", required = false)
	private String acquisitioncardChannel;
	// 是否重要参数
	@ApiModelProperty(value = "是否重要参数", required = false)
	private String ismain;
	// 参数标签（在线监测用）
	@ApiModelProperty(value = "参数标签（在线监测用）", required = false)
	private String measuretag;
	// 变压器高低压侧数据来源
	@ApiModelProperty(value = "变压器高低压侧数据来源", required = false)
	private String paramSource;
	// 参数单位
	@ApiModelProperty(value = "参数单位", required = false)
	private String paramUnit;
	// 项目编号
	@ApiModelProperty(value = "项目编号", required = false)
	private String projectCode;

	@ApiModelProperty(value = "是否启用(0未启用，1已启用)", required = false)
	private String enableFlag;
}
