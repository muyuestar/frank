package com.frank.msb.threaddemo;

import java.util.concurrent.CompletableFuture;

/**
 * 利用CompletableFuture完成功能
 * 
 * @author kst
 * @date 2022-03-27 23:06:32
 */
public class TestCompletableFuture5 {

	public static void main(String[] args) throws Exception {
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> commonAction("动作1"));
		completableFuture.thenRun(() -> System.out.println(1));
		completableFuture.thenRun(() -> System.out.println(2));
		completableFuture.thenRun(() -> System.out.println(3));
		completableFuture.thenRun(() -> System.out.println(4));
		completableFuture.get();
	}

	public static void commonAction(String action) {
		System.out.println(action + "\t" + "start");
		// 加上sleep以后，就不会按照1234弹出，就会按照linked stack弹出结果4321。
		// 没加sleep弹出1234是因为uniRunStage中Executor传的是null值，就会去执行uniRun方法，由于commonAction很快结束了，当前的
		// CompletableFuture不为null，就会立马去执行Runnable的run方法，所以直接输出1234
		// 加上sleep后，执行uniRun方法，commonAction还在执行，没有结束，当前的CompletableFuture结果是null，就会尝试去压栈，所以会输出4321
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(action + "\t" + "end");
	}

}
