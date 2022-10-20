package com.frank.googleguava;

/**
 * 实体类
 * 
 * @author kst
 * @version 创建时间：2020年3月20日 上午10:39:39
 */
public class Person {

	public String name;

	public Integer age;

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
