package com.frank.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author: kst
 * @date: 2025/3/4 17:59
 */
public class TestCountDownLatch1 {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Action(countDownLatch, i).start();
        }
        System.out.println("主线程等待子线程执行任务");
        countDownLatch.await();
        System.out.println("主线程结束");
    }
}

class Action extends Thread {
    private CountDownLatch latch;
    private int id;

    public Action(CountDownLatch latch, int id) {
        this.latch = latch;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程" + id + "开始执行任务");
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("线程" + id + "结束执行任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }

    }
}
