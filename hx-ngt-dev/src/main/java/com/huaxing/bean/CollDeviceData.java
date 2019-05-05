package com.huaxing.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.huaxing.common.entity.DateTimeEntity;
import com.huaxing.common.utils.DateUtils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 所需采集器的数据entity Create Date: 2018年5月31日 下午3:47:04
 * 
 * @version: V3.0.1
 * @author: feng yi
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CollDeviceData extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 网关Id
	private String collectorId;
	// 设备id
	private String equipmentId;
	// 数据类型（变压器1高、2低压），0其它设备
	private String dataType;
	// A相电压
	private BigDecimal aphaseVoltage;
	// B相电压
	private BigDecimal bphaseVoltage;
	// C相电压
	private BigDecimal cphaseVoltage;
	// A相电流
	private BigDecimal aphaseCurrent;
	// B相电流
	private BigDecimal bphaseCurrent;
	// C相电流
	private BigDecimal cphaseCurrent;
	// N相电流
	private BigDecimal nphaseCurrent;
	// 有功功率-总
	private BigDecimal sumActivePower;
	// 有功功率-A
	private BigDecimal aphaseActivePower;
	// 有功功率-B
	private BigDecimal bphaseActivePower;
	// 有功功率-C
	private BigDecimal cphaseActivePower;
	// 无功功率-总
	private BigDecimal sumReactivePower;
	// 无功功率-A
	private BigDecimal aphaseReactivePower;
	// 无功功率-B
	private BigDecimal bphaseReactivePower;
	// 无功功率-C
	private BigDecimal cphaseReactivePower;
	// 视在功率-总
	private BigDecimal sumApparentPower;
	// 视在功率-A
	private BigDecimal aphaseApparentPower;
	// 视在功率-B
	private BigDecimal bphaseApparentPower;
	// 视在功率-C
	private BigDecimal cphaseApparentPower;
	// 功率因数-总
	private BigDecimal sumPowerFactor;
	// 功率因数-A
	private BigDecimal aphasePowerFactor;
	// 功率因数-B
	private BigDecimal bphasePowerFactor;
	// 功率因数-C
	private BigDecimal cphasePowerFactor;
	// 电压相角-A
	private BigDecimal aphaseVoltagePhaseAngle;
	// 电压相角-B
	private BigDecimal bphaseVoltagePhaseAngle;
	// 电压相角-C
	private BigDecimal cphaseVoltagePhaseAngle;
	// 电流相角-A
	private BigDecimal aphaseCurrentPhaseAngle;
	// 电流相角-B
	private BigDecimal bphaseCurrentPhaseAngle;
	// 电流相角-C
	private BigDecimal cphaseCurrentPhaseAngle;
	// 电流THD-A
	private BigDecimal aphaseCurrentThd;
	// 电流THD-B
	private BigDecimal bphaseCurrentThd;
	// 电流THD-C
	private BigDecimal cphaseCurrentThd;
	// 累计电量
	private BigDecimal acmultElectr;
	// 本次电量
	private BigDecimal currentElectr;
	// 总有功电度
	private BigDecimal totalActivePower;
	// 总无功电度
	private BigDecimal totalReactivePower;
	// 电流三相不平衡度
	private BigDecimal threePhaseCurrentImbalance;
	// 线电压12
	private BigDecimal lineVoltageOneTwo;
	// 线电压23
	private BigDecimal lineVoltageTwoThree;
	// 线电压31
	private BigDecimal lineVoltageThreeOne;
	// 电网频率
	private BigDecimal gridFrequency;
	// 温度
	private BigDecimal temperature;
	// 湿度
	private BigDecimal humidity;
	// 开关状态
	private BigDecimal switchStatus;
	// 采集时间
	private String acquisitionTime;
	// 公司主键
	private String companyId;
	// 网关用途标识
	private String gatewayType;
	// 网关版本
	private String gatewayVersion;
	// 项目编号
	private String gatewayCode;
	// 测点编号
	private String stationNum;

	public Date getAcquisitionTime() {
		if (null != this.acquisitionTime) {
			return DateUtils.convert2Date(this.acquisitionTime, DateUtils.LONG_FORMAT);
		}
		return null;
	}

	public void setAcquisitionTime(String acquisitionTime) {
		this.acquisitionTime = acquisitionTime;
	}

	// for query
	@ApiModelProperty(value = "是否启用(0未启用，1已启用)", required = false)
	private String enableFlag;

	@ApiModelProperty(value = "时间类型", required = true)
	@NotBlank(message = "时间类型不能为空")
	private String typeDate;

	@ApiModelProperty(value = "参数标签", required = true)
	@NotBlank(message = "参数标签不能为空")
	private String measuretag;

	@ApiModelProperty(value = "开始时间", required = true)
	private String startTime;

	@ApiModelProperty(value = "结束时间", required = true)
	private String endTime;

	@ApiModelProperty(value = "设备Id", required = true)
	@NotBlank(message = "设备Id不能为空")
	private String equipment;

	@ApiModelProperty(value = "采集时间集合", required = false)
	private List<String> xDatas;

	@ApiModelProperty(value = "采集值集合", required = false)
	private List<String> yDatas;

	@ApiModelProperty(value = "采集时间", required = false)
	private String xData;

	@ApiModelProperty(value = "采集值", required = false)
	private String yData;
}
