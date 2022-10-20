package com.frank.socket.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer extends Thread {
	// 服务器套接字
	private ServerSocket serverSocket;
	// 端口号
	private int port;
	// 服务器状态
	private boolean running = false;

	public SimpleSocketServer(int port) {
		super();
		this.port = port;
	}

	/**
	 * 启动服务器
	 */
	public void startServer() {
		try {
			serverSocket = new ServerSocket(port);
			this.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 停止服务器
	 */
	public void stopServer() {
		running = false;
		this.interrupt();
	}

	@Override
	public void run() {
		running = true;
		while (running) {
			try {
				System.out.println("Listening for a connection");
				// 调用 accept() 处理下一个连接
				Socket socket = serverSocket.accept();
				// 向 RequestHandler 线程传递socket对象进行处理
				RequestHandler requestHandler = new RequestHandler(socket);
				requestHandler.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: SimpleSocketServer <port>");
			System.exit(0);
		}
		int port = Integer.parseInt(args[0]);
		System.out.println("Start server on port: " + port);
		SimpleSocketServer server = new SimpleSocketServer(port);
		server.startServer();
		// 1分钟后自动关闭
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		server.startServer();
	}
}

class RequestHandler extends Thread {
	private Socket socket;

	public RequestHandler(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Received a connection");
			// 获取输入和输出流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			// 向客户端写出头信息
			pw.println("Echo Server 1.0");
			pw.flush();
			// 向客户端回写信息，直到客户端关闭连接或者收到空行
			String line = br.readLine();
			while (line != null && line.length() > 0) {
				pw.println("Echo: " + line);
				pw.flush();
				line = br.readLine();
			}
			// 关闭自己的连接
			pw.close();
			br.close();
			socket.close();
			System.out.println("Connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
