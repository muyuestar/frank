package com.frank.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class TestBufferNIO {

	@SuppressWarnings("resource")
	public void readAndWriteFile() {
		try {
			FileChannel channel = new RandomAccessFile("D:\test.txt", "rw").getChannel();
			// �ƶ��ļ�ָ�뵽ĩβ��׷��д�룩
			channel.position(channel.size());
			// ����һ���µ��ֽڻ�����
			ByteBuffer byteBuffer = ByteBuffer.allocate(20);
			// ����д��Buffer
			byteBuffer.put("��ã����磡\n".getBytes(StandardCharsets.UTF_8));
			// Buffer -> Channel
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				channel.write(byteBuffer);
			}
			channel.position(0); // �ƶ��ļ�ָ�뵽��ͷ����ͷ��ȡ��
			// �����µ��ַ�������
			CharBuffer charBuffer = CharBuffer.allocate(10);
			CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
			// ������������
			byteBuffer.clear();
			while (channel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
				byteBuffer.flip();
				// ʹ��UTF-8����������
				charBuffer.clear();
				decoder.decode(byteBuffer, charBuffer, false);
				System.out.print(charBuffer.flip().toString());
				byteBuffer.compact(); // ���ݿ�����ʣ��
			}
			channel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
