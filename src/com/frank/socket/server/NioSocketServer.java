package com.frank.socket.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NioSocketServer {

	public NioSocketServer() {
		try {
			// ����һ�� AsynchronousServerSocketChannel ���� 5000 �˿�
			final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open()
					.bind(new InetSocketAddress(5000));
			listener.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

				@Override
				public void completed(AsynchronousSocketChannel ch, Void att) {
					// ������һ������
					listener.accept(null, this);
					// ��ͻ��˷����ʺ���Ϣ
					ch.write(ByteBuffer
							.wrap("Hello, I am Echo Server 2020, let's have an engaging conversation!n".getBytes()));
					// ����(4K)�ֽڻ������ڴӿͻ��˶�ȡ��Ϣ
					ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
					try {
						// Read the first line
						int bytesRead = ch.read(byteBuffer).get(20, TimeUnit.SECONDS);
						boolean running = true;
						while (bytesRead != -1 && running) {
							System.out.println("bytes read: " + bytesRead);
							// ȷ���ж�ȡ������
							if (byteBuffer.position() > 2) {
								// ׼��������ж�ȡ
								byteBuffer.flip();
								// �ѻ���ת�����ַ���
								byte[] lineBytes = new byte[bytesRead];
								byteBuffer.get(lineBytes, 0, bytesRead);
								String line = new String(lineBytes);
								System.out.println("Message: " + line);
								// ������߻�д
								ch.write(ByteBuffer.wrap(line.getBytes()));
								// ׼���������д����
								byteBuffer.clear();
								// ��ȡ��һ��
								bytesRead = ch.read(byteBuffer).get(20, TimeUnit.SECONDS);
							} else {
								// �����ǵ�Э���У����б�ʾ�Ự����
								running = false;
							}
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					} catch (TimeoutException e) {
						// �û��ﵽ20�볬ʱ���ر�����
						ch.write(ByteBuffer.wrap("Good Byen".getBytes()));
						System.out.println("Connection timed out, closing connection");
					}
					System.out.println("End of conversation");
					try {
						// �����Ҫ���ر�����
						if (ch.isOpen()) {
							ch.close();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				@Override
				public void failed(Throwable exc, Void att) {
					// ...
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		NioSocketServer server = new NioSocketServer();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
