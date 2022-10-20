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
 * @version 创建时间：2020年3月9日 上午10:12:42
 */
public class GuavaDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {
		// 1.集合的创建
		// 普通collection的创建
//		List<String> list = Lists.newArrayList();
//		Set<String> set = Sets.newHashSet();
//		Map<String, String> map = Maps.newHashMap();

		// 不变collection的创建
//		ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
//		ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
//		ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");

//		Multimap<String, Integer> map = ArrayListMultimap.create();
//		map.put("aa", 1);
//		map.put("aa", 2);
//		map.put("aa", 3);
//		System.out.println(map.get("aa"));

		// 2.将集合转换为特定规则的字符串
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

		// 3.将String转换为特定的集合
		// String->List
//		String str = "1-2-3-4-5-6";
//		List<String> list = Splitter.on("-").splitToList(str);
//		System.out.println(list);

		// 去除空串与空格
//		String str = "1-2-3-4- 5- 6 ";
//		List<String> list = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str);
//		System.out.println(list);

		// 将String转换成Map
//		String str = "aa=11,bb=22";
//		Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(str);
//		System.out.println(map.toString());

		// 4.guava还支持多个字符切割，或者特定的正则分隔
//		String str = "aa.dd,,ff,,.";
//		List<String> list = Splitter.onPattern("[.|,]").omitEmptyStrings().trimResults().splitToList(str);
//		System.out.println(list);

		// 判断匹配结果
//		boolean flag = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).matches('K');
//		System.out.println(flag);

		// 保留数字文本
//		String str = CharMatcher.inRange('0', '9').retainFrom("abc 123 ABC");
//		System.out.println(str);

		// 删除数字文本
//		String str = CharMatcher.inRange('0', '9').removeFrom("abc 123 ABC");
//		System.out.println(str);

		// 5.集合的过滤
		// 按照条件过滤
//		ImmutableList<String> names = ImmutableList.of("begin", "code", "Guava", "Java");
//		Iterable<String> fitered = Iterables.filter(names,
//				Predicates.or(Predicates.equalTo("code"), Predicates.equalTo("Guava"), Predicates.equalTo("Java")));
//		System.out.println(fitered);

		// 自定义过滤条件,使用自定义回调方法对Map的每个Value进行操作
//		ImmutableMap<String, Integer> m = ImmutableMap.of("begin", 12, "code", 15);
//		Map<String, Integer> map = Maps.transformValues(m, new Function<Integer, Integer>() {
//
//			@Override
//			public Integer apply(Integer input) {
//				return input > 12 ? input : input + 1;
//			}
//		});
//		System.out.println(map);

		// set的交集,并集,差集
//		Set<Integer> setA = new HashSet<Integer>();
//		for (int i = 1; i < 6; i++) {
//			setA.add(i);
//		}
//		Set<Integer> setB = new HashSet<Integer>();
//		for (int i = 4; i < 9; i++) {
//			setB.add(i);
//		}
//		// 交集
//		SetView intersaction = Sets.intersection(setA, setB);
//		System.out.println(intersaction);
//		// 并集
//		SetView union = Sets.union(setA, setB);
//		System.out.println(union);
//		// 差集
//		SetView difference = Sets.difference(setA, setB);
//		System.out.println(difference);

		// map的交集，并集，差集
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

		// 6.检查参数
//		String str = "";
//		System.out.println(Strings.isNullOrEmpty(str));
//		System.out.println(Strings.commonPrefix("abcd", "abefcd"));
//		System.out.println(Strings.commonSuffix("abcd", "abefcd"));
//		System.out.println(Strings.padEnd("abcd", 5, 'e'));
//		System.out.println(Strings.padStart("abcd", 5, '-'));
//		System.out.println(Strings.repeat("abcd", 2));
//		int count = -1;
//		Preconditions.checkArgument(count > 0, "must be positive: %s", count);

		// 8.强大的Ordering排序器
//		natural()	对可排序类型做自然排序，如数字按大小，日期按先后排序
//		usingToString()	按对象的字符串形式做字典排序[lexicographical ordering]
//		from(Comparator)	把给定的Comparator转化为排序器
//		reverse()	获取语义相反的排序器
//		nullsFirst()	使用当前排序器，但额外把null值排到最前面。
//		nullsLast()	使用当前排序器，但额外把null值排到最后面。
//		compound(Comparator)	合成另一个比较器，以处理当前排序器中的相等情况。
//		lexicographical()	基于处理类型T的排序器，返回该类型的可迭代对象Iterable<T>的排序器。
//		onResultOf(Function)	对集合中元素调用Function，再按返回值用当前排序器排序。

//		Person person = new Person("aa", 14); // String name ,Integer age
//		Person ps = new Person("bb", 14);
//		Ordering<Person> byOrdering = Ordering.natural().nullsFirst().onResultOf(new Function<Person, String>() {
//			public String apply(Person person) {
//				return person.age.toString();
//			}
//		});
//		byOrdering.compare(person, ps);
//		// 1 person的年龄比ps大 所以输出1
//		System.out.println(byOrdering.compare(person, ps));

		// 9.计算中间代码的运行时间
//		Stopwatch stopwatch = Stopwatch.createStarted();
//		for (int i = 0; i < 5; i++) {
//			// do some thing
//			Thread.sleep(150);
//		}
//		long nanos = stopwatch.elapsed(TimeUnit.MILLISECONDS);
//		System.out.println(nanos);

		// 10.文件操作
//		File file = new File("C:/kang/image/test.txt");
//		List<String> list = null;
//		try {
//			list = Files.readLines(file, Charsets.UTF_8);
//		} catch (Exception e) {
//		}
//		System.out.println(list.toString());

//		Files.copy(from,to);  //复制文件
//		File from = new File("C:/kang/image/files/test.txt");
//		File to = new File("C:/kang/image/files/to.txt");
//		Files.copy(from, to);

//		Files.move(File from, File to); //移动文件
//		File from = new File("C:/kang/image/files/test.txt");
//		File to = new File("C:/kang/image/produce/to.txt");
//		Files.move(from, to);

//		Files.deleteDirectoryContents(File directory); //删除文件夹下的内容(包括文件与子文件夹)  
//		Files.deleteRecursively(File file); //删除文件或者文件夹  
//		URL url = Resources.getResource("abc.xml"); //获取classpath根下的abc.xml文件url

		// 11、Lists
		// 各种创建list的方法
		// 将数组转成list,并在开头位置插入元素
//		List<String> list = Lists.asList("a", new String[] { "b", "c", "d" });
//		List<String> list1 = Lists.asList("a", "b", new String[] { "c", "d", "e" });
//		System.out.println(list1);

		// 直接创建ArrayList
//		ArrayList<String> arrayList = Lists.newArrayList();
		// 创建ArrayList,并初始化
//		ArrayList<String> arrayList1 = Lists.newArrayList("a", "b", "c");
		// 基于现有的arrayList,创建一个arrayList
//		ArrayList<String> arrayList2 = Lists.newArrayList(arrayList1);
		// 初始化指定容量大小的ArrayList，其中容量指ArrayList底层依赖的数组的length属性值，常用于提前知道ArrayList大小的情况的初始化
//		ArrayList<String> arrayList3 = Lists.newArrayListWithCapacity(10);
		// 初始化预定容量大小的ArrayList，返回的list的实际容量为5L + estimatedSize + (estimatedSize /
		// 10)，常用于不确定ArrayList大小的情况的初始化
//		ArrayList<String> arrayList4 = Lists.newArrayListWithExpectedSize(20);
		// 创建CopyOnWriteArrayList
//		CopyOnWriteArrayList<String> copyOnWriteArrayList = Lists.newCopyOnWriteArrayList();
		// 创建linkedList
//		LinkedList<String> linkedList = Lists.newLinkedList();

		// 按指定大小分隔list
//		List<String> list = Lists.newArrayList("a", "b", "c", "d", "e");
		// 将list按大小为2分隔成多个list
//		List<List<String>> splitList = Lists.partition(list, 3);
//		System.out.println(splitList);

		// 笛卡尔集
//		List<String> list1 = Lists.newArrayList("a", "b", "c");
//		List<String> list2 = Lists.newArrayList("d", "e", "f");
//		List<String> list3 = Lists.newArrayList("1", "2", "3");
		// 获取多个list的笛卡尔集
//		List<List<String>> list = Lists.cartesianProduct(list1, list2, list3);
//		System.out.println(list);

		// 字符串转成字符集合
//		ImmutableList<Character> list = Lists.charactersOf("abcdefgh");
//		System.out.println(list.get(4));

		// list反转
//		List<String> list = Lists.newArrayList("a", "b", "c", "1", "2", "3");
//		List<String> reverseList = Lists.reverse(list);
//		System.out.println(reverseList);

		// 数据转换
//		List<String> list = Lists.newArrayList("a","b","c");
		// 把list中的每个元素拼接一个1
//        List<String> list1 = Lists.transform(list,str -> str + "1");
//        System.out.println(list1);

		// 12、Sets
//		HashSet<String> set = Sets.newHashSet();
//		Sets.newLinkedHashSet();
//		Sets.newHashSetWithExpectedSize(10);
//		Sets.newTreeSet();
//		Sets.newConcurrentHashSet();

		// 笛卡尔集
//		Set<String> set1 = Sets.newHashSet("a", "b", "c");
//		Set<String> set2 = Sets.newHashSet("1", "2", "3");
//		Set<String> set3 = Sets.newHashSet("@", "#", "&");
		// 多个Set的笛卡尔集，参数接收多个set集合
//		Set<List<String>> sets = Sets.cartesianProduct(set1, set2, set3);
//        System.out.println(sets);

//		List<Set<String>> list = Lists.newArrayList(set1, set2, set3);
		// 也可以把多个Set集合，放到一个list中，再计算笛卡尔集
//		Set<List<String>> sets1 = Sets.cartesianProduct(list);
//		System.out.println(sets1);
		// Sets.combinations()
		// Sets.difference()

		// 按指定大小进行排列组合
//		Set<String> set1 = Sets.newHashSet("a", "b", "c", "d");
//		Set<Set<String>> sets = Sets.combinations(set1, 3);
//		for (Set<String> set : sets) {
//			System.out.println(set);
//		}

		// 差集
//		Set<String> set1 = Sets.newHashSet("a", "b", "d");
//		Set<String> set2 = Sets.newHashSet("d", "e", "f");
		// difference返回：从set1中剔除两个set公共的元素
//		System.out.println(Sets.difference(set1, set2));
		// symmetricDifference返回：剔除两个set公共的元素，再取两个集合的并集
//		System.out.println(Sets.symmetricDifference(set1, set2));

		// 交集
//		Set<String> set1 = Sets.newHashSet("a","b","c");
//        Set<String> set2 = Sets.newHashSet("a","b","f");
		// 取两个集合的交集
//        System.out.println(Sets.intersection(set1,set2));

		// 过滤
//		Set<String> set1 = Sets.newHashSet("a", "b", "c");
		// 建议可以直接使用java8的过滤，比较方便
//		Set<String> set2 = Sets.filter(set1, str -> str.equalsIgnoreCase("b"));
//		System.out.println(set2);

		// 所有的排列组合
//		Set<String> set1 = Sets.newHashSet("a", "b", "c");
		// 获取set可分隔成的所有子集
//		Set<Set<String>> allSet = Sets.powerSet(set1);
//		for (Set<String> set : allSet) {
//			System.out.println(set);
//		}

		// 并集
//		Set<String> set1 = Sets.newHashSet("a", "b", "c");
//		Set<String> set2 = Sets.newHashSet("1", "2", "3");
		// 取两个集合的并集
//		System.out.println(Sets.union(set1, set2));

		// 创建各种Map的方法
//		Maps.newHashMap();
//        Maps.newHashMapWithExpectedSize(10);
		// Maps.newEnumMap();
//        Maps.newConcurrentMap();
//        Maps.newIdentityHashMap();
//        Maps.newLinkedHashMap();
//        Maps.newLinkedHashMapWithExpectedSize(10);
//        Maps.newTreeMap();

		// set转map
//		Set<String> set = Sets.newHashSet("a", "b", "c");
		// 将set转成Map,key为set元素,value为每个元素的长度
//		Map<String, Integer> map = Maps.asMap(set, String::length);
//		System.out.println(map);

		// 计算map的差值
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> map2 = Maps.newHashMap();
//		map2.put("a", "1");
//		map2.put("e", "5");
//		map2.put("f", "6");
//		// mapDifference是将两个map相同的部分剔除
//		MapDifference<String, String> mapDifference = Maps.difference(map1, map2);
//		// 两个Map相同的部分
//		System.out.println(mapDifference.entriesInCommon());
//		// 左边集合剔除相同部分后的剩余
//		System.out.println(mapDifference.entriesOnlyOnLeft());
//		// 右边集合剔除相同部分后的剩余
//		System.out.println(mapDifference.entriesOnlyOnRight());

		// 通过Entry过滤
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.filterEntries(map1, item -> !item.getValue().equalsIgnoreCase("2"));
//		System.out.println(result);

		// 通过Key过滤
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.filterKeys(map1, item -> !item.equalsIgnoreCase("b"));
//		System.out.println(result);

		// 通过value过滤
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.filterValues(map1, item -> !item.equalsIgnoreCase("3"));
//		System.out.println(result);

		// 转换Entry
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.transformEntries(map1, (k, v) -> k + v);
//		System.out.println(result);

		// 转换value
//		Map<String, String> map1 = Maps.newHashMap();
//		map1.put("a", "1");
//		map1.put("b", "2");
//		map1.put("c", "3");
//		Map<String, String> result = Maps.transformValues(map1, value -> value + 10);
//		System.out.println(result);

		// 13.普通集合的创建
//		List<String> list = Lists.newArrayList();
//		Set<String> set = Sets.newHashSet();

		// 14.不可变集合的创建
//		ImmutableList<String> list = ImmutableList.of("a","b","c");
//		System.out.println(list.toString());
//		ImmutableSet<String> set = ImmutableSet.of("a","b");
//		System.out.println(set.toString());

		// 15.同key不同value
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

		// 16.两个键映射一个值
//		Table<String, String, Integer> table = HashBasedTable.create();
//		table.put("a", "b", 1);
//		table.put("a", "c", 2);
//		System.out.println(table.get("a", "b"));
//		System.out.println(table.row("a"));
		// 查看列数据
//		Map<String, Integer> column = table.column("b");
//		System.out.println(column);

		// 17.BiMap 一种连value也不能重复的HashMap
//		BiMap<String, String> biMap = HashBiMap.create();
//		biMap.put("a", "apple");
//		biMap.put("b", "apple");
//		System.out.println(biMap);

		// 既然value不能重复，何不实现个翻转key/value的方法，已经有了
//		BiMap<String, String> inverseMap = biMap.inverse();
//		System.out.println(inverseMap);

		// 18.Multiset 一种用来计数的Set
//		Multiset<String> multiset = HashMultiset.create();
//		multiset.add("apple");
//		multiset.add("apple");
//		multiset.add("banana");
		// 计数
//		System.out.println(multiset.count("apple"));
		// 查看去重的元素
//		Set<String> set = multiset.elementSet();
//		System.out.println(set);
		// 查看没有去重的元素
//		Iterator<String> iter = multiset.iterator();
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		// 手动设置某个元素出现的次数
//		multiset.setCount("apple", 5);
//		System.out.println(multiset.count("apple"));
	}

}
