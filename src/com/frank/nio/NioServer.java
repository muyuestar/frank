package com.frank.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * ���߳�Server
 * 
 * @author kst
 *
 */
public class NioServer {

	public static void main(String[] args) {
		// ����һ��selector
		try {
			Selector selector = Selector.open();
			// ��ʼ��TCP���Ӽ���ͨ��
			ServerSocketChannel listenChannel = ServerSocketChannel.open();
			listenChannel.bind(new InetSocketAddress(9999));
			// ���óɷ�����I/Oģʽ
			listenChannel.configureBlocking(false);
			// ע�ᵽselector��������ACCEPT�¼���
			listenChannel.register(selector, SelectionKey.OP_ACCEPT); // OP_ACCEPT-1000
			// ����һ���ֽڻ�����
			ByteBuffer buffer = ByteBuffer.allocate(100);
			while (true) {
				selector.select(); // ������ֱ���м������¼�����
				Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
				// ͨ�����������η���select������Channel�¼�
				while (keyIter.hasNext()) {
					SelectionKey key = keyIter.next();
					if (key.isAcceptable()) { // �����ӿ��Խ���
						SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
						channel.configureBlocking(false);
						channel.register(selector, SelectionKey.OP_READ);
						System.out.println("�롾" + channel.getRemoteAddress() + "�����������ӣ�");
					} else if (key.isReadable()) { // �����ݿ��Զ�ȡ
						buffer.clear();
						// ��ȡ����ĩβ˵��TCP�����ѶϿ���
						// �����Ҫ�ر�ͨ������ȡ������READ�¼�
						// ���������ѭ��
						if (((SocketChannel) key.channel()).read(buffer) != -1) {
							key.channel().close();
							return;
						}
						// ���ֽڱ�������
						buffer.flip();
						// ��֪�ڵ�ǰλ�ú�����֮���Ƿ���Ԫ��
						while (buffer.hasRemaining()) {
							byte b = buffer.get();
							if (b == 0) { // �ͻ�����Ϣĩβ��\0
								System.out.println();
								// ��Ӧ�ͻ���
								buffer.clear();
								buffer.put("Hello, Client!\0".getBytes());
								buffer.flip();
								while (buffer.hasRemaining()) {
									((SocketChannel) key.channel()).write(buffer);
								}
							} else {
								System.out.print((char) b);
							}
						}
					}
					// �Ѿ�������¼�һ��Ҫ�ֶ��Ƴ�
					keyIter.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
