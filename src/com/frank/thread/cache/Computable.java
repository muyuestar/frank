package com.frank.thread.cache;

/**
 * ������Ч�ҿ������Ľ������
 * 
 * @author kst
 * @date 2019-08-24 18:47:08
 */
public interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}
