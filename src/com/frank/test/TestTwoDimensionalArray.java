package com.frank.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 测试二维数组
 * 
 * @author kst
 *
 */
public class TestTwoDimensionalArray {

	public static void main(String[] args) {
		int[][] array = new int[4][3];
		array[0] = new int[] { 0, 1, 2, 3 };
		array[1] = new int[] { 4, 5, 6, 7 };
		array[2] = new int[] { 8, 9, 10, 11 };
		array[3] = new int[] { 12, 13, 14, 15 };
		// 二维数组遍历
		System.out.println("-------------二维数组遍历-------------");
		for (int[] arr : array) {
			System.out.println(Arrays.toString(arr));
		}
		// 二维数组的反转---头尾交换
		System.out.println("-------------二维数组的反转-------------");
		for (int start = 0, end = array.length - 1; start < end; start++, end--) {
			int[] temp = array[start];
			array[start] = array[end];
			array[end] = temp;
		}
		for (int[] arr : array) {
			System.out.println(Arrays.toString(arr));
		}
		// 从控制台输入行数，打印对应的杨辉三角
		System.out.println("-------------打印杨辉三角-------------");
		// 从控制台获取行数
		Scanner s = new Scanner(System.in);
		int row = s.nextInt();
		// 根据行数定义好二维数组，由于每一行的元素个数不同，所以不定义每一行的个数
		int[][] arr = new int[row][];
		// 遍历二维数组
		for (int i = 0; i < row; i++) {
			// 初始化每一行的这个一维数组:j=i+1
			arr[i] = new int[i + 1];
			// 遍历这个一维数组，添加元素
			for (int j = 0; j <= i; j++) {
				// 每一列的开头和结尾元素，开头的时候，j=0，结尾的时候，j=i
				if (j == 0 || j == i) {
					arr[i][j] = 1;
				} else {// 每一个元素是它上一行的元素和斜对角元素之和
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
