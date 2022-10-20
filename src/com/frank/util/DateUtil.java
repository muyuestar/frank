package com.frank.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

/**
 * ������
 * 
 * @author kst
 * @date 2021-08-15 20:35:05
 */
public class DateUtil {

	/**
	 * Date����תString����
	 * 
	 * @param date date
	 * @return String��������
	 * @author kst 20210815
	 */
	public static String dateConvertString(Date date) {
		return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * String����תDate����
	 * 
	 * @param dateString String��������
	 * @return Date��������
	 * @throws Exception
	 * @author kst 20210815
	 */
	public static Date stringConvertDate(String dateString) throws Exception {
		return DateUtils.parseDate(dateString, "yyyy-MM-dd HH:mm:ss");

	}

	/**
	 * ����nСʱ�������
	 * 
	 * @param date ����
	 * @param hour Сʱ
	 * @return nСʱ�������
	 * @author kst 20210815
	 */
	public static Date addHour(Date date, int hour) {
		return DateUtils.addHours(date, hour);
	}

	public static void main(String[] args) throws Exception {
		// ����nСʱ�������
//		String dateString = dateConvertString(addHour(new Date(), 2));
//		System.out.println(dateString);

	}

}
