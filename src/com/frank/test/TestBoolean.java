package com.frank.test;

import org.apache.commons.lang3.BooleanUtils;

import java.util.stream.Stream;

/**
 * ≤‚ ‘Boolean
 *
 * @author kst
 */
public class TestBoolean {

    public static void main(String[] args) {
//		Boolean bool = Boolean.TRUE;
//		System.out.println(bool.booleanValue());

        // and
//        Boolean[] booleans = new Boolean[]{Boolean.TRUE, Boolean.TRUE, Boolean.TRUE};
//        Boolean flag = BooleanUtils.and(booleans);
//        System.out.println(flag);

        // or
//		Boolean[] booleans = new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE };
//		Boolean flag = BooleanUtils.or(booleans);
//		System.out.println(flag);

        // compare≤‚ ‘
//        Boolean flag1 = false;
//        Boolean flag2 = true;
//        int cint = flag1.compareTo(flag2);
//        System.out.println(cint);

        // logicalAnd
//        System.out.println(Boolean.logicalAnd(true, false));

        // logicalOr
//        System.out.println(Boolean.logicalOr(true, false));

        // logicalXor
        System.out.println(Boolean.logicalXor(true, true)); // false
        System.out.println(Boolean.logicalXor(true, false)); // true
        System.out.println(Boolean.logicalXor(false, true)); // true
        System.out.println(Boolean.logicalXor(false, false)); // false
    }

}
