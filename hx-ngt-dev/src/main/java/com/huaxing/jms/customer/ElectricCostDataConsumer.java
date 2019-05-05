package com.huaxing.jms.customer;

import com.huaxing.bean.CollDeviceData;
import com.huaxing.common.utils.JsonUtil;
import com.huaxing.common.utils.ObjectSerialize;
import com.huaxing.service.impl.ElectricCostService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ElectricCostDataConsumer {
	@Autowired
	private ElectricCostService costService;

	//@JmsListener(destination = "huaxing.electricCostQueue")
	public void receive(String message) {
		log.debug("revice cost message:" + message);
		String msg = (String) ObjectSerialize.deserialization(message);
		log.debug("serialization  cost message:" + msg);
		List<Map> dataList = JsonUtil.json2Bean(msg, ArrayList.class);
		if (null != dataList && dataList.size() > 0) {
			List<CollDeviceData> list = new ArrayList<CollDeviceData>();
			for (Map map : dataList) {
				CollDeviceData beanItem = new CollDeviceData();
				try {
					BeanUtils.copyProperties(beanItem, map);
				} catch (Exception e) {

					log.error("revice collDeviceData error", e);
				}
				beanItem.setAcquisitionTime(map.get("acquisitionTime").toString());
				list.add(beanItem);
			}
			costService.savePowerCost(list,true);//调用计算电费计算接口的时候，传入单独标志，来判断是否计算统计数据
			log.debug("cal cost success");
		}

	}

}
