package com.frank.googleguava;

import com.google.common.base.CharMatcher;

/**
 * SmallCharMatcher extends CharMatcher
 *
 * @author: kst
 * @date: 2024/12/5 9:04
 */
public class CharMatcherTest {

    public static void main(String[] args) {
        // ƥ���ض��ַ���ͳ���ַ����ִ���
//        int count = CharMatcher.is('p').countIn("apple");
//        System.out.println(count);


        // ƥ���ַ���Χ
//        String str = CharMatcher.inRange('a', 'z').retainFrom("aHbJc123DEF");
//        String str = CharMatcher.inRange('A', 'Z').retainFrom("aHbJc123DEF");
//        String str = CharMatcher.inRange('1', '9').retainFrom("a4HbJc123DE9F");
//        System.out.println(str);


        // ƥ�������ַ�
//        String str = CharMatcher.digit().retainFrom("a1b2c3D4E5F");
//        System.out.println(str);


        // ƥ��հ��ַ�
//        int i = CharMatcher.whitespace().countIn("  a bc\td");
//        System.out.println(i);


        // ƥ��Ȳ�������Ҳ���ǿհ��ַ����ַ���guava�汾��ƥ��
//        String str = CharMatcher.not(CharMatcher.digit()).and(CharMatcher.not(CharMatcher.whitespace())).retainFrom("  a1b\tc");
//        System.out.println(str);


        // and or ���ƥ��
//        String str = CharMatcher.inRange('a', 'z').and(CharMatcher.anyOf("bc")).retainFrom("abc123DEF");
//        System.out.println(str);

    }

}
