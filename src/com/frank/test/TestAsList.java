package com.frank.test;

import java.util.Arrays;
import java.util.List;

/**
 * ����asList
 * 
 * @author kst
 *
 */
public class TestAsList {

	public static void main(String[] args) {
		// ����
		String[] arr = new String[] { "1", "2", "3", "4", "5" };
		List<String> list = Arrays.asList(arr);
		System.out.println("list���=" + list.toString());
		// 
	}
}
