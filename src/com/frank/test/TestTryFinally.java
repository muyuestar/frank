package com.frank.test;

/**
 * ≤‚ ‘finally
 *
 * @author: kst
 * @date: 2022/11/7 9:19
 */
public class TestTryFinally {

    public static String test() {
        try {
            System.out.println("111");
            return "success";
        } catch (Exception e) {
            System.out.println("222");
            return "fail";
        } finally {
            System.out.println("333");
        }
    }

    public static void main(String[] args) {
        String str = test();
        System.out.println(str);
    }

}
