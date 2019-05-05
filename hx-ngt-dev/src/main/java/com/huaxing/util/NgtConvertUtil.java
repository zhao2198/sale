package com.huaxing.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.github.pagehelper.util.StringUtil;
import com.huaxing.bean.AlarmGrade;
import com.huaxing.bean.AlarmType;
import com.huaxing.bean.Equipment;
import com.huaxing.bean.EquipmentType;
import com.huaxing.common.entity.UserEntity;
import com.huaxing.common.utils.ReflectUtils;
import com.huaxing.modules.utils.SpringUtil;
import com.huaxing.repository.UserRepository;
import com.huaxing.service.AlarmTypeService;
import com.huaxing.service.EquipmentService;
import com.huaxing.service.EquipmentTypeService;
import com.huaxing.service.IAlarmGradeService;

/**
 * 能管在线常用转换 Create Date: 2018年7月10日 上午9:29:55
 * 
 * @version: V3.0.1
 * @author: zhao wei
 */
public class NgtConvertUtil {
	/**
	 * 转换设备信息 Lian weimao CreateTime:2018年7月14日 上午10:50:04
	 * 
	 * @param obj
	 *            设备名称要存入的对象
	 * @param value
	 *            设备ID
	 * @param field
	 *            obj对象中，设备名称的属性名称
	 */
	public static void convertEquipment(Object obj, String value, String field) {
		EquipmentService equipmentSerivce = SpringUtil.getBean(EquipmentService.class);
		if (null != equipmentSerivce) {
			Map<String, Equipment> map = equipmentSerivce.getAllEquipment();
			Equipment equipment = map.get(value);
			if (null != equipment) {
				ReflectUtils.setFieldSetterValue(field, obj, equipment.getName());
			}

		}
	}

	public static void convertEquipmentCategory(Object obj, String value, String field) {
		EquipmentService equipmentSerivce = SpringUtil.getBean(EquipmentService.class);
		if (null != equipmentSerivce) {
			Map<String, Equipment> map = equipmentSerivce.getAllEquipment();
			Equipment equipment = map.get(value);
			if (null != equipment) {
				ReflectUtils.setFieldSetterValue(field, obj, equipment.getCategory());
			}

		}
	}

	public static void convertEquipmentCode(Object obj, String value, String field) {
		EquipmentService equipmentSerivce = SpringUtil.getBean(EquipmentService.class);
		if (null != equipmentSerivce) {
			Map<String, Equipment> map = equipmentSerivce.getAllEquipment();
			Equipment equipment = map.get(value);
			if (null != equipment) {
				ReflectUtils.setFieldSetterValue(field, obj, equipment.getCode());
			}

		}
	}

	public static <T> void convertListEquipment(List<T> list, String srcField, String distField) {
		EquipmentService equipmentSerivce = SpringUtil.getBean(EquipmentService.class);
		if (null != equipmentSerivce) {
			Map<String, Equipment> map = equipmentSerivce.getAllEquipment();

			list.forEach(item -> {
				String key = ReflectUtils.getFieldValue(srcField, item);
				if (StringUtil.isNotEmpty(key)) {
					Equipment equipment = map.get(key);
					if (null != equipment) {
						ReflectUtils.setFieldSetterValue(distField, item, equipment.getName());
					}
				}

			});

		}
	}

	public static void convertEquipmentType(Object obj, String[] values, String[] fields) {
		EquipmentTypeService equipmentTypeService = SpringUtil.getBean(EquipmentTypeService.class);
		if (null != equipmentTypeService) {
			Map<String, EquipmentType> map = equipmentTypeService.getAllEquipmentType();
			for (int i = 0; i < values.length; i++) {
				EquipmentType equipmentTypeEntity = map.get(values[i]);
				if (null != equipmentTypeEntity) {
					ReflectUtils.setFieldSetterValue(fields[i], obj, equipmentTypeEntity.getName());
				}
			}

		}
	}

	/**
	 * 转换告警类型
	 * 
	 * @param obj
	 * @param values
	 * @param fields
	 */
	public static <T> void convertAlarmType(List<T> list, String srcField, String distField) {
		AlarmTypeService alarmTypeService = SpringUtil.getBean(AlarmTypeService.class);
		if (null != alarmTypeService) {
			Map<String, AlarmType> map = alarmTypeService.getAllAlarmType();
			list.forEach(item -> {
				String key = ReflectUtils.getFieldValue(srcField, item);
				if (StringUtil.isNotEmpty(key)) {
					AlarmType alarmType = map.get(key);
					if (null != alarmType) {
						ReflectUtils.setFieldSetterValue(distField, item, alarmType.getName());
					}
				}

			});

		}
	}

	/**
	 * 转换告警级别
	 * 
	 * @param obj
	 * @param values
	 * @param fields
	 */
	public static <T> void convertAlarmGrade(List<T> list, String srcField, String distField) {
		IAlarmGradeService alarmGradeService = SpringUtil.getBean(IAlarmGradeService.class);
		if (null != alarmGradeService) {
			Map<String, AlarmGrade> map = alarmGradeService.getAllAlarmGrade();

			list.forEach(item -> {
				String key = ReflectUtils.getFieldValue(srcField, item);
				if (StringUtil.isNotEmpty(key)) {
					AlarmGrade alarmGrade = map.get(key);
					if (null != alarmGrade) {

						String grade = alarmGrade.getGrade();
						String value = "";
						if (grade.equals("0")) {
							value = "一般";
						} else if (grade.equals("1")) {
							value = "严重";
						} else if (grade.equals("2")) {
							value = "紧急";
						}

						ReflectUtils.setFieldSetterValue(distField, item, value);
					}
				}

			});

		}
	}

	public static <T> void convertListEquipmentType(List<T> list, String[] srcFields, String[] distFields) {
		EquipmentTypeService equipmentTypeService = SpringUtil.getBean(EquipmentTypeService.class);
		if (null != equipmentTypeService) {
			Map<String, EquipmentType> map = equipmentTypeService.getAllEquipmentType();

			list.forEach(item -> {
				for (int i = 0; i < srcFields.length; i++) {
					String key = ReflectUtils.getFieldValue(srcFields[i], item);
					if (StringUtil.isNotEmpty(key)) {
						EquipmentType equipmentTypeEntity = map.get(ReflectUtils.getFieldValue(srcFields[i], item));
						if (null != equipmentTypeEntity) {
							ReflectUtils.setFieldSetterValue(distFields[i], item, equipmentTypeEntity.getName());
						}
					}

				}

			});

		}
	}

	private Map<String, String> userIdToNameMap = null;

	/**
	 * 转换用户ID为用户名称 Lian weimao CreateTime:2018年7月16日 下午2:30:10
	 * 
	 * @param object
	 *            需要转换的对象
	 * @param userId
	 *            用户ID
	 * @param fieldName
	 *            对象中保存用户名的属性名称
	 */
	public void convertUserName(Object object, String userId, String fieldName) {
		initUserIdToNameMap();
		if (userIdToNameMap.containsKey(userId)) {
			ReflectUtils.setFieldSetterValue(fieldName, object, userIdToNameMap.get(userId));
		}
	}

	/**
	 * 传入UserI的，获得UserName Lian weimao CreateTime:2018年7月18日 下午4:31:21
	 * 
	 * @param userId
	 * @return
	 */
	public String convertUserName(String userId) {
		initUserIdToNameMap();
		if (userIdToNameMap.containsKey(userId)) {
			return userIdToNameMap.get(userId);
		}
		return null;
	}

	/**
	 * 初始化用户列表 Lian weimao CreateTime:2018年7月16日 下午2:34:02
	 */
	private void initUserIdToNameMap() {
		if (userIdToNameMap == null) {
			UserRepository userRepository = SpringUtil.getBean(UserRepository.class);
			List<UserEntity> allUser = userRepository.queryAll();
			userIdToNameMap = allUser.stream().filter(user -> (user.getId() != null && user.getName() != null))
					.collect(Collectors.toMap(UserEntity::getId, UserEntity::getName));
		}
	}

}
