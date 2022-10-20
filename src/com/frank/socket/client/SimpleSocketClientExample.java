package com.frank.socket.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SimpleSocketClientExample {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: SimpleSocketClientExample <server> <path>");
			System.exit(0);
		}
		String server = args[0]; // ip
		String path = args[1]; // ·��
		System.out.println("Loading contents of URL: " + server);
		try {
			// ������˿�Ϊ80�������������Ӧ�Ŀͻ���socket
			Socket socket = new Socket(server, 80);
			// �ӷ������˻�ȡһ��PrintStream
			PrintStream ps = new PrintStream(socket.getOutputStream());
			// ��ȡ�������˵�InputStream����һ��BufferedReader�����װ
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// ����һ��GET PATH HTTP/1.0���󵽷�������
			ps.println("GET " + path + " HTTP/1.0");
			ps.println();
			// ���еĶ�ȡ�������˵ķ��ص���Ӧ����
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				line = br.readLine();
			}
			// �ر���
			br.close();
			ps.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
