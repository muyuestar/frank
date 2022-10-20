package com.frank.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 进程终止
 * 
 * @author kst
 * @date 2018-12-03 17:07:34
 */
public class TestExecutorService {

	private static boolean exit = false;

	public static void main(String[] args) {
		Callable<String> task = new Callable<String>() {
			@Override
			public String call() throws Exception {
				int i = 1;
				while (!exit) {
					System.out.println("第" + (i++) + "次输出");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// e.printStackTrace();
					}
				}
				return "success";
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(task);
		// try {
		// String result = future.get(2, TimeUnit.SECONDS);
		// System.out.println("result=" + result);
		// } catch (InterruptedException e1) {
		//
		// } catch (ExecutionException e2) {
		//
		// } catch (TimeoutException e3) {
		// System.out.println("false");
		// exit = true;
		// executorService.shutdownNow();
		// } finally {
		// executorService.shutdownNow();
		// }
	}
}
