package com.huaxing.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huaxing.common.entity.UserEntity;
import com.huaxing.service.UserService;

/**
 * 测试定时任务(演示Demo，可删除)
 * 
 * testTask为spring bean的名称
 * 
 */
@Component("testTask")
public class TestTask {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	public void test1(String params) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		logger.info(simpleDateFormat.format(new Date()));
		/*logger.info("我是带参数的test方法，正在被执行，参数为：" + params);

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		UserEntity user = userService.getById("0167caeba28d44a3892db66d5dbbe161");
		System.out.println(ToStringBuilder.reflectionToString(user));
		*/
	}

	public void test2() {
		logger.info("我是不带参数的test2方法，正在被执行");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(simpleDateFormat.format(new Date()));
	}
}
