package com.frank.googleguava;

import com.google.common.base.Utf8;

import java.nio.charset.StandardCharsets;

/**
 * @author: kst
 * @date: 2024/12/19 17:39
 */
public class Utf8Test {

    public static void main(String[] args) {
        // ����UTF-8���볤��
//        int len = Utf8.encodedLength("Hello,��������");
//        System.out.println(len);


        // ���utf-8������Ч��
        boolean flag = Utf8.isWellFormed(new StringBuilder("apple").toString().getBytes(StandardCharsets.UTF_8));
        System.out.println(flag);

    }
}
