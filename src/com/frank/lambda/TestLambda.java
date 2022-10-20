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
 * @date 2019-02-19 08:55:28 Java��Lambda���ʽ��ʹ��
 */
public class TestLambda {

	public static void main(String[] args) {
		// 1������
//		String[] arr = new String[] { "a", "b", "c", "d", "e" };
//		List<String> list = Arrays.asList(arr);
//		list.forEach((str) -> System.out.println(str + ","));
//		list.forEach(System.out::println);

		// 2���߳�
		// new Thread(()->System.out.println("Hello World!")).start();

		// 3����������
		// String[] arr = new String[] { "banana", "apple", "peach", "plum",
		// "cherry" };
		// (1)�ַ�˳��
		// Arrays.sort(arr, (String s1, String s2) -> (s1.compareTo(s2)));
		// (2)�ַ�����
		// Arrays.sort(arr, (String s1, String s2) -> (s1.length() -
		// s2.length()));
		// (3)ĳ���ַ�����
		// Arrays.sort(arr, (String s1, String s2) -> (s2.charAt(s2.length() -
		// 1) - s1.charAt(s1.length() - 1)));
		// System.out.println(Arrays.toString(arr));

		// 4��ʹ��Lambdas��Streams
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
		// (1)������г���Ա������
		// System.out.println("���г���Ա��������");
		// javaProgrammers.forEach((p) -> System.out.printf("%s %s;",
		// p.getFirstName(), p.getLastName()));
		// System.out.println("\t");
		// phpProgrammers.forEach((p) -> System.out.printf("%s %s;",
		// p.getFirstName(), p.getLastName()));
		// (2)���ӳ���Ա����%5
		// Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5
		// + e.getSalary());
		// javaProgrammers.forEach(giveRaise);
		// phpProgrammers.forEach(giveRaise);
		// (3)������filter() ,��������ʾ��н����1400��Ԫ��PHP����Ա
//		phpProgrammers.stream().filter((p) -> p.getSalary() > 1400)
//				.forEach((p) -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
		// (4)������� 25������н��$1,400���ϵ�ŮPHP����Ա
//		phpProgrammers.stream().filter((p) -> p.getAge() > 25).filter((p) -> p.getSalary() > 1400)
//				.filter((p) -> "female".equals(p.getGender()))
//				.forEach((p) -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
		// (5)������� 25���Ů�� Java programmers:
//		javaProgrammers.stream().filter((p) -> p.getAge() > 25).filter((p) -> "female".equals(p.getGender()))
//				.forEach((p) -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
		// (6)��ǰ���3�� Java programmers:
//		javaProgrammers.stream().limit(3).forEach((p)->System.out.printf("%s %s;", p.getFirstName(),p.getLastName()));
		// (7)��ǰ���3��Ů�� Java programmers
//		javaProgrammers.stream().filter((p) -> "female".equals(p.getGender())).limit(3)
//				.forEach((p) -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
		// (8)������͵� Java programmer:
//		Person p = javaProgrammers.stream().min((p1, p2) -> p1.getSalary() - p2.getSalary()).get();
//		System.out.printf("Name:%s %s; Salary:$%,d.", p.getFirstName(), p.getLastName(), p.getSalary());
		// (9)������ߵ� Java programmer
//		Person p = javaProgrammers.stream().max((p1,p2)->p1.getSalary()-p2.getSalary()).get();
//		System.out.printf("Name:%s %s; Salary:$%,d.",p.getFirstName(),p.getLastName(),p.getSalary());
		// (10)���㸶�� Java programmers ������money
//		int totalMoney = javaProgrammers.parallelStream().mapToInt(p -> p.getSalary()).sum();
//		System.out.printf("$%,d",totalMoney);
		// (11)ʹ��summaryStatistics�������stream ��Ԫ�صĸ��ֻ������ݡ� ������,���ǿ��Է�����Щ����,����getMax,
		// getMin, getSum��getAverage
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
//		System.out.println("������֣�" + stats.getMax());
//		System.out.println("��С���֣�" + stats.getMin());
//		System.out.println("�����ܺͣ�" + stats.getSum());
//		System.out.println("ƽ��ֵ��" + stats.getAverage());
//		System.out.println("������" + stats.getCount());
		// (12)���� name ����,����ʾǰ5�� Java programmers
//		javaProgrammers.stream().sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName())).limit(5)
//				.collect(Collectors.toList())
//				.forEach((p) -> System.out.printf("%s %s;\n", p.getFirstName(), p.getLastName()));
		// (13)���� salary ���� Java programmers
//		javaProgrammers.stream().sorted((p1, p2) -> p1.getSalary() - p2.getSalary()).collect(Collectors.toList())
//				.forEach((p) -> System.out.printf("Name:%s %s; Salary:%s. \n", p.getFirstName(), p.getLastName(),
//						p.getSalary()));
		// (14)�� PHP programmers �� first name ƴ�ӳ��ַ���
//		String firstNames = phpProgrammers.stream().map(Person::getFirstName).collect(Collectors.joining(" ; "));
//		System.out.println(firstNames);
		// (15)���ַ���ת����Сд���ַ���
//		List<String> list = Arrays.asList(new String[] { "a", "b", "c" });
//		System.out.println(list.toString());
//		List<String> newList = list.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
//		List<String> newList = list.stream().map(String::toLowerCase).collect(Collectors.toList());
//		System.out.println(newList.toString());
		// (16)��������
//		List<String> list = Arrays.asList(new String[] { "a", "b", "c" });
//		String waibu = "lambda:";
//		list.stream().map(str->{
//			Long zidingyi = System.currentTimeMillis();
//			return waibu + str + "------:"+zidingyi; 
//		}).collect(Collectors.toList()).forEach(System.out::println);
		// (17)���ַ������ʹ��
//		List<Integer> list = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//		int sum = list.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2)
//				.limit(4).sum();
//		System.out.println(Integer.toString(sum));
		// (18)reduce����1
//		List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
//		Integer sums = list.stream().reduce((sum,item)->sum+item).get();
//		System.out.println(sums);
		// (19)reduce����2
//		List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
//		Integer sums = list.stream().reduce(0,(sum,item)->sum+item);
//		System.out.println(sums);
		// (20)allMatch,max�÷�
		List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		boolean flag = list.stream().allMatch(item -> item < 11);
//		System.out.println(flag);
		list.stream().max((s1, s2) -> s1.compareTo(s2)).ifPresent(System.out::println);
	}
}
