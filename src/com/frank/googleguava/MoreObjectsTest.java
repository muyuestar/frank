package com.frank.googleguava;

import com.google.common.base.MoreObjects;

/**
 * @author: kst
 * @date: 2024/12/4 8:54
 */
public class MoreObjectsTest {

    public static void main(String[] args) {
        // ���ص�1���ǿ�ֵ
//        String str = MoreObjects.firstNonNull(null, "apple");
//        System.out.println(str);


        // �����Զ���toString()��Ϣ
        Person person = new Person("apple", 20);
        System.out.println(person.toString());
    }
}
