package com.frank.collectionutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/**
 * @author kst
 * @date 2019��11��25�� ����7:17:34
 * 
 */
public class CollectionUtilsDemo {

	public static void main(String[] args) {
		// ����Ƿ�Ϊ��Ԫ��
		// List<String> list = new LinkedList<String>();
		// boolean flag = CollectionUtils.addIgnoreNull(list, null);
		// System.out.println(flag);
		// System.out.println(list.size());

		// �ϲ����������б�
		// List<String> list1 = Arrays.asList("A", "C", "E");
		// List<String> list2 = Arrays.asList("B", "D", "F");
		// List<String> list = CollectionUtils.collate(list1, list2);
		// System.out.println(list.toString());

		// Apacheͨ�ü���ת������
//		List<String> strList = Arrays.asList("1", "2", "3");
//		List<Integer> intList = (List<Integer>) CollectionUtils.collect(strList, new Transformer<String, Integer>() {
//			@Override
//			public Integer transform(String str) {
//				return Integer.parseInt(str);
//			}
//		});
//		System.out.println(intList.toString());

		// Apacheͨ�ü��Ϲ��˶���
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

		// Apacheͨ�ü��ϰ�ȫ�ռ��
//		List<String> list = new ArrayList<String>();
//		List<String> list = null;
//		boolean flag = CollectionUtils.isNotEmpty(list);
//		boolean flag = CollectionUtils.isEmpty(list);		
//		System.out.println(flag);

		// Apacheͨ�ü��ϰ�����ϵ
//		List<String> allList = Arrays.asList("1","2","3","4","5","6");
//		List<String> subList = Arrays.asList("1","2","3");
//		boolean flag = CollectionUtils.isSubCollection(subList, allList);
//		System.out.println(flag);

		// Apacheͨ�ü����ཻ
		List<String> allList = Arrays.asList("1", "2", "3", "4", "5", "6");
		List<String> subList = Arrays.asList("2", "3", "7");
//		System.out.println(CollectionUtils.intersection(subList, allList));
//		System.out.println(CollectionUtils.retainAll(allList, subList));

		// Apacheͨ�ü��ϲ
//		List<String> allList = Arrays.asList("1","2","3","4","5","6");
//		List<String> subList = Arrays.asList("2","3","7");
//		System.out.println(CollectionUtils.subtract(allList, subList));

		// Apacheͨ�ü�������
//		List<String> allList = Arrays.asList("1","2","3","4","5","6");
//		List<String> subList = Arrays.asList("2","3","7");
//		System.out.println(CollectionUtils.union(subList, allList));
	}
}
