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
			// 移动文件指针到末尾（追加写入）
			channel.position(channel.size());
			// 分配一个新的字节缓冲区
			ByteBuffer byteBuffer = ByteBuffer.allocate(20);
			// 数据写入Buffer
			byteBuffer.put("你好，世界！\n".getBytes(StandardCharsets.UTF_8));
			// Buffer -> Channel
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				channel.write(byteBuffer);
			}
			channel.position(0); // 移动文件指针到开头（从头读取）
			// 分配新的字符缓冲区
			CharBuffer charBuffer = CharBuffer.allocate(10);
			CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
			// 读出所有数据
			byteBuffer.clear();
			while (channel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
				byteBuffer.flip();
				// 使用UTF-8解码器解码
				charBuffer.clear();
				decoder.decode(byteBuffer, charBuffer, false);
				System.out.print(charBuffer.flip().toString());
				byteBuffer.compact(); // 数据可能有剩余
			}
			channel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
