package com.frank.test;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ≤‚ ‘ArrayUtils
 * 
 * @author kst
 *
 */
public class TestArrayUtils {

	public static void main(String[] args) {
		// ≤‚ ‘add
//		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
//		System.out.println(Arrays.toString(array));
//		array = ArrayUtils.subarray(ArrayUtils.add(array, 6, array[array.length-1]), 0, array.length);
//		System.out.println(Arrays.toString(array));

        String[] arr = new String[]{"a","b","c"};
        System.out.println(ArrayUtils.toString(arr));

    }
}