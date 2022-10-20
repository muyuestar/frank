package com.frank.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 连接到 redis 服务
 * 
 * @author kst
 * @date 2018-12-22 21:13:19
 */
public class RedisJava {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
		System.out.println("--------------------------------------------------------------");

		// 1、Redis Java String(字符串) 实例
		// 设置 redis 字符串数据
		jedis.set("runoobkey", "www.runoob.com");
		jedis.set("baidu", "www.baidu.com");
		// 获取存储的数据并输出
		System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey") + "  " + jedis.get("baidu"));
		System.out.println("--------------------------------------------------------------");

		// 2、Redis Java List(列表) 实例
		// 存储数据到列表中
		jedis.lpush("site-list", "Runoob");
		jedis.lpush("site-list", "Google");
		jedis.lpush("site-list", "Taobao");
		List<String> list = jedis.lrange("site-list", 0, 2);
		System.out.println(list.toString());
		System.out.println("--------------------------------------------------------------");

		// 3、Redis Java Keys 实例
		Set<String> keys = jedis.keys("*");
		for (Iterator<String> it = keys.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
