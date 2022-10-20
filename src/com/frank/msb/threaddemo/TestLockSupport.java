package com.frank.msb.threaddemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ģ������
 * 
 * @author kst
 * @date 2022-03-20 20:47:05
 */
public class TestLockSupport {

	public static void main(String[] args) throws Exception {
		// ��һ��
		ReentrantLock r1 = new ReentrantLock();
		ReentrantLock r2 = new ReentrantLock();
		CountDownLatch countDownLatch = new CountDownLatch(1);
		r1.lock();
		new Thread(() -> {
			r2.lock();
			countDownLatch.countDown();
			r1.lock();
		}).start();
		countDownLatch.await();
		r2.lock();
		
		// �ڶ���
//		LockSupport.park();
		
		
	}

}
