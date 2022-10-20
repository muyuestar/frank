package com.frank.test;

import java.nio.charset.Charset;

/**
 * ≤‚ ‘Charset
 * 
 * @author kst
 *
 */
public class TestCharset {

	public static void main(String[] args) {
		Boolean flag = Charset.isSupported("utf-8");
		System.out.println(flag);
	}
}
