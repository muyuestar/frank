package com.frank.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 在计时测试中使用CountDownLatch来启动和停止线程
 * 
 * @author kst
 * @date 2019-07-14 20:53:03
 */
public class TestHarness {

	public static void main(String[] args) throws InterruptedException {
		Thread harness = new Thread() {
			public void run() {
				System.out.println("开始执行线程任务：" + System.currentTimeMillis());
			};
		};
		harness.start();
		long timeDifference = timeTasks(100, harness);
		System.out.println("时间差：" + timeDifference + "ns");
	}

	/**
	 * 测试n个线程并发执行某个任务时需要的时间
	 * 
	 * @param nThreads
	 *            线程数
	 * @param task
	 *            任务
	 * @return 时间
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
