package com.frank.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * @author: kst
 * @date: 2025/4/23 10:53
 */
public class TestCompareContent {

    public static void main(String[] args) throws Exception {
        compareStr();
    }

    private static void printStr() throws Exception {
        File file = new File("C:/kang/demo/demo.txt");
        List<String> oneList = FileUtils.readLines(file, "UTF-8");
        oneList.forEach(ele -> System.out.println(ele.split("\"")[1].trim()));
    }

    private static void compareStr() throws Exception {
        File file = new File("D:/kang/demo/demo.txt");
        List<String> oneList = FileUtils.readLines(file, "UTF-8");

        File file1 = new File("D:/kang/demo/demo1.txt");
        List<String> twoList = FileUtils.readLines(file1, "UTF-8");

        System.out.println("A相对B");
        oneList.stream().filter(ele -> !twoList.contains(ele.toString())).forEach(ele -> System.out.println(ele));

        System.out.println("B相对A");
        twoList.stream().filter(ele -> !oneList.contains(ele.toString())).forEach(ele -> System.out.println(ele));
    }

    private static void compareStr1() throws Exception {
        File file = new File("D:/kang/demo/demo.txt");
        List<String> oneList = FileUtils.readLines(file, "UTF-8");

        File file1 = new File("D:/kang/demo/demo1.txt");
        List<String> twoList = FileUtils.readLines(file1, "UTF-8");

        System.out.println("A相对B");
        oneList.forEach(ele -> {
            twoList.forEach(ele1 -> {
                boolean flag = false;
                if (ele.split("\\|")[0].equals(ele1.split("\\|")[0])) {
                    if (ele.split("\\|").length < 4 && ele1.split("\\|").length >= 4) {
                        System.out.println("未送值=" + ele.split("\\|")[0] + "    B的值=" + ele1.split("\\|")[3]);
                        return;
                    }
                }
            });
        });
    }
}
