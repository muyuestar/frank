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
 * 阿里巴巴 simpleimage 图片处理工具类 功能 等比例缩放 裁切 加水印 复合操作
 * 
 * @author kst
 * @date 2020年1月6日 下午3:05:06
 * 
 */
public class ImageUtils {
	public static String WATER_IMAGE_URL = "E:/image/simpleimage/watermark.png";
	protected static ImageFormat outputFormat = ImageFormat.JPEG;
	// public static String WATER_IMAGE_URL = RamConstants.getWebRootPath() +
	// "/images/watermark.png";// 水印图片路径

	public static void main(String[] args) {
		System.out.println("开始执行");
		// 1.等比例缩放
		scaleNormal("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/scaleNormal.jpg", 400, 600);
		// 2.等比例缩放加水印
//		scaleWithWaterMark("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/scaleWithWaterMark.jpg", 400, 600);
		// 3.缩放到指定宽度
//		scaleWithWidth("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/scaleWithWidth.jpg", 400);
		// 4.缩放到指定高度
//		scaleWithHeight("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/scaleWithHeight.jpg", 600);
		// 5.裁切成正方形
//		Cut("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/cut.jpg");
		// 6.从中间裁切
//		CutCenter("E:/image/simpleimage/src.jpg", "E:/image/simpleimage/cutCenter.jpg", 400, 600);
		System.out.println("执行结束");
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
	 * 等比例缩放 会裁切部分内容
	 * 
	 * @param src
	 *            原图片路径
	 * @param target
	 *            目标图片路径
	 * @param width
	 *            目标宽
	 * @param height
	 *            目标高
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public final static void scaleNormal(String src, String target, int width, int height) {
		File out = new File(target); // 目的图片
		FileOutputStream outStream = null;
		File in = new File(src); // 原图片
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();
			// 1.缩放
			ScaleParameter scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS); // 缩放参数
			CropParameter cropParam = new CropParameter(0, 0, width, height);// 裁切参数
			float srcRatio = (float) w / h;
			float dstRatio = (float) width / height; // 源宽高比和目标宽高比
			if (w < width && h < height) {// 如果图片宽和高都小于目标图片则不做缩放处理
				scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS);
				cropParam = new CropParameter(0, 0, w, h);
			} else if (srcRatio >= dstRatio) { // 源宽高比>= 目标宽高比
				int newWidth = getWidth(w, h, height);
				scaleParam = new ScaleParameter(newWidth + 1, height, Algorithm.LANCZOS);
				cropParam = new CropParameter((newWidth - width) / 2, 0, width, height);
			} else if (srcRatio < dstRatio) { // 源宽高比 < 目标宽高比
				int newHeight = getHeight(w, h, width);
				scaleParam = new ScaleParameter(width, newHeight + 1, Algorithm.LANCZOS);
				cropParam = new CropParameter(0, (newHeight - height) / 2, width, height);
			}
			PlanarImage planrImage = ImageScaleHelper.scale(imageWrapper.getAsPlanarImage(), scaleParam);
			// 2.裁切
			imageWrapper = new ImageWrapper(planrImage);
			planrImage = ImageCropHelper.crop(planrImage, cropParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.输出
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // 图片文件输入输出流必须记得关闭
			IOUtils.closeQuietly(outStream);
		}
	}

	/**
	 * 压缩图片到 指定尺寸,图片比目标图片小则不会变形(有水印）
	 * 
	 * @param src
	 * @param target
	 * @param width
	 * @param height
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public final static void scaleWithWaterMark(String src, String target, int width, int height) {
		File out = new File(target); // 目的图片
		FileOutputStream outStream = null;
		File in = new File(src); // 原图片
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();
			// 1.缩放
			ScaleParameter scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS); // 缩放参数
			CropParameter cropParam = new CropParameter(0, 0, width, height);// 裁切参数
			float srcRatio = (float) w / h;
			float dstRatio = (float) width / height;// 源宽高比和目标宽高比
			if (w < width && h < height) {// 如果图片宽和高都小于目标图片则不做缩放处理
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
			// 2.裁切
			imageWrapper = new ImageWrapper(planrImage);
			planrImage = ImageCropHelper.crop(planrImage, cropParam);
			// 3.打水印
			BufferedImage waterImage = ImageIO.read(new File(WATER_IMAGE_URL));
			ImageWrapper waterWrapper = new ImageWrapper(waterImage);
			WatermarkParameter param = new WatermarkParameter(waterWrapper, 1, 0, 0);
			imageWrapper = new ImageWrapper(planrImage);
			BufferedImage bufferedImage = ImageDrawHelper.drawWatermark(imageWrapper.getAsBufferedImage(), param);
			imageWrapper = new ImageWrapper(bufferedImage);
			// 4.输出
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // 图片文件输入输出流必须记得关闭
			IOUtils.closeQuietly(outStream);
		}

	}

	/**
	 * 缩放到指定宽度 高度自适应
	 * 
	 * @param src
	 * @param target
	 * @param width
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public final static void scaleWithWidth(String src, String target, Integer width) {
		File out = new File(target); // 目的图片
		FileOutputStream outStream = null;
		File in = new File(src); // 原图片
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();
			// 1.缩放
			ScaleParameter scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS); // 缩放参数
			if (w < width) {// 如果图片宽和高都小于目标图片则不做缩放处理
				scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS);
			} else {
				int newHeight = getHeight(w, h, width);
				scaleParam = new ScaleParameter(width, newHeight + 1, Algorithm.LANCZOS);
			}
			PlanarImage planrImage = ImageScaleHelper.scale(imageWrapper.getAsPlanarImage(), scaleParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.输出
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // 图片文件输入输出流必须记得关闭
			IOUtils.closeQuietly(outStream);
		}
	}

	/**
	 * 缩放到指定高度，宽度自适应
	 * 
	 * @param src
	 * @param target
	 * @param height
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public final static void scaleWithHeight(String src, String target, Integer height) {
		File out = new File(target); // 目的图片
		FileOutputStream outStream = null;
		File in = new File(src); // 原图片
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();
			// 1.缩放
			ScaleParameter scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS); // 缩放参数
			if (w < height) {// 如果图片宽和高都小于目标图片则不做缩放处理
				scaleParam = new ScaleParameter(w, h, Algorithm.LANCZOS);

			} else {
				int newWidth = getWidth(w, h, height);
				scaleParam = new ScaleParameter(newWidth + 1, height, Algorithm.LANCZOS);

			}
			PlanarImage planrImage = ImageScaleHelper.scale(imageWrapper.getAsPlanarImage(), scaleParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.输出
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // 图片文件输入输出流必须记得关闭
			IOUtils.closeQuietly(outStream);
		}
	}

	/**
	 * 根据宽、高和目标宽度 等比例求高度
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
	 * 根据宽、高和目标高度 等比例求宽度
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
	 * 从中间裁切需要的大小
	 * 
	 * @param src
	 * @param target
	 * @param width
	 * @param height
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public final static void CutCenter(String src, String target, Integer width, Integer height) {
		File out = new File(target); // 目的图片
		FileOutputStream outStream = null;
		File in = new File(src); // 原图片
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(in);
			ImageWrapper imageWrapper = ImageReadHelper.read(inStream);

			int w = imageWrapper.getWidth();
			int h = imageWrapper.getHeight();

			int x = (w - width) / 2;

			int y = (h - height) / 2;

			CropParameter cropParam = new CropParameter(x, y, width, height);// 裁切参数
			if (x < 0 || y < 0) {
				cropParam = new CropParameter(0, 0, w, h);// 裁切参数

			}

			PlanarImage planrImage = ImageCropHelper.crop(imageWrapper.getAsPlanarImage(), cropParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.输出
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // 图片文件输入输出流必须记得关闭
			IOUtils.closeQuietly(outStream);
		}
	}

	/**
	 * 裁切 为正文形
	 * 
	 * @param src
	 * @param target
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public final static void Cut(String src, String target) {
		File out = new File(target); // 目的图片
		FileOutputStream outStream = null;
		File in = new File(src); // 原图片
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
			CropParameter cropParam = new CropParameter(0, 0, width, height);// 裁切参数
			PlanarImage planrImage = ImageCropHelper.crop(imageWrapper.getAsPlanarImage(), cropParam);
			imageWrapper = new ImageWrapper(planrImage);
			// 4.输出
			outStream = new FileOutputStream(out);
			String prefix = out.getName().substring(out.getName().lastIndexOf(".") + 1);
			ImageWriteHelper.write(imageWrapper, outStream, outputFormat.getImageFormat(prefix), new WriteParameter());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SimpleImageException e) {
		} finally {
			IOUtils.closeQuietly(inStream); // 图片文件输入输出流必须记得关闭
			IOUtils.closeQuietly(outStream);
		}
	}
}
