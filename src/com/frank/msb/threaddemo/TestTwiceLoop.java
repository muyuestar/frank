package com.frank.msb.threaddemo;

/**
 * 跳出两层循环
 * 
 * @author kst
 * @date 2022-01-22 22:07:00
 */
public class TestTwiceLoop {

	public static void main(String[] args) {
		out: for (;;) {
			for (;;) {
				System.out.println("跳出内循环");
				break out;
			}
		}
		System.out.println("执行了吗");
	}

}
