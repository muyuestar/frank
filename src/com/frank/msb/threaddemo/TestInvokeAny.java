package com.frank.msb.threaddemo;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.collect.Lists;

/**
 * 测试AbstractExecutorService中的invokeAny方法，任务都会执行，但是只会返回一个结果
 * 
 * @author kst
 * @date 2022-01-20 23:07:28
 */
public class TestInvokeAny {

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ArrayList<Callable<Integer>> tasks = Lists.newArrayList(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				System.out.println("1");
				return 1;
			}

		}, new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				try {
					Thread.sleep(1000);
					System.out.println("2");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 2;
			}
		});
		Integer retCode = executorService.invokeAny(tasks);
		System.out.println(retCode);
	}

}
