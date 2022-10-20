package com.frank.test;

import org.apache.commons.lang3.BooleanUtils;

/**
 * ≤‚ ‘Boolean
 * 
 * @author kst
 *
 */
public class TestBoolean {

	public static void main(String[] args) {
//		Boolean bool = Boolean.TRUE;
//		System.out.println(bool.booleanValue());
		// and
//		Boolean[] booleans = new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE };
//		Boolean flag = BooleanUtils.and(booleans);
//		System.out.println(flag);
		// or
		Boolean[] booleans = new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE };
		Boolean flag = BooleanUtils.or(booleans);
		System.out.println(flag);
	}
}
