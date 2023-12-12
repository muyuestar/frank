package com.frank.test.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: kst
 * @date: 2022/11/7 14:48
 */
public class PoolInfo {


    public static Map<String, String> poolMap = null;

    public static Map<String, String> getPoolInfo() {
//        if (pool != null) {
//            System.out.println("111");
//            return pool;
//        }
//        System.out.println("222");
//        pool = new Pool();
//        pool.setName("pool");
//        return pool;

        if (poolMap != null) {
            System.out.println("111");
            return poolMap;
        }
        System.out.println("222");
        poolMap = new HashMap<>();
        return poolMap;
    }
}
