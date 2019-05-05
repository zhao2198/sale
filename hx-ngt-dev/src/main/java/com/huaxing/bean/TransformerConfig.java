package com.huaxing.bean;

import com.huaxing.common.entity.DateTimeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 变压器参数配置entity Create Date: 2018年7月2日 下午3:28:58
 * 
 * @version: V3.0.1
 * @author: wang xiao chao
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TransformerConfig extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	// 类型,类似于key
	private String type;
	// 值
	private String value;
	// 公司id
	private String companyId;

	// mine
	private String operatingCapacity;// 运行容量
	private String ratedCapacity;// 额定容量
	private String contractCapacity;// 合同容量
}
