package com.frank.test;

import java.awt.Font;
import java.math.BigDecimal;

/**
 * @author kst
 * @date 2019��12��13�� ����8:31:24
 */
public class FontDemo {

    public static void main(String[] args) {
//        String str = "����";
//		str.setFont(new Font("Times New Roman",Font.ITALIC,18));


//        BigDecimal a = new BigDecimal("3");
//        BigDecimal b = new BigDecimal("3");
//        System.out.println(a.compareTo(b));

        String line = "4�����������º��Ĺ���ϵͳ��2016��1��-2017��9�£���Ŀ����������������º���ϵͳ";
        boolean flag = line.contains("����") || line.contains("�ۺ�ǰ��") || line.contains("�º���");
        System.out.println("flag=" + flag);
    }

}
