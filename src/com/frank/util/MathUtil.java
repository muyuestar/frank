package com.frank.util;

/**
 * 数学方法汇总
 * 
 * @author kst
 * @date 2021-09-12 10:48:54
 * @see https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
 *      https://blog.csdn.net/weixin_43253562/article/details/104237647
 *      http://commons.apache.org/proper/commons-math/
 */
public class MathUtil {

	public static void main(String[] args) {
		System.out.println(Math.abs(-1)); // 1
		System.out.println(Math.max(1, 2)); // 2
		System.out.println(Math.min(1, 2)); // 1
		System.out.println(Math.addExact(1, 2)); // 3
		System.out.println(Math.sin(3.1415926 / 2)); // 0.9999999999999997

		System.out.println(Math.toRadians(90)); // 1.5707963267948966
		System.out.println(Math.toDegrees(1.5707963267948966)); // 90.0

		System.out.println(Math.exp(1)); // 2.718281828459045
		System.out.println(Math.sqrt(10)); // 3.1622776601683795
		System.out.println(Math.IEEEremainder(2.1, 1.1)); // -0.1

		System.out.println(Math.ceil(1.4)); // 2.0
		System.out.println(Math.ceil(1.5)); // 2.0
		System.out.println(Math.floor(1.4)); // 1.0
		System.out.println(Math.floor(1.5)); // 1.0
		System.out.println(Math.rint(1.4)); // 1.0
		System.out.println(Math.rint(1.5)); // 2.0

		System.out.println(Math.random()); // 0.7274317261341466
		System.out.println(Math.random()); // 0.9718303870845516

		System.out.println(Math.subtractExact(1, 2)); // -1
		System.out.println(Math.incrementExact(160)); // 161
		System.out.println(Math.negateExact(160)); // -160

	}

}
