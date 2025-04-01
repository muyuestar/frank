package com.frank.googleguava;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author: kst
 * @date: 2024/12/18 17:15
 */
public class StopwatchTest {

    public static void main(String[] args) throws Exception {
        // ������������ʱ��
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        Thread.sleep(1000L);
//        long elapsed = stopwatch.stop().elapsed(TimeUnit.MILLISECONDS);
//        System.out.println("��ʱ=" + elapsed + "����");


        // ����δ�����Ķ�ʱ��
//        Stopwatch stopwatch = Stopwatch.createUnstarted();
//        stopwatch.start();
//        Thread.sleep(2000L);
//        stopwatch.stop();
//        long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
//        System.out.println("��ʱ=" + elapsed + "����");


        // ���ö�ʱ��
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        Thread.sleep(2000L);
//        stopwatch.stop();
//        stopwatch.reset();
//        stopwatch.start();
//        Thread.sleep(5000L);
//        long elapsed = stopwatch.stop().elapsed(TimeUnit.MILLISECONDS);
//        System.out.println("��ʱ=" + elapsed + "����");


        // ����ʱ���Ƿ�������
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        Thread.sleep(2000L);
//        boolean running = stopwatch.isRunning();
//        System.out.println(running);
//        stopwatch.stop();


        // ���ַ�����ʽ���������ʱ��
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(2000L);
        String s = stopwatch.stop().toString();
        System.out.println(s);
    }
}
