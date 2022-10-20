package com.frank.collectionutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/**
 * @author kst
 * @date 2019年11月25日 下午7:17:34
 * 
 */
public class CollectionUtilsDemo {

	public static void main(String[] args) {
		// 检查是否为空元素
		// List<String> list = new LinkedList<String>();
		// boolean flag = CollectionUtils.addIgnoreNull(list, null);
		// System.out.println(flag);
		// System.out.println(list.size());

		// 合并两个排序列表
		// List<String> list1 = Arrays.asList("A", "C", "E");
		// List<String> list2 = Arrays.asList("B", "D", "F");
		// List<String> list = CollectionUtils.collate(list1, list2);
		// System.out.println(list.toString());

		// Apache通用集合转换对象
//		List<String> strList = Arrays.asList("1", "2", "3");
//		List<Integer> intList = (List<Integer>) CollectionUtils.collect(strList, new Transformer<String, Integer>() {
//			@Override
//			public Integer transform(String str) {
//				return Integer.parseInt(str);
//			}
//		});
//		System.out.println(intList.toString());

		// Apache通用集合过滤对象
//		List<Integer> list = new ArrayList<Integer>();
//		list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
//		System.out.println(list.toString());
////		CollectionUtils.filter(list, new Predicate<Integer>() {
//		CollectionUtils.filterInverse(list, new Predicate<Integer>() {
//
//			@Override
//			public boolean evaluate(Integer input) {
//				return input % 2 == 0;
//			}
//		});
//		System.out.println(list.toString());

		// Apache通用集合安全空检查
//		List<String> list = new ArrayList<String>();
//		List<String> list = null;
//		boolean flag = CollectionUtils.isNotEmpty(list);
//		boolean flag = CollectionUtils.isEmpty(list);		
//		System.out.println(flag);

		// Apache通用集合包函关系
//		List<String> allList = Arrays.asList("1","2","3","4","5","6");
//		List<String> subList = Arrays.asList("1","2","3");
//		boolean flag = CollectionUtils.isSubCollection(subList, allList);
//		System.out.println(flag);

		// Apache通用集合相交
		List<String> allList = Arrays.asList("1", "2", "3", "4", "5", "6");
		List<String> subList = Arrays.asList("2", "3", "7");
//		System.out.println(CollectionUtils.intersection(subList, allList));
//		System.out.println(CollectionUtils.retainAll(allList, subList));

		// Apache通用集合差集
//		List<String> allList = Arrays.asList("1","2","3","4","5","6");
//		List<String> subList = Arrays.asList("2","3","7");
//		System.out.println(CollectionUtils.subtract(allList, subList));

		// Apache通用集合联合
//		List<String> allList = Arrays.asList("1","2","3","4","5","6");
//		List<String> subList = Arrays.asList("2","3","7");
//		System.out.println(CollectionUtils.union(subList, allList));
	}
}
