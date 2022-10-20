package com.frank.test;

/**
 * ≤‚ ‘OuterWhile
 * 
 * @author kst
 *
 */
public class TestOuterWhile {

	public static void main(String[] args) {
		int i;
		outer: while (true) {
			for (i = 0; i < 5; i++) {
				if (i == 3) {
					break outer;
				} else {
					System.out.println(i);
				}
			}
		}
	}
}
