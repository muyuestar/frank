package com.frank.test;

/**
 * 测试Integer中方法
 * 
 * @author kst
 *
 */
public class TestInteger {

	public static void main(String[] args) {
		int i = 170;
		// 整数转换成二进制数
		System.out.println("Binary=" + Integer.toBinaryString(i));
		// 返回指定 int 值的二进制补码表示形式的 1 位的数量
		System.out.println("1位数量=" + Integer.bitCount(i));
		// 返回具有至多单个 1 位的 int 值，在指定的 int 值中最高位（最左边）的 1 位的位置
		System.out.println("值最高位=" + Integer.highestOneBit(i));
		// 返回具有至多单个 1 位的 int 值，在指定的 int 值中最低位（最右边）的 1 位的位置
		System.out.println("最低位=" + Integer.lowestOneBit(i));
		// 在指定 int 值的二进制补码表示形式中最高位（最左边）的 1 位之前，返回零位的数量
		System.out.println(Integer.numberOfLeadingZeros(i));
		// 返回指定的 int 值的二进制补码表示形式中最低（“最右边”）的为 1 的位后面的零位个数
		System.out.println(Integer.numberOfTrailingZeros(i));
	}
}
