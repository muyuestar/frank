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
        // 匹配特定字符，统计字符出现次数
//        int count = CharMatcher.is('p').countIn("apple");
//        System.out.println(count);


        // 匹配字符范围
//        String str = CharMatcher.inRange('a', 'z').retainFrom("aHbJc123DEF");
//        String str = CharMatcher.inRange('A', 'Z').retainFrom("aHbJc123DEF");
//        String str = CharMatcher.inRange('1', '9').retainFrom("a4HbJc123DE9F");
//        System.out.println(str);


        // 匹配数字字符
//        String str = CharMatcher.digit().retainFrom("a1b2c3D4E5F");
//        System.out.println(str);


        // 匹配空白字符
//        int i = CharMatcher.whitespace().countIn("  a bc\td");
//        System.out.println(i);


        // 匹配既不是数字也不是空白字符的字符，guava版本不匹配
//        String str = CharMatcher.not(CharMatcher.digit()).and(CharMatcher.not(CharMatcher.whitespace())).retainFrom("  a1b\tc");
//        System.out.println(str);


        // and or 组合匹配
//        String str = CharMatcher.inRange('a', 'z').and(CharMatcher.anyOf("bc")).retainFrom("abc123DEF");
//        System.out.println(str);

    }

}
