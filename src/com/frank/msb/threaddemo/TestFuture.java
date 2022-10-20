package com.frank.msb.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future测试
 * 
 * @author kst
 * @date 2022-03-25 14:02:34
 */
public class TestFuture{

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<?> future = executorService.submit(() -> {
			System.out.println("start");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end");
		});

		System.out.println(future.isDone());

//		Thread.sleep(2000);
		
		// 无限期阻塞等待
		future.get();
		
		// 等待2s 阻塞
//		future.get(2, TimeUnit.SECONDS);
		
		// 如果是uture.get(2, TimeUnit.SECONDS)，由于阻塞，下面的代码不会执行
		// 如果是future.get()，下面的代码会执行
		System.out.println("222");
//		System.out.println(future.isDone());
		if (!future.isDone()) {
			System.out.println("333");
			future.cancel(true);
		}

	}

}
