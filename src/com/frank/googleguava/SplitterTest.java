package com.frank.googleguava;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * @author: kst
 * @date: 2024/12/18 9:14
 */
public class SplitterTest {

    public static void main(String[] args) {
        // String->List
//        String str = "1-2-3-4-5-6";
//        List<String> list = Splitter.on("-").splitToList(str);
//        System.out.println(list);

//        String str = "hello|world|fine|||thank ";
//        List<String> list = Splitter.on("|").omitEmptyStrings().trimResults().splitToList(str);
//        System.out.println(list);


        // String->List ȥ���մ���ո�
//        String str = "1-2-3-4- 5- 6 ";
//        List<String> list = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str);
//        System.out.println(list);


        // ��Stringת����Map
//        String str = "aa=11,bb=22";
//        Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(str);
//        System.out.println(map.toString());


        // guava��֧�ֶ���ַ��и�����ض�������ָ�
//		String str = "aa.dd,,ff,,.";
//		List<String> list = Splitter.onPattern("[.|,]").omitEmptyStrings().trimResults().splitToList(str);
//		System.out.println(list);


        // �̶����ȷָ�
//        String str = "aaabbbcccdddeeefff";
//        List<String> list = Splitter.fixedLength(3).splitToList(str);
//        System.out.println(list);


        // ���Ʒָ���������
//        String str = "aa|bb|cc|dd|ee";
//        List<String> list = Splitter.on("|").limit(3).splitToList(str);
//        System.out.println(list);
    }
}
