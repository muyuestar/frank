package com.frank.util;

import java.util.Arrays;
import java.util.List;

/**
 * 常见用法集锦
 * 
 * @author kst
 * @date 2022-03-26 20:29:00
 */
public class CommonUses {

	public static void main(String[] args) {
		// 数组拷贝用法
//		String[] ints = new String[] { "0", "1", "2", "3", "4", "5" };
//		String[] newInts = Arrays.copyOf(ints, ints.length);
//		System.out.println(Arrays.toString(newInts));

		// 格式转换
//		System.out.println(String.format("用户信息=%d", 1));

		// Arrays.asList用法
		List<String> list = Arrays.asList("1","2","3");
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println(Arrays.toString(list.toArray()));

	}

}
