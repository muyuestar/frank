package com.frank.test;

import java.util.concurrent.TimeUnit;

/** 
* @author kst  
* @date 2019-02-13 15:59:38
* ²âÊÔvolatileÓÃ·¨
*/
public class TestVolatile {
	
	public static volatile boolean flag = false;
	
	public static void main(String[] args) {
		new Thread(()->{
			while(!flag){
				
			}
			System.out.println("threadB end.");
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(()->{
			flag = true;
			System.out.println("threadA end.");
		}).start();
	}
}
