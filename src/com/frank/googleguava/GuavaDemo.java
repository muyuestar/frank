package com.frank.googleguava;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.io.Files;

/**
 *
 * @author kst
 * @version ����ʱ�䣺2020��3��9�� ����10:12:42
 */
public class GuavaDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {
		// 1.���ϵĴ���
		// ��ͨcollection�Ĵ���
//		List<String> list = Lists.newArrayList();
//		Set<String> set = Sets.newHashSet();
//		Map<String, String> map = Maps.newHashMap();

		// ����collection�Ĵ���
//		ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
//		ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
//		ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");

//		Multimap<String, Integer> map = ArrayListMultimap.create();
//		map.put("aa", 1);
//		map.put("aa", 2);
//		map.put("aa", 3);
//		System.out.println(map.get("aa"));

		// 2.������ת��Ϊ�ض�������ַ���
//		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		String result = Joiner.on("-").join(list);
//		System.out.println(result);

//		Map<String, Integer> map = Maps.newHashMap();
//		map.put("aa", 12);
//		map.put("bb", 34);
//		String result = Joiner.on(",").withKeyValueSeparator("=").join(map);
//		System.out.println(result);

		// 3.��Stringת��Ϊ�ض��ļ���
		// String->List
//		String str = "1-2-3-4-5-6";
//		List<String> list = Splitter.on("-").splitToList(str);
//		System.out.println(list);

		// ȥ���մ���ո�
//		String str = "1-2-3-4- 5- 6 ";
//		List<String> list = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str);
//		System.out.println(list);

		// ��Stringת����Map
//		String str = "aa=11,bb=22";
//		Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(str);
//		System.out.println(map.toString());

		// 4.guava��֧�ֶ���ַ��и�����ض�������ָ�
//		String str = "aa.dd,,ff,,.";
//		List<String> list = Splitter.onPattern("[.|,]").omitEmptyStrings().trimResults().splitToList(str);
//		System.out.println(list);

		// �ж�ƥ����
//		boolean flag = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).matches('K');
//		System.out.println(flag);

		// ���������ı�
//		String str = CharMatcher.inRange('0', '9').retainFrom("abc 123 ABC");
//		System.out.println(str);

		// ɾ�������ı�
//		String str = CharMatcher.inRange('0', '9').removeFrom("abc 123 ABC");
//		System.out.println(str);

		// 5.���ϵĹ���
		// ������������
//		ImmutableList<String> names = ImmutableList.of("begin", "code", "Guava", "Java");
//		Iterable<String> fitered = Iterables.filter(names,
//				Predicates.or(Predicates.equalTo("code"), Predicates.equalTo("Guava"), Predicates.equalTo("Java")));
//		System.out.println(fitered);

		// �Զ����������,ʹ���Զ���ص�������Map��ÿ��Value���в���
//		ImmutableMap<String, Integer> m = ImmutableMap.of("begin", 12, "code", 15);
//		Map<String, Integer> map = Maps.transformValues(m, new Function<Integer, Integer>() {
//
//			@Override
//			public Integer apply(Integer input) {
//				return input > 12 ? input : input + 1;
//			}
//		});
//		System.out.println(map);

		// set�Ľ���,����,�
//		Set<Integer> setA = new HashSet<Integer>();
//		for (int i = 1; i < 6; i++) {
//			setA.add(i);
//		}
//		Set<Integer> setB = new HashSet<Integer>();
//		for (int i = 4; i < 9; i++) {
//			setB.add(i);
//		}
//		// ����
//		SetView intersaction = Sets.intersection(setA, setB);
//		System.out.println(intersaction);
//		// ����
//		SetView union = Sets.union(setA, setB);
//		System.out.println(union);
//		// �
//		SetView difference = Sets.difference(setA, setB);
//		System.out.println(difference);

		// map�Ľ������������
//		Map<String, Integer> mapA = Maps.newHashMap();
//		mapA.put("a", 1);
//		mapA.put("b", 2);
//		mapA.put("c", 3);
//
//		Map<String, Integer> mapB = Maps.newHashMap();
//		mapB.put("b", 20);
//		mapB.put("c", 3);
//		mapB.put("d", 4);
//
//		MapDifference differenceMap = Maps.difference(mapA, mapB);
//		differenceMap.areEqual();
//		Map entriesDiffering = differenceMap.entriesDiffering();
//		System.out.println(entriesDiffering);
//		Map entriesOnlyLeft = differenceMap.entriesOnlyOnLeft();
//		System.out.println(entriesOnlyLeft);
//		Map entriesOnlyRight = differenceMap.entriesOnlyOnRight();
//		System.out.println(entriesOnlyRight);
//		Map entriesInCommon = differenceMap.entriesInCommon();
//		System.out.println(entriesInCommon);

		// 6.������
//		String str = "";
//		System.out.println(Strings.isNullOrEmpty(str));
//		System.out.println(Strings.commonPrefix("abcd", "abefcd"));
//		System.out.println(Strings.commonSuffix("abcd", "abefcd"));
//		System.out.println(Strings.padEnd("abcd", 5, 'e'));
//		System.out.println(Strings.padStart("abcd", 5, '-'));
//		System.out.println(Strings.repeat("abcd", 2));
//		int count = -1;
//		Preconditions.checkArgument(count > 0, "must be positive: %s", count);

		// 8.ǿ���Ordering������
//		natural()	�Կ�������������Ȼ���������ְ���С�����ڰ��Ⱥ�����
//		usingToString()	��������ַ�����ʽ���ֵ�����[lexicographical ordering]
//		from(Comparator)	�Ѹ�����Comparatorת��Ϊ������
//		reverse()	��ȡ�����෴��������
//		nullsFirst()	ʹ�õ�ǰ���������������nullֵ�ŵ���ǰ�档
//		nullsLast()	ʹ�õ�ǰ���������������nullֵ�ŵ�����档
//		compound(Comparator)	�ϳ���һ���Ƚ������Դ���ǰ�������е���������
//		lexicographical()	���ڴ�������T�������������ظ����͵Ŀɵ�������Iterable<T>����������
//		onResultOf(Function)	�Լ�����Ԫ�ص���Function���ٰ�����ֵ�õ�ǰ����������

//		Person person = new Person("aa", 14); // String name ,Integer age
//		Person ps = new Person("bb", 14);
//		Ordering<Person> byOrdering = Ordering.natural().nullsFirst().onResultOf(new Function<Person, String>() {
//			public String apply(Person person) {
//				return person.age.toString();
//			}
//		});
//		byOrdering.compare(person, ps);
//		// 1 person�������ps�� �������1
//		System.out.println(byOrdering.compare(person, ps));

		// 9.�����м���������ʱ��
//		Stopwatch stopwatch = Stopwatch.createStarted();
//		for (int i = 0; i < 5; i++) {
//			// do some thing
//			Thread.sleep(150);
//		}
//		long nanos = stopwatch.elapsed(TimeUnit.MILLISECONDS);
//		System.out.println(nanos);

		// 10.�ļ�����
//		File file = new File("C:/kang/image/test.txt");
//		List<String> list = null;
//		try {
//			list = Files.readLines(file, Charsets.UTF_8);
//		} catch (Exception e) {
//		}
//		System.out.println(list.toString());

//		Files.copy(from,to);  //�����ļ�
//		File from = new File("C:/kang/image/files/test.txt");
//		File to = new File("C:/kang/image/files/to.txt");
//		Files.copy(from, to);

//		Files.move(File from, File to); //�ƶ��ļ�
//		File from = new File("C:/kang/image/files/test.txt");
//		File to = new File("C:/kang/image/produce/to.txt");
//		Files.move(from, to);

//		Files.deleteDirectoryContents(File directory); //ɾ���ļ����µ�����(�����ļ������ļ���)  
//		Files.deleteRecursively(File file); //ɾ���ļ������ļ���  
//		URL url = Resources.getResource("abc.xml"); //��ȡclasspath���µ�abc.xml�ļ�url

		// 11��Lists
		// ���ִ���list�ķ���
		// ������ת��list,���ڿ�ͷλ�ò���Ԫ��
//		List<String> list = Lists.asList("a", new String[] { "b", "c", "d" });
//		List<String> list1 = Lists.asList("a", "b", new String[] { "c", "d", "e" });
//		System.out.println(list1);

		// ֱ�Ӵ���ArrayList
//		ArrayList<String> arrayList = Lists.newArrayList();
		// ����ArrayList,����ʼ��
//		ArrayList<String> arrayList1 = Lists.newArrayList("a", "b", "c");
		// �������е�arrayList,����һ��arrayList
//		ArrayList<String> arrayList2 = Lists.newArrayList(arrayList1);
		// ��ʼ��ָ��������С��ArrayList����������ָArrayList�ײ������������length����ֵ����������ǰ֪��ArrayList��С������ĳ�ʼ��
//		ArrayList<String> arrayList3 = Lists.newArrayListWithCapacity(10);
		// ��ʼ��Ԥ��������С��ArrayList�����ص�list��ʵ������Ϊ5L + estimatedSize + (estimatedSize /
		// 10)�������ڲ�ȷ��ArrayList��С������ĳ�ʼ��
//		ArrayList<String> arrayList4 = Lists.newArrayListWithExpectedSize(20);
		// ����CopyOnWriteArrayList
//		CopyOnWriteArrayList<String> copyOnWriteArrayList = Lists.newCopyOnWriteArrayList();
		// ����linkedList
//		LinkedList<String> linkedList = Lists.newLinkedList();

		// ��ָ����С�ָ�list
//		List<String> list = Lists.newArrayList("a", "b", "c", "d", "e");
		// ��list����СΪ2�ָ��ɶ��list
//		List<List<String>> splitList = Lists.partition(list, 3);
//		System.out.println(splitList);

		// �ѿ�����
//		List<String> list1 = Lists.newArrayList("a", "b", "c");
//		List<String> list2 = Lists.newArrayList("d", "e", "f");
//		List<String> list3 = Lists.newArrayList("1", "2", "3");
		// ��ȡ���list�ĵѿ�����
//		List<List<String>> list = Lists.cartesianProduct(list1, list2, list3);
//		System.out.println(list);

		// �ַ���ת���ַ�����
//		ImmutableList<Character> list = Lists.charactersOf("abcdefgh");
//		System.out.println(list.get(4));

		// list��ת
//		List<String> list = Lists.newArrayList("a", "b", "c", "1", "2", "3");
//		List<String> reverseList = Lists.reverse(list);
//		System.out.println(reverseList);

		// ����ת��
//		List<String> list = Lists.newArrayList("a","b","c");
		// ��list�е�ÿ��Ԫ��ƴ��һ��1
//        List<String> list1 = Lists.transform(list,str -> str + "1");
//        System.out.println(list1);

		// 12��Sets
//		HashSet<String> set = Sets.newHashSet();
//		Sets.newLinkedHashSet();
//		Sets.newHashSetWithExpectedSize(10);
//		Sets.newTreeSet();
//		Sets.newConcurrentHashSet();

		// �ѿ�����
//		Set<String> set1 = Sets.newHashSet("a", "b", "c");
//		Set<String> set2 = Sets.newHashSet("1", "2", "3");
//		Set<String> set3 = Sets.newHashSet("@", "#", "&");
		// ���Set�ĵѿ��������������ն��set����
//		Set<List<String>> sets = Sets.cartesianProduct(set1, set2, set3);
//        System.out.println(sets);

//		List<Set<String>> list = Lists.newArrayList(set1, set2, set3);
		// Ҳ���԰Ѷ��Set���ϣ��ŵ�һ��list�У��ټ���ѿ�����
//		Set<List<String>> sets1 = Sets.cartesianProduct(list);
//		System.out.println(sets1);
		// Sets.combinations()
		// Sets.difference()

		// ��ָ����С�����������
//		Set<String> set1 = Sets.newHashSet("a", "b", "c", "d");
//		Set<Set<String>> sets = Sets.combinations(set1, 3);
//		for (Set<String> set : sets) {
//			System.out.println(set);
//		}

		// �
//		Set<String> set1 = Sets.newHashSet("a", "b", "d");
//		Set<String> set2 = Sets.newHashSet("d", "e", "f");
		// difference���أ���set1���޳�����set������Ԫ��
//		System.out.println(Sets.difference(set1, set2));
		// symmetricDifference���أ��޳�����set������Ԫ�أ���ȡ�������ϵĲ���
//		System.out.println(Sets.symmetricDifference(set1, set2));

		// ����
//		Set<String> set1 = Sets.newHashSet("a","b","c");
//        Set<String> set2 = Sets.newHashSet("a","b","f");
		// ȡ�������ϵĽ���
//        System.out.println(Sets.intersection(set1,set2));

		// ����
//		Set<String> set1 = Sets.newHashSet("a", "b", "c");
		// �������ֱ��ʹ��java8�Ĺ��ˣ��ȽϷ���
//		Set<String> set2 = Sets.filter(set1, str -> str.equalsIgnoreCase("b"));
//		System.out.println(set2);

		// ���е��������
//		Set<String> set1 = Sets.newHashSet("a", "b", "c");
		// ��ȡset�ɷָ��ɵ������Ӽ�
//		Set<Set<String>> allSet = Sets.powerSet(set1);
//		for (Set<String> set : allSet) {
//			System.out.println(set);
//		}

		// ����
//		Set<String> set1 = Sets.newHashSet("a", "b", "c");
//		Set<String> set2 = Sets.newHashSet("1", "2", "3");
		// ȡ�������ϵĲ���
//		System.out.println(Sets.union(set1, set2));

		// ��������Map�ķ���
//		Maps.newHashMap();
//        Maps.newHashMapWithExpectedSize(10);
		// Maps.newEnumMap();
//        Maps.newConcurrentMap();
//        Maps.newIdentityHashMap();
//        Maps.newLinkedHashMap();
//        Maps.newLinkedHashMapWithExpectedSize(10);
//        Maps.newTreeMap();

		// setתmap
//		Set<String> set = Sets.newHashSet("a", "b", "c");
		// ��setת��Map,keyΪsetԪ��,valueΪÿ��Ԫ�صĳ���
//		Map<String, Integer> map = Maps.asMap(set, String::length);
//		System.out.println(map);

		// ����map�Ĳ�ֵ
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> map2 = Maps.newHashMap();
//		map2.put("a", "1");
//		map2.put("e", "5");
//		map2.put("f", "6");
//		// mapDifference�ǽ�����map��ͬ�Ĳ����޳�
//		MapDifference<String, String> mapDifference = Maps.difference(map1, map2);
//		// ����Map��ͬ�Ĳ���
//		System.out.println(mapDifference.entriesInCommon());
//		// ��߼����޳���ͬ���ֺ��ʣ��
//		System.out.println(mapDifference.entriesOnlyOnLeft());
//		// �ұ߼����޳���ͬ���ֺ��ʣ��
//		System.out.println(mapDifference.entriesOnlyOnRight());

		// ͨ��Entry����
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.filterEntries(map1, item -> !item.getValue().equalsIgnoreCase("2"));
//		System.out.println(result);

		// ͨ��Key����
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.filterKeys(map1, item -> !item.equalsIgnoreCase("b"));
//		System.out.println(result);

		// ͨ��value����
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.filterValues(map1, item -> !item.equalsIgnoreCase("3"));
//		System.out.println(result);

		// ת��Entry
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.transformEntries(map1, (k, v) -> k + v);
//		System.out.println(result);

		// ת��value
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.transformValues(map1, value -> value + 10);
//		System.out.println(result);

		// 13.��ͨ���ϵĴ���
//		List<String> list = Lists.newArrayList();
//		Set<String> set = Sets.newHashSet();

		// 14.���ɱ伯�ϵĴ���
//		ImmutableList<String> list = ImmutableList.of("a","b","c");
//		System.out.println(list.toString());
//		ImmutableSet<String> set = ImmutableSet.of("a","b");
//		System.out.println(set.toString());

		// 15.ͬkey��ͬvalue
		// use java
//		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		// use guava
//		Multimap<String, Integer> map = ArrayListMultimap.create();
//		map.put("key1", 1);
//		map.put("key1", 2);
//		map.put("key1", 3);
		// [1, 2,3]
//		System.out.println(map.get("key1"));
//		System.out.println(map.toString());
//		Collection<Integer> values = map.get("key1");
//		System.out.println(values);
//		Map<String, Collection<Integer>> collectionMap = map.asMap();
//		System.out.println(collectionMap);

		// 16.������ӳ��һ��ֵ
//		Table<String, String, Integer> table = HashBasedTable.create();
//		table.put("a", "b", 1);
//		table.put("a", "c", 2);
//		System.out.println(table.get("a", "b"));
//		System.out.println(table.row("a"));
		// �鿴������
//		Map<String, Integer> column = table.column("b");
//		System.out.println(column);

		// 17.BiMap һ����valueҲ�����ظ���HashMap
//		BiMap<String, String> biMap = HashBiMap.create();
//		biMap.put("a", "apple");
//		biMap.put("b", "apple");
//		System.out.println(biMap);

		// ��Ȼvalue�����ظ����β�ʵ�ָ���תkey/value�ķ������Ѿ�����
//		BiMap<String, String> inverseMap = biMap.inverse();
//		System.out.println(inverseMap);

		// 18.Multiset һ������������Set
//		Multiset<String> multiset = HashMultiset.create();
//		multiset.add("apple");
//		multiset.add("apple");
//		multiset.add("banana");
		// ����
//		System.out.println(multiset.count("apple"));
		// �鿴ȥ�ص�Ԫ��
//		Set<String> set = multiset.elementSet();
//		System.out.println(set);
		// �鿴û��ȥ�ص�Ԫ��
//		Iterator<String> iter = multiset.iterator();
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		// �ֶ�����ĳ��Ԫ�س��ֵĴ���
//		multiset.setCount("apple", 5);
//		System.out.println(multiset.count("apple"));
	}

}
