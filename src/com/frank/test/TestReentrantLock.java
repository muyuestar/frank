package com.frank.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ≤‚ ‘ReentrantLock
 *
 * @author: kst
 * @date: 2025/4/14 11:20
 */
public class TestReentrantLock {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ReentrantLock reentrantLock = new ReentrantLock();
        int[] counts = new int[]{0};
        for (int i = 0; i < 10000; i++) {
            executorService.submit(() -> {
                try {
                    reentrantLock.lock();
                    counts[0]++;

                } catch (Exception e) {
                    System.out.println(e.toString());
                } finally {
                    reentrantLock.unlock();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println(counts[0]);
    }
}
