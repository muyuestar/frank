package com.frank.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author kst
 * @date 2019-03-22 11:20:26 ����CountDownLatch
 */
public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);

        // ���δ���������5��worker�߳�
        for (int i = 0; i < 5; ++i) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }


        System.out.println("Driver is doing something...");
        System.out.println("Driver is Finished, start all workers ...");
        startSignal.countDown(); // Driverִ����ϣ�������ʼ�źţ�ʹ���е�worker�߳̿�ʼִ��
        doneSignal.await(); // �ȴ����е�worker�߳�ִ�н���
        System.out.println("Finished.");
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            startSignal.await(); // �ȴ�Driver�߳�ִ����ϣ���ÿ�ʼ�ź�
            System.out.println("Working now ...");
            doneSignal.countDown(); // ��ǰworkerִ����ϣ��ͷ�һ������ź�
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
