package com.frank.msb.threaddemo;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试ScheduledThreadPoolExecutor
 * 
 * @author kst
 * @date 2022-02-16 21:14:00
 */
public class TestScheduledThreadPoolExecutor {

	public static void main(String[] args) {
		// ScheduledThreadPoolExecutor使用案例
//		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(1);
//		stpe.schedule(() -> System.out.println("执行任务"), 2, TimeUnit.SECONDS);

		// 从任务开始执行起算固定时间，不包括操作时间
//		stpe.scheduleAtFixedRate(() -> {
//			System.out.println(new Date());
//			try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//
//			}
//		}, 0, 2, TimeUnit.SECONDS);

		// 从任务执行结束后起算固定时间，包括操作时间
//		stpe.scheduleWithFixedDelay(() -> {
//			System.out.println(new Date());
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//			}
//		}, 0, 2, TimeUnit.SECONDS);

		// ScheduledThreadPoolExecutor和线程池结合使用，实现分布式调度方案
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 设置核心线程数1，此时无界
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
		executor.schedule(() -> {
			// executorService线程池不阻塞executor执行
			executorService.execute(() -> {
				try {
					System.out.println("hello");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}, 1, TimeUnit.SECONDS);
	}

}
