package com.frank.test;

import java.math.BigInteger;

/**
 * ����BigInteger.shiftLeft��shiftRight����
 * 
 * @author Administrator
 *
 */
public class TestBigInteger {

	public static void main(String[] args) {
		BigInteger leftBI = new BigInteger("2").shiftLeft(2);
		System.out.println("����*=" + leftBI.toString());
		BigInteger rightBI = new BigInteger("16").shiftRight(2);
		System.out.println("����/=" + rightBI.toString());
	}
}
