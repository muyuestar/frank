package com.frank.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串操作类
 *
 * @author kst
 * @date 2019-05-14 08:56:31
 */
public class StringUtil {

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 参数化字符串
     *
     * @param str 字符串
     * @return 参数化后字符串
     */
    public static String formatStr(String str) {
        return String.format("smart_%s_admin", str);
    }

    /**
     * List集合拼接成以指定字符分隔的字符串
     *
     * @param list list集合
     * @return 拼接成以指定字符分隔的字符串
     * @author kst, 20210808
     */
    public static String joinStr(List<String> list, String str) {
        return (String) list.stream().collect(Collectors.joining(str));
    }

    /**
     * List集合拼接成以指定字符分隔的字符串
     *
     * @param list list集合
     * @return 拼接成以指定字符分隔的字符串
     * @author kst, 20210808
     */
    public static String joinStr2(List<String> list, String str) {
        return String.join(str, list);
    }

    /**
     * 比较两个对象是否相等
     *
     * @param a 对象a
     * @param b 对象b
     * @return true-相等，false-不等
     * @author kst, 20210808
     */
    public static boolean objectEquals(Object a, Object b) {
        return Objects.equals(a, b);
    }

    /**
     * 首字母转成大写
     *
     * @param str 字符串
     * @return 首字母大写的字符串
     * @author kst, 20210808
     */
    public static String capitalizeStr(String str) {
        return StringUtils.capitalize(str);
    }

    /**
     * 重复拼接字符串
     *
     * @param str 字符串
     * @param num 重复次数
     * @return 重复拼接字符串
     * @author kst, 20210808
     */
    public static String repeatStr(String str, int num) {
        return StringUtils.repeat(str, num);
    }

    /**
     * 去除字符串左边的0
     *
     * @param str 字符串
     * @return 去除后的字符串
     * @author kst, 20221209
     */
    public static String replaceLeftZero(String str) {
        return str.replaceAll("^(0+)", "");
    }

    /**
     * 去除字符串右边的0
     *
     * @param str 字符串
     * @return 去除后的字符串
     * @author kst, 20221209
     */
    public static String replaceRightZero(String str) {
        return str.replaceAll("0*$", "");
    }


    public static void main(String[] args) {
//		System.out.println(formatStr("123456"));

//		List<String> list = Arrays.asList("a", "b", "c");
//		System.out.println(joinStr(list, ","));

//		List<String> list = Arrays.asList("a", "b", "c");
//		System.out.println(joinStr2(list, ","));

//		System.out.println(objectEquals("a", "a"));
//		System.out.println(objectEquals("a", "b"));

//		System.out.println(capitalizeStr("frank"));

//		System.out.println(repeatStr("kang", 5));

//        System.out.println(replaceLeftZero("00001024"));

        System.out.println(StringUtils.indexOfAny((CharSequence)"77311", new String[]{"77311", "77313"}));
    }
}
