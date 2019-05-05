package com.huaxing.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huaxing.bean.Clazz;
import com.huaxing.common.web.transfer.TransferObject;

import lombok.Data;

/**
 * 班次的详情类
 * 
 * @author Xie Ning
 * @date 2018-06-25 09:17:23
 */
@Data
public class ClazzVo extends TransferObject<Clazz> {
	private static final long serialVersionUID = 1L;
	private String id;// 班次的id
	// 班次编号
	private String code;
	// 班次名称
	private String name;
	// 开始时间
	@JsonFormat(pattern = "HH:mm:ss")
	private Date startTime;
	// 结束时间
	@JsonFormat(pattern = "HH:mm:ss")
	private Date endTime;
	// 所属公司
	private String companyId;
	// 备注
	private String remarks;

}
