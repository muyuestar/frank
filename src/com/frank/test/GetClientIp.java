package com.frank.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 获取访问者IP
 * 
 * @author kst
 * @version 创建时间：2020年1月16日 下午4:59:14
 */
public class GetClientIp {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Socket socket = new ServerSocket(7777).accept();
		String hostAddress = socket.getLocalAddress().getHostAddress();
		System.out.println(hostAddress);
	}

}
