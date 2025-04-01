package com.frank.googleguava;

import com.google.common.base.Utf8;

import java.nio.charset.StandardCharsets;

/**
 * @author: kst
 * @date: 2024/12/19 17:39
 */
public class Utf8Test {

    public static void main(String[] args) {
        // 计算UTF-8编码长度
//        int len = Utf8.encodedLength("Hello,世界您好");
//        System.out.println(len);


        // 检查utf-8编码有效性
        boolean flag = Utf8.isWellFormed(new StringBuilder("apple").toString().getBytes(StandardCharsets.UTF_8));
        System.out.println(flag);

    }
}
