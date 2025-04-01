package com.frank.test;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        String str = "";
        String[] arr = str.split("¡¢");
        System.out.println(arr.length);
//        List<String> list = Lists.newArrayList("apple");
//        System.out.println(StringUtils.join(list, "¡¢"));
    }

}