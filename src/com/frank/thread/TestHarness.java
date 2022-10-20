package com.frank.thread;

import java.util.concurrent.CountDownLatch;

/**
 * �ڼ�ʱ������ʹ��CountDownLatch��������ֹͣ�߳�
 * 
 * @author kst
 * @date 2019-07-14 20:53:03
 */
public class TestHarness {

	public static void main(String[] args) throws InterruptedException {
		Thread harness = new Thread() {
			public void run() {
				System.out.println("��ʼִ���߳�����" + System.currentTimeMillis());
			};
		};
		harness.start();
		long timeDifference = timeTasks(100, harness);
		System.out.println("ʱ��" + timeDifference + "ns");
	}

	/**
	 * ����n���̲߳���ִ��ĳ������ʱ��Ҫ��ʱ��
	 * 
	 * @param nThreads
	 *            �߳���
	 * @param task
	 *            ����
	 * @return ʱ��
	 * @throws InterruptedException
	 */
	public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException e) {

					}
				}
			};
			t.start();
		}

		long startTime = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
}
