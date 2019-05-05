package com.huaxing.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.huaxing.bean.ElectricPriceBasic;
import com.huaxing.bean.ElectricPriceForce;
import com.huaxing.bean.ElectricPriceLadder;
import com.huaxing.bean.ElectricPricePower;
import com.huaxing.bean.ElectricPriceTemplate;
import com.huaxing.vo.ElectricPriceTemplateVo;

/**
 * 电价模板dao
 * Create Date:	2018年6月27日 上午9:20:41
 * @version:	V3.0.1
 * @author:		wang xiao chao
 */
public interface ElectricPriceTemplateRepository{
	/**保存电价主模板  王晓超 2018年6月28日14:37:29*/
	int savePriceTemplate(ElectricPriceTemplate templateEntity);
	
	/**保存阶梯电价模板  王晓超 2018年6月28日14:38:06*/
	int saveLadderPriceTemplate(List<ElectricPriceLadder> insertLadderList);
	
	/**保存力调电价模板  王晓超 2018年6月28日14:38:38*/
	int savePowerPriceTemplate(List<ElectricPricePower> insertParam);
	
	/**保存基本电价模板  王晓超 2018年6月28日16:08:41*/
	int saveBasicPriceTemplate(List<ElectricPriceBasic> basicPriceList);
	
	/**保存力调电价模板  王晓超 2018年6月28日16:25:06*/
	int saveForcePriceTemplate(ElectricPriceForce forcePriceEntity);
	
	/**删除电价模板  王晓超 2018年6月29日10:32:30*/
	int deleteElectricPriceTemplate(String templateId);
	
	
	
	
	/**查询电价主模板  王晓超 2018年6月29日15:56:45
	 * @param companyId */
	ElectricPriceTemplate getElectricPriceTemplate(@Param("templateId")String templateId, @Param("companyId")String companyId);
	
	/**查询电度电价模板信息 王晓超 2018年6月29日15:57:15
	 * @param companyId */
	List<ElectricPricePower> getPowerPriceTemplate(String templateId);
	
	/**查询电度电价中阶梯电价模板信息  王晓超 2018年6月29日15:57:39
	 * @param companyId */
	List<ElectricPriceLadder> getLadderPriceInPowerTemplate(String templateId);
	
	/**查询基本电价模板信息  王晓超 2018年6月29日15:58:07
	 * @param companyId */
	List<ElectricPriceBasic> getBasicPriceTemplate(String templateId);
	
	/**查询力调电价模板信息  王晓超 2018年6月29日15:58:22
	 * @param companyId */
	ElectricPriceForce getForcePriceTemplate(String templateId);
	/**查询电价模板列表*/
	List<ElectricPriceTemplate> getElectricPriceTemplateList(Map<String, Object> queryParam);
	/**
	 * 根据变压器id和公司id获取电费模板中尖峰平谷时间段或尖峰平谷电价
	 * 需要传入分组名称，获取时间段传入值“p.time”，获取尖峰平谷电价传入值“p.time_type”，变量名称：groupName
	 * @param map
	 * @return
	 */
	List<Map<String, String>> getElectricCostTimes(Map<String, String> map);
	/**
	 * 判断变压器下的电价模板是否能删除
	 * @param equipmentId
	 * @return
	 */
	int isDeleteElectricPriceTemplate(String equipmentId);
	
}
