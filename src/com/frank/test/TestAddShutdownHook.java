package com.frank.test;

/**
 * @author kst
 * @date 2019-01-31 16:03:44 ����
 */
public class TestAddShutdownHook {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				System.out.println("�߳�1");
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				System.out.println("�߳�2");
			}
		};
		Thread t3 = new Thread() {
			@Override
			public void run() {
				System.out.println("shutdownThread");
			}
		};
		Runtime.getRuntime().addShutdownHook(t3);
		t1.start();
		t2.start();
	}
}
