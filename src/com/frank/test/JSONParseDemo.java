package com.frank.test;

import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * jsonת��demo
 * 
 * @author kst
 * @version ����ʱ�䣺2020��8��12�� ����8:13:50
 */
public class JSONParseDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// mapת����json�ַ���������˳�����
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("a", "1");
		map.put("c", "3");
		map.put("e", "5");
		map.put("d", "4");
		map.put("b", "2");
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);

		// json�ַ���ת����map������˳�����
		Map<String, String> jsonMap = JSON.parseObject(jsonString, LinkedHashMap.class);
		for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}

	}

}
