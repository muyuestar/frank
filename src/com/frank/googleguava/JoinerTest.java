package com.frank.googleguava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串连接处理类
 *
 * @author: kst
 * @date: 2024/12/3 9:30
 */
public class JoinerTest {

    public static void main(String[] args) {
        // 指定字符拼接成字符串
//        String[] arr = new String[]{"apple", "banana", "orange"};
//        String join = Joiner.on(",").join(arr);
//        System.out.println(join);


        // 指定字符替换null
//        String[] arr = new String[]{"apple", null, "orange"};
//        String join = Joiner.on(",").useForNull("aaa").join(arr);
//        System.out.println(join);


        // 过滤null值
//        String[] arr = new String[]{"apple", null, "orange"};
//        String join = Joiner.on(",").skipNulls().join(arr);
//        System.out.println(join);


        // list元素按指定字符拼接
//        List<String> list = Lists.newArrayList("apple", "banana", "orange", "cherry");
//        String join = Joiner.on(",").join(list.iterator());
//        String join = Joiner.on(",").join(list);
//        System.out.println(join);


        // map key-value按指定字符拼接
//        Map<String, String> map = Maps.newHashMap();
//        map.put("aaa", "111");
//        map.put("bbb", "222");
//        map.put("ccc", "333");
//        String join = Joiner.on(",").join(map.entrySet());
//        String join = Joiner.on(",").join(map.keySet());
//        System.out.println(join);


        // StringBuilder拼接
//        String[] arr = new String[]{"apple", "banana", "orange"};
//        StringBuilder sb = new StringBuilder();
//        StringBuilder join = Joiner.on(",").appendTo(sb, arr);
//        System.out.println(join);


        // Map中key-value拼接
//        Map<String, String> map = Maps.newHashMap();
//        map.put("aaa", "111");
//        map.put("bbb", "222");
//        map.put("ccc", "333");
//        map.put("ddd", null);
//        String join = Joiner.on(",").withKeyValueSeparator(":").join(map);
//        String join = Joiner.on(",").withKeyValueSeparator(":").useForNull("null").join(map);
//        System.out.println(join);


        // DTO参数拼接
        // >=guava21.0
//        List<Student> list = Lists.newArrayList(new Student("张三", "20", "BeiJingUniversity"), new Student("李四", "21", "QingHuaUniversity"), new Student("王五", "22", "ZheJiangUniversity"));
//        String join = Joiner.on(",").withKeyValueSeparator(":").join(list, record -> record.getName(), record -> record.getAge(), record -> record.getSchool());
//        System.out.println(join);
    }
}
