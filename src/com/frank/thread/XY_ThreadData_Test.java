package com.frank.thread;

import java.util.Random;

/**
 * @author kst
 * @date 2019-01-19 09:18:24
 */
public class XY_ThreadData_Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					final int value = new Random().nextInt();
//					XY_ThreadData.setData(value);
//					XY_ThreadData.getData();
					
					XY_ThreadData.setMapData(value);
				    XY_ThreadData.getMapData();
				    
//				    XY_ThreadData.setThreadLocalData(value);
//				    XY_ThreadData.getThreadLocalData();
				}
			}).start();
		}
	}
}
