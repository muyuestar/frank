package com.frank.test;

/**
 * ���Զ��߳�
 * 
 * @author kst
 * @date 2018-12-03 18:51:32
 */
public class TestThread2 {

	public static void main(String[] args) {
		System.out.println("��ʼִ���߳�");
		Thread t1 = new Thread() {
			@Override
			public void run() {
				int i = 0;
				while (true) {
					System.out.println("��" + (i++) + "�����");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
//						e.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
	}
}
