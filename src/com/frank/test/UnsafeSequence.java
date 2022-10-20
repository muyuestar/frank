package com.frank.test;

/**
 * @author kst
 * @date 2019-01-13 20:50:23
 */
public class UnsafeSequence {
	private int value = 0;

	public synchronized int getNext() {
		return value++;
	}
}
