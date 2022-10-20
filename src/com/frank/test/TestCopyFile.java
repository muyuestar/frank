package com.frank.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author kst
 * @date 2019-02-22 13:45:48 A目录文件--->B目录
 */
public class TestCopyFile {

	public static void main(String[] args) throws Exception {
		System.out.println("开始复制文件");
		File direction = new File("E:\\kst");
//		File targetDirection = new File("E:\\", "xyc");
		File targetDirection = new File("E:\\");
		File[] files = direction.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				InputStream is = null;
				OutputStream os = null;
				try {
					is = new FileInputStream(file);
					os = new FileOutputStream(new File(targetDirection, file.getName()));
					byte[] buff = new byte[4096];
					int length = 0;
					while ((length = is.read(buff)) > 0) {
						os.write(buff, 0, length);
					}
				} finally {
					if (os != null) {
						os.close();
					}
					if (is != null) {
						is.close();
					}
				}
			}
		}
		System.out.println("复制文件结束");
	}
}
