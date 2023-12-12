package com.frank.lambda;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 测试Stream
 *
 * @author kst
 */
public class TestStream {

    public static void main(String[] args) throws Exception {
        // eg1
//        List<String> sentences = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/frank/" + "files/stream.txt")).stream().map(line -> line.trim())
//                .filter(line -> line.length() > 1).collect(Collectors.toList());
//        sentences.forEach(sentence -> System.out.println(sentence));

        // eg2:stream的count，anyMatch，allMatch，noneMatch操作
//		List<String> list = Arrays.asList(new String[]{"a","a","a","a","b"});
//		boolean any = list.stream().anyMatch(str->"a".equals(str));
//		boolean all = list.stream().allMatch(str->"a".equals(str));
//		boolean none = list.stream().noneMatch(str->"a".equals(str));
//		long count = list.stream().filter(str->"a".equals(str)).count();
//		System.out.println("any:"+any);
//		System.out.println("all:"+all);
//		System.out.println("none:"+none);
//		System.out.println("count:"+count);

        // eg3:测试Arrays.stream()用法
//		String[] strs = new String[] { "a", "a", "a", "a", "b" };
        // 计算数组中和a相等的字符串个数
//		long count = Arrays.stream(strs).filter(str->"a".equals(str)).count();
//		System.out.println(count);
        // 返回流中的第1个元素
//		Optional<String> optionalStr = Arrays.stream(strs).filter(str -> "a".equals(str)).findFirst();
        // 返回流中的任何一个元素
//		Optional<String> optionalStr = Arrays.stream(strs).filter(str -> "a".equals(str)).findAny();
//		System.out.println(optionalStr);
//		System.out.println(optionalStr.get());
//		System.out.println(optionalStr.isPresent());
    }
}
