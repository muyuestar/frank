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
 * 图片操作
 * 
 * @author kst
 * @date 2019-05-18 09:32:56
 */
public class ImageOperation {

	public static void main(String[] args) throws Exception {
		// 1、裁剪图片
		 System.out.println("开始图片裁剪");
		 String originalImagePath = "E:\\1.jpg";
		 String clipImagePath = "E:\\2.jpg";
		 int[] array = ImageUtils.getImageWidthAndLength(originalImagePath);
		 System.out.println(Arrays.toString(array));
		 ImageUtils.clipImage(originalImagePath, clipImagePath, 0, 257,
		 array[0], array[1] - 1);
		 System.out.println("图片裁剪成功");

		// 2、修改图片rgb值
		// System.out.println("开始修改修改图片rgb值");
		// int x = 0;
		// ImageOperation rc = new ImageOperation();
		// x = rc.getScreenPixel(100, 345);
		// System.out.println(x + " - ");
		// rc.getImagePixel("E:\\3.jpg");
		// System.out.println("修改图片rgb值结束");

		// 3、修改图片rgb值
//		System.out.println("修改图片rgb值开始");
//		ImageOperation rc = new ImageOperation();
//		rc.setAlpha("E:\\test.jpg");
//		System.out.println("修改图片rgb值结束");
	}

	/**
	 * 读取一张图片的RGB值
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
				int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")");
				bi.setRGB(123, 123, 123);
			}
		}
	}

	/**
	 * 返回屏幕色彩值
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @throws AWTException
	 */
	public int getScreenPixel(int x, int y) throws AWTException { // 函数返回值为颜色的RGB值。
		Robot rb = null; // java.awt.image包中的类，可以用来抓取屏幕，即截屏。
		rb = new Robot();
		Toolkit tk = Toolkit.getDefaultToolkit(); // 获取缺省工具包
		Dimension di = tk.getScreenSize(); // 屏幕尺寸规格
		System.out.println(di.width);
		System.out.println(di.height);
		Rectangle rec = new Rectangle(0, 0, di.width, di.height);
		BufferedImage bi = rb.createScreenCapture(rec);
		int pixelColor = bi.getRGB(x, y);
		return 16777216 + pixelColor; // pixelColor的值为负，经过实践得出：加上颜色最大值就是实际颜色值。
	}

	private void setAlpha(String os) {
		/**
		 * 增加测试项 读取图片，绘制成半透明,修改像素
		 */
		try {
			ImageIcon imageIcon = new ImageIcon(os);
			BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(),
					BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
			g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());
			// 循环每一个像素点，改变像素点的Alpha值
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

			// 生成图片为PNG
			ImageIO.write(bufferedImage, "jpg", new File("E:\\demo.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
