package com.huaxing.job;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;

import com.huaxing.common.exception.ServiceException;
import com.huaxing.modules.utils.SpringUtil;

/**
 * 执行定时任务
 * 
 */
public class ScheduleRunnable implements Runnable {
	private Object target;
	private Method method;
	private String params;

	public ScheduleRunnable(String beanName, String methodName, String params) throws NoSuchMethodException, SecurityException {
		this.target = SpringUtil.getBean(beanName);
		this.params = params;

		if (StringUtils.isNotBlank(params)) {
			this.method = target.getClass().getDeclaredMethod(methodName, String.class);
		} else {
			this.method = target.getClass().getDeclaredMethod(methodName);
		}
	}

	@Override
	public void run() {
		try {
			ReflectionUtils.makeAccessible(method);
			if (StringUtils.isNotBlank(params)) {
				method.invoke(target, params);
			} else {
				method.invoke(target);
			}
		} catch (Exception e) {
			throw new ServiceException("执行定时任务失败", e);
		}
	}

}
