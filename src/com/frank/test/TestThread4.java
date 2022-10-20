package com.frank.test;

/**
 * 测试多线程
 * 
 * @author kst
 * @date 2018-12-03 18:51:32
 */
public class TestThread4 extends Thread {
	private volatile boolean exit = false;

	public void run() {
		int i = 1;
		while (!exit) {
			System.out.println("第" + (i++) + "次输出");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TestThread4 thread = new TestThread4();
		thread.start();
		sleep(5000); // 主线程延迟5秒
		thread.exit = true; // 终止线程thread
		thread.join();
		System.out.println("线程退出!");
	}
}
