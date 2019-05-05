package com.huaxing.job;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Create Date: 2018年5月30日 下午7:19:48
 * 
 * @version: V3.0.1
 * @author: zhao wei
 */
public class CronExpressionUtil {
	public static String formatDateByPattern(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String formatTimeStr = null;
		if (date != null) {
			formatTimeStr = sdf.format(date);
		}
		return formatTimeStr;
	}

	/***
	 * convert Date to cron ,eg. "0 06 10 15 1 ? 2014"
	 * 
	 * @param date
	 *            : 时间点
	 * @return
	 */
	public static String getCron(Date date) {
		String dateFormat = "ss mm HH dd MM ? yyyy";
		return formatDateByPattern(date, dateFormat);
	}

}
