package com.frank.test;

import java.net.InetAddress;

/**
 * 获取服务器IP
 * 
 * @author kst
 * @date 2019-07-29 09:34:19
 */
public class GetServerIp {

	public static void main(String[] args) throws Exception {
		InetAddress address = InetAddress.getLocalHost();
		String hostAddress = address.getHostAddress();
		System.out.println(hostAddress);
	}
}
