package com.frank.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * ÅÅÐò
 * @author: kst
 * @date: 2023/6/25 17:17
 */
public class SortData {

    public static void main(String[] args) {
        List<Map<Object, Object>> list = new ArrayList<>();

        String[] zxlshArray = new String[]{"954883686", "957056381", "959073488", "974773324", "990521363", "992777889", "992797647", "1011847908", "1012113719", "1016188211", "1031877506", "1031795089", "1051342855", "1051583427", "1071066696", "1071133010", "1074717206", "1092560436", "1092596055", "1099483057", "1110205199", "1110335467", "1124020276", "1123893613", "1127708776", "1142520964", "1142836837"};
        String[] applydateArray = new String[]{"20210615", "20210618", "20210621", "20210715", "20210809", "20210813", "20210813", "20210915", "20210915", "20210921", "20211015", "20211015", "20211115", "20211115", "20211216", "20211216", "20211221", "20220117", "20220117", "20220127", "20220218", "20220218", "20220315", "20220315", "20220321", "20220415", "20220415"};

        int length = zxlshArray.length;
        for (int i = 0; i < length; i++) {
            Map<Object, Object> map = new HashMap<>();
            map.put("zxlsh", zxlshArray[i]);
            map.put("applydate", applydateArray[i]);
            list.add(map);
        }
        sortListMapFWithFlag(list, "zxlsh", false);
        list.forEach(item -> System.out.println(item));
    }

    public static void sortListMapFWithFlag(List<Map<Object, Object>> list, String sortStr, boolean flag) {
        Collections.sort(list, new Comparator<Map<Object, Object>>() {
            @Override
            public int compare(Map<Object, Object> map0, Map<Object, Object> map1) {
                // ½µÐò
                if (flag) {
                    return Integer.parseInt(map1.get(sortStr).toString()) - Integer.parseInt(map0.get(sortStr).toString());
                }
                // ÉýÐò
                return Integer.parseInt(map0.get(sortStr).toString()) - Integer.parseInt((map1.get(sortStr).toString()));
            }
        });
    }
}
