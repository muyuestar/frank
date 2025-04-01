package com.frank.googleguava;

import com.google.common.base.MoreObjects;

/**
 * @author: kst
 * @date: 2024/12/4 8:54
 */
public class MoreObjectsTest {

    public static void main(String[] args) {
        // 返回第1个非空值
//        String str = MoreObjects.firstNonNull(null, "apple");
//        System.out.println(str);


        // 返回自定义toString()信息
        Person person = new Person("apple", 20);
        System.out.println(person.toString());
    }
}
