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


        // String->List 去除空串与空格
//        String str = "1-2-3-4- 5- 6 ";
//        List<String> list = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str);
//        System.out.println(list);


        // 将String转换成Map
//        String str = "aa=11,bb=22";
//        Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(str);
//        System.out.println(map.toString());


        // guava还支持多个字符切割，或者特定的正则分隔
//		String str = "aa.dd,,ff,,.";
//		List<String> list = Splitter.onPattern("[.|,]").omitEmptyStrings().trimResults().splitToList(str);
//		System.out.println(list);


        // 固定长度分割
//        String str = "aaabbbcccdddeeefff";
//        List<String> list = Splitter.fixedLength(3).splitToList(str);
//        System.out.println(list);


        // 限制分割结果的数量
//        String str = "aa|bb|cc|dd|ee";
//        List<String> list = Splitter.on("|").limit(3).splitToList(str);
//        System.out.println(list);
    }
}
