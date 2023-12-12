package com.frank.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * �ַ���������
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
     * �������ַ���
     *
     * @param str �ַ���
     * @return ���������ַ���
     */
    public static String formatStr(String str) {
        return String.format("smart_%s_admin", str);
    }

    /**
     * List����ƴ�ӳ���ָ���ַ��ָ����ַ���
     *
     * @param list list����
     * @return ƴ�ӳ���ָ���ַ��ָ����ַ���
     * @author kst, 20210808
     */
    public static String joinStr(List<String> list, String str) {
        return (String) list.stream().collect(Collectors.joining(str));
    }

    /**
     * List����ƴ�ӳ���ָ���ַ��ָ����ַ���
     *
     * @param list list����
     * @return ƴ�ӳ���ָ���ַ��ָ����ַ���
     * @author kst, 20210808
     */
    public static String joinStr2(List<String> list, String str) {
        return String.join(str, list);
    }

    /**
     * �Ƚ����������Ƿ����
     *
     * @param a ����a
     * @param b ����b
     * @return true-��ȣ�false-����
     * @author kst, 20210808
     */
    public static boolean objectEquals(Object a, Object b) {
        return Objects.equals(a, b);
    }

    /**
     * ����ĸת�ɴ�д
     *
     * @param str �ַ���
     * @return ����ĸ��д���ַ���
     * @author kst, 20210808
     */
    public static String capitalizeStr(String str) {
        return StringUtils.capitalize(str);
    }

    /**
     * �ظ�ƴ���ַ���
     *
     * @param str �ַ���
     * @param num �ظ�����
     * @return �ظ�ƴ���ַ���
     * @author kst, 20210808
     */
    public static String repeatStr(String str, int num) {
        return StringUtils.repeat(str, num);
    }

    /**
     * ȥ���ַ�����ߵ�0
     *
     * @param str �ַ���
     * @return ȥ������ַ���
     * @author kst, 20221209
     */
    public static String replaceLeftZero(String str) {
        return str.replaceAll("^(0+)", "");
    }

    /**
     * ȥ���ַ����ұߵ�0
     *
     * @param str �ַ���
     * @return ȥ������ַ���
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
