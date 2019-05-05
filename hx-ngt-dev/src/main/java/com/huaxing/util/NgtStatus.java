package com.huaxing.util;

import org.apache.commons.lang3.StringUtils;

import com.huaxing.common.exception.Status;

/**
 * Create Date: 2018年4月25日 下午2:43:44
 * 
 * @version: V3.0.1
 * @author: zhao wei
 */
public enum NgtStatus implements Status {

	NGTUSER_NAME_EXISTS(40002, "用户登录名重复"),

	NGTROLE_NAME_EXISTS(40003, "角色名或英文名称重复"),

	NGTROLE_EXISTS_USER(40006, "角色下存在用户"),

	PERIODIC_MAIN_CONTENT_TEMPLATE_NAME_EXISTS(40009, "模板名称已经存在"),

	NGTEUQIPMENT_CODE_EXISTS(40010, "设备编号重复"),

	NGTCOLLECTOR_CODE_EXISTS(40011, "网关编号重复"),

	NGTEUQIPMENTHOUSE_CODE_EXISTS(40012, "物料编号重复"),

	NGTEUQIPMENTHOUSE_STOCKNUMBER_BAD(40013, "库存数不足"),

	NGTEUQIPMENTPARAM_CONFIG_BAD(40014, "该网关无配置信息"),

	NGTALARM_SETTING_EXISTS(40015, "同一参数的告警类型不能重复"),

	NGTALARM_SETTING_LIST_ISNULL(40016, "告警配置信息表不能为空，删除该设备的相关设置请在设置列表中删除"),

	NGTEQU_PARAMCONFIG_STATIONNUM_EXISTS(40017, "该测点地址已存在"),

	NGTEUQIPMENT_NAME_EXISTS(40018, "设备名称重复"),

	NGTTeam_NAME_EXISTS(40101, "班组名称重复"),

	NGTCLAZZ_EXISTS(40102, "该班次已经存在"),

	NGT_DUTY_STARTTIME_IS_EMPTY(40103, "值班计划的开始时间为空"),

	NGT_DUTY_ENDTIME_IS_EMPTY(40104, "值班计划的结束时间为空"),

	NGT_DUTY_TEAM_EMPTY(40105, "值班班组不存在"),

	NGT_DUTY_CLAZZ_EMPTY(40106, "值班班次不存在"),

	NGT_DUTY_TEAM_EXISTS(40107, "班组存在"),

	NGT_DUTY_CLAZZ_EXISTS(40108, "班次已经存在"),

	DATE_LEGNTH_NOT_RIGHT(40109, "时间长度不符合要求"),

	START_BIGGER_THAN_END(40110, "开始时间小于结束时间"),

	NGT_DUTY_PLAN_CODE_USABLE(40111, "值班计划的编号可用"),

	NGT_DUTY_PLAN_CODE_UNUSABLE(40112, "值班计划编号已经存在，不可用"),

	NGT_DUTY_PLAN_CLAZZ_AND_TEAM_UNUSABLE(40113, "所选值班的班组和班次均不存在"),

	NGT_DUTY_PLAN_PUBLISH_STATE_UNUSEABLE(40114, "值班计划的发布状态不符合要求，请查看api文档或者联系管理员"),

	NGT_DUTY_PLAN_INTERVALDAY_UNUSEABLE(40115, "值班计划的间隔天数与开始日期和结束日期不匹配，请重新输入"),

	NGT_DUTY_PLAN_START_EQUALS_END(40116, "值班计划的开始日期和结束日期相同，间隔时间应为0"),

	NGT_DUTY_MISSION_SAVE_FAILED(40117, "值班任务保存失败！"),

	NGT_DUTY_MISSION_TODO_SAVE_FAILED(40118, "值班任务创建待办任务失败！"),

	NGT_TIMEUNIT_UNUSABLE(40119, "时间的单位不正确，可选项：0--日  1--月  2--年！"),

	NGT_STARTTIME_AND_UNIT_UNUSABLE(40120, "开始时间与时间单位不符"),

	NGT_ENDTIME_AND_UNIT_UNUSABLE(40121, "结束时间与时间单位不符"),

	NGT_TIME_AND_UNIT_UNUSABLE(40122, "开始时间和结束时间均与时间单位不符"),

	NGT_EQUIPMENT_TYPE_NAME_IS_EXISTS(40123, "名称重复"),

	MISSION_STATUS_ERROR(40020, "任务状态不正确"),

	SCHEME_STATUS_ERROR(40021, "计划状态不正确"),

	NGT_EQUIPMENT_TYPE_IS_INITED(40125, "已经初始化完成"),

	NGT_EQUIPMENT_TYPE_IS_EXISTS_CHILD(40126, "存在子节点"),

	NGT_PLAN_IS_UNPUBLISHABLE(40127, "值班计划不存在或者已经发布"),

	NGT_ONLINE_BUSINESS_CODE(40019, "code is exists"),

	METER_VALUE_EXISTS(40128, "表底数已经保存过，不要再次保存"),

	METER_MISSION_NOT_RUNABLE(40129, "抄表任务尚未到执行时间"),

	COLLECTORMODEL_NAME_EXISTS(40130, "采集器型号名称重复"),

	ACQUISITIONCARD_NAME_EXISTS(40131, "采集卡名称重复"),

	EQUIPMENTPARAM_NAME_EXISTS(40132, "参数名称重复"),

	PATROL_STATE_UNUSABLE(40133, "巡检状态不正确"),

	PATROL_SCHEMETYPE_UNUSABLE(40134, "巡检性质不正确"),

	REPAIRFORM_TYPE_UNUSABLE(40135, "修复单的修复类型格式不正确"),

	REPAIRFORM_STATE_UNUSABLE(40136, "修复单的修复结果格式不正确"),

	CLIENT_DEVICE_LOCKED(20002, "client device locked.");

	Integer code;
	String reason;

	NgtStatus(Integer code) {
		this.code = code;
		this.reason = StringUtils.EMPTY;
	}

	NgtStatus(Integer code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public static NgtStatus getResponseStatus(int status) {
		for (NgtStatus responseStatus : NgtStatus.values()) {
			if (responseStatus.getCode() == status) {
				return responseStatus;
			}
		}
		return null;
	}

	@Override
	public int getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String getMessage() {

		return reason;
	}

}
