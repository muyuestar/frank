package com.frank.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ���Զ�ά����
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
		// ��ά�������
		System.out.println("-------------��ά�������-------------");
		for (int[] arr : array) {
			System.out.println(Arrays.toString(arr));
		}
		// ��ά����ķ�ת---ͷβ����
		System.out.println("-------------��ά����ķ�ת-------------");
		for (int start = 0, end = array.length - 1; start < end; start++, end--) {
			int[] temp = array[start];
			array[start] = array[end];
			array[end] = temp;
		}
		for (int[] arr : array) {
			System.out.println(Arrays.toString(arr));
		}
		// �ӿ���̨������������ӡ��Ӧ���������
		System.out.println("-------------��ӡ�������-------------");
		// �ӿ���̨��ȡ����
		Scanner s = new Scanner(System.in);
		int row = s.nextInt();
		// ������������ö�ά���飬����ÿһ�е�Ԫ�ظ�����ͬ�����Բ�����ÿһ�еĸ���
		int[][] arr = new int[row][];
		// ������ά����
		for (int i = 0; i < row; i++) {
			// ��ʼ��ÿһ�е����һά����:j=i+1
			arr[i] = new int[i + 1];
			// �������һά���飬���Ԫ��
			for (int j = 0; j <= i; j++) {
				// ÿһ�еĿ�ͷ�ͽ�βԪ�أ���ͷ��ʱ��j=0����β��ʱ��j=i
				if (j == 0 || j == i) {
					arr[i][j] = 1;
				} else {// ÿһ��Ԫ��������һ�е�Ԫ�غ�б�Խ�Ԫ��֮��
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
