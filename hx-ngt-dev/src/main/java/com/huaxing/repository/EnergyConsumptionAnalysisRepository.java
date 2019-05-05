package com.huaxing.repository;

import java.math.BigDecimal;
import java.util.List;

import com.huaxing.bean.EnergyConsumptionAnalysis;
import com.huaxing.common.repository.BaseRepository;

/**
 * InnoDB free: 8192 kB
 * 
 * @author feng yi
 * @date 2018-07-16 16:29:36
 */
public interface EnergyConsumptionAnalysisRepository extends BaseRepository<EnergyConsumptionAnalysis> {

	BigDecimal queryTotalEnergy(EnergyConsumptionAnalysis energyConsumptionAnalysis);

	List<EnergyConsumptionAnalysis> queryOrgEnergyList(EnergyConsumptionAnalysis energyConsumptionAnalysis);

	List<EnergyConsumptionAnalysis> getEquipmentTypeEnergyList(EnergyConsumptionAnalysis energyConsumptionAnalysis);

	List<EnergyConsumptionAnalysis> queryAvgLoad(EnergyConsumptionAnalysis energyConsumptionAnalysis);

}
