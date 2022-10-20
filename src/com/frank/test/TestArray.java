package com.frank.test;

import java.util.Arrays;

/**
 * ≤‚ ‘ ˝◊È
 * 
 * @author kst
 *
 */
public class TestArray {

	public static void main(String[] args) {
//		int[] arr = new int[10];
//		System.out.println(Arrays.toString(arr));
//		String[] EMPTY_STRING_ARRAY = new String[0];
//		System.out.println("EMPTY_STRING_ARRAY=" + Arrays.toString(EMPTY_STRING_ARRAY));
//		String[] EMPTY_STRING_ARRAY2 = new String[] {};
//		System.out.println("EMPTY_STRING_ARRAY2=" + Arrays.toString(EMPTY_STRING_ARRAY2));
		
		// ≤‚ ‘Arrays.sort
//		int[] array = new int[] { 8, 7, 6, 4, 3, 5, 2, 1, 9 };
//		Arrays.sort(array);
//		System.out.println(Arrays.toString(array));
//		String[] array = new String[]{"eew","aew","cgd","acd","dop"};
//		Arrays.sort(array);
//		System.out.println(Arrays.toString(array));
		
		// ≤‚ ‘Arrays.copyOf
		int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] newarray = Arrays.copyOf(array, 5);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(newarray));
	}
}
