package com.frank.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.frank.util.BaseUtils;

/**
 * @author kst
 * @date 2019-01-13 20:46:39 // https://github.com/google/guava.git
 */
public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		List<String> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("zhlsh", "" + i);
			map.put("coordX", "10" + i);
			map.put("coordY", "20" + i);
			String json = JSON.toJSONString(map);
			list.add(json);
		}

//		System.out.println(list.toString());

		List<Map<Object, Object>> jsonList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			jsonList.add((Map<Object, Object>) JSON.parse(list.get(i)));
		}

		sortListMapWithFlag(jsonList, "zhlsh", false);
		System.out.println(jsonList.toString());
	}

	/**
	 * 根据map某个key排序装有map的list集合
	 * 
	 * @param list    含有map的集合
	 * @param sortStr 排序字段
	 * @param flag    true-降序，false-升序
	 * @author kst 20210820
	 */
	public static void sortListMapWithFlag(List<Map<Object, Object>> list, String sortStr, boolean flag) {
		Collections.sort(list, new Comparator<Map<Object, Object>>() {

			@Override
			public int compare(Map<Object, Object> map0, Map<Object, Object> map1) {
				// 降序
				if (flag) {
					return map1.get(sortStr).toString().compareTo(map0.get(sortStr).toString());
				}
				// 升序
				return map0.get(sortStr).toString().compareTo(map1.get(sortStr).toString());
			}

		});
	}
}