package com.frank.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author kst
 * @date 2019-06-03 17:47:22
 */
public class ImageFormatConversion {
	public static final String JPG = "jpg";
	public static final String GIF = "gif";
	public static final String PNG = "png";
	public static final String BMP = "bmp";

	public static void main(String[] args) {
		String src = "E:/WZHPT008201906030000001081_003_1_1.";
		System.out.println("��ʼ");
		new ImageFormatConversion().Conversion(JPG, PNG, src);// JPGת��PNG
		System.out.println("�ɹ�");
//		new ImageFormatConversion().Conversion(JPG, GIF, src);// JPGת��GIF
//		new ImageFormatConversion().Conversion(JPG, BMP, src);// JPGת��BMP
	}

	// inputFormat��ʾԭ��ʽ��outputFormat��ʾת����ĸ�ʽ
	public void Conversion(String inputFormat, String outputFormat, String src) {
		try {
			File input = new File(src + inputFormat);
			BufferedImage bim = ImageIO.read(input);
			File output = new File(src + outputFormat);
			ImageIO.write(bim, outputFormat, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
