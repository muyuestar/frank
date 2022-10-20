package com.frank.msb.threaddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 模拟引出CompletableFuture的好处
 * 
 * @author kst
 * @date 2022-03-26 20:52:00
 */
public class TestCompletableFuture1 {

	private static final String USER_MSG_FORMAT = "用户信息%d";
	private static final String USER_MSG_START_FORMAT = "正在获取用户%d的信息";
	private static final String USER_MSG_END_FORMAT = "获取结束";

	private static ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("开始执行业务逻辑");
		Future<List<Integer>> future = threadPoolExecutor.submit(TestCompletableFuture1::getUserIdList);
		mainThreadDoSomething();
		List<Integer> userIdList = future.get();
		List<Future<String>> futureList = new ArrayList<>();
		userIdList.forEach(userId -> futureList.add(threadPoolExecutor.submit(() -> getUserMsg(userId))));
		for (int i = 0; i < futureList.size(); i++) {
			String userMsg = futureList.get(i).get();
			System.out.println(userMsg);
		}
		mainThreadDoSomething();
		threadPoolExecutor.shutdown();
		threadPoolExecutor.awaitTermination(1, TimeUnit.DAYS);
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
