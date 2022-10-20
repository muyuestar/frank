package com.frank.test;

import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * json转换demo
 * 
 * @author kst
 * @version 创建时间：2020年8月12日 下午8:13:50
 */
public class JSONParseDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// map转换成json字符串，按照顺序输出
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("a", "1");
		map.put("c", "3");
		map.put("e", "5");
		map.put("d", "4");
		map.put("b", "2");
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);

		// json字符串转换成map，按照顺序输出
		Map<String, String> jsonMap = JSON.parseObject(jsonString, LinkedHashMap.class);
		for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}

	}

}
