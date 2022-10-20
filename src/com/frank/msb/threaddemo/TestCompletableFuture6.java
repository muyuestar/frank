package com.frank.msb.threaddemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ²âÊÔrunAfterBoth()
 * 
 * @author kst
 * @date 2022-04-02 11:17:19
 */
public class TestCompletableFuture6 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture cf1 = CompletableFuture.runAsync(() -> {
			System.out.println("cf1 start");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("cf1 end");
		});

		CompletableFuture cf2 = CompletableFuture.runAsync(() -> {
			System.out.println("cf2 start");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("cf2 end");
		});

		cf1.runAfterBoth(cf2, () -> System.out.println("all end")).get();
	}

}
