package com.frank.msb.threaddemo;

/**
 * ��������ѭ��
 * 
 * @author kst
 * @date 2022-01-22 22:07:00
 */
public class TestTwiceLoop {

	public static void main(String[] args) {
		out: for (;;) {
			for (;;) {
				System.out.println("������ѭ��");
				break out;
			}
		}
		System.out.println("ִ������");
	}

}
