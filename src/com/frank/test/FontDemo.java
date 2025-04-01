package com.frank.test;

import java.awt.Font;
import java.math.BigDecimal;

/**
 * @author kst
 * @date 2019年12月13日 上午8:31:24
 */
public class FontDemo {

    public static void main(String[] args) {
//        String str = "标题";
//		str.setFont(new Font("Times New Roman",Font.ITALIC,18));


//        BigDecimal a = new BigDecimal("3");
//        BigDecimal b = new BigDecimal("3");
//        System.out.println(a.compareTo(b));

        String line = "4、甘肃银行新核心柜面系统，2016年1月-2017年9月，项目经理，负责甘肃银行新核心系统";
        boolean flag = line.contains("柜面") || line.contains("综合前端") || line.contains("新核心");
        System.out.println("flag=" + flag);
    }

}
