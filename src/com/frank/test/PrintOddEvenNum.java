package com.frank.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �����߳̽���ִ�д�ӡ 1~100
 * 
 * @author kst
 *
 */
public class PrintOddEvenNum {
	private int start = 1;

	/**
	 * ��֤�ڴ�ɼ��� ��ʵ������֮��Ҳ���Ա�֤�ɼ��� �����ò��� volatile ��һ��
	 */
	private boolean flag = false;

	/**
	 * ������
	 */
	private final static Lock LOCK = new ReentrantLock();

	public static void main(String[] args) {
		PrintOddEvenNum printOddEvenNum = new PrintOddEvenNum();
		Thread t1 = new Thread(new OuNum(printOddEvenNum));
		t1.setName("t1ż���߳�");
		Thread t2 = new Thread(new JiNum(printOddEvenNum));
		t2.setName("t2�����߳�");
		t1.start();
		t2.start();
	}

	/**
	 * ż���߳�
	 */
	public static class OuNum implements Runnable {
		private PrintOddEvenNum number;

		public OuNum(PrintOddEvenNum number) {
			this.number = number;
		}

		@Override
		public void run() {
			while (number.start <= 100) {
				if (number.flag) {
					try {
						LOCK.lock();
						System.out.println(Thread.currentThread().getName() + "=" + number.start);
						number.start++;
						number.flag = false;
					} finally {
						LOCK.unlock();
					}
				} else {
					try {
						// ��ֹ�߳̿�ת
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * �����߳�
	 */
	public static class JiNum implements Runnable {
		private PrintOddEvenNum number;

		public JiNum(PrintOddEvenNum number) {
			this.number = number;
		}

		@Override
		public void run() {
			while (number.start <= 100) {
				if (!number.flag) {
					try {
						LOCK.lock();
						System.out.println(Thread.currentThread().getName() + "=" + number.start);
						number.start++;
						number.flag = true;

					} finally {
						LOCK.unlock();
					}
				} else {
					try {
						// ��ֹ�߳̿�ת
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
