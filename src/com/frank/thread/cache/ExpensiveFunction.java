package com.frank.thread.cache;

import java.math.BigInteger;

/**
 * ������Ч�ҿ������Ľ������
 * 
 * @author kst
 * @date 2019-08-24 18:50:27
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		// ������ʱ��ļ����
		return new BigInteger(arg);
	}
}
