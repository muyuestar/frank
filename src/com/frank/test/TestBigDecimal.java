package com.frank.test;

import java.math.BigDecimal;

/**
 * ≤‚ ‘BigDecimal
 * 
 * @author kst
 * @date 2022-05-10 20:05:18
 */
public class TestBigDecimal {

	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("0.00");
		bigDecimal = bigDecimal.add(new BigDecimal("12.98"));
		bigDecimal = bigDecimal.add(new BigDecimal("23.56"));
		bigDecimal = bigDecimal.add(new BigDecimal("34.87"));
		bigDecimal = bigDecimal.add(new BigDecimal("67.8888"));
		bigDecimal = bigDecimal.add(new BigDecimal("67.2"));
		bigDecimal = bigDecimal.add(new BigDecimal("12"));
		System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
	}

}
