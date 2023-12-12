package com.frank.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试map.forEach
 *
 * @author kst
 */
public class TestMap {

    public static void main(String[] args) {
        // 1.mapforEach输出
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("1", "a");
//        map.put("2", "b");
//        map.put("3", "c");
//        map.forEach((key, value) ->
//                System.out.println("key=" + key + ",value=" + value));

        // 2.ab的value值合并到c
//        Map<String, Object> map = new HashMap<>();
//        map.put("a", new String[]{"1", "2", "3"});
//        map.put("b", new String[]{"4", "5", "6"});
//        Object[] aArr = (Object[]) map.get("a");
//        Object[] bArr = (Object[]) map.get("b");
//        Object[] cArr = new Object[aArr.length + bArr.length];
//
//        System.arraycopy(aArr, 0, cArr, 0, aArr.length);
//        System.arraycopy(bArr, 0, cArr, aArr.length, bArr.length);
//        System.out.println(Arrays.toString(cArr));




    }
}
