package com.frank.test;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 *
 * @author kst
 * @version 创建时间：2020年3月4日 下午2:40:52
 */
public class TestStopwatch {

	public static void main(String[] args) throws InterruptedException {
		Stopwatch stopWatch = Stopwatch.createStarted();
		// do String
		Thread.sleep(2000);
		long second = stopWatch.elapsed(TimeUnit.SECONDS);
		System.out.println(second);
	}

}
