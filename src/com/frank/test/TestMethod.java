package com.frank.test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * ≤‚ ‘Method
 * 
 * @author kst
 * @date 2018-11-27 09:01:41
 */
public class TestMethod {

	public static void main(String[] args) throws Exception {
		String name = Method.class.getName();
		System.out.println(name);
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "a");
		map.put("2", "b");
		System.out.println("111111111111");
		map.wait(2000);
		System.out.println("222222222222");
		System.out.println(map);
	}
}
