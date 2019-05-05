package com.huaxing.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.huaxing.bean.CollDeviceData;
import com.huaxing.common.web.transfer.TransferObject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * InnoDB free: 8192 kB
 * 
 * @author feng yi
 * @date 2018-07-16 16:29:36
 */
@ApiModel(value = "设备采集数据")
@Data
@EqualsAndHashCode(callSuper = false)
public class CollDeviceDataVO extends TransferObject<CollDeviceData> {
	private static final long serialVersionUID = 1L;

	//
	@ApiModelProperty(value = "", required = false)
	private String id;
	// 网关Id
	@ApiModelProperty(value = "网关Id", required = false)
	private String collectorId;
	// 设备id
	@ApiModelProperty(value = "设备id", required = false)
	private String equipmentId;
	// 数据类型（变压器1高压、2低压），0其它设备
	@ApiModelProperty(value = "数据类型（变压器1高压、2低压），0其它设备", required = false)
	private String dataType;
	// A相电压
	@ApiModelProperty(value = "A相电压", required = false)
	private BigDecimal aphaseVoltage;
	// B相电压
	@ApiModelProperty(value = "B相电压", required = false)
	private BigDecimal bphaseVoltage;
	// C相电压
	@ApiModelProperty(value = "C相电压", required = false)
	private BigDecimal cphaseVoltage;
	// A相电流
	@ApiModelProperty(value = "A相电流", required = false)
	private BigDecimal aphaseCurrent;
	// B相电流
	@ApiModelProperty(value = "B相电流", required = false)
	private BigDecimal bphaseCurrent;
	// C相电流
	@ApiModelProperty(value = "C相电流", required = false)
	private BigDecimal cphaseCurrent;
	// N相电流
	@ApiModelProperty(value = "N相电流", required = false)
	private BigDecimal nphaseCurrent;
	// 有功功率-总
	@ApiModelProperty(value = "有功功率-总", required = false)
	private BigDecimal sumActivePower;
	// 有功功率-A
	@ApiModelProperty(value = "有功功率-A", required = false)
	private BigDecimal aphaseActivePower;
	// 有功功率-B
	@ApiModelProperty(value = "有功功率-B", required = false)
	private BigDecimal bphaseActivePower;
	// 有功功率-C
	@ApiModelProperty(value = "有功功率-C", required = false)
	private BigDecimal cphaseActivePower;
	// 无功功率-总
	@ApiModelProperty(value = "无功功率-总", required = false)
	private BigDecimal sumReactivePower;
	// 无功功率-A
	@ApiModelProperty(value = "无功功率-A", required = false)
	private BigDecimal aphaseReactivePower;
	// 无功功率-B
	@ApiModelProperty(value = "无功功率-B", required = false)
	private BigDecimal bphaseReactivePower;
	// 无功功率-C
	@ApiModelProperty(value = "无功功率-C", required = false)
	private BigDecimal cphaseReactivePower;
	// 视在功率-总
	@ApiModelProperty(value = "视在功率-总", required = false)
	private BigDecimal sumApparentPower;
	// 视在功率-A
	@ApiModelProperty(value = "视在功率-A", required = false)
	private BigDecimal aphaseApparentPower;
	// 视在功率-B
	@ApiModelProperty(value = "视在功率-B", required = false)
	private BigDecimal bphaseApparentPower;
	// 视在功率-C
	@ApiModelProperty(value = "视在功率-C", required = false)
	private BigDecimal cphaseApparentPower;
	// 功率因数-总
	@ApiModelProperty(value = "功率因数-总", required = false)
	private BigDecimal sumPowerFactor;
	// 功率因数-A
	@ApiModelProperty(value = "功率因数-A", required = false)
	private BigDecimal aphasePowerFactor;
	// 功率因数-B
	@ApiModelProperty(value = "功率因数-B", required = false)
	private BigDecimal bphasePowerFactor;
	// 功率因数-C
	@ApiModelProperty(value = "功率因数-C", required = false)
	private BigDecimal cphasePowerFactor;
	// 电压相角-A
	@ApiModelProperty(value = "电压相角-A", required = false)
	private BigDecimal aphaseVoltagePhaseAngle;
	// 电压相角-B
	@ApiModelProperty(value = "电压相角-B", required = false)
	private BigDecimal bphaseVoltagePhaseAngle;
	// 电压相角-C
	@ApiModelProperty(value = "电压相角-C", required = false)
	private BigDecimal cphaseVoltagePhaseAngle;
	// 电流相角-A
	@ApiModelProperty(value = "电流相角-A", required = false)
	private BigDecimal aphaseCurrentPhaseAngle;
	// 电流相角-B
	@ApiModelProperty(value = "电流相角-B", required = false)
	private BigDecimal bphaseCurrentPhaseAngle;
	// 电流相角-C
	@ApiModelProperty(value = "电流相角-C", required = false)
	private BigDecimal cphaseCurrentPhaseAngle;
	// 电流THD-A
	@ApiModelProperty(value = "电流THD-A", required = false)
	private BigDecimal aphaseCurrentThd;
	// 电流THD-B
	@ApiModelProperty(value = "电流THD-B", required = false)
	private BigDecimal bphaseCurrentThd;
	// 电流THD-C
	@ApiModelProperty(value = "电流THD-C", required = false)
	private BigDecimal cphaseCurrentThd;
	// 累计电量
	@ApiModelProperty(value = "累计电量", required = false)
	private BigDecimal acmultElectr;
	// 本次电量
	@ApiModelProperty(value = "本次电量", required = false)
	private BigDecimal currentElectr;
	// 电流三相不平衡度
	@ApiModelProperty(value = "电流三相不平衡度", required = false)
	private BigDecimal threePhaseCurrentImbalance;
	// 线电压12
	@ApiModelProperty(value = "线电压12", required = false)
	private BigDecimal lineVoltageOneTwo;
	// 线电压23
	@ApiModelProperty(value = "线电压23", required = false)
	private BigDecimal lineVoltageTwoThree;
	// 线电压31
	@ApiModelProperty(value = "线电压31", required = false)
	private BigDecimal lineVoltageThreeOne;
	// 电网频率
	@ApiModelProperty(value = "电网频率", required = false)
	private BigDecimal gridFrequency;
	// 温度
	@ApiModelProperty(value = "温度", required = false)
	private BigDecimal temperature;
	// 湿度
	@ApiModelProperty(value = "湿度", required = false)
	private BigDecimal humidity;
	// 开关状态
	@ApiModelProperty(value = "开关状态", required = false)
	private BigDecimal switchStatus;
	// 采集时间
	@ApiModelProperty(value = "采集时间", required = false)
	private Date acquisitionTime;
	// 公司主键
	@ApiModelProperty(value = "公司主键", required = false)
	private String companyId;
	// 网关用途标识
	@ApiModelProperty(value = "网关用途标识", required = false)
	private String gatewayType;
	// 网关版本
	@ApiModelProperty(value = "网关版本", required = false)
	private String gatewayVersion;
	// 项目编号
	@ApiModelProperty(value = "项目编号", required = false)
	private String gatewayCode;
	// 测点编号
	@ApiModelProperty(value = "测点编号", required = false)
	private String stationNum;
	// 创建时间
	@ApiModelProperty(value = "创建时间", required = false)
	private Date createDate;
	// 删除标记
	@ApiModelProperty(value = "删除标记", required = false)
	private String delFlag;
	// 启用标记
	@ApiModelProperty(value = "启用标记", required = false)
	private String enableFlag;
	// 总有功电度
	@ApiModelProperty(value = "总有功电度", required = false)
	private BigDecimal totalActivePower;
	// 总无功电度
	@ApiModelProperty(value = "总无功电度", required = false)
	private BigDecimal totalReactivePower;

	// for query
	@ApiModelProperty(value = "采集时间", required = false)
	private List<String> xDatas;

	@ApiModelProperty(value = "采集值", required = false)
	private List<String> yDatas;

}
