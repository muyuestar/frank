package com.frank.lambda;

/**
 * �����߳�Lambda
 * 
 * @author kst
 * @date 2021-11-20 20:19:06
 */
public class TheadDemo {

	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("�����߳�");
		}).start();
	}

}
