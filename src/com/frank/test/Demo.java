package com.frank.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.util.MathUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public class Demo {

    public static void main(String[] args) throws Exception {
//        String str = "test10410004354";
        String str = "testmt0";
        int index = -1;
        if(matcherStr(str) && (index = getDigitIndex(str)) != -1){
            str = str.substring(0,index) + str.substring(index);
        }
        System.out.println(str);
    }

    private static int getDigitIndex(String str){
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                index = i;
                break;
            }
        }
        return index;
    }

    public static boolean matcherStr(String str) {
        String regex = "[a-zA-Z]";
        return Pattern.compile(regex).matcher(str).find();
    }



}
