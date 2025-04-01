package com.frank.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 测试BigDecimal
 *
 * @author kst
 * @date 2022-05-10 20:05:18
 */
public class TestBigDecimal {

    public static void main(String[] args) {
        // 测试1
//		BigDecimal bigDecimal = new BigDecimal("0.00");
//		bigDecimal = bigDecimal.add(new BigDecimal("12.98"));
//		bigDecimal = bigDecimal.add(new BigDecimal("23.56"));
//		bigDecimal = bigDecimal.add(new BigDecimal("34.87"));
//		bigDecimal = bigDecimal.add(new BigDecimal("67.8888"));
//		bigDecimal = bigDecimal.add(new BigDecimal("67.2"));
//		bigDecimal = bigDecimal.add(new BigDecimal("12"));
//		System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));

        // 测试2
//        BigDecimal b1 = new BigDecimal("0.00").multiply(new BigDecimal("0.56"));
//        BigDecimal b2 = new BigDecimal("203.00").multiply(new BigDecimal("0.52"));
//        BigDecimal b3 = new BigDecimal("300.12").multiply(new BigDecimal("0.78"));
//        BigDecimal b = b1.add(b2).add(b3);
//        System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP));


        // 小数点后四舍五入
//        BigDecimal bigDecimal = new BigDecimal("3.14155").setScale(4, RoundingMode.HALF_UP);
//        System.out.println(bigDecimal);

        // 比较数字字符串大小
        boolean flag = new BigDecimal("10").compareTo(new BigDecimal("10")) <= 0;
        System.out.println(flag);
    }

}
