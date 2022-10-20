package com.frank.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author kst
 * @version 创建时间：2020年1月17日 下午3:55:05
 */
public class JavaBean {

	public static void main(String[] args)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		// 读取设置JavaBean值
		User user = new User();
		BeanUtils.setProperty(user, "userName", "木月");
		BeanUtils.setProperty(user, "password", "123456");
		String userName = BeanUtils.getProperty(user, "password");
		System.out.println(userName);

		// map和bean的互相转换
		// bean->map
		Map<String, String> map = BeanUtils.describe(user);
		System.out.println(map.toString());
		// map->bean
		BeanUtils.populate(user, map);
		System.out.println(user.getPassword());
		
	}

}
