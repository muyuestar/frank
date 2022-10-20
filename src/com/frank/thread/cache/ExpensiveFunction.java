package com.frank.thread.cache;

import java.math.BigInteger;

/**
 * 构建高效且可伸缩的结果缓存
 * 
 * @author kst
 * @date 2019-08-24 18:50:27
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		// 经过长时间的计算后
		return new BigInteger(arg);
	}
}
