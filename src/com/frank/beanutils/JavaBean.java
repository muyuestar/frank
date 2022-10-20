package com.frank.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author kst
 * @version ����ʱ�䣺2020��1��17�� ����3:55:05
 */
public class JavaBean {

	public static void main(String[] args)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		// ��ȡ����JavaBeanֵ
		User user = new User();
		BeanUtils.setProperty(user, "userName", "ľ��");
		BeanUtils.setProperty(user, "password", "123456");
		String userName = BeanUtils.getProperty(user, "password");
		System.out.println(userName);

		// map��bean�Ļ���ת��
		// bean->map
		Map<String, String> map = BeanUtils.describe(user);
		System.out.println(map.toString());
		// map->bean
		BeanUtils.populate(user, map);
		System.out.println(user.getPassword());
		
	}

}
