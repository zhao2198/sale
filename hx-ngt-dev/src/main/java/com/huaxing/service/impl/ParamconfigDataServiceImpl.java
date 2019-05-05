package com.huaxing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxing.bean.EquipmentParamConfig;
import com.huaxing.bean.ParamconfigData;
import com.huaxing.common.service.impl.BaseServiceImpl;
import com.huaxing.common.utils.RestResult;
import com.huaxing.common.utils.RestResultUtil;
import com.huaxing.common.utils.StringUtilForUdp;
import com.huaxing.repository.EquipmentParamConfigRepository;
import com.huaxing.repository.ParamconfigDataRepository;
import com.huaxing.service.ParamconfigDataService;
import com.huaxing.util.NgtStatus;

@Service
public class ParamconfigDataServiceImpl extends BaseServiceImpl<ParamconfigData> implements ParamconfigDataService {
	@Autowired
	private ParamconfigDataRepository paramconfigDataRepository;
	@Autowired
	private EquipmentParamConfigRepository equipmentparamConfigRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.baseRepository = paramconfigDataRepository;
	}

	@Override
	public RestResult<String> downGateWayConfig(String companyId, String projectCode, String userId) {
		int count = equipmentparamConfigRepository.getCountByProjectCode(projectCode, companyId);
		if (count == 0) {
			return RestResultUtil.getResult(NgtStatus.NGTEUQIPMENTPARAM_CONFIG_BAD);
		}
		String dataNum = StringUtilForUdp.DecToHex(count);
		StringBuilder data = new StringBuilder(String.format("%02x", Integer.parseInt(dataNum, 16)));
		EquipmentParamConfig equipmentparamConfig = new EquipmentParamConfig();
		equipmentparamConfig.setProjectCode(projectCode);
		equipmentparamConfig.setCompanyId(companyId);
		List<EquipmentParamConfig> list = equipmentparamConfigRepository.queryList(equipmentparamConfig);
		int number = saveEquipmentparamConfig(list, data, projectCode, companyId, userId);
		return this.result(number);
	}

	private int saveEquipmentparamConfig(List<EquipmentParamConfig> list, StringBuilder data, String projectCode, String companyId, String userId) {
		if (list.size() > 0) {
			for (EquipmentParamConfig equParamConfig : list) {
				String channelState = equParamConfig.getChannelState();// 通道状态
				String paramType = equParamConfig.getParamType();// 测点状态
				String phase = equParamConfig.getPhase();// 相位
				String branchCode = equParamConfig.getBranchCode();// 分支号
				String dataType = channelState + paramType + phase + branchCode;// 数据类型
				dataType = StringUtilForUdp.DecToHex(StringUtilForUdp.BinStr2Int(dataType));// 2进制转16进制
				StringBuilder dataType1 = new StringBuilder(dataType);
				String transmission = equParamConfig.getTransmission();// 是否传输
				String grade = equParamConfig.getGrade();// 重要等级
				String cycle = equParamConfig.getCycle();// 传输周期
				String dataConfig = transmission + grade + cycle;// 数据类型
				dataConfig = StringUtilForUdp.DecToHex(StringUtilForUdp.BinStr2Int(dataConfig));// 2进制转16进制
				StringBuilder dataConfig1 = new StringBuilder(dataConfig);
				data.append(dataType1).append(dataConfig1);
			}
			ParamconfigData paramconfigData = new ParamconfigData();
			paramconfigData.setProjectCode(projectCode);
			paramconfigData.setParamConfigData(data.toString());
			paramconfigData.setCompanyId(companyId);
			ParamconfigData paramconfigDataSourse = paramconfigDataRepository.findByProjectCode(paramconfigData);

			if (paramconfigDataSourse != null) {
				paramconfigDataSourse.setParamConfigData(data.toString());
				paramconfigDataSourse.setUpdate(userId);
				int count = paramconfigDataRepository.update(paramconfigDataSourse);
				return count;
			} else {
				paramconfigData.setCreate(userId);
				paramconfigData.setUUID();
				int count = paramconfigDataRepository.save(paramconfigData);
				return count;
			}
		}

		return 0;

	}

	@Override
	public int delete(String companyId, String projectCode, String userId) {
		ParamconfigData paramconfigData = new ParamconfigData();
		paramconfigData.setCompanyId(companyId);
		paramconfigData.setProjectCode(projectCode);
		paramconfigData.setUpdate(userId);
		int count = paramconfigDataRepository.deleteConfig(paramconfigData);
		return count;
	}

}
