package com.frank.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��ȡ������IP
 * 
 * @author kst
 * @version ����ʱ�䣺2020��1��16�� ����4:59:14
 */
public class GetClientIp {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Socket socket = new ServerSocket(7777).accept();
		String hostAddress = socket.getLocalAddress().getHostAddress();
		System.out.println(hostAddress);
	}

}
