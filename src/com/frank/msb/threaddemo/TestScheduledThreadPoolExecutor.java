package com.frank.msb.threaddemo;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ����ScheduledThreadPoolExecutor
 * 
 * @author kst
 * @date 2022-02-16 21:14:00
 */
public class TestScheduledThreadPoolExecutor {

	public static void main(String[] args) {
		// ScheduledThreadPoolExecutorʹ�ð���
//		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(1);
//		stpe.schedule(() -> System.out.println("ִ������"), 2, TimeUnit.SECONDS);

		// ������ʼִ������̶�ʱ�䣬����������ʱ��
//		stpe.scheduleAtFixedRate(() -> {
//			System.out.println(new Date());
//			try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//
//			}
//		}, 0, 2, TimeUnit.SECONDS);

		// ������ִ�н���������̶�ʱ�䣬��������ʱ��
//		stpe.scheduleWithFixedDelay(() -> {
//			System.out.println(new Date());
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//			}
//		}, 0, 2, TimeUnit.SECONDS);

		// ScheduledThreadPoolExecutor���̳߳ؽ��ʹ�ã�ʵ�ֲַ�ʽ���ȷ���
		ExecutorService executorService = Executors.newCachedThreadPool();
		// ���ú����߳���1����ʱ�޽�
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
		executor.schedule(() -> {
			// executorService�̳߳ز�����executorִ��
			executorService.execute(() -> {
				try {
					System.out.println("hello");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}, 1, TimeUnit.SECONDS);
	}

}
