package com.frank.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ²âÊÔList×ª»»³É×Ö·û´®
 * @author kst
 *
 */
public class TestListToString {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list);
		Map<String, String> map = new HashMap<String,String>();
		map.put("cornName", list.toString());
		System.out.println(map.toString());
	}
}
