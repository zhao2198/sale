package com.huaxing.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huaxing.bean.DutyMission;
import com.huaxing.bean.TodoCenterContent;
import com.huaxing.bean.TodoCenterOperation;
import com.huaxing.common.utils.JsonUtil;
import com.huaxing.service.DutyMissionService;
import com.huaxing.service.TodoCenterContentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("dutyMissionJobs")
public class DutyMissionJobs {

	@Autowired
	private TodoCenterContentService todoCenterContentService;
	@Autowired
	private DutyMissionService dutyMissionService;

	/***
	 * 查询当天所有的值班任务并把值班任务添加到待办中心
	 */
	public void addDutyMission_2_TodoCenter(String paramsJson) {
		Map<String, String> params = JsonUtil.json2HashMap(paramsJson, String.class);
		String companyId = params.get("companyId");
		List<DutyMission> missions = dutyMissionService.findTodayMissions(companyId);
		for (DutyMission mission : missions) {
			addTaskToTodoCenter(mission);
		}
	}

	/**
	 * 添加值班任务到待办中心并推送
	 * 
	 */
	private int addTaskToTodoCenter(DutyMission mission) {
		List<String> receiverList = new ArrayList<String>();
		String userId = mission.getUserId();
		if (userId != null) {
			receiverList.add(userId);
		}
		int res = 0;
		if (receiverList.size() != 0) {
			TodoCenterContent content = new TodoCenterContent();// 推送的内容
			content.setContent("新的值班任务");
			content.setTheme("值班任务");
			TodoCenterOperation operate_view = new TodoCenterOperation();// 推送消息的操作
			operate_view.setType("2");
			Map<String, String> param = new HashMap<>();
			param.put("uriParam", "id=" + mission.getId());
			param.put("title", "值班任务详情");
			operate_view.setParam(param.toString());
			operate_view.setLabelName("查看");
			operate_view.setOperate("/api/dutymission/info/" + mission.getId());
			operate_view.setStyle("btn-info");
			content.setOperation(operate_view);// TodoCenterOperation
			content.setReceiverIds(receiverList);// ReceiverIds
			content.setRefId(mission.getId());// 保存值班任务的id到待办内容表中
			res = todoCenterContentService.createContent(content);// 保存待办
		}
		return res;
	}
}
