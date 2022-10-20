package com.frank.json;

import java.util.HashMap;
import java.util.Map;

import com.google.common.graph.ElementOrder.Type;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * google gson生产解析gson
 *
 * @author kst
 * @date 2021-09-05 10:14:43
 * 
 *       https://blog.csdn.net/erlian1992/article/details/77101526
 */
public class GoogleGsonDemo {

	public static void main(String[] args) {
//		1.gson.jar生成多节点复杂的jsonDemo1
		Gson gson = new Gson();
		Map<String, Object> jsonMap = new HashMap<>();
		Map<String, Object> reqMap = new HashMap<>();

		// head
		Map<String, String> headMap = new HashMap<>();
		headMap.put("branch", "0101");
		headMap.put("channel", "202");

		// body
		Map<String, Object> bodyMap = new HashMap<>();
		bodyMap.put("addWord", "差旅费");
		bodyMap.put("appointFlag", "1");
		User user = new User();
		user.setAge("20");
		user.setName("张三");
		bodyMap.put("user", user);

		// AMLField
		Map<String, String> aMLFieldMap = new HashMap<>();
		aMLFieldMap.put("amount", "100.00");

		Requ requ = new Requ();
		requ.setHead(headMap);
		requ.setBody(bodyMap);
		requ.setAMLField(aMLFieldMap);
		reqMap.put("req", requ);

		jsonMap.put("bupps", reqMap);
		String json = gson.toJson(jsonMap);
		System.out.println(json);

		// 2.生成多节点复杂的jsonDemo2
//		GsonBuilder gsonBuilder = new GsonBuilder();
//		Gson gson = gsonBuilder.setPrettyPrinting().create();
//		Map<String, Object> jsonMap = new HashMap<>();
//		Map<String, Object> reqMap = new HashMap<>();
//
//		// head
//		Map<String, String> headMap = new HashMap<>();
//		headMap.put("branch", "0101");
//		headMap.put("channel", "202");
//
//		// body
//		Map<String, String> bodyMap = new HashMap<>();
//		bodyMap.put("addWord", "差旅费");
//		bodyMap.put("appointFlag", "1");
//
//		Requ requ = new Requ();
//		requ.setHead(headMap);
//		requ.setBody(bodyMap);
//		reqMap.put("req", requ);
//
//		jsonMap.put("bupps", reqMap);
//		String json = gson.toJson(jsonMap);
//		System.out.println(json);

	}

}
