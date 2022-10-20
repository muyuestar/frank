package com.frank.test;

import java.util.Arrays;

import com.frank.util.ByteUtil;

/**
 * @author kst
 * @date 2019��12��2�� ����10:04:03
 * 
 */
public class TestByteUtils {

	public static void main(String[] args) throws Exception {
		byte[] data = "abc".getBytes("gbk");
		System.out.println(Arrays.toString(data));
		byte[] dbcss = ByteUtil.toDBCS(data);
		System.out.println(Arrays.toString(dbcss));
	}
}
