package com.frank.googleguava;

import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * @author: kst
 * @date: 2024/12/24 8:59
 */
public class CacheBuilderSpecTest {

    public static void main(String[] args) throws Exception {
        // 创建简单缓存并制定最大缓存数
//        Cache<Integer, String> cache = CacheBuilder.from(CacheBuilderSpec.parse("maximumSize=10")).build();
//        for (int i = 1; i <= 10; i++) {
//            cache.put(i, i + "a");
//        }
//        System.out.println(cache.getIfPresent(11));


        // 配置过期时间，写入后过期
//        Cache<Integer, String> cache = CacheBuilder.from(CacheBuilderSpec.parse("expireAfterWrite=10s")).build();
//        cache.put(1, "apple");
//        Thread.sleep(11000);
//        String str = cache.getIfPresent(1);
//        System.out.println(str);

        // 访问后过期
//        Cache<Object, Object> cache = CacheBuilder.from(CacheBuilderSpec.parse("expireAfterWrite=10s")).build();
//        cache.put(1,"apple");
//        Thread.sleep(5000);
//        System.out.println(cache.getIfPresent(1));
//        Thread.sleep(6000);
//        System.out.println(cache.getIfPresent(1));


        // 创建一个加载缓存，当请求的键不存在时，会自动加载数据：跟guava版本有关，暂时没有试验成功
//        LoadingCache<Integer, String> loadCache = CacheBuilder.from(CacheBuilderSpec.parse("maximumSize=10,expireAfterWrite=10s")).build(new CacheLoader<Integer, String>() {
//            @Override
//            public String load(Integer key) throws Exception {
//                return "loadValue-" + key;
//            }
//        });
//        System.out.println(loadCache.get(1));


        // 配置多个配置
        // 最大缓存大小、写入后过期时间以及并发级别。concurrencyLevel=4 表示缓存可以同时支持 4 个并发的写操作
//        Cache<Object, Object> cache = CacheBuilder.from(CacheBuilderSpec.parse("maximumSize=10,expireAfterWrite=10s,concurrencyLevel=4")).build();

    }
}
