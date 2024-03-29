package com.frank.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替执行打印 1~100
 * 
 * @author kst
 *
 */
public class PrintOddEvenNum {
	private int start = 1;

	/**
	 * 保证内存可见性 其实用锁了之后也可以保证可见性 这里用不用 volatile 都一样
	 */
	private boolean flag = false;

	/**
	 * 重入锁
	 */
	private final static Lock LOCK = new ReentrantLock();

	public static void main(String[] args) {
		PrintOddEvenNum printOddEvenNum = new PrintOddEvenNum();
		Thread t1 = new Thread(new OuNum(printOddEvenNum));
		t1.setName("t1偶数线程");
		Thread t2 = new Thread(new JiNum(printOddEvenNum));
		t2.setName("t2奇数线程");
		t1.start();
		t2.start();
	}

	/**
	 * 偶数线程
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
						// 防止线程空转
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 奇数线程
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
						// 防止线程空转
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
