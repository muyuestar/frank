package com.frank.test;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

/**
 *
 * @author kst
 * @version 创建时间：2020年3月4日 上午11:25:11
 */
public class PairAndTriple {

	public static void main(String[] args) {
		Pair<Integer, Integer> pair = new ImmutablePair<>(1, 2);
		System.out.println(pair.getLeft() + "," + pair.getRight());

		Triple<Integer, Integer, Integer> triple = new ImmutableTriple<>(1, 2, 3);
		System.out.println(triple.getLeft() + "," + triple.getMiddle() + "," + triple.getRight());
	}

}
