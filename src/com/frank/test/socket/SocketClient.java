package com.frank.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

	public static void main(String[] args) {
		try {
			/** ����Socket */
			// ����һ�����׽��ֲ��������ӵ�ָ�� IP ��ַ��ָ���˿ں�(�����Ǳ���)
			Socket socket = new Socket("127.0.0.1", 2013);
			// 60s��ʱ
			socket.setSoTimeout(125000);
			
			/** ���Ϳͻ���׼���������Ϣ */
			// ��Socket����õ��������������PrintWriter����
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			// �����������ַ��������Server
			BufferedReader sysBuff = new BufferedReader(new InputStreamReader(System.in));
			printWriter.println(sysBuff.readLine());
			// ˢ���������ʹServer�����յ����ַ���
			printWriter.flush();
			
			/** ���ڻ�ȡ����˴���������Ϣ */
			// ��Socket����õ�����������������Ӧ��BufferedReader����
			Thread.sleep(130000);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// �������һ�ַ���
			String result = bufferedReader.readLine();
			System.out.println("Server say : " + result);
			/** �ر�Socket */
			printWriter.close();
			bufferedReader.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
	}
}
