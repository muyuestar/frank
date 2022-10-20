package com.frank.util;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 图片操作类
 * 
 * @author kst
 * @date 2019-05-18 09:29:00
 */
public class ImageUtils {

	/**
	 * 获取图片宽和高
	 * 
	 * @param imagePath 图片路径
	 * @return 图片宽度高度数组
	 * @throws IOException
	 * @author kst,20210909
	 */
	public static int[] getImageWidthAndLength(String imagePath) throws IOException {
		File file = new File(imagePath);
		BufferedImage image = ImageIO.read(file);
		return new int[] { image.getWidth(), image.getHeight() };
	}

	/**
	 * 图片修剪
	 * 
	 * @param originalImagePath 原图片路径
	 * @param clipImagePath     修剪后图片路径
	 * @param imageType         图片类型
	 * @param x                 图片修剪初始x坐标
	 * @param y                 图片修剪初始y坐标
	 * @param width             图片宽度
	 * @param height            图片高度
	 * @return false:修剪失败,true:修剪成功
	 * @throws IOException
	 * @author kst,20210909
	 */
	public static boolean clipImage(String originalImagePath, String clipImagePath, int x, int y, int width, int height)
			throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		boolean flag = false;
		try {
			String imageType = clipImagePath.substring(clipImagePath.indexOf(".") + 1);
			is = new FileInputStream(originalImagePath);
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(imageType);
			ImageReader reader = it.next();
			iis = ImageIO.createImageInputStream(is);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			// 实际高度大于目标高度或者实际宽度大于目标宽度则进行剪切
			File file = new File(originalImagePath);
			BufferedImage bii = ImageIO.read(file);
			int itempWidth = bii.getWidth(); // 实际宽度
			int itempHeight = bii.getHeight(); // 实际高度
			if ((itempHeight > height) || (itempWidth > width)) {
				ImageIO.write(bi, imageType, new File(clipImagePath));
				flag = true;
			}
		} finally {
			if (iis != null) {
				iis.close();
			}
			if (is != null) {
				is.close();
			}
		}
		return flag;
	}

	/**
	 * 图片按比例缩放
	 * 
	 * @param originalImagePath 原图片路径
	 * @param zoomImagePath     缩放图片路径
	 * @param zoomWidth         缩放宽度
	 * @param zoomHeight        缩放高度
	 * @return true:成功,false:失败
	 * @throws IOException
	 * @author kst,20210909
	 */
	public static boolean zoomImage(String originalImagePath, String zoomImagePath, int zoomWidth, int zoomHeight)
			throws IOException {
		BufferedImage bi = ImageIO.read(new File(originalImagePath));
		double zw = zoomWidth * 1.0 / bi.getWidth();
		double zh = zoomHeight * 1.0 / bi.getHeight();
		AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(zw, zh), null);
		return ImageIO.write((BufferedImage) ato.filter(bi, null),
				zoomImagePath.substring(zoomImagePath.lastIndexOf(".") + 1), new File(zoomImagePath));
	}

	/**
	 * 图片添加文字水印
	 * 
	 * @param srcImagePath    原图片路径
	 * @param targerImagePath 目标图片路径
	 * @param str             字符串
	 * @return true:成功,false:失败
	 * @throws Exception
	 * @author kst,20210907
	 */
	public static boolean imageAddStringMark(String srcImagePath, String targerImagePath, String str) throws Exception {
		BufferedImage image = ImageIO.read(new File(srcImagePath));
		Graphics g = image.getGraphics();
		g.setFont(new Font("Serif", Font.BOLD, 14));
		g.setColor(Color.blue);
		g.drawString(str, 69, 152);
		return ImageIO.write(image, "png", new File(targerImagePath));
	}

	/**
	 * 图片添加文字水印
	 * 
	 * @param originalImagePath 原图片路径
	 * @param markImagePath     水印文字图片路径
	 * @param markContent       水印文字
	 * @param markX             水印文字X坐标
	 * @param markY             水印文字Y坐标
	 * @return true:成功,false:失败
	 * @author kst,20210907
	 */
	public static boolean imageAddStringMark(String originalImagePath, String markImagePath, String markContent,
			int markX, int markY) {
		Image image = new ImageIcon(originalImagePath).getImage();
		BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		// SRC、SRC_ATOP
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1));
		g.setColor(Color.RED);
		g.drawImage(image, 0, 0, null);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString(markContent, markX, markY);
		g.dispose();
		try {
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(new FileOutputStream(markImagePath));
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);
			param.setQuality(100, true);
			encoder.encode(bi, param);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 图片添加文字水印
	 * 
	 * @param srcImagePath    原图片路径
	 * @param targerImagePath 目标图片路径
	 * @param rotation        旋转角度
	 * @param alpha           透明度
	 * @author kst,20210909
	 */
	public static void imageAdddStringMark(String srcImagePath, String targerImagePath, double rotation, float alpha) {
		OutputStream os = null;
		try {
			Image srcImage = ImageIO.read(new File(srcImagePath));
			BufferedImage bi = new BufferedImage(srcImage.getWidth(null), srcImage.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			// 得到画布对象
			Graphics2D graphics2D = bi.createGraphics();
			// 设置对线段的锯齿状边缘处理
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics2D.drawImage(
					srcImage.getScaledInstance(srcImage.getWidth(null), srcImage.getHeight(null), Image.SCALE_SMOOTH),
					0, 0, null);
			// 设置水印旋转角度及坐标
			graphics2D.rotate(Math.toRadians(rotation), (double) bi.getWidth() / 2, (double) bi.getHeight() / 2);
			// 透明度
			graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// 设置颜色和画笔粗细
			graphics2D.setColor(Color.gray);
			graphics2D.setStroke(new BasicStroke(10));
			graphics2D.setFont(new Font("SimSun", Font.ITALIC, 18));
			// 绘制图案或文字
			String content = "窗前明月光";
			String dateStr = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
			int halfGap = 12;
			int charWidth1 = 8;
			int charWidth2 = 8;

			// 第1行文字
			graphics2D.drawString(content, (srcImage.getWidth(null) - content.length() * charWidth1) / 2,
					(srcImage.getHeight(null) - (charWidth1 + halfGap)) / 2);
			// 第2行文字
			graphics2D.drawString(dateStr, (srcImage.getWidth(null) - dateStr.length() * charWidth2) / 2,
					(srcImage.getHeight(null) + (charWidth2 + halfGap)) / 2);

			graphics2D.dispose();
			// 生成图片 (可设置 jpg或者png格式)
			ImageIO.write(bi, "png", new FileOutputStream(targerImagePath));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 图片转换成pdf
	 * 
	 * @param imgFilePath 图片路径
	 * @param pdfFilePath PDF文件路径
	 * @author kst,20210909
	 */
	public static void convertImgToPdf(String imgFilePath, String pdfFilePath) {
		try {
			System.out.println("图片转换成pdf开始");
			File file = new File(pdfFilePath);
			Document document = new Document();
			document.setMargins(0, 0, 0, 0);
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(imgFilePath);
			image.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
			document.setPageSize(new com.itextpdf.text.Rectangle(image.getWidth(), image.getHeight()));
			document.newPage();
			document.add(image);
			document.close();
			System.out.println("图片转换成pdf成功");
		} catch (Exception e) {
			System.out.println("图片转换成pdf异常:" + e.toString());
			return;
		}
	}

	/**
	 * 图片转换成base64
	 *
	 * @param imgFilePath
	 * @return base64字符串
	 * @author kst,20210909
	 */
	public static String encodeImage(String imgFilePath) {
		byte[] data = null;
		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

	/**
	 * base64转换成图片
	 *
	 * @param imgStr      base64数据
	 * @param imgFilePath 图片路径
	 * @return 是否生成
	 * @author kst,20210909
	 */
	public static boolean decodeImage(String imgStr, String imgFilePath) {
		if (imgStr == null) {
			return false;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {
					bytes[i] += 256;// 调整异常数据
				}
			}
			// 生成jpg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 按照指定宽高压缩图片
	 * 
	 * @param srcImageFile  源图片文件
	 * @param destImageFile 目标图片文件
	 * @param width         指定宽
	 * @param height        指定高
	 * @param quality       压缩质量
	 * @return 目标图片文件
	 * @author kst,2020.10.10
	 */
	public static String scaleImage(String srcImageFile, String destImageFile, int width, int height, float quality) {
		try {
			Image image = ImageIO.read(new File(srcImageFile));
			// 宽高设定
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			bufferedImage.getGraphics().drawImage(image, 0, 0, width, height, null);
			FileOutputStream out = new FileOutputStream(destImageFile);
			JPEGImageEncoder jie = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bufferedImage);
			// 压缩质量
			jep.setQuality(quality, true);
			jie.encode(bufferedImage, jep);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destImageFile;
	}

	/**
	 * svg转换成png图片格式
	 * 
	 * @param svgPath svg图片路径
	 * @param pngPath png图片路径
	 * @throws Exception
	 * @author kst,2020.11.18
	 */
	public static void convertSvg2Png(File svgPath, File pngPath) throws Exception {
		Transcoder transcoder = new PNGTranscoder();
		TranscoderInput input = new TranscoderInput(new FileInputStream(svgPath));
		TranscoderOutput output = new TranscoderOutput(new BufferedOutputStream(new FileOutputStream(pngPath)));
		transcoder.transcode(input, output);
	}

	/**
	 * bmp格式图片转换成jpg格式图片
	 * 
	 * @param bmpPath bmp格式图片路径
	 * @param jpgPath jpg格式图片路径
	 * @author kst,2020.12.10
	 */
	public static void convertBmp2jpg(String bmpPath, String jpgPath) {
		try {
			Image image = ImageIO.read(new File(bmpPath));
			BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			bi.getGraphics().drawImage(
					image.getScaledInstance(image.getWidth(null), image.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
					null);
			FileOutputStream out = new FileOutputStream(jpgPath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(bi);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * bmp格式图片转换成png格式图片
	 * 
	 * @param bmpPath bmp格式图片路径
	 * @param pngPath png格式图片路径
	 * @author kst,2020.12.15
	 */
	public static void convertBmp2Png(String bmpPath, String pngPath) {
		try {
			BufferedImage bi = ImageIO.read(new File(bmpPath));
			ImageIO.write(bi, "BMP", new File(pngPath));
			bi.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * jpg格式图片转换成png格式图片
	 * 
	 * @param jpgPath jpg格式图片路径
	 * @param pngPath png格式图片路径
	 * @author kst,2020.12.15
	 */
	public static void convertJpg2Png(String jpgPath, String pngPath) {
		try {
			BufferedImage bi = ImageIO.read(new File(jpgPath));
			ImageIO.write(bi, "PNG", new File(pngPath));
			bi.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * png格式图片转换成jpg格式图片
	 * 
	 * @param pngPath png格式图片路径
	 * @param jpgPath jpg格式图片路径
	 * @author kst,2020.12.15
	 */
	public static void convertPng2Jpg(String pngPath, String jpgPath) {
		try {
			BufferedImage bi = ImageIO.read(new File(pngPath));
			ImageIO.write(bi, "JPG", new File(jpgPath));
			bi.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取图片格式
	 * 
	 * @param imagePath 图片路径
	 * @author kst,2020.12.14
	 */
	public static void getImageType(String imagePath) {
		try {
			InputStream is = new FileInputStream(imagePath);
			byte[] b = new byte[3];
			is.read(b, 0, b.length);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < b.length; i++) {
				System.out.println(b[i]);
				int v = b[i] & 0xFF;
				System.out.println(v);
				String hv = Integer.toHexString(v);
				System.out.println(hv);
				if (hv.length() < 2) {
					sb.append(0);
				}
				sb.append(hv);
			}
			is.close();
			String photoHead = sb.toString().toUpperCase();
			System.out.println("头文件是：" + photoHead);
			String imageType = TypeDict.checkType(photoHead);
			System.out.println("后缀名是：" + imageType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		// 1.按照指定宽高压缩图片
		// 226*168
//		String string = scaleImage("C:/kang/image/addImage/1.jpg", "C:/kang/image/addImage/1_scale.jpg", 600,
//				350, 8f);
//		System.out.println("string=" + string);
//		ImageUtils.saveMinPhoto("f:/食尸鬼 - 藿香.jpg", "f:/11.jpg", 139, 0.9d);

		// 2.bmp格式图片转换成jpg格式图片
//		convertBmp2jpg("C:/kang/image/3.bmp", "C:/kang/image/3.jpg");

		// 3.获取图片宽和高
//		int[] whArray = getImageWidthAndLength("C:/kang/image/template.jpg");
//		System.out.println(Arrays.toString(whArray));
//		getImageType("C:/kang/image/1.jpg");

		// 4.bmp格式图片转换成png格式图片
//		convertBmp2Png("C:/kang/image/3.bmp", "C:/kang/image/3.png");

		// 5.jpg格式图片转换成png格式图片
//		convertJpg2Png("C:/kang/image/1.jpg", "C:/kang/image/1_1.png");

		// 6.png格式图片转换成jpg格式图片
//		convertPng2Jpg("C:/kang/image/2.png", "C:/kang/image/2.jpg");

		// 7.图片按比例缩放
//		zoomImage("C:/kang/image/15.jpg", "C:/kang/image/16.jpg", 1080, 720);

		// 8.图片添加文字水印
		String originalImagePath = "C:/kang/image/17.jpg";
		String markImagePath = "C:/kang/image/17_fb.jpg";
		boolean flag = ImageUtils.imageAddStringMark(originalImagePath, markImagePath, "0202  温州分行营业部  张三  02021", 250,
				30);
		System.out.println(flag);

		// 9.图片添加文字水印
//		String srcImagePath = "C:/kang/image/mark.png";
//		String targerImagePath = "C:/kang/image/mark_fb.png";
//		double rotation = -15;
//		float alpha = 0.25f;
//		imageAdddStringMark(srcImagePath, targerImagePath, rotation, alpha);

		// 10.imageAddStringMark
//		String srcImagePath = "C:/kang/image/mark.png";
//		String targerImagePath = "C:/kang/image/mark_fb.png";
//		String str = "床前明月光";
//		imageAddStringMark(srcImagePath, targerImagePath, str);
	}

}
