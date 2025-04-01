package com.frank.googleguava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �ַ������Ӵ�����
 *
 * @author: kst
 * @date: 2024/12/3 9:30
 */
public class JoinerTest {

    public static void main(String[] args) {
        // ָ���ַ�ƴ�ӳ��ַ���
//        String[] arr = new String[]{"apple", "banana", "orange"};
//        String join = Joiner.on(",").join(arr);
//        System.out.println(join);


        // ָ���ַ��滻null
//        String[] arr = new String[]{"apple", null, "orange"};
//        String join = Joiner.on(",").useForNull("aaa").join(arr);
//        System.out.println(join);


        // ����nullֵ
//        String[] arr = new String[]{"apple", null, "orange"};
//        String join = Joiner.on(",").skipNulls().join(arr);
//        System.out.println(join);


        // listԪ�ذ�ָ���ַ�ƴ��
//        List<String> list = Lists.newArrayList("apple", "banana", "orange", "cherry");
//        String join = Joiner.on(",").join(list.iterator());
//        String join = Joiner.on(",").join(list);
//        System.out.println(join);


        // map key-value��ָ���ַ�ƴ��
//        Map<String, String> map = Maps.newHashMap();
//        map.put("aaa", "111");
//        map.put("bbb", "222");
//        map.put("ccc", "333");
//        String join = Joiner.on(",").join(map.entrySet());
//        String join = Joiner.on(",").join(map.keySet());
//        System.out.println(join);


        // StringBuilderƴ��
//        String[] arr = new String[]{"apple", "banana", "orange"};
//        StringBuilder sb = new StringBuilder();
//        StringBuilder join = Joiner.on(",").appendTo(sb, arr);
//        System.out.println(join);


        // Map��key-valueƴ��
//        Map<String, String> map = Maps.newHashMap();
//        map.put("aaa", "111");
//        map.put("bbb", "222");
//        map.put("ccc", "333");
//        map.put("ddd", null);
//        String join = Joiner.on(",").withKeyValueSeparator(":").join(map);
//        String join = Joiner.on(",").withKeyValueSeparator(":").useForNull("null").join(map);
//        System.out.println(join);


        // DTO����ƴ��
        // >=guava21.0
//        List<Student> list = Lists.newArrayList(new Student("����", "20", "BeiJingUniversity"), new Student("����", "21", "QingHuaUniversity"), new Student("����", "22", "ZheJiangUniversity"));
//        String join = Joiner.on(",").withKeyValueSeparator(":").join(list, record -> record.getName(), record -> record.getAge(), record -> record.getSchool());
//        System.out.println(join);
    }
}
