package com.frank.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java使用内存映射实现大文件的上传
 * 
 * @author kst
 *
 */
public class TestMappedByteBuffer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 第一种
		try {
			FileInputStream fis = new FileInputStream("C:\\address.txt");
			int sum = 0;
			int n;
			long t1 = System.currentTimeMillis();
			try {
				while ((n = fis.read()) >= 0) {
					sum += n;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			long t = System.currentTimeMillis() - t1;
			System.out.println("sum:" + sum + "  time:" + t);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 第二种
		try {
			FileInputStream fis = new FileInputStream("C:\\address.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int sum = 0;
			int n;
			long t1 = System.currentTimeMillis();
			try {
				while ((n = bis.read()) >= 0) {
					sum += n;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			long t = System.currentTimeMillis() - t1;
			System.out.println("sum:" + sum + "  time:" + t);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 第三种最快
		MappedByteBuffer buffer = null;
		try {
			buffer = new RandomAccessFile("C:\\address.txt", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0,
					1253244); // 字节长度待定
			int sum = 0;
			int n;
			long t1 = System.currentTimeMillis();
			for (int i = 0; i < 1253244; i++) {
				n = 0x000000ff & buffer.get(i);
				sum += n;
			}
			long t = System.currentTimeMillis() - t1;
			System.out.println("sum:" + sum + "  time:" + t);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
