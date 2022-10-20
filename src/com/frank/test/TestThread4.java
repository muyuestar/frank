package com.frank.test;

/**
 * ���Զ��߳�
 * 
 * @author kst
 * @date 2018-12-03 18:51:32
 */
public class TestThread4 extends Thread {
	private volatile boolean exit = false;

	public void run() {
		int i = 1;
		while (!exit) {
			System.out.println("��" + (i++) + "�����");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TestThread4 thread = new TestThread4();
		thread.start();
		sleep(5000); // ���߳��ӳ�5��
		thread.exit = true; // ��ֹ�߳�thread
		thread.join();
		System.out.println("�߳��˳�!");
	}
}
