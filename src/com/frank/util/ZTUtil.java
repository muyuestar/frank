package com.frank.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ����˾������ģ�嵥
 *
 * @author: kst
 * @date: 2024/4/19 15:45
 */
public class ZTUtil {
    private static BigDecimal three = new BigDecimal("3");
    private static BigDecimal six = new BigDecimal("6");
    private static BigDecimal bage = new BigDecimal("0");

    // <3
    private static List<String> oneList = new ArrayList<>();
    // 3-6
    private static List<String> twoList = new ArrayList<>();
    // >6
    private static List<String> threeList = new ArrayList<>();
    // �ǹ��桢���ۺ�ǰ�ˡ����º���
    private static List<String> fourList = new ArrayList<>();
    // ��List
    private static List<String> allList = new ArrayList<>();
    // ��ʵ��List
    private static List<String> realAllList = new ArrayList<>();

    private static int start = 0;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        File file = new File("C:/kang/demo.txt");
        File destFile = new File("C:/kang/content.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        for (int j = 0; j < 183; j++) {
            singleDeal(lineList);
            int length = count - allList.size();
            for (int k = 0; k < length; k++) {
                allList.add("");
            }
            realAllList.addAll(allList);
            oneList.clear();
            twoList.clear();
            threeList.clear();
            fourList.clear();
            allList.clear();
            count = 0;
        }
        FileUtils.writeLines(destFile, realAllList);
        System.out.println("�ɹ�");
    }

    private static void singleDeal(List<String> lineList) {
        boolean flag = false;
        for (int i = start; i < lineList.size(); i++) {
            String line = lineList.get(i);
            String age = line.split("\t")[0];
            if (StringUtils.isNotBlank(line.substring(0, 1))) {
                if (age.length() > 6) {
                    System.out.println("�����ʽ������");
                    break;
                }
                bage = new BigDecimal(age);
                if (flag) {
                    start = i;

                    // �ƹ񡢳���������PAD��1��
                    if (oneList.size() > 0 || twoList.size() > 0 || threeList.size() > 0) {
                        fourList.clear();
                    }
                    break;
                }
                flag = true;
            }

            count++;

            // <3 1�� ���桢�ۺ�ǰ�ˡ��º���
            if (bage.compareTo(three) == -1 && oneList.size() < 1) {
                if (line.contains("����") || line.contains("�ۺ�ǰ��") || line.contains("�º���")) {
                    oneList.add(line);
                }
            }
            // 3-6 3�� ���桢�ۺ�ǰ�ˡ��º���
            if (bage.compareTo(three) >= 0 && bage.compareTo(six) <= 0 && twoList.size() < 3) {
                if (line.contains("����") || line.contains("�ۺ�ǰ��") || line.contains("�º���")) {
                    twoList.add(line);
                }
            }

            // >6 6�� ���桢�ۺ�ǰ�ˡ��º���
            if (bage.compareTo(six) > 0 && threeList.size() < 6) {
                if (line.contains("����") || line.contains("�ۺ�ǰ��") || line.contains("�º���")) {
                    threeList.add(line);
                }
            }

            // ���ƹ񡢳���������PAD��1���ӽ�ȥ������
            if (!(line.contains("����") || line.contains("�ۺ�ǰ��") || line.contains("�º���")) && fourList.size() < 1) {
                fourList.add(line);
            }

            // �ƹ񡢳���������PAD��1��
            if (oneList.size() > 0 || twoList.size() > 0 || threeList.size() > 0) {
                fourList.clear();
            }
        }

        // <3
        if (oneList.size() > 0) {
            for (int i = 0; i < oneList.size(); i++) {
                dealLine(oneList.get(i), i);
            }
        }
        // 3-6
        if (twoList.size() > 0) {
            for (int i = 0; i < twoList.size(); i++) {
                dealLine(twoList.get(i), i);
            }

        }
        // >6
        if (threeList.size() > 0) {
            for (int i = 0; i < threeList.size(); i++) {
                dealLine(threeList.get(i), i);
            }
        }

        // �ǹ��桢���ۺ�ǰ�ˡ����º���
        if (fourList.size() > 0) {
            for (int i = 0; i < fourList.size(); i++) {
                dealLine(fourList.get(i), i);
            }
        }
    }

    private static void dealLine(String oriLine, int i) {
        String listLine = oriLine;
        listLine = StringUtils.isNotBlank(listLine.substring(0, 1)) ? listLine.split("\t")[1] : listLine;
        listLine = listLine.trim();
        String line = "";
        if (".".equals(listLine.substring(0, 1)) || ".".equals(listLine.substring(1, 2))) {
            line = (i + 1) + "��" + listLine.substring(listLine.indexOf(".") + 1);
        } else if ("��".equals(listLine.substring(0, 1)) || "��".equals(listLine.substring(1, 2))) {
            line = (i + 1) + "��" + listLine.substring(listLine.indexOf("��") + 1);
        } else if (startWithNumber(listLine)) {
            line = (i + 1) + "��" + listLine;
        }

        line = StringUtils.isNotBlank(line) ? line : (i + 1) + "��" + listLine;
//        System.out.println(line);
        allList.add(line);
    }

    public static boolean startWithNumber(String str) {
        return str.matches("\\d.*");
    }
}
