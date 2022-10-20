package com.frank.msb.threaddemo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * 利用RecursiveTask执行FJP裂变的任务
 * 
 * @author kst
 * @date 2022-03-24 09:59:07
 */
public class TestRecursiveTask {

	public static void main(String[] args) throws Exception {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		MyThread t = new MyThread(2);
		forkJoinPool.execute(t);
		forkJoinPool.shutdown();
		forkJoinPool.awaitTermination(1, TimeUnit.DAYS);
	}

	static final class MyThread extends RecursiveTask<Integer> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		int num;

		public MyThread(int num) {
			this.num = num;
		}

		@Override
		protected Integer compute() {
			if (num == 1) {
				return num;
			}
			MyThread t1 = new MyThread(1);
			MyThread t2 = new MyThread(1);
			t1.fork();
			t2.fork();
			t1.join();
			t2.join();
			try {
				int result = t1.get() + t2.get();
				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}

	}

}
