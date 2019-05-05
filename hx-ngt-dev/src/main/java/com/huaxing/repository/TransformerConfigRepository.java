package com.huaxing.repository;

import java.util.List;
import java.util.Map;

import com.huaxing.bean.TransformerConfig;

/**
 * 变压器参数配置dao
 * Create Date:	2018年7月2日 下午4:29:19
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface TransformerConfigRepository {
	/**新增变压器参数配置  王晓超 2018年7月2日16:29:42*/
	int createTransformerConfig(List<TransformerConfig> list);
	/**删除变压器配置详情  王晓超 2018年7月2日17:24:12*/
	int deleteTransformerConfig(Map<String, String> map);
	/**查看变压器配置的详情*/
	List<TransformerConfig> getTransformerConfigInfo(Map<String, String> map);

}
