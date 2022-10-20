package com.frank.test;

import java.util.Arrays;

/**
 * 测试Java 9种排序算法详解和示例汇总 参考资源网址：https://juejin.im/entry/5b122391518825139e0d832d
 * 
 * @author kst
 *
 */
public class TestSortAlgorithm {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--------------原来排序--------------");
		int[] array = { 23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36 };
		System.out.println(Arrays.toString(array));
		// 第一种：冒泡排序
		System.out.println("--------------冒泡排序--------------");
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		// 第二种：选择排序
		System.out.println("--------------选择排序--------------");
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		// 第三种：直接插入排序
		// 第四种：二分法排序
		// 第五种：希尔排序
		// 第六种：快速排序
		// 第七种：堆排序
		// 第八种：归并排序
		// 第九种：基数排序
		System.out.println("--------------基数排序--------------");
		radixSort(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 冒泡排序：两两比较，大者交换位置，则每一圈比较最大的数就会冒到最后，循环直至遍历完所有
	 * 
	 * @param array
	 *            数组
	 */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 选择排序：找到当前数中最大的数字，找到后与最后一个位置的数字交换位置，直至循环遍历完所有的数为止
	 * 
	 * @param array
	 */
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			// 定义最大数字的下标，默认为0
			int max = 0;
			for (int j = 0; j < array.length - i; j++) {
				// 找到比自己大的数就更新下标
				if (array[max] < array[j]) {
					max = j;
				}
			}
			// 将找到最大的数与最后一个数字交换位置
			int temp = array[array.length - i - 1];
			array[array.length - i - 1] = array[max];
			array[max] = temp;
		}
	}

	/**
	 * 基数排序，先按个位将所有数字按照个位的值放入0-9的二维数组中，依次取出之后再按十位 如此循环直至个十百千等等所有位数遍历完为止
	 * 
	 * @param array
	 */
	public static void radixSort(int[] array) {
		// 定义二位数组用来存储每个基数以及基数下的数值
		int[][] temp;
		// 定义一维数组记录基数下保存了几位
		int[] position;
		int radix = 1;
		while (true) {
			position = new int[10];
			temp = new int[10][array.length];
			for (int i = 0; i < array.length; i++) {
				int value = (array[i] / radix) % 10;
				temp[value][position[value]] = array[i];
				position[value]++;
			}
			// 判断是否所有的数值都在0位上，都在0位上则表示排序完成
			if (position[0] == array.length) {
				break;
			}

			int index = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < position[i]; j++) {
					array[index] = temp[i][j];
					index++;
				}
			}
			radix = radix * 10;
		}
	}
}
