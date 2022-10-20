package com.frank.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

/**
 * 日期类
 * 
 * @author kst
 * @date 2021-08-15 20:35:05
 */
public class DateUtil {

	/**
	 * Date类型转String类型
	 * 
	 * @param date date
	 * @return String类型日期
	 * @author kst 20210815
	 */
	public static String dateConvertString(Date date) {
		return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * String类型转Date类型
	 * 
	 * @param dateString String类型日期
	 * @return Date类型日期
	 * @throws Exception
	 * @author kst 20210815
	 */
	public static Date stringConvertDate(String dateString) throws Exception {
		return DateUtils.parseDate(dateString, "yyyy-MM-dd HH:mm:ss");

	}

	/**
	 * 计算n小时后的日期
	 * 
	 * @param date 日期
	 * @param hour 小时
	 * @return n小时后的日期
	 * @author kst 20210815
	 */
	public static Date addHour(Date date, int hour) {
		return DateUtils.addHours(date, hour);
	}

	public static void main(String[] args) throws Exception {
		// 计算n小时后的日期
//		String dateString = dateConvertString(addHour(new Date(), 2));
//		System.out.println(dateString);

	}

}
