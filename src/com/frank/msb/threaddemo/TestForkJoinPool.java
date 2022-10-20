package com.frank.msb.threaddemo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 测试ForkJoinPool
 * 
 * @author kst
 * @date 2022-03-07 21:14:14
 */
public class TestForkJoinPool {

	public static void main(String[] args) throws Exception {
		ForkJoinPool fork = new ForkJoinPool();
		// fork如何初始化
		fork.submit(() -> System.out.println("hello fork."));
		fork.shutdown();
		fork.awaitTermination(1, TimeUnit.SECONDS);
	}

}
