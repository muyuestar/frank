package com.frank.msb.threaddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * ����CompletableFuture��ɹ���
 * 
 * @author kst
 * @date 2022-03-27 11:08:58
 */
public class TestCompletableFuture3 {

	private static final String USER_MSG_FORMAT = "�û���Ϣ%d";
	private static final String USER_MSG_START_FORMAT = "���ڻ�ȡ�û�%d����Ϣ";
	private static final String USER_MSG_END_FORMAT = "��ȡ����";

	public static void main(String[] args) throws Exception {
		System.out.println(Thread.currentThread() + "\t" + "��ʼִ��ҵ���߼�");

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
		
		System.out.println(Thread.currentThread() + "\t" + "����ִ��ҵ���߼�");
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
