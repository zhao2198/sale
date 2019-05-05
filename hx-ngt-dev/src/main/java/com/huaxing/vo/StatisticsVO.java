package com.huaxing.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 首页综合统计数据
 * Create Date:	2018年7月3日 下午2:42:28
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
@Data
@ApiModel(value="首页综合统计数据")
public class StatisticsVO {
	@ApiModelProperty(value="总告警",required=true)
	private Integer totalAlarmFault;//告警总数
	@ApiModelProperty(value="已确认",required=true)
	private Integer confirmAlarmFault;// 已确认的告警总数
	@ApiModelProperty(value="未确认",required=true)
	private Integer noConfirmAlarmFault;	//未确认的告警总数
//	@ApiModelProperty(value="已屏蔽",required=true)  这里暂时去掉已屏蔽的返回信息
//	private Integer shieldingAlarmFault;// 已屏蔽的告警总数
	
	@ApiModelProperty(value="总修复",required=true)
	private Integer totalRepair; //总修复
	@ApiModelProperty(value="未受理",required=true)
	private Integer noRepair;//未受理
	@ApiModelProperty(value="受理中",required=true)
	private Integer ingRepair;//受理中
	@ApiModelProperty(value="已修复",required=true)
	private Integer yesRepair;//已修复
	
	
	@ApiModelProperty(value="总定保",required=true)
	private Integer totalProtect; //总定保
	@ApiModelProperty(value="未受理",required=true)
	private Integer noPotect;//未受理
	@ApiModelProperty(value="定保中",required=true)
	private Integer ingProtect;//定保中
	@ApiModelProperty(value="已定保",required=true)
	private Integer yesProtect;//已定保
	
	@ApiModelProperty(value="总巡检",required=true)
	private Integer totalPolling; //总巡检
	@ApiModelProperty(value="未受理",required=true)
	private Integer noPolling;//未受理
	@ApiModelProperty(value="巡检中",required=true)
	private Integer ingPolling;//巡检中
	@ApiModelProperty(value="已巡检",required=true)
	private Integer yesPolling;//已巡检

	
	
	
}
