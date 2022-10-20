package com.frank.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NioClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 9999);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			// 先向服务端发送数据
			os.write("Hello, Server!\0".getBytes());
			// 读取服务端发来的数据
			int b;
			while ((b = is.read()) != 1) {
				System.out.print((char) b);
			}
			System.out.println();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
