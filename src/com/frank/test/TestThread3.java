package com.frank.test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试多线程
 * 
 * @author kst
 * @date 2018-12-03 18:51:32
 */
public class TestThread3 {

	public static void main(String[] args) {
		// demo1();
		// demo2();
		// demo3();
		// runDAfterABC();
		// runABCWhenAllReady();
		doTaskWithResultInWorker();
	}

	/**
	 * 同时进行
	 */
	private static void demo1() {
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("A");
			}
		});

		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("B");
			}
		});

		A.start();
		B.start();
	}

	/**
	 * 两个线程依次执行 A 1, A 2, A 3, B 1, B 2, B 3
	 */
	private static void demo2() {
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("A");
			}
		});

		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("B 开始等待 A");
				try {
					A.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				printNumber("B");
			}
		});

		A.start();
		B.start();
	}

	/**
	 * 两个线程按照指定方式有序交叉运行 A 1, B 1, B 2, B 3, A 2, A 3
	 */
	private static void demo3() {
		Object lock = new Object();

		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("INFO: A 等待锁");
				synchronized (lock) {
					System.out.println("INFO: A 得到了锁 lock");
					System.out.println("A 1");
					try {
						System.out.println("INFO: A 准备进入等待状态，调用 lock.wait() 放弃锁 lock 的控制权");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("INFO: 有人唤醒了 A, A 重新获得锁 lock");
					System.out.println("A 2");
					System.out.println("A 3");
				}

			}
		});

		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("INFO: B 等待锁");
				synchronized (lock) {
					System.out.println("INFO: B 得到了锁 lock");
					System.out.println("B 1");
					System.out.println("B 2");
					System.out.println("B 3");

					System.out.println("INFO: B 打印完毕，调用 lock.notify() 方法");
					lock.notify();
				}
			}
		});

		A.start();
		B.start();
	}

	/**
	 * 打印数字
	 * 
	 * @param threadName
	 *            线程名
	 */
	private static void printNumber(String threadName) {
		int j = 0;
		while (j++ < 3) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " print: " + j);
		}
	}

	/**
	 * 四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
	 */
	private static void runDAfterABC() {
		int worker = 3;
		CountDownLatch countDownLatch = new CountDownLatch(worker);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("D is waiting for other three threads");
				try {
					countDownLatch.await();
					System.out.println("All done, D starts working");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		for (char threadName = 'A'; threadName <= 'C'; threadName++) {
			final String tN = String.valueOf(threadName);
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(tN + " is working");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(tN + " finished");
					countDownLatch.countDown();
				}
			}).start();
		}
	}

	/**
	 * 三个运动员各自准备，等到三个人都准备好后，再一起跑
	 */
	private static void runABCWhenAllReady() {
		int runner = 3;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
		final Random random = new Random();
		for (char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
			final String rN = String.valueOf(runnerName);
			new Thread(new Runnable() {
				@Override
				public void run() {
					long prepareTime = random.nextInt(10000) + 100;
					System.out.println(rN + " is preparing for time:" + prepareTime);
					try {
						Thread.sleep(prepareTime);
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						System.out.println(rN + " is prepared, waiting for others");
						cyclicBarrier.await(); // 当前运动员准备完毕，等待别人准备好
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
					System.out.println(rN + " starts running"); // 所有运动员都准备好了，一起开始跑
				}
			}).start();
		}
	}

	/**
	 * 子线程完成某件任务后，把得到的结果回传给主线程
	 */
	private static void doTaskWithResultInWorker() {
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("Task starts");
				Thread.sleep(1000);
				int result = 0;
				for (int i = 0; i <= 100; i++) {
					result += i;
				}
				System.out.println("Task finished and return result");
				return result;
			}
		};
		FutureTask<Integer> futureTask = new FutureTask<>(callable);
		new Thread(futureTask).start();
		try {
			System.out.println("Before futureTask.get()");
			System.out.println("Result:" + futureTask.get());
			System.out.println("After futureTask.get()");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
