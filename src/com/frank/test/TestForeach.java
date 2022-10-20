package com.frank.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试Java8foreach特性
 * 
 * @author kst
 *
 */
public class TestForeach {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		StringBuffer sb = new StringBuffer();
		list.forEach(str -> sb.append(str).toString());
		System.out.println("list拼接值=" + sb.toString());
	}
}
