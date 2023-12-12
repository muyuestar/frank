package com.frank.test.cache;

import java.util.Map;

/**
 * @author: kst
 * @date: 2022/11/7 14:57
 */
public class TestCache {


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Map<String, String> map = PoolInfo.getPoolInfo();
            System.out.println(map);
        }
    }

}
