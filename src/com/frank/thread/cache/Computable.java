package com.frank.thread.cache;

/**
 * 构建高效且可伸缩的结果缓存
 * 
 * @author kst
 * @date 2019-08-24 18:47:08
 */
public interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}
