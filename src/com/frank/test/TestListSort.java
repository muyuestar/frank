package com.frank.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 测试ListSort
 * 
 * @author kst
 * @date 2018-12-06 12:06:07
 */
public class TestListSort {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Student s1 = new Student();
		s1.setAge(20);
		s1.setUsable(true);
		s1.setName("张三");
		Student s2 = new Student();
		s2.setAge(19);
		s2.setUsable(true);
		s2.setName("李四");
		Student s3 = new Student();
		s3.setAge(21);
		s3.setUsable(false);
		s3.setName("王五");
		list.add(s1);
		list.add(s2);
		list.add(s3);
		System.out.println("排序前：" + list);

		// Lambda
		list.forEach((Student st) -> System.out.println(st.toString()));

//		Collections.sort(list, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				// 按照学生的年龄进行升序排列
//				if (o1.getAge() > o2.getAge()) {
//					return 1;
//				}
//				if (o1.getAge() == o2.getAge()) {
//					return 0;
//				}
//				return -1;
//			}
//		});
//		System.out.println("升序排序后：" + list);

		Collections.sort(list, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				// 按照学生的年龄进行降序排列
				if (o1.getAge() > o2.getAge()) {
					return -1;
				}
				if (o1.getAge() == o2.getAge()) {
					return 0;
				}
				return 1;
			}
		});
		System.out.println("降序排序后：" + list);

//		Boolean b1 = true; // 创建Boolean对象1
//		Boolean b2 = false; // 创建Boolean对象0
//		Boolean b3 = true; // 创建Boolean对象1
//		System.out.println(b1);
//		int i;
//		i = b1.compareTo(b2); // b1和b2进行比较
//		System.out.println(i);// 1-0
//		i = b2.compareTo(b1); // b2和b1进行比较
//		System.out.println(i);// 0-1
//		i = b1.compareTo(b3); // b1和b3进行比较
//		System.out.println(i);// 1-1
	}
}

class Student {
	private int age;

	private Boolean isUsable;

	private String name;

	public int getAge() {
		return age;
	}

	public Boolean isUsable() {
		return isUsable;
	}

	public void setUsable(Boolean isUsable) {
		this.isUsable = isUsable;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getAge() + "";
	}
}