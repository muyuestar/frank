package com.frank.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64Utils {
	/**
	 * 字符串转换成base64字符串
	 *
	 * @param bstr
	 *            byte数组
	 * @return base64字符串
	 */
	public static String encode(byte[] bstr) {
		return new BASE64Encoder().encode(bstr);
	}

	/**
	 * base64字符串转换成byte数组
	 *
	 * @param str
	 *            字符串
	 * @return byte数组
	 * @throws IOException
	 */
	public static byte[] decode(String str) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(str);
	}

	/**
	 * base64字符串转化成图片
	 *
	 * @param base64Str
	 *            base64字符串
	 * @param imageFilePath
	 *            图片路径
	 * @return true:生成成功，false:生成失败
	 */
	public static boolean base64StrToImg(String base64Str, String imageFilePath) {
		BASE64Decoder decoder = new BASE64Decoder();
		OutputStream out = null;
		try {
			byte[] b = decoder.decodeBuffer(base64Str);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			out = new FileOutputStream(imageFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (IOException e) {
			return false;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					return false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String base64Str = "data:image/jpeg;base64,Z9i6rOgEY8if6VwYBrm0yl21VMGBWT6j9LAFc23w/YEWzC3GjigFElHVYNbIl5oEk7taTw9XME1ZDOU5qAUI/D24ku2w8VBDSyMZ4ei5rWnB4pPckZtiUdq4m3Mg8miYkzcGTOle6uiztEngGGTjMUoG+4G3QXNhGJp4pTYnvE2FLsWqJNMwA7Lbu0Z8Iy6wJw/u+7vjhNmOCr8JF0hF20xkhZDQiO+y5WHUYnwjLrAnD+77u+OE2Y4KvwkXSEXbTGSFkNCI77LlYdRifCMusCcP7vu744TZjgq/CRdIRdtMZIWQ0IjvsuVh1GJ8Iy6wJw/u+7vjhNmOCr8JF0hFFw==";
		String imageFilePath = "C:/kang/image/finger.jpg";
		System.out.println(base64StrToImg(base64Str, imageFilePath));
	}
}