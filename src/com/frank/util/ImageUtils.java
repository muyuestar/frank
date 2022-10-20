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
 * ͼƬ������
 * 
 * @author kst
 * @date 2019-05-18 09:29:00
 */
public class ImageUtils {

	/**
	 * ��ȡͼƬ��͸�
	 * 
	 * @param imagePath ͼƬ·��
	 * @return ͼƬ��ȸ߶�����
	 * @throws IOException
	 * @author kst,20210909
	 */
	public static int[] getImageWidthAndLength(String imagePath) throws IOException {
		File file = new File(imagePath);
		BufferedImage image = ImageIO.read(file);
		return new int[] { image.getWidth(), image.getHeight() };
	}

	/**
	 * ͼƬ�޼�
	 * 
	 * @param originalImagePath ԭͼƬ·��
	 * @param clipImagePath     �޼���ͼƬ·��
	 * @param imageType         ͼƬ����
	 * @param x                 ͼƬ�޼���ʼx����
	 * @param y                 ͼƬ�޼���ʼy����
	 * @param width             ͼƬ���
	 * @param height            ͼƬ�߶�
	 * @return false:�޼�ʧ��,true:�޼��ɹ�
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
			// ʵ�ʸ߶ȴ���Ŀ��߶Ȼ���ʵ�ʿ�ȴ���Ŀ��������м���
			File file = new File(originalImagePath);
			BufferedImage bii = ImageIO.read(file);
			int itempWidth = bii.getWidth(); // ʵ�ʿ��
			int itempHeight = bii.getHeight(); // ʵ�ʸ߶�
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
	 * ͼƬ����������
	 * 
	 * @param originalImagePath ԭͼƬ·��
	 * @param zoomImagePath     ����ͼƬ·��
	 * @param zoomWidth         ���ſ��
	 * @param zoomHeight        ���Ÿ߶�
	 * @return true:�ɹ�,false:ʧ��
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
	 * ͼƬ�������ˮӡ
	 * 
	 * @param srcImagePath    ԭͼƬ·��
	 * @param targerImagePath Ŀ��ͼƬ·��
	 * @param str             �ַ���
	 * @return true:�ɹ�,false:ʧ��
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
	 * ͼƬ�������ˮӡ
	 * 
	 * @param originalImagePath ԭͼƬ·��
	 * @param markImagePath     ˮӡ����ͼƬ·��
	 * @param markContent       ˮӡ����
	 * @param markX             ˮӡ����X����
	 * @param markY             ˮӡ����Y����
	 * @return true:�ɹ�,false:ʧ��
	 * @author kst,20210907
	 */
	public static boolean imageAddStringMark(String originalImagePath, String markImagePath, String markContent,
			int markX, int markY) {
		Image image = new ImageIcon(originalImagePath).getImage();
		BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		// SRC��SRC_ATOP
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1));
		g.setColor(Color.RED);
		g.drawImage(image, 0, 0, null);
		g.setFont(new Font("����", Font.BOLD, 30));
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
	 * ͼƬ�������ˮӡ
	 * 
	 * @param srcImagePath    ԭͼƬ·��
	 * @param targerImagePath Ŀ��ͼƬ·��
	 * @param rotation        ��ת�Ƕ�
	 * @param alpha           ͸����
	 * @author kst,20210909
	 */
	public static void imageAdddStringMark(String srcImagePath, String targerImagePath, double rotation, float alpha) {
		OutputStream os = null;
		try {
			Image srcImage = ImageIO.read(new File(srcImagePath));
			BufferedImage bi = new BufferedImage(srcImage.getWidth(null), srcImage.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			// �õ���������
			Graphics2D graphics2D = bi.createGraphics();
			// ���ö��߶εľ��״��Ե����
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics2D.drawImage(
					srcImage.getScaledInstance(srcImage.getWidth(null), srcImage.getHeight(null), Image.SCALE_SMOOTH),
					0, 0, null);
			// ����ˮӡ��ת�Ƕȼ�����
			graphics2D.rotate(Math.toRadians(rotation), (double) bi.getWidth() / 2, (double) bi.getHeight() / 2);
			// ͸����
			graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// ������ɫ�ͻ��ʴ�ϸ
			graphics2D.setColor(Color.gray);
			graphics2D.setStroke(new BasicStroke(10));
			graphics2D.setFont(new Font("SimSun", Font.ITALIC, 18));
			// ����ͼ��������
			String content = "��ǰ���¹�";
			String dateStr = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
			int halfGap = 12;
			int charWidth1 = 8;
			int charWidth2 = 8;

			// ��1������
			graphics2D.drawString(content, (srcImage.getWidth(null) - content.length() * charWidth1) / 2,
					(srcImage.getHeight(null) - (charWidth1 + halfGap)) / 2);
			// ��2������
			graphics2D.drawString(dateStr, (srcImage.getWidth(null) - dateStr.length() * charWidth2) / 2,
					(srcImage.getHeight(null) + (charWidth2 + halfGap)) / 2);

			graphics2D.dispose();
			// ����ͼƬ (������ jpg����png��ʽ)
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
	 * ͼƬת����pdf
	 * 
	 * @param imgFilePath ͼƬ·��
	 * @param pdfFilePath PDF�ļ�·��
	 * @author kst,20210909
	 */
	public static void convertImgToPdf(String imgFilePath, String pdfFilePath) {
		try {
			System.out.println("ͼƬת����pdf��ʼ");
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
			System.out.println("ͼƬת����pdf�ɹ�");
		} catch (Exception e) {
			System.out.println("ͼƬת����pdf�쳣:" + e.toString());
			return;
		}
	}

	/**
	 * ͼƬת����base64
	 *
	 * @param imgFilePath
	 * @return base64�ַ���
	 * @author kst,20210909
	 */
	public static String encodeImage(String imgFilePath) {
		byte[] data = null;
		// ��ȡͼƬ�ֽ�����
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���ֽ�����Base64����
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

	/**
	 * base64ת����ͼƬ
	 *
	 * @param imgStr      base64����
	 * @param imgFilePath ͼƬ·��
	 * @return �Ƿ�����
	 * @author kst,20210909
	 */
	public static boolean decodeImage(String imgStr, String imgFilePath) {
		if (imgStr == null) {
			return false;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {
					bytes[i] += 256;// �����쳣����
				}
			}
			// ����jpgͼƬ
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
	 * ����ָ�����ѹ��ͼƬ
	 * 
	 * @param srcImageFile  ԴͼƬ�ļ�
	 * @param destImageFile Ŀ��ͼƬ�ļ�
	 * @param width         ָ����
	 * @param height        ָ����
	 * @param quality       ѹ������
	 * @return Ŀ��ͼƬ�ļ�
	 * @author kst,2020.10.10
	 */
	public static String scaleImage(String srcImageFile, String destImageFile, int width, int height, float quality) {
		try {
			Image image = ImageIO.read(new File(srcImageFile));
			// ����趨
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			bufferedImage.getGraphics().drawImage(image, 0, 0, width, height, null);
			FileOutputStream out = new FileOutputStream(destImageFile);
			JPEGImageEncoder jie = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bufferedImage);
			// ѹ������
			jep.setQuality(quality, true);
			jie.encode(bufferedImage, jep);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destImageFile;
	}

	/**
	 * svgת����pngͼƬ��ʽ
	 * 
	 * @param svgPath svgͼƬ·��
	 * @param pngPath pngͼƬ·��
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
	 * bmp��ʽͼƬת����jpg��ʽͼƬ
	 * 
	 * @param bmpPath bmp��ʽͼƬ·��
	 * @param jpgPath jpg��ʽͼƬ·��
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
	 * bmp��ʽͼƬת����png��ʽͼƬ
	 * 
	 * @param bmpPath bmp��ʽͼƬ·��
	 * @param pngPath png��ʽͼƬ·��
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
	 * jpg��ʽͼƬת����png��ʽͼƬ
	 * 
	 * @param jpgPath jpg��ʽͼƬ·��
	 * @param pngPath png��ʽͼƬ·��
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
	 * png��ʽͼƬת����jpg��ʽͼƬ
	 * 
	 * @param pngPath png��ʽͼƬ·��
	 * @param jpgPath jpg��ʽͼƬ·��
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
	 * ��ȡͼƬ��ʽ
	 * 
	 * @param imagePath ͼƬ·��
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
			System.out.println("ͷ�ļ��ǣ�" + photoHead);
			String imageType = TypeDict.checkType(photoHead);
			System.out.println("��׺���ǣ�" + imageType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		// 1.����ָ�����ѹ��ͼƬ
		// 226*168
//		String string = scaleImage("C:/kang/image/addImage/1.jpg", "C:/kang/image/addImage/1_scale.jpg", 600,
//				350, 8f);
//		System.out.println("string=" + string);
//		ImageUtils.saveMinPhoto("f:/ʳʬ�� - ޽��.jpg", "f:/11.jpg", 139, 0.9d);

		// 2.bmp��ʽͼƬת����jpg��ʽͼƬ
//		convertBmp2jpg("C:/kang/image/3.bmp", "C:/kang/image/3.jpg");

		// 3.��ȡͼƬ��͸�
//		int[] whArray = getImageWidthAndLength("C:/kang/image/template.jpg");
//		System.out.println(Arrays.toString(whArray));
//		getImageType("C:/kang/image/1.jpg");

		// 4.bmp��ʽͼƬת����png��ʽͼƬ
//		convertBmp2Png("C:/kang/image/3.bmp", "C:/kang/image/3.png");

		// 5.jpg��ʽͼƬת����png��ʽͼƬ
//		convertJpg2Png("C:/kang/image/1.jpg", "C:/kang/image/1_1.png");

		// 6.png��ʽͼƬת����jpg��ʽͼƬ
//		convertPng2Jpg("C:/kang/image/2.png", "C:/kang/image/2.jpg");

		// 7.ͼƬ����������
//		zoomImage("C:/kang/image/15.jpg", "C:/kang/image/16.jpg", 1080, 720);

		// 8.ͼƬ�������ˮӡ
		String originalImagePath = "C:/kang/image/17.jpg";
		String markImagePath = "C:/kang/image/17_fb.jpg";
		boolean flag = ImageUtils.imageAddStringMark(originalImagePath, markImagePath, "0202  ���ݷ���Ӫҵ��  ����  02021", 250,
				30);
		System.out.println(flag);

		// 9.ͼƬ�������ˮӡ
//		String srcImagePath = "C:/kang/image/mark.png";
//		String targerImagePath = "C:/kang/image/mark_fb.png";
//		double rotation = -15;
//		float alpha = 0.25f;
//		imageAdddStringMark(srcImagePath, targerImagePath, rotation, alpha);

		// 10.imageAddStringMark
//		String srcImagePath = "C:/kang/image/mark.png";
//		String targerImagePath = "C:/kang/image/mark_fb.png";
//		String str = "��ǰ���¹�";
//		imageAddStringMark(srcImagePath, targerImagePath, str);
	}

}
