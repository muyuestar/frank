package com.frank.test;

/**
 * @author: kst
 * @date: 2025/4/18 17:09
 */
public class TestThread5 {

    public static void main(String[] args) {
//        new Thread() {
//            @Override
//            public void run() {
//                System.out.println("11");
//            }
//        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("11111");
            }
        }).start();
    }
}
