package com.frank.msb.threaddemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ����runAfterEither����
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

		// get֮��commone FJP�̳߳ؽ����ˣ����߳�Ҳ�����ˣ����������ʱ��ϼ�2000ms����,cf2 end�ͻ������
		Thread.sleep(1000);
	}

}
