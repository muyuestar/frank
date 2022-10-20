package com.frank.simpleimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.simpleimage.ImageFormat;
import com.alibaba.simpleimage.ImageWrapper;
import com.alibaba.simpleimage.SimpleImageException;
import com.alibaba.simpleimage.render.CropParameter;
import com.alibaba.simpleimage.render.ScaleParameter;
import com.alibaba.simpleimage.render.WatermarkParameter;
import com.alibaba.simpleimage.render.WriteParameter;
import com.alibaba.simpleimage.render.ScaleParameter.Algorithm;
import com.alibaba.simpleimage.util.ImageCropHelper;
import com.alibaba.simpleimage.util.ImageDrawHelper;
import com.alibaba.simpleimage.util.ImageReadHelper;
import com.alibaba.simpleimage.util.ImageScaleHelper;
import com.alibaba.simpleimage.util.ImageWriteHelper;

/**
 * ����Ͱ� simpleimage ͼƬ�������� ���� �ȱ������� ���� ��ˮӡ ���ϲ���
 * 
 * @author kst
 * @date 2020��1��6�� ����3:05:06
 * 
 */
public class ImageUtils {
	public static String WATER_IMAGE_URL = "E:/image/simpleimage/watermark.png";
	protected static ImageFormat outputFormat = ImageFormat.JPEG;
	// public static String WATER_IMAGE_URL = RamConstants.getWebRootPath() +
	// "/images/watermark.png";// ˮӡͼƬ·��

	public static void main(String[] args) {
		System.out.println("��ʼִ��");
		// 1.�ȱ�������
		scaleNormal("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/scaleNormal.jpg", 400, 600);
		// 2.�ȱ������ż�ˮӡ
//		scaleWithWaterMark("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/scaleWithWaterMark.jpg", 400, 600);
		// 3.���ŵ�ָ�����
//		scaleWithWidth("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/scaleWithWidth.jpg", 400);
		// 4.���ŵ�ָ���߶�
//		scaleWithHeight("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/scaleWithHeight.jpg", 600);
		// 5.���г�������
//		Cut("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/cut.jpg");
		// 6.���м����
//		CutCenter("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/cutCenter.jpg", 400, 600);
		System.out.println("ִ�н���");
	}

	/**
	 * 
	 * @param pInput
	 * @param pImgeFlag
	 * @return
	 * @throws Exception
	 */
	public static boolean isPicture(String pInput, String pImgeFlag) throws Exception {
		if (StringUtils.isBlank(pInput)) {
			return false;
		}
		String tmpName = pInput.substring(pInput.lastIndexOf(".") + 1, pInput.length());
		String imgeArray[][] = { { "bmp", "0" }, { "dib", "1" }, { "gif", "2" }, { "jfif", "3" }, { "jpe", "4" },
				{ "jpeg", "5" }, { "jpg", "6" }, { "png", "7" }, { "tif", "8" }, { "tiff", "9" }, { "ico", "10" } };
		for (int i = 0; i < imgeArray.length; i++) {
			if (!StringUtils.isBlank(pImgeFlag) && imgeArray[i][0].equals(tmpName.toLowerCase())
					&& imgeArray[i][1].equals(pImgeFlag)) {
				return true;
			}
			if (StringUtils.isBlank(pImgeFlag) && imgeArray[i][0].equals(tmpName.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �ȱ������� ����в�������
	 * 
	 * @param src
	 *            ԭͼƬ·��
	 * @param target
	 *            Ŀ��ͼƬ·��
	 * @param width
	 *            Ŀ���
	 * @param height
	 *            Ŀ���
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public final static void scaleNormal(String src, String target, int width, int height) {
		File out = new File(target); // Ŀ��ͼƬ
		FileOutputStream outStream = null;
		File in = new File(src); // ԭͼƬ
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();
			// 1.����
			ScaleParameter scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS); // ���Ų���
			CropParameter cropParam = new CropParameter(0, 0, width, height);// ���в���
			float srcRatio = (float) w / h;
			float dstRatio = (float) width / height; // Դ��߱Ⱥ�Ŀ���߱�
			if (w < width && h < height) {// ���ͼƬ��͸߶�С��Ŀ��ͼƬ�������Ŵ���
				scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS);
				cropParam = new CropParameter(0, 0, w, h);
			} else if (srcRatio >= dstRatio) { // Դ��߱�>= Ŀ���߱�
				int newWidth = getWidth(w, h, height);
				scaleParam = new ScaleParameter(newWidth + 1, height, Algorithm.LANCZOS);
				cropParam = new CropParameter((newWidth - width) / 2, 0, width, height);
			} else if (srcRatio < dstRatio) { // Դ��߱� < Ŀ���߱�
				int newHeight = getHeight(w, h, width);
				scaleParam = new ScaleParameter(width, newHeight + 1, Algorithm.LANCZOS);
				cropParam = new CropParameter(0, (newHeight - height) / 2, width, height);
			}
			PlanarImage planrImage = ImageScaleHelper.scale(imageWrapper.getAsPlanarImage(), scaleParam);
			// 2.����
			imageWrapper = new ImageWrapper(planrImage);
			planrImage = ImageCropHelper.crop(planrImage, cropParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.���
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // ͼƬ�ļ��������������ǵùر�
			IOUtils.closeQuietly(outStream);
		}
	}

	/**
	 * ѹ��ͼƬ�� ָ���ߴ�,ͼƬ��Ŀ��ͼƬС�򲻻����(��ˮӡ��
	 * 
	 * @param src
	 * @param target
	 * @param width
	 * @param height
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public final static void scaleWithWaterMark(String src, String target, int width, int height) {
		File out = new File(target); // Ŀ��ͼƬ
		FileOutputStream outStream = null;
		File in = new File(src); // ԭͼƬ
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();
			// 1.����
			ScaleParameter scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS); // ���Ų���
			CropParameter cropParam = new CropParameter(0, 0, width, height);// ���в���
			float srcRatio = (float) w / h;
			float dstRatio = (float) width / height;// Դ��߱Ⱥ�Ŀ���߱�
			if (w < width && h < height) {// ���ͼƬ��͸߶�С��Ŀ��ͼƬ�������Ŵ���
				scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS);
				cropParam = new CropParameter(0, 0, w, h);
			} else if (srcRatio >= dstRatio) {
				int newWidth = getWidth(w, h, height);
				scaleParam = new ScaleParameter(newWidth + 1, height, Algorithm.LANCZOS);
				cropParam = new CropParameter((newWidth - width) / 2, 0, width, height);

			} else if (srcRatio < dstRatio) {
				int newHeight = getHeight(w, h, width);
				scaleParam = new ScaleParameter(width, newHeight + 1, Algorithm.LANCZOS);
				cropParam = new CropParameter(0, (newHeight - height) / 2, width, height);
			}
			PlanarImage planrImage = ImageScaleHelper.scale(imageWrapper.getAsPlanarImage(), scaleParam);
			// 2.����
			imageWrapper = new ImageWrapper(planrImage);
			planrImage = ImageCropHelper.crop(planrImage, cropParam);
			// 3.��ˮӡ
			BufferedImage waterImage = ImageIO.read(new File(WATER_IMAGE_URL));
			ImageWrapper waterWrapper = new ImageWrapper(waterImage);
			WatermarkParameter param = new WatermarkParameter(waterWrapper, 1, 0, 0);
			imageWrapper = new ImageWrapper(planrImage);
			BufferedImage bufferedImage = ImageDrawHelper.drawWatermark(imageWrapper.getAsBufferedImage(), param);
			imageWrapper = new ImageWrapper(bufferedImage);
			// 4.���
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // ͼƬ�ļ��������������ǵùر�
			IOUtils.closeQuietly(outStream);
		}

	}

	/**
	 * ���ŵ�ָ����� �߶�����Ӧ
	 * 
	 * @param src
	 * @param target
	 * @param width
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public final static void scaleWithWidth(String src, String target, Integer width) {
		File out = new File(target); // Ŀ��ͼƬ
		FileOutputStream outStream = null;
		File in = new File(src); // ԭͼƬ
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();
			// 1.����
			ScaleParameter scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS); // ���Ų���
			if (w < width) {// ���ͼƬ��͸߶�С��Ŀ��ͼƬ�������Ŵ���
				scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS);
			} else {
				int newHeight = getHeight(w, h, width);
				scaleParam = new ScaleParameter(width, newHeight + 1, Algorithm.LANCZOS);
			}
			PlanarImage planrImage = ImageScaleHelper.scale(imageWrapper.getAsPlanarImage(), scaleParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.���
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // ͼƬ�ļ��������������ǵùر�
			IOUtils.closeQuietly(outStream);
		}
	}

	/**
	 * ���ŵ�ָ���߶ȣ��������Ӧ
	 * 
	 * @param src
	 * @param target
	 * @param height
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public final static void scaleWithHeight(String src, String target, Integer height) {
		File out = new File(target); // Ŀ��ͼƬ
		FileOutputStream outStream = null;
		File in = new File(src); // ԭͼƬ
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();
			// 1.����
			ScaleParameter scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS); // ���Ų���
			if (w < height) {// ���ͼƬ��͸߶�С��Ŀ��ͼƬ�������Ŵ���
				scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS);

			} else {
				int newWidth = getWidth(w, h, height);
				scaleParam = new ScaleParameter(newWidth + 1, height, Algorithm.LANCZOS);

			}
			PlanarImage planrImage = ImageScaleHelper.scale(imageWrapper.getAsPlanarImage(), scaleParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.���
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // ͼƬ�ļ��������������ǵùر�
			IOUtils.closeQuietly(outStream);
		}
	}

	/**
	 * ���ݿ��ߺ�Ŀ���� �ȱ�����߶�
	 * 
	 * @param w
	 * @param h
	 * @param width
	 * @return
	 */
	public static Integer getHeight(Integer w, Integer h, Integer width) {

		return h * width / w;
	}

	/**
	 * ���ݿ��ߺ�Ŀ��߶� �ȱ�������
	 * 
	 * @param w
	 * @param h
	 * @param height
	 * @return
	 */
	public static Integer getWidth(Integer w, Integer h, Integer height) {
		return w * height / h;
	}

	/**
	 * ���м������Ҫ�Ĵ�С
	 * 
	 * @param src
	 * @param target
	 * @param width
	 * @param height
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public final static void CutCenter(String src, String target, Integer width, Integer height) {
		File out = new File(target); // Ŀ��ͼƬ
		FileOutputStream outStream = null;
		File in = new File(src); // ԭͼƬ
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();

			int x = (w - width) / 2;

			int y = (h - height) / 2;

			CropParameter cropParam = new CropParameter(x, y, width, height);// ���в���
			if (x < 0 || y < 0) {
				cropParam = new CropParameter(0, 0, w, h);// ���в���

			}

			PlanarImage planrImage = ImageCropHelper.crop(imageWrapper.getAsPlanarImage(), cropParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.���
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // ͼƬ�ļ��������������ǵùر�
			IOUtils.closeQuietly(outStream);
		}
	}

	/**
	 * ���� Ϊ������
	 * 
	 * @param src
	 * @param target
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public final static void Cut(String src, String target) {
		File out = new File(target); // Ŀ��ͼƬ
		FileOutputStream outStream = null;
		File in = new File(src); // ԭͼƬ
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();
			int width = 0;
			int height = 0;

			if (w >= h) {
				width = h;
				height = h;
			} else {
				width = w;
				height = w;
			}
			CropParameter cropParam = new CropParameter(0, 0, width, height);// ���в���
			PlanarImage planrImage = ImageCropHelper.crop(imageWrapper.getAsPlanarImage(), cropParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.���
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // ͼƬ�ļ��������������ǵùر�
			IOUtils.closeQuietly(outStream);
		}
	}
}
