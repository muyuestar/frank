package com.frank.test;

import java.util.Arrays;

/**
 * ����Java 9�������㷨����ʾ������ �ο���Դ��ַ��https://juejin.im/entry/5b122391518825139e0d832d
 * 
 * @author kst
 *
 */
public class TestSortAlgorithm {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--------------ԭ������--------------");
		int[] array = { 23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36 };
		System.out.println(Arrays.toString(array));
		// ��һ�֣�ð������
		System.out.println("--------------ð������--------------");
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		// �ڶ��֣�ѡ������
		System.out.println("--------------ѡ������--------------");
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		// �����֣�ֱ�Ӳ�������
		// �����֣����ַ�����
		// �����֣�ϣ������
		// �����֣���������
		// �����֣�������
		// �ڰ��֣��鲢����
		// �ھ��֣���������
		System.out.println("--------------��������--------------");
		radixSort(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * ð�����������Ƚϣ����߽���λ�ã���ÿһȦ�Ƚ��������ͻ�ð�����ѭ��ֱ������������
	 * 
	 * @param array
	 *            ����
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
	 * ѡ�������ҵ���ǰ�����������֣��ҵ��������һ��λ�õ����ֽ���λ�ã�ֱ��ѭ�����������е���Ϊֹ
	 * 
	 * @param array
	 */
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			// ����������ֵ��±꣬Ĭ��Ϊ0
			int max = 0;
			for (int j = 0; j < array.length - i; j++) {
				// �ҵ����Լ�������͸����±�
				if (array[max] < array[j]) {
					max = j;
				}
			}
			// ���ҵ������������һ�����ֽ���λ��
			int temp = array[array.length - i - 1];
			array[array.length - i - 1] = array[max];
			array[max] = temp;
		}
	}

	/**
	 * ���������Ȱ���λ���������ְ��ո�λ��ֵ����0-9�Ķ�ά�����У�����ȡ��֮���ٰ�ʮλ ���ѭ��ֱ����ʮ��ǧ�ȵ�����λ��������Ϊֹ
	 * 
	 * @param array
	 */
	public static void radixSort(int[] array) {
		// �����λ���������洢ÿ�������Լ������µ���ֵ
		int[][] temp;
		// ����һά�����¼�����±����˼�λ
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
			// �ж��Ƿ����е���ֵ����0λ�ϣ�����0λ�����ʾ�������
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
