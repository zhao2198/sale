package com.huaxing.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxing.bean.Equipment;
import com.huaxing.bean.MeterreadingMission;
import com.huaxing.bean.MeterreadingScheme;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.DateUtils;
import com.huaxing.common.utils.ListUtils;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.utils.StringUtils;
import com.huaxing.dto.MeterreadingSchemeCreateDTO;
import com.huaxing.dto.MeterreadingSchemeUpdateDTO;
import com.huaxing.repository.MeterreadingMissionRepository;
import com.huaxing.repository.MeterreadingSchemeRepository;
import com.huaxing.repository.UserRepository;
import com.huaxing.service.EquipmentService;
import com.huaxing.service.MeterreadingMissionService;
import com.huaxing.service.MeterreadingSchemeService;
import com.huaxing.util.NgtConvertUtil;
import com.huaxing.util.NgtDefine.MeterreadingMissionStatusEnum;
import com.huaxing.vo.MeterreadingSchemeEquipmentTimeDetailListVO;
import com.huaxing.vo.MeterreadingSchemeEquipmentTimeListVO;
import com.huaxing.vo.MeterreadingSchemeMeterListVO;
import com.huaxing.vo.MeterreadingSchemeVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MeterreadingSchemeServiceImpl extends BaseServiceImpl<MeterreadingScheme> implements MeterreadingSchemeService {
	@Autowired
	private MeterreadingSchemeRepository schemeRepository;
	@Autowired
	private MeterreadingMissionRepository missionRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MeterreadingMissionService meterreadingMissionService;
	@Autowired
	private EquipmentService equipmentService;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = schemeRepository;
	}

	@Override
	public PagingList<MeterreadingSchemeVO> queryList(MeterreadingScheme meterreadingScheme, PagingAttribute pageAttr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagingList<MeterreadingSchemeMeterListVO> getMeterListHasScheme(String companyId, PagingAttribute pagAttr) {
		MeterreadingScheme queryParam = new MeterreadingScheme();// 创建查询参数，查询一家公司下面所有设定的抄表计划列表
		queryParam.setCompanyId(companyId);
		List<MeterreadingScheme> schemeContentList = schemeRepository.queryList(queryParam);
		if (schemeContentList == null)
			return null;
		List<MeterreadingSchemeMeterListVO> voList = schemeListToEquipmentListVoList(schemeContentList);
		List<MeterreadingSchemeMeterListVO> distList = ListUtils.limitPage(voList, pagAttr.getCurrentPage(), pagAttr.getPageSize());
		PagingList<MeterreadingSchemeMeterListVO> pagingList = new PagingList<>(distList, new Paging(voList.size(), pagAttr));
		return pagingList;
	}

	/**
	 * 从计划列表中提取设备列表，并设置设备当前是否有抄表任务 Lian weimao CreateTime:2018年7月18日 上午11:21:27
	 * 
	 * @param schemeContentList
	 * @return
	 */
	private List<MeterreadingSchemeMeterListVO> schemeListToEquipmentListVoList(List<MeterreadingScheme> schemeContentList) {
		List<MeterreadingSchemeMeterListVO> voList = new ArrayList<>();
		schemeContentList.stream().map(MeterreadingScheme::getMeterId)// 提取列表中的表计ID，并生成stream流
				.distinct()// 去重复项
				.forEach(meterId -> {// 遍历ID列表，并且创建一个表计列表，包含表计ID，表计名称
					MeterreadingSchemeMeterListVO temp = new MeterreadingSchemeMeterListVO();
					temp.setMeterId(meterId);
					NgtConvertUtil.convertEquipment(temp, meterId, "meterName");
					voList.add(temp);
				});
		Date today = DateUtils.getDate(new Date());// 当前日期
		List<String> hasMissionIdList = schemeContentList.stream().filter(schemeContent -> (schemeContent.getDay().compareTo(today) == 0))// 过滤计划执行时间有效的计划
				.map(MeterreadingScheme::getMeterId)// 提取列表中的表计ID，并生成stream流
				.distinct()// 去重复项
				.collect(Collectors.toList());
		voList.stream().forEach(vo -> {// 遍历之前生成的表计列表，如果表计的ID对应的计划在hasMissionIdList中，则设置表计的hasTodayMission属性为true
			if (hasMissionIdList.stream().anyMatch(meterId -> meterId.equals(vo.getMeterId())))
				vo.setTodayHasMission(true);
		});
		return voList;
	}

	@Override
	public PagingList<MeterreadingSchemeEquipmentTimeListVO> getEquipmentDateViewVoList(String meterId, PagingAttribute pagAttr) {
		MeterreadingScheme queryParam = new MeterreadingScheme();// 创建查询参数，查询一家公司下面所有设定的抄表计划列表
		queryParam.setMeterId(meterId);
		List<MeterreadingScheme> schemeContentList = schemeRepository.queryList(queryParam);
		if (schemeContentList == null)
			return null;
		List<MeterreadingSchemeEquipmentTimeListVO> voList = schemeListToEquipmentTimeListVoList(schemeContentList);
		List<MeterreadingSchemeEquipmentTimeListVO> distList = ListUtils.limitPage(voList, pagAttr.getCurrentPage(), pagAttr.getPageSize());
		PagingList<MeterreadingSchemeEquipmentTimeListVO> pagingList = new PagingList<>(distList, new Paging(voList.size(), pagAttr));
		return pagingList;
	}

	/**
	 * 从指定表计的所有计划列表中，提取以时间为单位的列表，并有每个时间点，所有的抄表日期和抄表人员 Lian weimao CreateTime:2018年7月18日 下午3:35:54
	 * 
	 * @param schemeContentList
	 * @return
	 */
	private List<MeterreadingSchemeEquipmentTimeListVO> schemeListToEquipmentTimeListVoList(List<MeterreadingScheme> schemeContentList) {
		final List<MeterreadingSchemeEquipmentTimeListVO> voList = new ArrayList<MeterreadingSchemeEquipmentTimeListVO>();// 要返回的VO集合
		NgtConvertUtil ngtConvertUtil = new NgtConvertUtil();// 传唤hanglerId到Name时使用
		Map<String, List<MeterreadingScheme>> schemeTimeMap = schemeContentList.stream().collect(Collectors.groupingBy(MeterreadingScheme::getTime));// 将计划的集合转换为map，key为时间点，value为该时间点下的计划集合
		schemeTimeMap.forEach((k, v) -> {// 对上面生成的map进行遍历
			MeterreadingSchemeEquipmentTimeListVO voTemp = new MeterreadingSchemeEquipmentTimeListVO();// 创建临时vo
			voTemp.setTime(DateUtils.stringToDate(k, "HHmm"));// 设置时间
			voTemp.setStartDate(v.parallelStream().map(MeterreadingScheme::getDay).min((s1, s2) -> (s1.compareTo(s2))).get());// 设置开始时间
			voTemp.setEndDate(v.parallelStream().map(MeterreadingScheme::getDay).max((s1, s2) -> (s1.compareTo(s2))).get());// 设置结束时间
			StringBuilder handlerName = new StringBuilder();// 创建sb，拼接处理人的名称
			v.stream().map(scheme -> {
				return scheme.getHandlerIds().split(",");
			})// 重新映射时间点下计划集合，只保留处理人ID
					.flatMap(Arrays::stream)// 合并处理人ID流
					.distinct()// 去重、排序
					.sorted().forEach(handlerId -> {// 使用转换工具，将ID转换为名称，并保存到vo对象中
						handlerName.append(ngtConvertUtil.convertUserName(handlerId)).append(",");
					});
			voTemp.setHandlerNames(handlerName.toString().substring(0, handlerName.length() - 1));
			voList.add(voTemp);
		});

		return voList.stream()// list返回之前，根据时间点进行再次排序
				.sorted(Comparator.comparing(MeterreadingSchemeEquipmentTimeListVO::getTime)).collect(Collectors.toList());
	}

	@Override
	public PagingList<MeterreadingSchemeEquipmentTimeDetailListVO> getEquipmentDateDetailViewVoList(String meterId, String time,
			PagingAttribute pagAttr) {
		MeterreadingScheme queryParam = new MeterreadingScheme();// 创建查询参数，查询一家公司下面所有设定的抄表计划列表
		queryParam.setMeterId(meterId);
		queryParam.setTime(time);
		List<MeterreadingScheme> schemeContentList = schemeRepository.queryList(queryParam);
		if (schemeContentList == null)
			return null;
		List<MeterreadingSchemeEquipmentTimeDetailListVO> voList = schemeListToEquipmentTimeDetailListVoList(schemeContentList);
		List<MeterreadingSchemeEquipmentTimeDetailListVO> distList = ListUtils.limitPage(voList, pagAttr.getCurrentPage(), pagAttr.getPageSize());
		PagingList<MeterreadingSchemeEquipmentTimeDetailListVO> pagingList = new PagingList<>(distList, new Paging(voList.size(), pagAttr));
		return pagingList;
	}

	/**
	 * 从指定表计，指定时间点的所有计划列表中，提取列表，每个项目包括开始、结束日期，抄表人、id Lian weimao CreateTime:2018年7月19日 上午9:27:25
	 * 
	 * @param schemeContentList
	 * @return
	 */
	private List<MeterreadingSchemeEquipmentTimeDetailListVO> schemeListToEquipmentTimeDetailListVoList(List<MeterreadingScheme> schemeContentList) {
		final List<MeterreadingSchemeEquipmentTimeDetailListVO> voList = new ArrayList<>();// 要返回的VO集合
		NgtConvertUtil ngtConvertUtil = new NgtConvertUtil();// 传唤hanglerId到Name时使用
		schemeContentList.stream()// 对计划列表进行排序，优先根据开始日期排序，再次根据结束如期排序
				.sorted((s1, s2) -> (s1.getDay().compareTo(s2.getDay()))).forEachOrdered(scheme -> {// 遍历设置属性
					MeterreadingSchemeEquipmentTimeDetailListVO voTemp = new MeterreadingSchemeEquipmentTimeDetailListVO();
					BeanUtils.copyProperties(scheme, voTemp);
					List<String> nameList = new ArrayList<>();
					Stream.of(scheme.getHandlerIds().split(",")).distinct().forEach(handlerId -> {
						nameList.add(ngtConvertUtil.convertUserName(handlerId));
					});
					String handlerNames = nameList.stream().sorted().collect(Collectors.joining(","));
					voTemp.setHandlerNames(handlerNames);
					voList.add(voTemp);
				});
		return voList;
	}

	@Override
	@Transactional
	public RestResult<String> save(MeterreadingSchemeCreateDTO schemeCreateDTO) {
		validateCreateSchemeParams(schemeCreateDTO);// 数据校验
		// 从数据库中查询中符合当前条件的计划列表
		List<MeterreadingScheme> beforeSchemeList = queryBeforeSchemeList(schemeCreateDTO);
		// 按照前台传入的条件，生成一分计划列表
		List<MeterreadingScheme> currentSchemeList = analyzeSchemeListFromCreateDTO(schemeCreateDTO);
		// 分析西数据库中的计划列表和当前的新计划列表,创建需要新增的计划列表
		List<MeterreadingScheme> insertSchemeList = currentSchemeList;
		if (beforeSchemeList != null && beforeSchemeList.size() > 0) {
			insertSchemeList = analyzeSchemeChange(beforeSchemeList, currentSchemeList);
		}
		// TODO beforeSchemeList里的项目要全部删除
		// 删除重复的计划
		if (beforeSchemeList != null && beforeSchemeList.size() != 0) {
			schemeRepository.deleteBatch(beforeSchemeList.stream().map(MeterreadingScheme::getId).toArray(String[]::new));
		}
		// 保存创建的计划
		if (insertSchemeList != null) {
			insertSchemeList = insertSchemeList.stream().filter(scheme -> {
				Date day = DateUtils.getDate(scheme.getDay());
				Date today = DateUtils.getDate(new Date());
				int nowTime = Integer.parseInt(new SimpleDateFormat("HHmm").format(new Date()));
				int time = Integer.parseInt(scheme.getTime());
				return day.after(today) || day.equals(today) && time > nowTime;
			}).collect(Collectors.toList());
			if (insertSchemeList.size() > 0) {
				schemeRepository.saveBatch(insertSchemeList);
			}
		}
		// 获取当前的任务列表
		List<MeterreadingMission> beforeMissionList = queryBeforeMissionList(schemeCreateDTO);
		// 按照前台传入的条件，生成一分计划列表
		List<MeterreadingMission> currentMissionList = analyzeMissionListFromCreateDTO(schemeCreateDTO);
		// 分析现存任务列表和新增任务列表，并生成出一个任务的新增和修改列表
		List<MeterreadingMission> updateMissionList = new ArrayList<>();
		List<MeterreadingMission> insertMissionList = currentMissionList;
		if (beforeMissionList != null && beforeMissionList.size() > 0) {
			insertMissionList = new ArrayList<>();
			analyzeMissionChange(beforeMissionList, currentMissionList, insertMissionList, updateMissionList);
			// 对需要修改的任务做出修改
			if (updateMissionList != null && updateMissionList.size() > 0) {
				missionRepository.updateHandlerIdsBatch(updateMissionList);
			}
		}
		// 对需要新增的任务进行新增
		if (insertMissionList != null) {
			insertMissionList = insertMissionList.stream().filter(mission -> {
				Date day = DateUtils.getDate(mission.getDay());
				Date today = DateUtils.getDate(new Date());
				int nowTime = Integer.parseInt(new SimpleDateFormat("HHmm").format(new Date()));
				int time = Integer.parseInt(mission.getTime());
				return day.after(today) || day.equals(today) && time > nowTime;
			}).collect(Collectors.toList());
			if (insertMissionList.size() > 0)
				missionRepository.saveBatch(insertMissionList);
		}
		return RestResultUtil.ok();
	}

	/**
	 * 分析数据库现存的任务列表和页面传入的任务列表，找出需要变更的地方，并返回新增和修改列表 Lian weimao CreateTime:2018年7月20日 下午5:04:53
	 * 
	 * @param beforeMissionList
	 * @param currentMissionList
	 * @param insertMissionList
	 * @param updateMissionList
	 */
	private void analyzeMissionChange(List<MeterreadingMission> beforeMissionList, List<MeterreadingMission> currentMissionList,
			List<MeterreadingMission> insertMissionList, List<MeterreadingMission> updateMissionList) {
		// 总变压器 1200 2018-01-01 张三，李四<br>
		// key value
		// 201801011200 >> 总变压器 1200 2018-01-01 张三，李四
		Map<String, MeterreadingMission> dayTimeToMissionMap = beforeMissionList.stream().collect(Collectors.toMap(m -> {
			String key = DateUtils.dateToString(m.getDay(), "yyyyMMdd") + m.getTime();
			log.debug("key:" + key);
			return key;
		}, m -> m));
		currentMissionList.forEach(m -> {
			String key = DateUtils.dateToString(m.getDay(), "yyyyMMdd") + m.getTime();
			if (dayTimeToMissionMap.containsKey(key)) {
				MeterreadingMission updateTemp = dayTimeToMissionMap.get(key);
				String beforeHandlerIds = updateTemp.getHandlerIds();
				String currentHandlerIds = m.getHandlerIds();
				updateTemp.setHandlerIds(Stream.concat(Stream.of(beforeHandlerIds.split(",")), Stream.of(currentHandlerIds.split(","))).distinct()
						.sorted().collect(Collectors.joining(",")));
				updateTemp.setUpdate(updateTemp.getUpdateBy());
				updateMissionList.add(updateTemp);
			} else {
				insertMissionList.add(m);
			}
		});
	}

	/**
	 * 从前台传入的计划中，创建出一个任务列表<br>
	 * 抄表计划的前台传入数据格式<br>
	 * 表计： 总变压器<br>
	 * 开始日期： 2018-01-01<br>
	 * 结束日期： 2018-01-03<br>
	 * 抄表时间： 12:00 13:00<br>
	 * ID 表计 时间点 抄表日期 所有抄表人<br>
	 * 总变压器 1200 2018-01-01 张三，李四<br>
	 * 总变压器 1300 2018-01-01 张三，李四<br>
	 * 总变压器 1200 2018-01-02 张三，李四<br>
	 * 总变压器 1300 2018-01-02 张三，李四<br>
	 * 总变压器 1200 2018-01-03 张三，李四<br>
	 * 总变压器 1300 2018-01-03 张三，李四<br>
	 * Lian weimao CreateTime:2018年7月20日 下午3:41:19<br>
	 * 
	 * @param schemeCreateDTO
	 * @return
	 */
	private List<MeterreadingMission> analyzeMissionListFromCreateDTO(MeterreadingSchemeCreateDTO schemeCreateDTO) {
		String meterId = schemeCreateDTO.getMeterId();
		Date startDate = schemeCreateDTO.getStartDate();
		Date endDate = schemeCreateDTO.getEndDate();
		String[] handlerIdsArr = schemeCreateDTO.getHandlerIds();
		String handlerIds = Arrays.stream(handlerIdsArr).collect(Collectors.joining(","));
		String[] times = schemeCreateDTO.getTimes();
		List<MeterreadingMission> missionList = new ArrayList<>();
		List<Date> dayList = DateUtils.getEveryDateUnit(startDate, endDate, Calendar.DAY_OF_MONTH);
		dayList.forEach(day -> {
			Arrays.asList(times).forEach(time -> {
				MeterreadingMission temp = new MeterreadingMission();
				temp.setUUID();
				temp.setMeterId(meterId);
				temp.setDay(day);
				temp.setTime(time);
				temp.setHandlerIds(handlerIds);
				temp.setCreate(schemeCreateDTO.getCreateBy());
				temp.setState(MeterreadingMissionStatusEnum.DAI_CHAO_BIAO.getCode());
				missionList.add(temp);
			});
		});
		return missionList;
	}

	/**
	 * 根据前台传入的计划的条件，查询数据库的计划列表 Lian weimao CreateTime:2018年7月20日 下午4:56:11
	 * 
	 * @param schemeCreateDTO
	 * @return
	 */
	private List<MeterreadingScheme> queryBeforeSchemeList(MeterreadingSchemeCreateDTO schemeCreateDTO) {
		MeterreadingScheme queryParam = new MeterreadingScheme();
		queryParam.setMeterId(schemeCreateDTO.getMeterId());
		queryParam.setStartDate(schemeCreateDTO.getStartDate());
		queryParam.setEndDate(schemeCreateDTO.getEndDate());
		queryParam.setTimes(schemeCreateDTO.getTimes());
		return schemeRepository.queryList(queryParam);
	}

	/**
	 * 根据前台传入的计划的条件，查询数据库的任务列表 Lian weimao CreateTime:2018年7月20日 下午4:54:46
	 * 
	 * @param schemeCreateDTO
	 * @return
	 */
	private List<MeterreadingMission> queryBeforeMissionList(MeterreadingSchemeCreateDTO schemeCreateDTO) {
		MeterreadingMission missionQueryParam = new MeterreadingMission();
		missionQueryParam.setMeterId(schemeCreateDTO.getMeterId());
		missionQueryParam.setStartDate(schemeCreateDTO.getStartDate());
		missionQueryParam.setEndDate(schemeCreateDTO.getEndDate());
		missionQueryParam.setTimes(schemeCreateDTO.getTimes());
		return missionRepository.queryList(missionQueryParam);

	}

	/**
	 * 分析数据库现存的计划列表和页面传入的计划列表，找出需要变更的地方 Lian weimao CreateTime:2018年7月20日 下午4:36:06
	 * 
	 * @param beforeSchemeList
	 * @param currentSchemeList
	 * @return
	 */
	private List<MeterreadingScheme> analyzeSchemeChange(List<MeterreadingScheme> beforeSchemeList, List<MeterreadingScheme> currentSchemeList) {
		// 总变压器 1200 2018-01-01 张三，李四<br>
		// 201801011200 >> 张三，李四
		Map<String, String> dayTimeToHandlerIdsMap = beforeSchemeList.stream().collect(Collectors.toMap(s -> {
			return DateUtils.dateToString(s.getDay(), "yyyyMMdd") + s.getTime();
		}, MeterreadingScheme::getHandlerIds));
		// List<MeterreadingScheme> insertSchemeList = new ArrayList<>();
		// 使用当前的计划列表，如果找出了原计划存在的内容，则把两个计划的抄表人合并
		currentSchemeList.forEach(s -> {
			String key = DateUtils.dateToString(s.getDay(), "yyyyMMdd") + s.getTime();
			if (dayTimeToHandlerIdsMap.containsKey(key)) {
				String beforeHandlerIds = dayTimeToHandlerIdsMap.get(key);
				String currentHandlerIds = s.getHandlerIds();
				s.setHandlerIds(Stream.concat(Stream.of(beforeHandlerIds.split(",")), Stream.of(currentHandlerIds.split(","))).distinct().sorted()
						.collect(Collectors.joining(",")));

			}
		});
		return currentSchemeList;
	}

	/**
	 * 从前台传入的计划中，创建出一个计划列表<br>
	 * 抄表计划的前台传入数据格式<br>
	 * 表计： 总变压器<br>
	 * 开始日期： 2018-01-01<br>
	 * 结束日期： 2018-01-03<br>
	 * 抄表时间： 12:00 13:00<br>
	 * ID 表计 时间点 抄表日期 所有抄表人<br>
	 * 总变压器 1200 2018-01-01 张三，李四<br>
	 * 总变压器 1300 2018-01-01 张三，李四<br>
	 * 总变压器 1200 2018-01-02 张三，李四<br>
	 * 总变压器 1300 2018-01-02 张三，李四<br>
	 * 总变压器 1200 2018-01-03 张三，李四<br>
	 * 总变压器 1300 2018-01-03 张三，李四<br>
	 * Lian weimao CreateTime:2018年7月20日 下午3:41:19<br>
	 * 
	 * @param schemeCreateDTO
	 * @return
	 */
	private List<MeterreadingScheme> analyzeSchemeListFromCreateDTO(MeterreadingSchemeCreateDTO schemeCreateDTO) {
		String meterId = schemeCreateDTO.getMeterId();
		Date startDate = schemeCreateDTO.getStartDate();
		Date endDate = schemeCreateDTO.getEndDate();
		String[] handlerIdsArr = schemeCreateDTO.getHandlerIds();
		String handlerIds = Arrays.stream(handlerIdsArr).collect(Collectors.joining(","));
		String[] times = schemeCreateDTO.getTimes();
		List<MeterreadingScheme> schemeList = new ArrayList<>();
		List<Date> dayList = DateUtils.getEveryDateUnit(startDate, endDate, Calendar.DAY_OF_MONTH);
		dayList.forEach(day -> {
			Arrays.asList(times).forEach(time -> {
				MeterreadingScheme temp = new MeterreadingScheme();
				temp.setUUID();
				temp.setMeterId(meterId);
				temp.setDay(day);
				temp.setTime(time);
				temp.setHandlerIds(handlerIds);
				temp.setCreate(schemeCreateDTO.getCreateBy());
				schemeList.add(temp);
			});
		});
		return schemeList;
	}

	/**
	 * 验证dto里面的数据 Lian weimao CreateTime:2018年7月20日 上午10:55:57
	 * 
	 * @param schemeCreateDTO
	 */
	private void validateCreateSchemeParams(MeterreadingSchemeCreateDTO schemeCreateDTO) {
		String meterId = schemeCreateDTO.getMeterId();
		Date startDate = schemeCreateDTO.getStartDate();
		Date endDate = schemeCreateDTO.getEndDate();
		String[] handlerIds = schemeCreateDTO.getHandlerIds();
		String[] times = schemeCreateDTO.getTimes();
		// 验证表计ID
		Validate.notBlank(meterId, "meterId不能为空");
		Equipment meter = equipmentService.getById(meterId);
		Validate.notNull(meter, "meterId无效");
		// 验证startDate和endDate
		Validate.notNull(startDate, "startDate不能为空");
		Validate.notNull(endDate, "endDate不能为空");
		Validate.validState(!startDate.after(endDate), "startDate不能晚于endDate");
		// 验证handlerIds
		Validate.notNull(handlerIds, "handlerIds不能为空");
		Validate.validState(handlerIds.length != 0, "handlerIds不能为空");
		NgtConvertUtil ngtConvertUtil = new NgtConvertUtil();
		Arrays.asList(handlerIds).forEach(handlerId -> {
			Validate.notBlank(ngtConvertUtil.convertUserName(handlerId), "handlerIds存在无效数据");
		});
		schemeCreateDTO.setHandlerIds(Arrays.asList(handlerIds).stream().distinct().sorted().toArray(String[]::new));
		// 验证times
		Validate.notNull(times, "times不能为空");
		Validate.validState(times.length != 0, "times不能为空");
		Arrays.asList(times).forEach(time -> {
			Validate.matchesPattern(time, "^([0-1]\\d|2[0-3])(00|30)$", "times:时间点格式错误，支持【1200,1230】，前两位代表小时，后两位代表分钟，分钟仅支持00和30");
		});
		schemeCreateDTO.setTimes(
				Arrays.asList(times).stream().distinct().sorted((t1, t2) -> (Integer.parseInt(t1) - Integer.parseInt(t2))).toArray(String[]::new));
	}

	@Override
	@Transactional
	public RestResult<String> deleteById(String id) {
		MeterreadingScheme scheme = schemeRepository.get(id);
		if (scheme == null)
			return RestResultUtil.failed("id:id无效");

		MeterreadingScheme deleteParam = new MeterreadingScheme();
		deleteParam.setId(id);
		schemeRepository.delete(deleteParam);// 删除计划
		Date today = DateUtils.getDate(new Date());
		if (scheme.getDay().before(today)) {
			scheme.setDay(today);
		}
		missionRepository.delete(scheme);// 删除相关任务
		return RestResultUtil.ok();
	}

	@Override
	@Transactional
	public RestResult<String> deleteByMeterIdAndTime(String meterId, String time) {
		MeterreadingScheme deleteParam = new MeterreadingScheme();
		deleteParam.setMeterId(meterId);
		deleteParam.setTime(time);
		schemeRepository.delete(deleteParam);
		missionRepository.delete(deleteParam);// 删除相关任务
		return RestResultUtil.ok();
	}

	@Override
	@Transactional
	public RestResult<String> deleteByMeterId(String meterId) {
		MeterreadingScheme deleteParam = new MeterreadingScheme();
		deleteParam.setMeterId(meterId);
		schemeRepository.delete(deleteParam);
		missionRepository.delete(deleteParam);// 删除相关任务
		return RestResultUtil.ok();
	}

	@Override
	@Transactional
	public RestResult<String> update(MeterreadingSchemeUpdateDTO updateDTO, String currUserId) {
		String schemeId = updateDTO.getId();
		MeterreadingScheme source = schemeRepository.get(schemeId);
		if (source == null) {
			return RestResultUtil.failed("id:id无效");
		}
		deleteById(schemeId);
		MeterreadingSchemeCreateDTO createSchemeDTO = new MeterreadingSchemeCreateDTO();
		source.setUpdateBy(currUserId);
		BeanUtils.copyProperties(source, createSchemeDTO);
		createSchemeDTO.setHandlerIds(updateDTO.getHandlerIds());
		createSchemeDTO.setStartDate(updateDTO.getDay());
		createSchemeDTO.setEndDate(updateDTO.getDay());
		createSchemeDTO.setTimes(new String[] { source.getTime() });
		return save(createSchemeDTO);
	}

	@Override
	public MeterreadingSchemeEquipmentTimeDetailListVO getById(String id) {
		MeterreadingScheme scheme = schemeRepository.get(id);
		MeterreadingSchemeEquipmentTimeDetailListVO schemeVo = null;
		if (scheme != null) {
			String handlerIds = scheme.getHandlerIds();
			if (!StringUtils.isEmpty(handlerIds)) {
				String[] idArr = handlerIds.split(",");
				String handlerNames = userRepository.getNamesByIds(idArr);
				scheme.setHandlerNames(handlerNames);
			}
			schemeVo = new MeterreadingSchemeEquipmentTimeDetailListVO();
			BeanUtils.copyProperties(scheme, schemeVo);
		}
		return schemeVo;
	}

}
