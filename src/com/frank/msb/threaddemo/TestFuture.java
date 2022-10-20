package com.frank.msb.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future����
 * 
 * @author kst
 * @date 2022-03-25 14:02:34
 */
public class TestFuture{

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<?> future = executorService.submit(() -> {
			System.out.println("start");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end");
		});

		System.out.println(future.isDone());

//		Thread.sleep(2000);
		
		// �����������ȴ�
		future.get();
		
		// �ȴ�2s ����
//		future.get(2, TimeUnit.SECONDS);
		
		// �����uture.get(2, TimeUnit.SECONDS)����������������Ĵ��벻��ִ��
		// �����future.get()������Ĵ����ִ��
		System.out.println("222");
//		System.out.println(future.isDone());
		if (!future.isDone()) {
			System.out.println("333");
			future.cancel(true);
		}

	}

}
