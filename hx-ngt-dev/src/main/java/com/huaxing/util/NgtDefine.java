package com.huaxing.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huaxing.common.utils.BigDecimalUtils;

public class NgtDefine {
	public static final String SHARP = "尖";
	public static final String PEAK = "峰";
	public static final String FLAT = "平";
	public static final String VALLEY = "谷";
	public static final String POWER_COST = "电度电费";
	public static final String BASIC_COST = "基本电费";
	public static final String FORCE_COST = "力调电费";
	public static final BigDecimal TAN_PAI_FANG = BigDecimalUtils.getBigValue("1.5");
	public static final BigDecimal MEI_HAO_ZHI = BigDecimalUtils.getBigValue("0.8");
	/**巡检统计*/
	public static final String PLAN_PATROL_COUNT = "计划巡检";
	public static final String ERROR_PATROL_COUNT = "故障巡检";
	public static final String SPECIL_PATROL_COUNT = "特巡";
	public static final String NIGHT_PATROL_COUNT = "夜间巡检";
	public static final String WATCH_PATROL_COUNT = "监察巡检";
	public static final String ONCE_PATROL_COUNT = "临时巡检";
	public static final String DUTY_PATROL_COUNT = "定时巡检";
	public static final String SUCCESS_COUNT = "成功修复";
	public static final String ERROR_COUNT = "未成功修复";
	public static final String NO_COUNT = "未处理";
	
	
	public enum ScheduleStatus {
		/**
		 * 正常
		 */
		NORMAL(0),
		/**
		 * 暂停
		 */
		PAUSE(1);

		private int value;

		private ScheduleStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * 获取普通阶梯map
	 * 
	 * @return
	 */
	public static Map<String, String> getLadderMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "first");
		map.put("2", "second");
		map.put("3", "third");
		map.put("4", "fourth");
		return map;

	}

	/**
	 * 获取电价类型map
	 * 
	 * @return
	 */
	public static Map<String, String> getLadderTypeMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sharp", "0");
		map.put("peak", "1");
		map.put("flat", "2");
		map.put("valley", "3");
		return map;

	}

	/**
	 * 获取尖峰平谷所属时间段map
	 * 
	 * @return
	 */
	public static Map<String, String> getTypeMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sharp", "Sharp");
		map.put("peak", "Peak");
		map.put("flat", "Flat");
		map.put("valley", "Valley");
		return map;
	}

	/**
	 * 获取尖峰平谷时间段的数组
	 * 
	 * @return
	 */
	public static Map<String, List<String>> getTypeListMap() {
		List<String> sharpTimeArr = new ArrayList<String>(), peakTimeArr = new ArrayList<String>(), flatTimeArr = new ArrayList<String>(),
				valleyTimeArr = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("sharp", sharpTimeArr);
		map.put("peak", peakTimeArr);
		map.put("flat", flatTimeArr);
		map.put("valley", valleyTimeArr);
		return map;

	}

	/**
	 * 需要生成CODE的表
	 * 
	 * @return
	 */
	public static Map<String, String> getTableMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("repair", "ngt_repair_form");
		map.put("patrol", "ngt_patrol_mission");
		map.put("periodic", "ngt_periodic_maintenance");
		return map;
	}

	public enum TableEnum {
		/** 数据库表 ： 修复单 */
		REPAIRFORM("ngt_repair_form", "修复单"),
		/** 数据库表 ： 巡检计划 */
		PATROL_SCHEME("ngt_patrol_scheme", "巡检计划"),
		/** 数据库表 ： 巡检任务单 */
		PATROL_MISSION("ngt_patrol_mission", "巡检任务单"),
		/** 数据库表 ： 定保计划 */
		MAINTENANCE_SCHEME("ngt_periodic_maintenance", "定保计划"),
		/** 数据库表 ： 定保任务单 */
		MAINTENANCE_MISSION("ngt_periodic_maintenance_mission", "定保任务单");
		private String tableName;
		private String description;

		private TableEnum(String tableName, String description) {
			this.tableName = tableName;
			this.description = description;
		}

		public String getTableName() {
			return tableName;
		}

		public String getDescription() {
			return description;
		}
	}

	/**
	 * 需要生成CODE的表
	 * 
	 * @return
	 */
	public static Map<String, String> getRepairFormStatusMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "未受理");
		map.put("1", "修复中");
		map.put("2", "待验收");
		map.put("3", "已验收已通过");
		map.put("4", "已验收未通过");
		return map;
	}

	/**
	 * 定时计划的运行方式 Create Date: 2018年7月13日 上午11:35:40
	 * 
	 * @version: V3.0.1
	 * @author: Lian weimao
	 */
	public enum TerminationCondition {
		/** 计划的状态位 ：不首限制 */
		ALWAYS_RUN("0", "不受限制"),
		/** 计划的状态位 ：限定次数 */
		LIMITED_NUMBER("1", "限定次数"),
		/** 计划的状态位 ：限定日期 */
		LIMITED_DATE("2", "限定日期");
		private String code;
		private String description;

		private TerminationCondition(String code, String description) {
			this.code = code;
			this.description = description;
		}

		public String getCode() {
			return code;
		}

		public String getDescription() {
			return description;
		}
	}

	/**
	 * 获取定时计划的运行方式map Lian weimao CreateTime:2018年7月13日 上午11:39:07
	 * 
	 * @return
	 */
	public static Map<String, TerminationCondition> getTerminationConditionMap() {
		Map<String, TerminationCondition> map = new HashMap<String, TerminationCondition>();
		map.put("0", TerminationCondition.ALWAYS_RUN);
		map.put("1", TerminationCondition.LIMITED_NUMBER);
		map.put("2", TerminationCondition.LIMITED_DATE);
		return map;
	}

	/**
	 * 计划的状态位 Create Date: 2018年7月13日 上午11:58:42
	 * 
	 * @version: V3.0.1
	 * @author: Lian weimao
	 */
	public enum SchemeStatus {
		/** 计划的状态位 ：可编辑 */
		EDITABLE("0", "可编辑"),
		/** 计划的状态位 ：已派发任务，等待执行 */
		DISPATCHED("1", "已派发任务，等待执行"),
		/** 计划的状态位 ：已执行任务，等待该下次派发 */
		DONE_WAIT_NEXT("2", "已执行任务，等待下次派发"),
		/** 计划的状态位 ：计划终止 */
		TERMINATED("3", "计划终止"),
		/** 计划的状态位 ：计划暂停 */
		PAUSE("4", "计划暂停"),
		/** 计划的状态位 ：计划恢复 */
		NORMAL("5", "计划恢复"),;
		private String code;
		private String description;

		private SchemeStatus(String code, String description) {
			this.code = code;
			this.description = description;
		}

		public String getCode() {
			return code;
		}

		public String getDescription() {
			return description;
		}
	}

	/**
	 * 获取计划的状态位 Lian weimao CreateTime:2018年7月13日 下午1:35:12
	 * 
	 * @return
	 */
	public static Map<String, SchemeStatus> getSchemeStatusMap() {
		Map<String, SchemeStatus> map = new HashMap<String, SchemeStatus>();
		map.put("0", SchemeStatus.EDITABLE);
		map.put("1", SchemeStatus.DISPATCHED);
		map.put("2", SchemeStatus.DONE_WAIT_NEXT);
		map.put("3", SchemeStatus.TERMINATED);
		return map;
	}

	/**
	 * 获取sql中用来格式化日期的map 0日1月2年
	 * 
	 * @return
	 */
	public static Map<String, String> getFormatSqlStr() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "%Y-%m-%d"); // 日
		map.put("1", "%Y-%m"); // 月
		map.put("2", "%Y"); // 年
		return map;
	}

	public static Map<String, String> getEquipmentTypeMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("3", "配电房");
		map.put("1", "建筑");
		map.put("4", "类别");
		map.put("2", "组织");
		return map;
	}

	public static Map<String, String> getEquipmentTypeNameMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("3", "distribution_room");
		map.put("1", "building");
		map.put("4", "category");
		map.put("2", "organization");
		return map;
	}

	public enum MissionStatus {
		/** 任务单状态位 ： 未受理 */
		UNACCEPT("0", "未受理"),
		/** 任务单状态位 ： 修复中 */
		REPAIRING("1", "修复中"),
		/** 任务单状态位 ： 待验收 */
		WAIT_CHECK("2", "待验收"),
		/** 任务单状态位 ： 已验收已通过 */
		CHECKED_PASS("3", "已验收已通过"),
		/** 任务单状态位 ："已验收未通过 */
		CHECKED_UNPASS("4", "已验收未通过"),
		/** 任务单状态位 ：已终止 */
		TERMINATED("5", "已终止");
		private String code;
		private String description;

		private MissionStatus(String code, String description) {
			this.code = code;
			this.description = description;
		}

		public String getCode() {
			return code;
		}

		public String getDescription() {
			return description;
		}
	}

	public static Map<String, MissionStatus> getMissionStatusMap() {
		Map<String, MissionStatus> map = new HashMap<String, MissionStatus>();
		map.put("0", MissionStatus.UNACCEPT);
		map.put("1", MissionStatus.REPAIRING);
		map.put("2", MissionStatus.WAIT_CHECK);
		map.put("3", MissionStatus.CHECKED_PASS);
		map.put("4", MissionStatus.CHECKED_UNPASS);
		map.put("5", MissionStatus.TERMINATED);
		return map;
	}

	// 0计划巡检,1故障巡检，2特巡，3夜间巡检，4检查巡检，5临时巡检，6定期巡检
	public enum PatrolTypeEnum {
		/** 巡检类型 ：计划巡检 */
		JIHUA("0", "计划巡检"),
		/** 巡检类型 ：故障巡检 */
		GUZHANG("1", "故障巡检"),
		/** 巡检类型 ：特巡 */
		TEXUN("2", "特巡"),
		/** 巡检类型 ：夜间巡检 */
		YEJIAN("3", "夜间巡检"),
		/** 巡检类型 ：监查巡检 */
		JIANCHA("4", "监查巡检"),
		/** 巡检类型 ：临时巡检 */
		LINSHI("5", "临时巡检"),
		/** 巡检类型 ：定期巡检 */
		DINGQI("6", "定期巡检");
		private String code;
		private String description;

		private PatrolTypeEnum(String code, String description) {
			this.code = code;
			this.description = description;
		}

		public String getCode() {
			return code;
		}

		public String getDescription() {
			return description;
		}
	}

	/**
	 * 抄表任务的状态位 Create Date: 2018年7月19日 下午1:46:15
	 * 
	 * @version: V3.0.1
	 * @author: Lian weimao
	 */
	public enum MeterreadingMissionStatusEnum {
		/** 抄表任务的状态位 ：等待抄表 */
		DAI_CHAO_BIAO("0", "等待抄表"),
		/** 抄表任务的状态位 ：等待提交 */
		DAI_TI_JIAO("1", "等待提交"),
		/** 抄表任务的状态位 ：已经提交 */
		YI_TI_JIAO("2", "已经提交");
		private String code;
		private String description;

		private MeterreadingMissionStatusEnum(String code, String description) {
			this.code = code;
			this.description = description;
		}

		public String getCode() {
			return code;
		}

		public String getDescription() {
			return description;
		}
	}

	public static Map<String, MeterreadingMissionStatusEnum> getMeterreadingMissionStatusMap() {
		Map<String, MeterreadingMissionStatusEnum> map = new HashMap<String, MeterreadingMissionStatusEnum>();
		map.put("0", MeterreadingMissionStatusEnum.DAI_CHAO_BIAO);
		map.put("1", MeterreadingMissionStatusEnum.DAI_TI_JIAO);
		map.put("2", MeterreadingMissionStatusEnum.YI_TI_JIAO);
		return map;
	}

	/**
	 * 用电参数查看方式 王晓超2018年7月26日16:00:13
	 * 
	 * @return
	 */
	public static Map<String, String> getElectricityParameterType() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "功率因数");
		map.put("1", "负载率");
		return map;
	}

}
