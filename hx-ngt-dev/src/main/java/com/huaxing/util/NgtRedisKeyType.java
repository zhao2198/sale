
package com.huaxing.util;

/**
 * Create Date: 2018年5月9日 上午10:35:03
 * 
 * @version: V3.0.1
 * @author: zhao wei
 */
public enum NgtRedisKeyType {
	/** 用户协议：申请开通能管在线 */
	USER_AGREEMENT_PLATFORM_APPLY_NGTOL("user_agreement:apply_ngtol", 1 * 60 * 60 * 24 * 30), NGT_EQUIPMENT__ALL("ngt:equipment:all",
			1 * 60 * 60 * 24 * 30), NGT_POWER_COST("ngt:power:cost", 1 * 60 * 60 * 24 * 30), NGT_EQUIPMENT_TYPE_ALL("ngt:equipment:type:all",
					1 * 60 * 60 * 24 * 30), NGT_ALARM_TYPE_ALL("ngt:alarm:type:all",
							1 * 60 * 60 * 24 * 30),NGT_DATA_STATISTICAL("ngt:data:statistical", 1 * 60 * 60 * 24 * 30),
	NGT_DATA_STATISTICAL_COUNT_SUM("ngt:data:statistical:count:sum", 1 * 60 * 60 * 24 * 30),
	NGT_TRANSFORMER_CAPACITY("ngt:transformer:capacity", 1 * 60 * 60 * 24 * 30),NGT_ALARM_GRADE_ALL("ngt:alarm:grade:all", 1 * 60 * 60 * 24 * 30);
	private String prefix;
	private long expiredTime; // Second

	NgtRedisKeyType(String prefix, long expiredTime) {
		this.prefix = prefix;
		this.expiredTime = expiredTime;
	}

	public String getPrefix() {
		return prefix;
	}

	public long getExpiredTime() {
		return expiredTime;
	}

	@Override
	public String toString() {
		return this.getPrefix();
	}

}
