package com.frank.msb.threaddemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 测试runAfterEither方法
 * 
 * @author kst
 * @date 2022-04-02 14:21:37
 */
public class TestCompletableFuture7 {

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

		CompletableFuture cf3 = cf1.runAfterEither(cf2, () -> System.out.println("all end"));
		cf3.get();

		// get之后，commone FJP线程池结束了，主线程也结束了，如果休眠了时间合计2000ms以上,cf2 end就会结束掉
		Thread.sleep(1000);
	}

}
