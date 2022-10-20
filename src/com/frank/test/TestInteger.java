package com.frank.test;

/**
 * ����Integer�з���
 * 
 * @author kst
 *
 */
public class TestInteger {

	public static void main(String[] args) {
		int i = 170;
		// ����ת���ɶ�������
		System.out.println("Binary=" + Integer.toBinaryString(i));
		// ����ָ�� int ֵ�Ķ����Ʋ����ʾ��ʽ�� 1 λ������
		System.out.println("1λ����=" + Integer.bitCount(i));
		// ���ؾ������൥�� 1 λ�� int ֵ����ָ���� int ֵ�����λ������ߣ��� 1 λ��λ��
		System.out.println("ֵ���λ=" + Integer.highestOneBit(i));
		// ���ؾ������൥�� 1 λ�� int ֵ����ָ���� int ֵ�����λ�����ұߣ��� 1 λ��λ��
		System.out.println("���λ=" + Integer.lowestOneBit(i));
		// ��ָ�� int ֵ�Ķ����Ʋ����ʾ��ʽ�����λ������ߣ��� 1 λ֮ǰ��������λ������
		System.out.println(Integer.numberOfLeadingZeros(i));
		// ����ָ���� int ֵ�Ķ����Ʋ����ʾ��ʽ����ͣ������ұߡ�����Ϊ 1 ��λ�������λ����
		System.out.println(Integer.numberOfTrailingZeros(i));
	}
}
