package com.frank.test;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.frank.util.ImageUtils;

/**
 * ͼƬ����
 * 
 * @author kst
 * @date 2019-05-18 09:32:56
 */
public class ImageOperation {

	public static void main(String[] args) throws Exception {
		// 1���ü�ͼƬ
		 System.out.println("��ʼͼƬ�ü�");
		 String originalImagePath = "E:\\1.jpg";
		 String clipImagePath = "E:\\2.jpg";
		 int[] array = ImageUtils.getImageWidthAndLength(originalImagePath);
		 System.out.println(Arrays.toString(array));
		 ImageUtils.clipImage(originalImagePath, clipImagePath, 0, 257,
		 array[0], array[1] - 1);
		 System.out.println("ͼƬ�ü��ɹ�");

		// 2���޸�ͼƬrgbֵ
		// System.out.println("��ʼ�޸��޸�ͼƬrgbֵ");
		// int x = 0;
		// ImageOperation rc = new ImageOperation();
		// x = rc.getScreenPixel(100, 345);
		// System.out.println(x + " - ");
		// rc.getImagePixel("E:\\3.jpg");
		// System.out.println("�޸�ͼƬrgbֵ����");

		// 3���޸�ͼƬrgbֵ
//		System.out.println("�޸�ͼƬrgbֵ��ʼ");
//		ImageOperation rc = new ImageOperation();
//		rc.setAlpha("E:\\test.jpg");
//		System.out.println("�޸�ͼƬrgbֵ����");
	}

	/**
	 * ��ȡһ��ͼƬ��RGBֵ
	 * 
	 * @throws Exception
	 */
	public void getImagePixel(String image) throws Exception {
		int[] rgb = new int[3];
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		System.out.println("width=" + width + ",height=" + height + ".");
		System.out.println("minx=" + minx + ",miniy=" + miny + ".");
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				int pixel = bi.getRGB(i, j); // �������д��뽫һ������ת��ΪRGB����
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")");
				bi.setRGB(123, 123, 123);
			}
		}
	}

	/**
	 * ������Ļɫ��ֵ
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @throws AWTException
	 */
	public int getScreenPixel(int x, int y) throws AWTException { // ��������ֵΪ��ɫ��RGBֵ��
		Robot rb = null; // java.awt.image���е��࣬��������ץȡ��Ļ����������
		rb = new Robot();
		Toolkit tk = Toolkit.getDefaultToolkit(); // ��ȡȱʡ���߰�
		Dimension di = tk.getScreenSize(); // ��Ļ�ߴ���
		System.out.println(di.width);
		System.out.println(di.height);
		Rectangle rec = new Rectangle(0, 0, di.width, di.height);
		BufferedImage bi = rb.createScreenCapture(rec);
		int pixelColor = bi.getRGB(x, y);
		return 16777216 + pixelColor; // pixelColor��ֵΪ��������ʵ���ó���������ɫ���ֵ����ʵ����ɫֵ��
	}

	private void setAlpha(String os) {
		/**
		 * ���Ӳ����� ��ȡͼƬ�����Ƴɰ�͸��,�޸�����
		 */
		try {
			ImageIcon imageIcon = new ImageIcon(os);
			BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(),
					BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
			g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());
			// ѭ��ÿһ�����ص㣬�ı����ص��Alphaֵ
			int alpha = 100;
			for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {
				for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {
					int pixel = bufferedImage.getRGB(j2, j1);
					int[] rgb = new int[3];
//					rgb[0] = (pixel & 0xffffff) >> 16;
//					rgb[1] = (pixel & 0xffffff) >> 8;
//					rgb[2] = (pixel & 0xffffff);
//					rgb[0] = (pixel & 0xff0000) >> 16;
//					rgb[1] = (pixel & 0xff00) >> 8;
//					rgb[2] = (pixel & 0xff);
//					System.out.println("i=" + j1 + ",j=" + j2 + ":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")");

//					pixel = ((alpha + 1) << 24) | (pixel & 0x00ffffff);
					pixel = ((alpha + 1) << 10) | (pixel & 0x00ffffff);
					bufferedImage.setRGB(j2, j1, pixel);
				}
			}
			g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());

			// ����ͼƬΪPNG
			ImageIO.write(bufferedImage, "jpg", new File("E:\\demo.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
