package com.frank.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.frank.test.Constants.Person;
import com.google.common.collect.Lists;

/**
 * @author kst
 * @date 2019-02-19 08:55:28 Java中Lambda表达式的使用
 */
public class TestLambda {

	public static void main(String[] args) {
		// 1、数组
//		String[] arr = new String[] { "a", "b", "c", "d", "e" };
//		List<String> list = Arrays.asList(arr);
//		list.forEach((str) -> System.out.println(str + ","));
//		list.forEach(System.out::println);

		// 2、线程
		// new Thread(()->System.out.println("Hello World!")).start();

		// 3、集合排序
		// String[] arr = new String[] { "banana", "apple", "peach", "plum",
		// "cherry" };
		// (1)字符顺序
		// Arrays.sort(arr, (String s1, String s2) -> (s1.compareTo(s2)));
		// (2)字符长度
		// Arrays.sort(arr, (String s1, String s2) -> (s1.length() -
		// s2.length()));
		// (3)某个字符排序
		// Arrays.sort(arr, (String s1, String s2) -> (s2.charAt(s2.length() -
		// 1) - s1.charAt(s1.length() - 1)));
		// System.out.println(Arrays.toString(arr));

		// 4、使用Lambdas和Streams
//		List<Person> javaProgrammers = new ArrayList<Person>() {
//			{
//				add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 2000, 43));
//				add(new Person("Tamsen", "Brittany", "Java programmer", "female", 1500, 23));
//				add(new Person("Floyd", "Donny", "Java programmer", "male", 1800, 33));
//				add(new Person("Sindy", "Jonie", "Java programmer", "female", 1600, 32));
//				add(new Person("Vere", "Hervey", "Java programmer", "male", 1200, 22));
//				add(new Person("Maude", "Jaimie", "Java programmer", "female", 1900, 27));
//				add(new Person("Shawn", "Randall", "Java programmer", "male", 2300, 30));
//				add(new Person("Jayden", "Corrina", "Java programmer", "female", 1700, 35));
//				add(new Person("Palmer", "Dene", "Java programmer", "male", 2000, 33));
//				add(new Person("Addison", "Pam", "Java programmer", "female", 1300, 34));
//			}
//		};
//		List<Person> phpProgrammers = new ArrayList<Person>() {
//			{
//				add(new Person("Jarrod", "Pace", "PHP programmer", "male", 1550, 34));
//				add(new Person("Clarette", "Cicely", "PHP programmer", "female", 1200, 23));
//				add(new Person("Victor", "Channing", "PHP programmer", "male", 1600, 32));
//				add(new Person("Tori", "Sheryl", "PHP programmer", "female", 1000, 21));
//				add(new Person("Osborne", "Shad", "PHP programmer", "male", 1100, 32));
//				add(new Person("Rosalind", "Layla", "PHP programmer", "female", 1300, 25));
//				add(new Person("Fraser", "Hewie", "PHP programmer", "male", 1100, 36));
//				add(new Person("Quinn", "Tamara", "PHP programmer", "female", 1000, 21));
//				add(new Person("Alvin", "Lance", "PHP programmer", "male", 1600, 38));
//				add(new Person("Evonne", "Shari", "PHP programmer", "female", 1800, 40));
//			}
//		};
		// (1)输出所有程序员的姓名
		// System.out.println("所有程序员的姓名：");
		// javaProgrammers.forEach((p) -> System.out.printf("%s %s;",
		// p.getFirstName(), p.getLastName()));
		// System.out.println("\t");
		// phpProgrammers.forEach((p) -> System.out.printf("%s %s;",
		// p.getFirstName(), p.getLastName()));
		// (2)增加程序员工资%5
		// Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5
		// + e.getSalary());
		// javaProgrammers.forEach(giveRaise);
		// phpProgrammers.forEach(giveRaise);
		// (3)过滤器filter() ,让我们显示月薪超过1400美元的PHP程序员
//		phpProgrammers.stream().filter((p) -> p.getSalary() > 1400)
//				.forEach((p) -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
		// (4)年龄大于 25岁且月薪在$1,400以上的女PHP程序员
//		phpProgrammers.stream().filter((p) -> p.getAge() > 25).filter((p) -> p.getSalary() > 1400)
//				.filter((p) -> "female".equals(p.getGender()))
//				.forEach((p) -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
		// (5)年龄大于 25岁的女性 Java programmers:
//		javaProgrammers.stream().filter((p) -> p.getAge() > 25).filter((p) -> "female".equals(p.getGender()))
//				.forEach((p) -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
		// (6)最前面的3个 Java programmers:
//		javaProgrammers.stream().limit(3).forEach((p)->System.out.printf("%s %s;", p.getFirstName(),p.getLastName()));
		// (7)最前面的3个女性 Java programmers
//		javaProgrammers.stream().filter((p) -> "female".equals(p.getGender())).limit(3)
//				.forEach((p) -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
		// (8)工资最低的 Java programmer:
//		Person p = javaProgrammers.stream().min((p1, p2) -> p1.getSalary() - p2.getSalary()).get();
//		System.out.printf("Name:%s %s; Salary:$%,d.", p.getFirstName(), p.getLastName(), p.getSalary());
		// (9)工资最高的 Java programmer
//		Person p = javaProgrammers.stream().max((p1,p2)->p1.getSalary()-p2.getSalary()).get();
//		System.out.printf("Name:%s %s; Salary:$%,d.",p.getFirstName(),p.getLastName(),p.getSalary());
		// (10)计算付给 Java programmers 的所有money
//		int totalMoney = javaProgrammers.parallelStream().mapToInt(p -> p.getSalary()).sum();
//		System.out.printf("$%,d",totalMoney);
		// (11)使用summaryStatistics方法获得stream 中元素的各种汇总数据。 接下来,我们可以访问这些方法,比如getMax,
		// getMin, getSum或getAverage
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
//		System.out.println("最大数字：" + stats.getMax());
//		System.out.println("最小数字：" + stats.getMin());
//		System.out.println("数字总和：" + stats.getSum());
//		System.out.println("平均值：" + stats.getAverage());
//		System.out.println("总数：" + stats.getCount());
		// (12)根据 name 排序,并显示前5个 Java programmers
//		javaProgrammers.stream().sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName())).limit(5)
//				.collect(Collectors.toList())
//				.forEach((p) -> System.out.printf("%s %s;\n", p.getFirstName(), p.getLastName()));
		// (13)根据 salary 排序 Java programmers
//		javaProgrammers.stream().sorted((p1, p2) -> p1.getSalary() - p2.getSalary()).collect(Collectors.toList())
//				.forEach((p) -> System.out.printf("Name:%s %s; Salary:%s. \n", p.getFirstName(), p.getLastName(),
//						p.getSalary()));
		// (14)将 PHP programmers 的 first name 拼接成字符串
//		String firstNames = phpProgrammers.stream().map(Person::getFirstName).collect(Collectors.joining(" ; "));
//		System.out.println(firstNames);
		// (15)将字符串转换成小写的字符串
//		List<String> list = Arrays.asList(new String[] { "a", "b", "c" });
//		System.out.println(list.toString());
//		List<String> newList = list.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
//		List<String> newList = list.stream().map(String::toLowerCase).collect(Collectors.toList());
//		System.out.println(newList.toString());
		// (16)变量处理
//		List<String> list = Arrays.asList(new String[] { "a", "b", "c" });
//		String waibu = "lambda:";
//		list.stream().map(str->{
//			Long zidingyi = System.currentTimeMillis();
//			return waibu + str + "------:"+zidingyi; 
//		}).collect(Collectors.toList()).forEach(System.out::println);
		// (17)多种方法结合使用
//		List<Integer> list = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//		int sum = list.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2)
//				.limit(4).sum();
//		System.out.println(Integer.toString(sum));
		// (18)reduce方法1
//		List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
//		Integer sums = list.stream().reduce((sum,item)->sum+item).get();
//		System.out.println(sums);
		// (19)reduce方法2
//		List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
//		Integer sums = list.stream().reduce(0,(sum,item)->sum+item);
//		System.out.println(sums);
		// (20)allMatch,max用法
		List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		boolean flag = list.stream().allMatch(item -> item < 11);
//		System.out.println(flag);
		list.stream().max((s1, s2) -> s1.compareTo(s2)).ifPresent(System.out::println);
	}
}
