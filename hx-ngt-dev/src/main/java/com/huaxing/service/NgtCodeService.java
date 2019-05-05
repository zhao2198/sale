package com.huaxing.service;

import com.huaxing.util.NgtDefine.TableEnum;

public interface NgtCodeService {
	/**
	 * 传入表名，该方法会查询该公司的最后一个单号，并生成一个新单号
	 * 该方法已在内部做了单号的可用验证，外部不需要再次校验
	 * Lian weimao CreateTime:2018年7月14日 下午1:48:20
	 * @param tableType
	 * @param companyId
	 * @return
	 */
	String genCode(TableEnum tableType, String companyId);

	boolean isExistsCode(TableEnum tableType, String code, String companyId);

}
