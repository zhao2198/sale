package com.huaxing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxing.bean.StaticsPatrolPersion;
import com.huaxing.bean.StatisticsPatrolPerson;
import com.huaxing.common.paging.Paging;
import com.huaxing.common.paging.PagingAttribute;
import com.huaxing.common.paging.PagingList;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.BigDecimalUtils;
import com.huaxing.common.utils.DateUtils;
import com.huaxing.repository.StatisticsRepository;
import com.huaxing.service.PatrolStasticsService;
import com.huaxing.util.NgtDefine;
import com.huaxing.vo.BarsAndLinesEchartsBase;
import com.huaxing.vo.BarsAndLinesEchartsVO;
import com.huaxing.vo.Series;
import com.huaxing.vo.StatisticsPatrolPersonVo;

import lombok.extern.slf4j.Slf4j;

/**
 * Create Date: 2018年7月25日 下午5:34:06
 * 
 * @version: V3.0.1
 * @author: Xie Ning
 */
@Service
@Slf4j
public class PatrolStasticsServiceImpl extends BaseServiceImpl<StatisticsPatrolPerson> implements PatrolStasticsService {
	@Autowired
	StatisticsRepository statisticsRepository;


	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public PagingList<StatisticsPatrolPersonVo> getPatrolPersons(StatisticsPatrolPerson queryParam, PagingAttribute pageAttr) {
		int total = 0;
		List<Integer> totalList = statisticsRepository.queryPatrolStaticPersonsCount(queryParam);
		if (null != totalList && totalList.size() > 0) {
			total = totalList.size();
		}
		List<StaticsPatrolPersion> list = statisticsRepository.queryPatrolStaticPersons(queryParam, pageAttr);
		List<StatisticsPatrolPersonVo> personList = new ArrayList<StatisticsPatrolPersonVo>();
		if (null != list && list.size() > 0) {
			LinkedHashMap<String, StatisticsPatrolPersonVo> map = new LinkedHashMap<String, StatisticsPatrolPersonVo>();
			for (StaticsPatrolPersion patrolPerson : list) {
				String handlerId = patrolPerson.getHandlerId();

				StatisticsPatrolPersonVo personVO = map.get(handlerId);
				if (null == personVO) {
					personVO = new StatisticsPatrolPersonVo();
					map.put(handlerId, personVO);
					personList.add(personVO);
				}

				buildPerson(personVO, patrolPerson);
			}
		}

		Paging paging = new Paging(total, pageAttr);
		PagingList<StatisticsPatrolPersonVo> pagingList = new PagingList<StatisticsPatrolPersonVo>(personList, paging);
		return pagingList;
	}

	private void buildPerson(StatisticsPatrolPersonVo personVO, StaticsPatrolPersion patrolPerson) {
		personVO.setHandlerName(patrolPerson.getHandlerName());
		String type = patrolPerson.getType();
		String count = patrolPerson.getTotal();
		switch (type) {
		case "0":
			personVO.setPlanPatrolCount(count);
			break;
		case "1":
			personVO.setErrorPatrolCount(count);
			break;
		case "2":
			personVO.setSpecilPatrolCount(count);
			break;
		case "3":
			personVO.setNightPatrolCount(count);
			break;
		case "4":
			personVO.setWatchPatrolCount(count);
			break;
		case "5":
			personVO.setOncePatrolCount(count);
			break;
		case "6":
			personVO.setDutyPatrolCount(count);
			break;
		default:
			break;
		}
	}
	/**
	 * 巡检统计图
	 */
	@Override
	public BarsAndLinesEchartsVO getBarsOrLinesEchart(StatisticsPatrolPerson entity) {
		List<BarsAndLinesEchartsBase> yDataList = new ArrayList<BarsAndLinesEchartsBase>();
		BarsAndLinesEchartsBase planPatrolCount = new BarsAndLinesEchartsBase(NgtDefine.PLAN_PATROL_COUNT);
		BarsAndLinesEchartsBase errorPatrolCount = new BarsAndLinesEchartsBase(NgtDefine.ERROR_PATROL_COUNT);
		BarsAndLinesEchartsBase specilPatrolCount = new BarsAndLinesEchartsBase(NgtDefine.SPECIL_PATROL_COUNT);
		BarsAndLinesEchartsBase nightPatrolCount = new BarsAndLinesEchartsBase(NgtDefine.NIGHT_PATROL_COUNT);
		BarsAndLinesEchartsBase watchPatrolCount = new BarsAndLinesEchartsBase(NgtDefine.WATCH_PATROL_COUNT);
		BarsAndLinesEchartsBase oncePatrolCount = new BarsAndLinesEchartsBase(NgtDefine.ONCE_PATROL_COUNT);
		BarsAndLinesEchartsBase dutyPatrolCount = new BarsAndLinesEchartsBase(NgtDefine.DUTY_PATROL_COUNT);
		//x轴数据
		List<String> xData = this.getXDataList(entity.getStartDate(),entity.getEndDate(),entity.getDateTimeUnit());
		//获取原始数据
		List<StatisticsPatrolPerson> countList = statisticsRepository.getPatrolDataCount(entity);
		for (int i = 0; i < xData.size(); i++) {
			boolean flag = true;
			for (int j = 0; j < countList.size(); j++) {
				String date = countList.get(j).getCreateDateStr();
				if(xData.get(i).equals(date)) {
					StatisticsPatrolPerson personEntity = countList.get(j);
					String type = personEntity.getPatrolSchemeType();
					switch (type) {
					case "0":
						planPatrolCount.add(BigDecimalUtils.converIntToBig(personEntity.getTotalCount()));
						break;
					case "1":
						errorPatrolCount.add(BigDecimalUtils.converIntToBig(personEntity.getTotalCount()));
						break;
					case "2":
						specilPatrolCount.add(BigDecimalUtils.converIntToBig(personEntity.getTotalCount()));
						break;
					case "3":
						nightPatrolCount.add(BigDecimalUtils.converIntToBig(personEntity.getTotalCount()));
						break;
					case "4":
						watchPatrolCount.add(BigDecimalUtils.converIntToBig(personEntity.getTotalCount()));
						break;
					case "5":
						oncePatrolCount.add(BigDecimalUtils.converIntToBig(personEntity.getTotalCount()));
						break;
					case "6":
						dutyPatrolCount.add(BigDecimalUtils.converIntToBig(personEntity.getTotalCount()));
						break;
					default:
						break;
					}
					flag = false;
				}
			}
			if(flag) {
				planPatrolCount.add(BigDecimalUtils.converIntToBig(0));
				errorPatrolCount.add(BigDecimalUtils.converIntToBig(0));
				specilPatrolCount.add(BigDecimalUtils.converIntToBig(0));
				nightPatrolCount.add(BigDecimalUtils.converIntToBig(0));
				watchPatrolCount.add(BigDecimalUtils.converIntToBig(0));
				oncePatrolCount.add(BigDecimalUtils.converIntToBig(0));
				dutyPatrolCount.add(BigDecimalUtils.converIntToBig(0));
			}
		}
		//构建柱状图图例
		List<String> legendNameList = new ArrayList<String>();
		this.buildBarOrLineLegendNameList(legendNameList,planPatrolCount,errorPatrolCount,specilPatrolCount,nightPatrolCount,watchPatrolCount,oncePatrolCount,dutyPatrolCount);
		yDataList.add(planPatrolCount);
		yDataList.add(errorPatrolCount);
		yDataList.add(specilPatrolCount);
		yDataList.add(nightPatrolCount);
		yDataList.add(watchPatrolCount);
		yDataList.add(oncePatrolCount);
		yDataList.add(dutyPatrolCount);
		BarsAndLinesEchartsVO vo = new BarsAndLinesEchartsVO();
		vo.setXData(xData);
		vo.setYData(yDataList);
		return vo;
	}
	/**
	 * build legendName
	 * @param legendNameList
	 * @param planPatrolCount
	 * @param errorPatrolCount
	 * @param specilPatrolCount
	 * @param nightPatrolCount
	 * @param watchPatrolCount
	 * @param oncePatrolCount
	 * @param dutyPatrolCount
	 */
	private void buildBarOrLineLegendNameList(List<String> legendNameList, BarsAndLinesEchartsBase planPatrolCount,
			BarsAndLinesEchartsBase errorPatrolCount, BarsAndLinesEchartsBase specilPatrolCount, BarsAndLinesEchartsBase nightPatrolCount,
			BarsAndLinesEchartsBase watchPatrolCount, BarsAndLinesEchartsBase oncePatrolCount, BarsAndLinesEchartsBase dutyPatrolCount) {
		legendNameList.add(planPatrolCount.getName());
		legendNameList.add(errorPatrolCount.getName());
		legendNameList.add(specilPatrolCount.getName());
		legendNameList.add(nightPatrolCount.getName());
		legendNameList.add(watchPatrolCount.getName());
		legendNameList.add(oncePatrolCount.getName());
		legendNameList.add(dutyPatrolCount.getName());
	}

	/**
	 * 获取x轴数据
	 * @param startDate
	 * @param endDate
	 * @param dateTimeUnit
	 * @return
	 */
	private List<String> getXDataList(String startDate, String endDate, String dateTimeUnit) {
		List<String> x = DateUtils.getEveryDateUnit(startDate, endDate, dateTimeUnit);
		return x;
	}
}
