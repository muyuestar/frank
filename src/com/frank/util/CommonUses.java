package com.frank.util;

import java.util.Arrays;
import java.util.List;

/**
 * �����÷�����
 * 
 * @author kst
 * @date 2022-03-26 20:29:00
 */
public class CommonUses {

	public static void main(String[] args) {
		// ���鿽���÷�
//		String[] ints = new String[] { "0", "1", "2", "3", "4", "5" };
//		String[] newInts = Arrays.copyOf(ints, ints.length);
//		System.out.println(Arrays.toString(newInts));

		// ��ʽת��
//		System.out.println(String.format("�û���Ϣ=%d", 1));

		// Arrays.asList�÷�
		List<String> list = Arrays.asList("1","2","3");
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println(Arrays.toString(list.toArray()));

	}

}
