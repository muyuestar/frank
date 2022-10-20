package com.frank.msb.threaddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * 利用CompletableFuture完成功能
 * 
 * @author kst
 * @date 2022-03-27 11:08:58
 */
public class TestCompletableFuture3 {

	private static final String USER_MSG_FORMAT = "用户信息%d";
	private static final String USER_MSG_START_FORMAT = "正在获取用户%d的信息";
	private static final String USER_MSG_END_FORMAT = "获取结束";

	public static void main(String[] args) throws Exception {
		System.out.println(Thread.currentThread() + "\t" + "开始执行业务逻辑");

		CompletableFuture<List<CompletableFuture<Void>>> completableFutureList = CompletableFuture
				.supplyAsync(TestCompletableFuture3::getUserIdList)
				.thenApplyAsync(userIdList -> userIdList.stream().map(userId -> CompletableFuture
						.supplyAsync(() -> getUserMsg(userId)).thenAccept(msg -> System.out.println(msg)))
						.collect(Collectors.toList()));

		mainThreadDoSomething();

		completableFutureList.thenAccept(completableFutures -> {
			CompletableFuture<Void> completableFuture = CompletableFuture
					.allOf(completableFutures.toArray(new CompletableFuture[1]));
			completableFuture.thenRun(() -> mainThreadDoSomething());
		}).get();
		
		Thread.sleep(20000);
		
		System.out.println(Thread.currentThread() + "\t" + "结束执行业务逻辑");
	}

	// 模拟主线程干事情
	public static void mainThreadDoSomething() {
		System.out.println(Thread.currentThread() + "\t" + "主线程开始执行别的逻辑");
		sleep();
		System.out.println(Thread.currentThread() + "\t" + "主线程结束执行别的逻辑");
	}

	// 获取用户信息
	public static String getUserMsg(Integer userId) {
		System.out.println(String.format(Thread.currentThread() + "\t" + USER_MSG_START_FORMAT, userId));
		sleep();
		System.out.println(Thread.currentThread() + "\t" + USER_MSG_END_FORMAT);
		return String.format(USER_MSG_FORMAT, userId);
	}

	// 查询数据库并返回所有用户ID列表
	public static List<Integer> getUserIdList() {
		sleep();
		return new ArrayList<Integer>() {
			{
				this.add(1);
				this.add(2);
				this.add(3);
				this.add(4);
				this.add(5);
			}
		};
	}

	// 为了模拟数据库延时操作
	public static void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
