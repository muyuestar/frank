package com.frank.msb.threaddemo;

import java.util.concurrent.CompletableFuture;

/**
 * 利用CompletableFuture完成功能
 * 
 * @author kst
 * @date 2022-03-27 11:56:43
 */
public class TestCompletableFuture4 {

	public static void main(String[] args) throws Exception {
		CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> commonAction("stage1"));
		CompletableFuture<Void> completableFuture2 = completableFuture1.thenRunAsync(() -> commonAction("stage2"));
		completableFuture2.thenRunAsync(() -> commonAction("stage3"));
		CompletableFuture<Void> completableFuture = completableFuture2.thenRunAsync(() -> commonAction("stage4"))
				.thenRunAsync(() -> commonAction("stage5"));
//		completableFuture.get();
	}

	public static void commonAction(String action) {
		System.out.println(action + "\t" + "start");
		System.out.println(action + "\t" + "end");
	}

}
