package com.frank.mt;

import com.cfcc.spz.sdk.SPZUtils;

/**
 * @author: kst
 * @date: 2024/7/17 17:38
 */
public class SPZDemo {

    public static void main(String[] args) throws Exception {
        boolean flag = SPZUtils.includeRareCJKorEscMean("DEFAULT");
        System.out.println(flag);

//        String str = SPZUtils.escapeRareCJK("\"?\", \"U+\"");
//        System.out.println(str);

//        String str = SPZUtils.unescapeRareCJK("`H03473");
//        System.out.println(str);
    }

}
