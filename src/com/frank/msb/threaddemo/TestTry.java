package com.frank.msb.threaddemo;

/**
 * 测试finally之后的代码走不走
 * 
 * @author kst
 * @date 2022-02-09 21:42:14
 */
public class TestTry {

	public static void main(String[] args) {
//		try {
//			int num = 1 / 0;
//			System.out.println("1111");
//		} finally {
//			System.out.println("2222");
//		}
//		System.out.println("3333");

		try {
			int num = 1 / 0;
			System.out.println("1111");
		} catch (Exception e) {
			System.out.println("2222");
		} finally {
			System.out.println("3333");
		}
		System.out.println("4444");
	}

}
