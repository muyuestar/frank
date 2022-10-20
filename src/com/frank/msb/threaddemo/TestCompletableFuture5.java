package com.frank.msb.threaddemo;

import java.util.concurrent.CompletableFuture;

/**
 * ����CompletableFuture��ɹ���
 * 
 * @author kst
 * @date 2022-03-27 23:06:32
 */
public class TestCompletableFuture5 {

	public static void main(String[] args) throws Exception {
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> commonAction("����1"));
		completableFuture.thenRun(() -> System.out.println(1));
		completableFuture.thenRun(() -> System.out.println(2));
		completableFuture.thenRun(() -> System.out.println(3));
		completableFuture.thenRun(() -> System.out.println(4));
		completableFuture.get();
	}

	public static void commonAction(String action) {
		System.out.println(action + "\t" + "start");
		// ����sleep�Ժ󣬾Ͳ��ᰴ��1234�������ͻᰴ��linked stack�������4321��
		// û��sleep����1234����ΪuniRunStage��Executor������nullֵ���ͻ�ȥִ��uniRun����������commonAction�ܿ�����ˣ���ǰ��
		// CompletableFuture��Ϊnull���ͻ�����ȥִ��Runnable��run����������ֱ�����1234
		// ����sleep��ִ��uniRun������commonAction����ִ�У�û�н�������ǰ��CompletableFuture�����null���ͻ᳢��ȥѹջ�����Ի����4321
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(action + "\t" + "end");
	}

}
