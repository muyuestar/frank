package com.frank.msb.threaddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ģ������CompletableFuture�ĺô�
 * 
 * @author kst
 * @date 2022-03-26 20:52:00
 */
public class TestCompletableFuture1 {

	private static final String USER_MSG_FORMAT = "�û���Ϣ%d";
	private static final String USER_MSG_START_FORMAT = "���ڻ�ȡ�û�%d����Ϣ";
	private static final String USER_MSG_END_FORMAT = "��ȡ����";

	private static ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("��ʼִ��ҵ���߼�");
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

	// ģ�����̸߳�����
	public static void mainThreadDoSomething() {
		System.out.println(Thread.currentThread() + "\t" + "���߳̿�ʼִ�б���߼�");
		sleep();
		System.out.println(Thread.currentThread() + "\t" + "���߳̽���ִ�б���߼�");
	}

	// ��ȡ�û���Ϣ
	public static String getUserMsg(Integer userId) {
		System.out.println(String.format(Thread.currentThread() + "\t" + USER_MSG_START_FORMAT, userId));
		sleep();
		System.out.println(Thread.currentThread() + "\t" + USER_MSG_END_FORMAT);
		return String.format(USER_MSG_FORMAT, userId);
	}

	// ��ѯ���ݿⲢ���������û�ID�б�
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

	// Ϊ��ģ�����ݿ���ʱ����
	public static void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
