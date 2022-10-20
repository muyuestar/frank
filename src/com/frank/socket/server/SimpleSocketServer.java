package com.frank.socket.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer extends Thread {
	// �������׽���
	private ServerSocket serverSocket;
	// �˿ں�
	private int port;
	// ������״̬
	private boolean running = false;

	public SimpleSocketServer(int port) {
		super();
		this.port = port;
	}

	/**
	 * ����������
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
	 * ֹͣ������
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
				// ���� accept() ������һ������
				Socket socket = serverSocket.accept();
				// �� RequestHandler �̴߳���socket������д���
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
		// 1���Ӻ��Զ��ر�
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
			// ��ȡ����������
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			// ��ͻ���д��ͷ��Ϣ
			pw.println("Echo Server 1.0");
			pw.flush();
			// ��ͻ��˻�д��Ϣ��ֱ���ͻ��˹ر����ӻ����յ�����
			String line = br.readLine();
			while (line != null && line.length() > 0) {
				pw.println("Echo: " + line);
				pw.flush();
				line = br.readLine();
			}
			// �ر��Լ�������
			pw.close();
			br.close();
			socket.close();
			System.out.println("Connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
