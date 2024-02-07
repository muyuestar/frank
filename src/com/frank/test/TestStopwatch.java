package com.frank.test;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 *
 * @author kst
 * @version ����ʱ�䣺2020��3��4�� ����2:40:52
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
