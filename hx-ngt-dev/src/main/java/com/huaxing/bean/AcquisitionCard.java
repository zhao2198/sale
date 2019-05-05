package com.huaxing.bean;
import lombok.Data;
import com.huaxing.common.entity.DateTimeEntity;


/**
 * 采集卡entity
 * Create Date:	2018年7月10日 下午3:53:30
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
public class AcquisitionCard extends DateTimeEntity {
	private static final long serialVersionUID = 1L;
	//名称
	private String name;
	//接口数
	private String channelNum;
	//类型
	private String type;
	//备注信息
	private String remarks;

}
