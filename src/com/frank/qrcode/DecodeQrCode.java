package com.frank.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;

/**
 * ������ά��
 * 
 * @author kst
 * @date 2019-05-24 15:59:56
 */
public class DecodeQrCode {

	private static String decode(String qrcodePicfilePath) {
		System.out.println("��ʼ������ά�룡��");
		/* ��ȡ��ά��ͼ������ */
		File imageFile = new File(qrcodePicfilePath);
		BufferedImage image = null;
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("��ȡ��ά��ͼƬʧ�ܣ� " + e.getMessage());
			return null;
		}
		/* ������ά�� */
		QRCodeDecoder decoder = new QRCodeDecoder();
		String decodedData = new String(decoder.decode(new J2SEImageGucas(image)));
		System.out.println("�����������£�" + decodedData);
		return decodedData;
	}

	public static void main(String[] args) {
		DecodeQrCode.decode("C:/kang/image/hutool/wx.png");
	}

}

class J2SEImageGucas implements QRCodeImage {
	BufferedImage image;

	public J2SEImageGucas(BufferedImage image) {
		this.image = image;
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}

	public int getPixel(int x, int y) {
		return image.getRGB(x, y);
	}
}
