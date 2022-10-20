package com.frank.test;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ≤‚ ‘org.apache.commons.lang3.ArrayUtils∑Ω∑®
 * 
 * @author kst
 *
 */
public class TestLangArrayUtils {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// toMap
//		Map colorMap = ArrayUtils
//				.toMap(new String[][] { { "RED", "#FF0000" }, { "GREEN", "#00FF00" }, { "BLUE", "#0000FF" } });
//		System.out.println(colorMap.toString());
		
		// toArray
//		String[] array = ArrayUtils.toArray("1", "2", "3", "4", "5");
//		System.out.println(Arrays.toString(array));
		
		// clone
//		int[] array = new int[] { 0, 1, 2, 3, 4 };
//		int[] cloneArray = ArrayUtils.clone(array);
//		System.out.println(Arrays.toString(cloneArray));
		
		// subarray
//		int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		int[] subarray = ArrayUtils.subarray(array, 2, 5);
//		System.out.println(Arrays.toString(subarray));
		
		// isSameLength
//		int[] array1 = new int[] { 0, 1, 2 };
//		int[] array2 = new int[] { 0, 1, 2, 3 };
//		boolean flag = ArrayUtils.isSameLength(array1, array2);
//		System.out.println(flag);
		
		// getLength
//		int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		int length = ArrayUtils.getLength(array);
//		System.out.println(length);
		
		// reverse
//		int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		ArrayUtils.reverse(array);
//		System.out.println(Arrays.toString(array));
		
		// isEmpty
//		int[] array = null;
//		System.out.println(Arrays.toString(array));
//		System.out.println("boolean=" + ArrayUtils.isEmpty(array));
		
		// addAll
//		int[] array1 = new int[] { 0, 1, 2, 3, 4 };
//		int[] array1 = null;
//		int[] array2 = new int[] { 5, 6, 7, 8, 9 };
//		int[] array2 = null;
//		int i = 5;
//		int[] array = ArrayUtils.addAll(array1, array2);
//		System.out.println(Arrays.toString(array));
		
		// removeAll
//		int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		array = ArrayUtils.removeAll(array, 5, 8, 9);
//		System.out.println(Arrays.toString(array));
		
		// removeElements
//		int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		array = ArrayUtils.removeElements(array, 5, 8);
//		System.out.println(Arrays.toString(array));
		
		// isSorted
//		int[] array = new int[] { 8, 7, 6, 4, 3, 5, 2, 1, 9 };
		int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		boolean flag = ArrayUtils.isSorted(array);
		System.out.println(flag);
		
	}
}
