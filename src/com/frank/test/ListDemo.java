package com.frank.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List���demo
 * 
 * @author kst
 * @version ����ʱ�䣺2020��9��14�� ����11:37:16
 */
public class ListDemo {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		// List�ظ�Ԫ��
//		List<String> list = new ArrayList<String>(Arrays.asList("a", "a", "b", "c", "d"));
//		Set<String> set = new HashSet<String>(list);
//		if (list.size() == set.size()) {
//			System.out.println("���ظ�Ԫ��");
//		} else {
//			System.out.println("���ظ�Ԫ��");
//		}

//		List<String> list = new ArrayList<String>(Arrays.asList("a", "a", "b", "c", "d"));
//		long count = list.stream().distinct().count();
//		if (list.size() == count) {
//			System.out.println("���ظ�Ԫ��");
//		} else {
//			System.out.println("���ظ�Ԫ��");
//		}

		List<Person> personList = new ArrayList<Person>() {
			{
				add(new Person("����"));
				add(new Person("����"));
				add(new Person("����"));
				add(new Person("����"));
			}
		};
		List<String> stringList = personList.stream().map(Person::getName).collect(Collectors.toList());
		long count = stringList.stream().distinct().count();
		if (stringList.size() == count) {
			System.out.println("���ظ�Ԫ��");
		} else {
			System.out.println("���ظ�Ԫ��");
		}

	}

}
