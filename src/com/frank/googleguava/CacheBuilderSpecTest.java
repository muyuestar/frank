package com.frank.googleguava;

import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * @author: kst
 * @date: 2024/12/24 8:59
 */
public class CacheBuilderSpecTest {

    public static void main(String[] args) throws Exception {
        // �����򵥻��沢�ƶ���󻺴���
//        Cache<Integer, String> cache = CacheBuilder.from(CacheBuilderSpec.parse("maximumSize=10")).build();
//        for (int i = 1; i <= 10; i++) {
//            cache.put(i, i + "a");
//        }
//        System.out.println(cache.getIfPresent(11));


        // ���ù���ʱ�䣬д������
//        Cache<Integer, String> cache = CacheBuilder.from(CacheBuilderSpec.parse("expireAfterWrite=10s")).build();
//        cache.put(1, "apple");
//        Thread.sleep(11000);
//        String str = cache.getIfPresent(1);
//        System.out.println(str);

        // ���ʺ����
//        Cache<Object, Object> cache = CacheBuilder.from(CacheBuilderSpec.parse("expireAfterWrite=10s")).build();
//        cache.put(1,"apple");
//        Thread.sleep(5000);
//        System.out.println(cache.getIfPresent(1));
//        Thread.sleep(6000);
//        System.out.println(cache.getIfPresent(1));


        // ����һ�����ػ��棬������ļ�������ʱ�����Զ��������ݣ���guava�汾�йأ���ʱû������ɹ�
//        LoadingCache<Integer, String> loadCache = CacheBuilder.from(CacheBuilderSpec.parse("maximumSize=10,expireAfterWrite=10s")).build(new CacheLoader<Integer, String>() {
//            @Override
//            public String load(Integer key) throws Exception {
//                return "loadValue-" + key;
//            }
//        });
//        System.out.println(loadCache.get(1));


        // ���ö������
        // ��󻺴��С��д������ʱ���Լ���������concurrencyLevel=4 ��ʾ�������ͬʱ֧�� 4 ��������д����
//        Cache<Object, Object> cache = CacheBuilder.from(CacheBuilderSpec.parse("maximumSize=10,expireAfterWrite=10s,concurrencyLevel=4")).build();

    }
}
