package com.frank.test;

/**
 * ����StringBuilder
 * 
 * @author kst
 *
 */
public class TestStringBuilder {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("1").append("2").append("3").append("4").append("5");
		System.out.println("��ʼ�ַ���=" + sb.toString());
		sb.insert(1, "a");
		System.out.println("�������ַ���=" + sb.toString());
	}
}
