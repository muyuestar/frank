package com.frank.test;

import java.util.HashMap;
import java.util.Map;

/**
 * ≤‚ ‘map.forEach
 * @author kst
 *
 */
public class TestMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.forEach((key,value)->{
			System.out.println("key="+key+",value="+value);
		});
	}
}
