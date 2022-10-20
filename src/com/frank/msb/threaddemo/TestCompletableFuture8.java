package com.frank.msb.threaddemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 测试exceptionally
 * 
 * @author kst
 * @date 2022-04-02 15:08:18
 */
public class TestCompletableFuture8 {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// runAsync和exceptionally结合用法
//		CompletableFuture cf1 = CompletableFuture.runAsync(() -> {
//			System.out.println("cf1 start");
//			int i = 1 / 0;
//			System.out.println("cf1 end");
//		}).exceptionally(e -> {
//			e.printStackTrace();
//			return null;
//		});
////		cf1.get();
//		Thread.sleep(1000);

		// supplier和excepitonally结合用法
		CompletableFuture cf2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("cf2 start");
			int i = 1 / 0;
			System.out.println("cf2 end");
			return 1;
		}).exceptionally(e -> {
			e.printStackTrace();
			return 2;
		});
		Thread.sleep(1000);
		System.out.println(cf2.get());
	}

}
