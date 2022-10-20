package com.frank.msb.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ≤‚ ‘‘≠◊”–‘
 * 
 * @author kst
 * @date 2022-04-03 16:52:54
 */
public class TestAtomic {

	public static int count;

	public static synchronized void incr() {
		count++;
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++) {
			executorService.execute(() -> incr());
		}
		executorService.shutdown();
		executorService.awaitTermination(2, TimeUnit.SECONDS);
		System.out.println(count);
	}

}
