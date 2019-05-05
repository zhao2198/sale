package com.huaxing.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxing.bean.Equipment;
import com.huaxing.bean.MeterreadingLogSubmit;
import com.huaxing.bean.MeterreadingLogUpdata;
import com.huaxing.bean.MeterreadingMission;
import com.huaxing.common.exception.ResponseStatus;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.DateUtils;
import com.huaxing.common.utils.ListUtils;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.utils.StringUtils;
import com.huaxing.repository.MeterreadingMissionRepository;
import com.huaxing.service.MeterreadingLogSubmitService;
import com.huaxing.service.MeterreadingLogUpdateService;
import com.huaxing.service.MeterreadingMissionService;
import com.huaxing.util.NgtConvertUtil;
import com.huaxing.util.NgtDefine;
import com.huaxing.util.NgtDefine.MeterreadingMissionStatusEnum;
import com.huaxing.util.NgtStatus;
import com.huaxing.vo.EchartsOption;
import com.huaxing.vo.Legend;
import com.huaxing.vo.MeterReadingStatistics;
import com.huaxing.vo.MeterreadingMissionContentVO;
import com.huaxing.vo.MeterreadingMissionDayListVO;
import com.huaxing.vo.MeterreadingMissionVO;
import com.huaxing.vo.MeterreadingStatisticsVo;
import com.huaxing.vo.Meterreadingdetail;
import com.huaxing.vo.Series;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MeterreadingMissionServiceImpl extends BaseServiceImpl<MeterreadingMission> implements MeterreadingMissionService {
	@Autowired
	private MeterreadingMissionRepository missionRepository;
	@Autowired
	private MeterreadingLogSubmitService submitLogService;
	@Autowired
	private MeterreadingLogUpdateService saveValueLogService;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = missionRepository;
	}

	@Override
	public PagingList<MeterreadingMissionVO> queryList(MeterreadingMission meterreadingMission, PagingAttribute pageAttr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagingList<MeterreadingMissionDayListVO> getDayViewMissionlist(String userId, Date date, PagingAttribute pagAttr) {
		MeterreadingMission queryParam = new MeterreadingMission();// 创建查询参数，查询一家公司下面所有设定的抄表计划列表
		queryParam.setHandlerId(userId);
		queryParam.setDay(date);
		List<MeterreadingMission> missionList = missionRepository.queryList(queryParam);
		if (missionList == null)
			return null;
		List<MeterreadingMissionDayListVO> voList = missionListToDayViewVoList(missionList);
		List<MeterreadingMissionDayListVO> distList = ListUtils.limitPage(voList, pagAttr.getCurrentPage(), pagAttr.getPageSize());
		PagingList<MeterreadingMissionDayListVO> pagingList = new PagingList<>(distList, new Paging(distList.size(), pagAttr));
		return pagingList;
	}

	/**
	 * 将任务列表，提取为以表计为单位，每个表计中包含任务列表，任务包含任务时间点、当前抄表额，任务状态 Lian weimao CreateTime:2018年7月19日 下午2:16:46
	 * 
	 * @param schemeContentList
	 * @return
	 */
	private List<MeterreadingMissionDayListVO> missionListToDayViewVoList(List<MeterreadingMission> missionList) {
		List<MeterreadingMissionDayListVO> voList = new ArrayList<>();// 创建一个返回的voList
		// 将数据以表计为key，重新分组，value是表计下的任务列表
		Map<String, List<MeterreadingMission>> meterIdToMissionListMap = missionList.stream()
				.collect(Collectors.groupingBy(MeterreadingMission::getMeterId));
		meterIdToMissionListMap.forEach((k, v) -> {
			MeterreadingMissionDayListVO voTemp = new MeterreadingMissionDayListVO();// 创建临时对象
			voTemp.setMeterId(k);
			NgtConvertUtil.convertEquipment(voTemp, k, "meterName");// 转换表计名称
			List<MeterreadingMissionContentVO> contentList = new ArrayList<>();
			v.forEach(mission -> {// 遍历，获取任务的详情
				MeterreadingMissionContentVO contentTemp = new MeterreadingMissionContentVO();
				BeanUtils.copyProperties(mission, contentTemp);
				contentList.add(contentTemp);
			});
			voTemp.setMissionList(contentList.stream().sorted((m1, m2) -> {
				return Integer.parseInt(m1.getTime()) - Integer.parseInt(m2.getTime());
			}).collect(Collectors.toList()));
			voList.add(voTemp);
		});
		return voList;
	}

	@Override
	public PagingList<MeterreadingMissionContentVO> getMeterDayViewMissionlist(String meterId, String userId, Date date, PagingAttribute pagAttr) {
		MeterreadingMission queryParam = new MeterreadingMission();// 创建查询参数，查询一家公司下面所有设定的抄表计划列表
		queryParam.setHandlerId(userId);
		queryParam.setDay(date);
		queryParam.setMeterId(meterId);
		List<MeterreadingMission> missionList = missionRepository.queryList(queryParam);
		if (missionList == null)
			return null;
		List<MeterreadingMissionContentVO> voList = missionListToDayViewVoList(missionList).get(0).getMissionList();
		List<MeterreadingMissionContentVO> distList = ListUtils.limitPage(voList, pagAttr.getCurrentPage(), pagAttr.getPageSize());
		PagingList<MeterreadingMissionContentVO> pagingList = new PagingList<>(distList, new Paging(distList.size(), pagAttr));
		return pagingList;
	}

	@Override
	@Transactional
	public RestResult<String> saveMeterValue(MeterreadingMission mission) {
		MeterreadingMission source = missionRepository.get(mission);
		if (source == null)
			return RestResultUtil.failed("ID无效");
		if (!StringUtils.equalsAnyOne(source.getState(), MeterreadingMissionStatusEnum.DAI_CHAO_BIAO.getCode(),
				MeterreadingMissionStatusEnum.DAI_TI_JIAO.getCode())) {
			return RestResultUtil.getResult(NgtStatus.MISSION_STATUS_ERROR, "当前任务状态不允许提交抄表数值");
		}
		String time = source.getTime();
		Date day = source.getDay();
		BigDecimal value = source.getValue();
		int dayCompareResult = day.compareTo(DateUtils.getDate(new Date()));
		String nowTime = DateUtils.dateToString(new Date(), "HHmm");
		int timeCompareResult = DateUtils.stringToDate(time, "HHmm").compareTo(DateUtils.stringToDate(nowTime, "HHmm"));
		if (dayCompareResult > 0 || dayCompareResult == 0 && timeCompareResult > 0) {
			return RestResultUtil.getResult(NgtStatus.METER_MISSION_NOT_RUNABLE);
		}
		if (mission.getValue().compareTo(value) == 0) {
			return RestResultUtil.getResult(NgtStatus.METER_VALUE_EXISTS);
		}
		mission.setState(NgtDefine.MeterreadingMissionStatusEnum.DAI_TI_JIAO.getCode());
		mission.setUpdate(mission.getHandlerId());
		int count = missionRepository.update(mission);
		saveSaveValueLog(mission, source);
		return result(count);
	}

	/**
	 * 保存抄表数表更日志 Lian weimao CreateTime:2018年7月19日 下午5:13:47
	 * 
	 * @param now
	 * @param before
	 */
	private void saveSaveValueLog(MeterreadingMission now, MeterreadingMission before) {
		MeterreadingLogUpdata saveValueLog = new MeterreadingLogUpdata();
		saveValueLog.setMissionId(now.getId());
		saveValueLog.setBeforeValue(before.getValue());
		saveValueLog.setAfterValue(now.getValue());
		saveValueLog.setBeforeHandlerId(before.getHandlerId());
		saveValueLog.setAfterHandlerId(now.getHandlerId());
		saveValueLog.setBeforeCreateDate(before.getUpdateDate());
		saveValueLog.setAfterCreateDate(new Date());
		saveValueLogService.save(saveValueLog);
	}

	@Override
	@Transactional
	public RestResult<String> saveAndSubmitMeterValue(MeterreadingMission mission) {
		MeterreadingMission source = missionRepository.get(mission);
		if (source == null)
			return RestResultUtil.failed("ID无效");
		if (mission.getValue() != null) {
			RestResult<String> saveResult = saveMeterValue(mission);
			if (saveResult.getCode() == NgtStatus.METER_VALUE_EXISTS.getCode()) {
				mission.setHandlerId(null);
			} else if (saveResult.getCode() != ResponseStatus.OK.getCode()) {
				return saveResult;
			}
			source = missionRepository.get(mission);
		} else {
			String time = source.getTime();
			Date day = source.getDay();
			int dayCompareResult = day.compareTo(DateUtils.getDate(new Date()));
			String nowTime = DateUtils.dateToString(new Date(), "HHmm");
			int timeCompareResult = DateUtils.stringToDate(time, "HHmm").compareTo(DateUtils.stringToDate(nowTime, "HHmm"));
			if (dayCompareResult > 0 || dayCompareResult == 0 && timeCompareResult > 0) {
				return RestResultUtil.getResult(NgtStatus.METER_MISSION_NOT_RUNABLE);
			}
		}
		if (!NgtDefine.MeterreadingMissionStatusEnum.DAI_TI_JIAO.getCode().equals(source.getState())) {
			return RestResultUtil.getResult(NgtStatus.MISSION_STATUS_ERROR, "当前状态不允许提交");
		}
		mission.setState(MeterreadingMissionStatusEnum.YI_TI_JIAO.getCode());
		mission.setUpdate(mission.getHandlerId());
		int count = missionRepository.update(mission);
		mission.setHandlerId(source.getHandlerId());
		saveSubmitLog(mission);
		return result(count);
	}

	/**
	 * 保存提交抄表任务的记录 Lian weimao CreateTime:2018年7月19日 下午5:17:36
	 * 
	 * @param mission
	 */
	private void saveSubmitLog(MeterreadingMission mission) {
		MeterreadingLogSubmit submitLog = new MeterreadingLogSubmit();
		submitLog.setMissionId(mission.getId());
		submitLog.setCreateBy(mission.getHandlerId());
		submitLogService.save(submitLog);
	}

	@Override
	@Transactional
	public RestResult<String> submitDateValue(String handlerId, Date date) {
		MeterreadingMission queryParam = new MeterreadingMission();
		queryParam.setHandlerId(handlerId);
		queryParam.setDay(date);
		List<MeterreadingMission> unSubmitList = getUnSubmitList(queryParam);
		queryParam.setState(MeterreadingMissionStatusEnum.DAI_TI_JIAO.getCode());
		queryParam.setUpdate(handlerId);
		missionRepository.submitDate(queryParam);
		saveSubmitLogList(unSubmitList);
		return RestResultUtil.ok();
	}

	private void saveSubmitLogList(List<MeterreadingMission> unSubmitList) {
		List<MeterreadingLogSubmit> logList = new ArrayList<>();
		unSubmitList.forEach(mission -> {
			MeterreadingLogSubmit logTemp = new MeterreadingLogSubmit();
			logTemp.setMissionId(mission.getId());
			logTemp.setCreateBy(mission.getHandlerId());
			logList.add(logTemp);
		});
		submitLogService.saveBatch(logList);
	}

	@Override
	public List<MeterreadingMission> getUnSubmitList(MeterreadingMission mission) {
		MeterreadingMission queryParam = new MeterreadingMission();
		queryParam.setHandlerId(mission.getHandlerId());
		queryParam.setDay(mission.getDay());
		queryParam.setState(MeterreadingMissionStatusEnum.DAI_TI_JIAO.getCode());
		return missionRepository.queryList(queryParam);
	}

	@Override
	@Transactional
	public RestResult<String> updateBatch(List<MeterreadingMission> updateMissionList) {
		for (MeterreadingMission meterreadingMission : updateMissionList) {
			missionRepository.update(meterreadingMission);
		}
		return RestResultUtil.ok();
	}

	/*
	 * 按日统计抄表 Create Date 2018年7月30日 上午10:40:13
	 * 
	 * @author xie ning
	 */
	@Override
	public MeterReadingStatistics staDay(MeterreadingMission queryData) {
		MeterReadingStatistics statistics = new MeterReadingStatistics();
		List<MeterreadingMission> missions = missionRepository.queryMissionList(queryData);// 某一天所选设备的抄表记录，升序排序
		List<MeterreadingStatisticsVo> vos = genListData(missions, queryData);// 封装列表数据
		statistics.setRows(vos);
		EchartsOption option = genEchartsData(vos, queryData);// 封装echarts数据
		statistics.setOption(option);
		return statistics;
	}

	private EchartsOption genEchartsData(List<MeterreadingStatisticsVo> datas, MeterreadingMission queryData) {
		EchartsOption option = new EchartsOption();
		List<String> xData = getAllTimes();// x轴数据
		Legend legend = new Legend();
		List<Equipment> eqps = getEquipments(queryData);
		List<String> names = new ArrayList<String>();// legend
		for (Equipment e : eqps) {
			String name = e.getName();
			names.add(name);
		}
		List<Series> seriess = genSeriess(eqps, datas, queryData);
		option.setXAxis_data(xData);
		option.setSeries(seriess);
		legend.setData(names);
		option.setLegend(legend);
		return option;
	}

	/****
	 * 封装Series数据
	 * 
	 * @param eqps
	 * @param datas
	 * @return
	 */
	private List<Series> genSeriess(List<Equipment> eqps, List<MeterreadingStatisticsVo> datas, MeterreadingMission queryData) {
		List<Series> list = new ArrayList<Series>();
		for (Equipment e : eqps) {
			Series s = new Series();
			s.setName(e.getName());
			List<BigDecimal> values = genData(e, datas, queryData);// 给value=null值找到最近的一次抄表值
			s.setDatas(values);
			list.add(s);
		}
		return list;
	}

	/*****
	 * 处理null值
	 * 
	 * @param e
	 * @param datas
	 * @return
	 */
	private List<BigDecimal> genData(Equipment e, List<MeterreadingStatisticsVo> datas, MeterreadingMission queryData) {
		List<BigDecimal> values = new ArrayList<BigDecimal>(48);
		String meterId = e.getId();
		for (MeterreadingStatisticsVo vo : datas) {
			String empId = vo.getMeterId();
			if (meterId.equals(empId)) {
				List<Meterreadingdetail> details = vo.getMetersDetail();
				for (Meterreadingdetail detail : details) {
					if (detail.getValue() == null) {
						String time = detail.getTime();
						queryData.setTime(time);
						detail.setValue(getRecentValue(queryData));
					}
					values.add(detail.getValue());
				}
			}
		}
		return values;
	}

	/*****
	 * 获取最近一次的抄表数
	 * 
	 * @param queryData
	 * @return
	 */
	private BigDecimal getRecentValue(MeterreadingMission queryData) {
		BigDecimal value = missionRepository.getRecentValue(queryData);
		if (value == null) {
			value = BigDecimal.ZERO;
		}
		return value;
	}

	/****
	 * 获取所有的表计的列表
	 * 
	 * @param queryData
	 * @return
	 */
	private List<Equipment> getEquipments(MeterreadingMission queryData) {
		List<Equipment> eqps = missionRepository.getEqps(queryData);
		return eqps;
	}

	/****
	 * 获取48个抄表时间点
	 * 
	 * @return
	 */
	private List<String> getAllTimes() {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		String str = "0000";
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		Date d2 = c.getTime();
		List<String> times = new ArrayList<String>();
		long timesecond = date.getTime();
		while (timesecond <= d2.getTime()) {
			String tmp = sdf.format(date);
			times.add(tmp);// 时间格式为00:30
			timesecond = timesecond + 30 * 60 * 1000;// 时间加上半小时
			if (timesecond == d2.getTime()) {
				break;
			}
			date.setTime(timesecond);
		}
		return times;
	}

	/*****
	 * 封装列表数据
	 * 
	 * @param missions
	 * @return
	 */
	private List<MeterreadingStatisticsVo> genListData(List<MeterreadingMission> missions, MeterreadingMission queryData) {
		List<MeterreadingStatisticsVo> vos = genDayStatisticVos(queryData);// 建数据模型 每个设备对应48个抄表时间点
		for (MeterreadingMission mission : missions) {
			String meterId = mission.getMeterId();
			String time = mission.getTime();
			BigDecimal value = mission.getValue();
			for (MeterreadingStatisticsVo vo : vos) {
				if (meterId != null && meterId.equals(vo.getMeterId())) {
					List<Meterreadingdetail> details = vo.getMetersDetail();
					for (Meterreadingdetail detail : details) {
						if (detail.getTime().equals(time)) {
							detail.setValue(value);
						}
					}
					vo.setMetersDetail(details);
				}
			}
		}
		return vos;
	}

	/****
	 * 建数据模型，每个表计对应48个时间点及抄表值
	 */
	private List<MeterreadingStatisticsVo> genDayStatisticVos(MeterreadingMission queryData) {
		List<MeterreadingStatisticsVo> volist = new ArrayList<MeterreadingStatisticsVo>();
		List<Equipment> equipmewnts = getEquipments(queryData);
		for (Equipment e : equipmewnts) {
			MeterreadingStatisticsVo vo = new MeterreadingStatisticsVo();
			vo.setMeterId(e.getId());
			vo.setMeterName(e.getName());
			List<Meterreadingdetail> details = genDayStaDetails();
			vo.setMetersDetail(details);
			volist.add(vo);
		}
		return volist;
	}

	/****
	 * 每个表计对应一个List<Meterreadingdetail>
	 * 
	 * @param e
	 * @return
	 */
	private List<Meterreadingdetail> genDayStaDetails() {
		List<Meterreadingdetail> details = new ArrayList<Meterreadingdetail>();
		List<String> times = getAllTimes();
		for (String time : times) {
			Meterreadingdetail detail = new Meterreadingdetail();
			detail.setTime(time);
			detail.setValue(null);
			details.add(detail);
		}
		return details;
	}

	/****
	 * 转换时间的显示方式转换 eg. 0030--00:30
	 * 
	 * @param time
	 * @return
	 */
	private static String transStrTimeToTime(String time) {
		String t = null;
		if (time != null && !time.isEmpty()) {
			t = time.substring(0, (time.length() / 2)) + ":" + time.substring((time.length() / 2), (time.length()));
		}
		return t;
	}

	/*****
	 * 按月统计抄表
	 */
	@Override
	public MeterReadingStatistics staMonth(MeterreadingMission queryData) {
		List<MeterreadingMission> max_month = missionRepository.getRecentlyMeterreading(queryData);// 获取各个设备 本月抄表的最后一次抄表数
		// String dayTime = queryData.getDayTime();// 目标月
		// String backMonth = DateUtils.mouthMove2(dayTime, -1);// 本月的前一个月
		// queryData.setDayTime(backMonth);
		List<MeterreadingMission> min_month = missionRepository.getRecentlyBaseMeterreading(queryData);// 获取本月的最开始一次抄表值
		// queryData.setDayTime(dayTime);
		return analyData(max_month, min_month, queryData);// 封装数据，用电量前台计算
	}

	/*****
	 * 封装数据 rows option等
	 * 
	 * @param max_month
	 *            当月所有表计的最后一条抄表值
	 * @param min_month
	 *            当月月所有表计的首次抄表值
	 * @return
	 */
	private MeterReadingStatistics analyData(List<MeterreadingMission> max_month, List<MeterreadingMission> min_month,
			MeterreadingMission queryData) {
		Map<String, MeterreadingStatisticsVo> map = genMonthStatisticVos(queryData);// 建模
		EchartsOption option = new EchartsOption();
		for (MeterreadingMission mission : min_month) {// 各个设备的首次抄表数
			String mId = mission.getMeterId();
			if (map.containsKey(mId)) {
				MeterreadingStatisticsVo vo = map.get(mId);
				List<Meterreadingdetail> details = new ArrayList<Meterreadingdetail>();
				Meterreadingdetail detail = new Meterreadingdetail();
				// String month = transMonth2String(mission.getDay());
				detail.setTime(queryData.getDayTime());
				BigDecimal value = mission.getValue();
				if (value == null) {
					value = BigDecimal.ZERO;
				}
				detail.setValue(value);
				details.add(detail);
				vo.setMetersDetail(details);
				map.put(mId, vo);// 覆盖原来的vo
			}
		}
		Legend legend = new Legend();
		List<Series> series = new ArrayList<Series>();
		for (MeterreadingMission m : max_month) {// 本月各个设备的最后抄表数
			String meterId = m.getMeterId();
			if (map.containsKey(meterId)) {
				MeterreadingStatisticsVo vo = map.get(meterId);
				Series s = new Series();
				s.setName(m.getMeterName());
				List<BigDecimal> datas = new ArrayList<BigDecimal>();
				List<Meterreadingdetail> details = vo.getMetersDetail();
				Meterreadingdetail d = new Meterreadingdetail();
				String month = transMonth2String(m.getDay());
				d.setTime(month);
				BigDecimal value = m.getValue();
				if (value == null) {
					value = details.get(0).getValue();
				}
				d.setValue(value);
				details.add(d);
				vo.setMetersDetail(details);
				map.put(meterId, vo);// 覆盖原来的vo
				datas.add(details.get(0).getValue());
				datas.add(details.get(1).getValue());
				List<String> eqipmentNames = new ArrayList<String>();// legend 属性封装
				eqipmentNames.add(m.getMeterName());
				legend.setData(eqipmentNames);
				s.setDatas(datas);
				series.add(s);
			}
		}
		List<MeterreadingStatisticsVo> vos = new ArrayList<MeterreadingStatisticsVo>();
		for (String str : map.keySet()) {
			MeterreadingStatisticsVo vo = map.get(str);
			vos.add(vo);
		}
		List<String> xData = new ArrayList<String>();// x轴
		String dayTime = queryData.getDayTime();// 目标月
		String backMonth = DateUtils.mouthMove2(dayTime, -1);
		xData.add(backMonth);
		xData.add(dayTime);
		option.setLegend(legend);
		option.setSeries(series);
		option.setXAxis_data(xData);
		MeterReadingStatistics statics = new MeterReadingStatistics();
		statics.setRows(vos);
		statics.setOption(option);
		return statics;
	}

	private String transMonth2String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String month = null;
		try {
			month = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("月份转换为String异常");
		}
		return month;
	}

	/****
	 * 建数据模型,目标表计的所有值
	 */
	private Map<String, MeterreadingStatisticsVo> genMonthStatisticVos(MeterreadingMission queryData) {
		Map<String, MeterreadingStatisticsVo> map = new HashMap<String, MeterreadingStatisticsVo>();
		List<Equipment> equipmewnts = getEquipments(queryData);
		for (Equipment e : equipmewnts) {
			MeterreadingStatisticsVo vo = new MeterreadingStatisticsVo();
			String meterId = e.getId();
			vo.setMeterId(e.getId());
			vo.setMeterName(e.getName());
			map.put(meterId, vo);
		}
		return map;
	}

}
