package com.frank.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * ���ӵ� redis ����
 * 
 * @author kst
 * @date 2018-12-22 21:13:19
 */
public class RedisJava {

	public static void main(String[] args) {
		// ���ӱ��ص� Redis ����
		Jedis jedis = new Jedis("localhost");
		System.out.println("���ӳɹ�");
		// �鿴�����Ƿ�����
		System.out.println("������������: " + jedis.ping());
		System.out.println("--------------------------------------------------------------");

		// 1��Redis Java String(�ַ���) ʵ��
		// ���� redis �ַ�������
		jedis.set("runoobkey", "www.runoob.com");
		jedis.set("baidu", "www.baidu.com");
		// ��ȡ�洢�����ݲ����
		System.out.println("redis �洢���ַ���Ϊ: " + jedis.get("runoobkey") + "  " + jedis.get("baidu"));
		System.out.println("--------------------------------------------------------------");

		// 2��Redis Java List(�б�) ʵ��
		// �洢���ݵ��б���
		jedis.lpush("site-list", "Runoob");
		jedis.lpush("site-list", "Google");
		jedis.lpush("site-list", "Taobao");
		List<String> list = jedis.lrange("site-list", 0, 2);
		System.out.println(list.toString());
		System.out.println("--------------------------------------------------------------");

		// 3��Redis Java Keys ʵ��
		Set<String> keys = jedis.keys("*");
		for (Iterator<String> it = keys.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
