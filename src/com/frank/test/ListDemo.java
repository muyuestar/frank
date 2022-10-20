package com.frank.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List相关demo
 * 
 * @author kst
 * @version 创建时间：2020年9月14日 上午11:37:16
 */
public class ListDemo {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		// List重复元素
//		List<String> list = new ArrayList<String>(Arrays.asList("a", "a", "b", "c", "d"));
//		Set<String> set = new HashSet<String>(list);
//		if (list.size() == set.size()) {
//			System.out.println("无重复元素");
//		} else {
//			System.out.println("有重复元素");
//		}

//		List<String> list = new ArrayList<String>(Arrays.asList("a", "a", "b", "c", "d"));
//		long count = list.stream().distinct().count();
//		if (list.size() == count) {
//			System.out.println("无重复元素");
//		} else {
//			System.out.println("有重复元素");
//		}

		List<Person> personList = new ArrayList<Person>() {
			{
				add(new Person("张三"));
				add(new Person("李四"));
				add(new Person("王五"));
				add(new Person("王五"));
			}
		};
		List<String> stringList = personList.stream().map(Person::getName).collect(Collectors.toList());
		long count = stringList.stream().distinct().count();
		if (stringList.size() == count) {
			System.out.println("无重复元素");
		} else {
			System.out.println("有重复元素");
		}

	}

}
