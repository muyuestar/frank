package com.frank.msb.threaddemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * ≤‚ ‘FutureTask
 * 
 * @author kst
 * @date 2022-03-26 10:03:25
 */
public class TestFutureTask {

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return 1;
			}
		});

		executorService.submit(futureTask);
		System.out.println(futureTask.get());
	}

}
